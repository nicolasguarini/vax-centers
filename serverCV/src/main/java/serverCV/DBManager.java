package serverCV;

import java.sql.*;

public class DBManager {
    Connection connection;
    String host;
    String port;
    String username;
    String password;
    final String dbName = "dbcv";

    private static DBManager DBManagerInstance = null;

    public static DBManager getInstance(){
        if(DBManagerInstance == null) DBManagerInstance = new DBManager();
        return DBManagerInstance;
    }

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

