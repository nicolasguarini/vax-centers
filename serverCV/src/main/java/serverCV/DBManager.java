//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package serverCV;

import java.sql.*;

/**
 * La classe <code>DBManager</code>, implementando il pattern Singleton, inizializza il database e permette alle altre classi di accedervi
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 */
public class DBManager {
    /**
     * Oggetto per poter gestire la connessione ed effettuare query al database
     */
    Connection connection;

    /**
     * Indirizzo dell'host del server Postgres
     */
    String host;

    /**
     * Porta del server Postgres
     */
    String port;

    /**
     * Username per accedere al server Postgres
     */
    String username;

    /**
     * Password per accedere al server Postgres
     */
    String password;

    /**
     * Nome del database dell'applicazione. Se questo non esiste già verrà creato.
     */
    final String dbName = "dbcv";

    /**
     * Oggetto <code>DBManager</code> necessario a implementare il pattern Singleton, rappresenta l'istanza corrente della classe.
     */
    private static DBManager DBManagerInstance = null;

    /**
     * Metodo che ritorna l'istanza della classe. Se non è ancora stata istanziata lo fa, altrimenti ritorna l'istanza esistente.
     *
     * @return l'istanza corrente della classe <code>DBManager</code>
     *
     * @author Nicolas Guarini
     */
    public static DBManager getInstance(){
        if(DBManagerInstance == null) DBManagerInstance = new DBManager();
        return DBManagerInstance;
    }

    /**
     * Metodo che realizza la connessione al server Postgres tramite il driver JDBC
     *
     * @param host indirizzo del server Postgres
     * @param port porta del server Postgres
     * @param username username per accedere al server Postgres
     * @param password password per accedere al server Postgres
     * @return esito della connessione tramite l'enumerazione {@link ConnectionResult}
     *
     * @author Nicolas Guarini
     */
    public ConnectionResult connect(String host, String port, String username, String password) {
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;

        try{
            connection = DriverManager.getConnection(url, username, password);
            setupTables();
            return ConnectionResult.OK;
        } catch (SQLException exception) {
            exception.printStackTrace();
            if(exception.getMessage().contains(dbName)){
                createDB();
                return  ConnectionResult.DB_CREATED;
            }else return ConnectionResult.FAILED;
        }
    }

    /**
     * Metodo che si occupa di creare il database e le relative tabelle nel caso in cui quest'ultimo non esista già
     *
     * @author Nicolas Guarini
     */
    private void createDB(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/", username, password);
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE " + dbName);
            this.connection = DriverManager.getConnection("jdbc:postgresql:" + dbName, username, password);
            setupTables();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Metodo che si occupa della creazione, nel caso in cui non esistano già, delle tabelle del database
     *
     * @throws SQLException eccezione che da informazioni sull'errore o sugli errori che sono avvenuti
     *
     * @author Nicolas Guarini
     */
    private void setupTables() throws SQLException{
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS CentriVaccinali(\n" +
                "    idCentroVaccinale VARCHAR(5) PRIMARY KEY NOT NULL,\n" +
                "    nomeCentroVaccinale VARCHAR(50) NOT NULL,\n" +
                "    tipologia VARCHAR(20) NOT NULL,\n" +
                "    indirizzo VARCHAR(100) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Vaccinazioni(\n" +
                "    idVaccinazione VARCHAR(16) PRIMARY KEY NOT NULL,\n" +
                "    nomeVaccinato VARCHAR(50) NOT NULL, \n" +
                "    cognomeVaccinato VARCHAR(50)NOT NULL, \n" +
                "    cfVaccinato VARCHAR(16) NOT NULL,\n" +
                "    dataVaccinazione DATE NOT NULL,\n" +
                "    idCentroVaccinale VARCHAR(5) NOT NULL,\n" +
                "    nomeVaccino VARCHAR(50) NOT NULL,\n" +
                "    registrato BOOLEAN NOT NULL,\n" +
                "    username VARCHAR(100) NULL,\n" +
                "    email VARCHAR(100) NULL,\n" +
                "    password VARCHAR(64) NULL,\n" +
                "    CONSTRAINT fk_centrivaccinali\n" +
                "        FOREIGN KEY (idCentroVaccinale)\n" +
                "        REFERENCES CentriVaccinali(idCentroVaccinale)\n" +
                "        ON UPDATE CASCADE\n" +
                "        ON DELETE RESTRICT\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS EventiAvversi(\n" +
                "    nomeEventoAvverso VARCHAR(100) NOT NULL,\n" +
                "    severita SMALLINT NOT NULL,\n" +
                "    noteAggiuntive VARCHAR(5000) NULL,\n" +
                "    idVaccinazione VARCHAR(16) NOT NULL,\n" +
                "    PRIMARY KEY (nomeEventoAvverso, idVaccinazione),\n" +
                "    CONSTRAINT fk_vaccinazione \n" +
                "        FOREIGN KEY(idVaccinazione)\n" +
                "        REFERENCES Vaccinazioni(idVaccinazione)\n" +
                "        ON DELETE CASCADE\n" +
                "        ON UPDATE CASCADE\n" +
                ");";
        statement.execute(query);
    }
}

