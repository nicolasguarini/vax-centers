package serverCV;

import common.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    private final List<LogListener> listeners = new LinkedList<>();

    public ServerImpl() throws RemoteException{
        super();
    }

    public void addListener(LogListener toAdd){
        listeners.add(toAdd);
    }

    public void notifyUpdate(String message){
        for(LogListener l : listeners){
            l.updateLog(message);
        }
    }

    public synchronized boolean registraCentroVaccinale(CentroVaccinale centroVaccinale) throws RemoteException{
        try {
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) \n" +
                            "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, centroVaccinale.getId());
            preparedStatement.setString(2, centroVaccinale.getNome());
            preparedStatement.setString(3, centroVaccinale.getTipologia());
            preparedStatement.setString(4, centroVaccinale.getIndirizzo().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            notifyUpdate(new java.util.Date() + " -- Nuovo centro vaccinale registrato (" + centroVaccinale.getNome() + ")");
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized LinkedList<CentroVaccinale> getCentriVaccinali() throws RemoteException {
        LinkedList<CentroVaccinale> centriVaccinali = new LinkedList<>();

        try {
            Statement statement = DBManager.getInstance().connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM centrivaccinali");
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String tipologia = resultSet.getString(3);
                Indirizzo indirizzo = new Indirizzo(resultSet.getString(4));
                centriVaccinali.add(new CentroVaccinale(nome, indirizzo, tipologia, id));
            }
            notifyUpdate(new java.util.Date() + " -- Restituita lista dei centri vaccinali");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return centriVaccinali;
    }

    public synchronized boolean registraVaccinato(Vaccinazione vaccinazione) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato) \n" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, vaccinazione.getIdVaccinazione());
            preparedStatement.setString(2, vaccinazione.getNomeVaccinato());
            preparedStatement.setString(3, vaccinazione.getCognomeVaccinato());
            preparedStatement.setString(4, vaccinazione.getCf());
            preparedStatement.setDate(5, new Date(vaccinazione.getDataVaccinazione().getTime()));
            preparedStatement.setString(6, vaccinazione.getCentroVaccinale().getId());
            preparedStatement.setString(7, vaccinazione.getNomeVaccino());
            preparedStatement.setBoolean(8, false);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            notifyUpdate(new java.util.Date() + " -- Nuova vaccinazione registrata (" + vaccinazione.getCf() + ")");
        }catch (SQLException exception){
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized LinkedList<Vaccinazione> getVaccinazioni(CentroVaccinale centroVaccinale) throws RemoteException{
        LinkedList<Vaccinazione> vaccinazioni = new LinkedList<>();

        try{
            PreparedStatement preparedStatement = DBManager.getInstance().connection.prepareStatement("SELECT * FROM vaccinazioni \n" +
                    "WHERE idcentrovaccinale = ?");
            preparedStatement.setString(1, centroVaccinale.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String idVaccinazione = resultSet.getString(1);
                String nomeVaccinato = resultSet.getString(2);
                String cognomeVaccinato = resultSet.getString(3);
                String cfVaccinato = resultSet.getString(4);
                Date dataVaccinazione = resultSet.getDate(5);
                String nomeVaccino = resultSet.getString(7);

                Vaccinazione vaccinazione = new Vaccinazione(nomeVaccinato, cognomeVaccinato, cfVaccinato, idVaccinazione, dataVaccinazione, centroVaccinale, nomeVaccino);
                vaccinazione.setEventiAvversi(getEventiAvversi(vaccinazione));
                vaccinazioni.add(vaccinazione);
            }

            preparedStatement.close();
            notifyUpdate(new java.util.Date() + " -- Restituita lista vaccinazioni");
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        return vaccinazioni;
    }

    private LinkedList<EventoAvverso> getEventiAvversi(Vaccinazione vaccinazione){
        LinkedList<EventoAvverso> eventiAvversi = new LinkedList<>();

        try{
            PreparedStatement preparedStatement = DBManager.getInstance().connection.prepareStatement("SELECT * FROM eventiavversi WHERE idvaccinazione = ?");
            preparedStatement.setString(1, vaccinazione.getIdVaccinazione());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String nomeEventoAvverso = resultSet.getString(1);
                int severita = resultSet.getInt(2);
                String noteAggiuntive = resultSet.getString(3);

                EventoAvverso eventoAvverso = new EventoAvverso(nomeEventoAvverso, severita, noteAggiuntive);
                eventiAvversi.add(eventoAvverso);
            }

            notifyUpdate(new java.util.Date() + " -- Restituita lista eventi avversi della vaccinazione " + vaccinazione.getIdVaccinazione());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return eventiAvversi;
    }

    public synchronized boolean registraCittadino(Cittadino cittadino) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("UPDATE vaccinazioni \n" +
                            "SET registrato = true,\n" +
                            "username = ?,\n" +
                            "email = ?,\n" +
                            "password = ? \n" +
                        "WHERE idvaccinazione = ?");
            preparedStatement.setString(1, cittadino.getUsername());
            preparedStatement.setString(2, cittadino.getEmail());
            preparedStatement.setString(3, cittadino.getPassword());
            preparedStatement.setString(4, cittadino.getIdVaccinazione());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            notifyUpdate(new java.util.Date() + " -- Nuovo cittadino registrato (" + cittadino.getCF() + ")");
        }catch (SQLException exception){
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized LinkedList<Cittadino> getCittadini() throws RemoteException{
        LinkedList<Cittadino> cittadini = new LinkedList<>();

        try{
            Statement statement = DBManager.getInstance().connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " +
                    "(vaccinazioni JOIN centrivaccinali " +
                    "ON vaccinazioni.idcentrovaccinale = centrivaccinali.idcentrovaccinale) " +
                    "WHERE registrato = true");

            while(resultSet.next()){
                String idVaccinazione = resultSet.getString(1);
                String nomeVaccinato = resultSet.getString(2);
                String cognomeVaccinato = resultSet.getString(3);
                String cfVaccinato = resultSet.getString(4);
                String username = resultSet.getString(9);
                String email = resultSet.getString(10);
                String password = resultSet.getString(11);

                Cittadino cittadino = new Cittadino(nomeVaccinato, cognomeVaccinato, cfVaccinato, email, username, password, idVaccinazione);
                cittadini.add(cittadino);
            }
            notifyUpdate(new java.util.Date() + " -- Restituita lista cittadini registrati");
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        return cittadini;
    }

    public synchronized boolean registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione) \n" +
                            "VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, eventoAvverso.getNome());
            preparedStatement.setInt(2, eventoAvverso.getSeverita());
            preparedStatement.setString(3, eventoAvverso.getNoteAggiuntive());
            preparedStatement.setString(4, cittadino.getIdVaccinazione());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            notifyUpdate(new java.util.Date() + " -- Nuovo evento avverso registrato dal cittadino " + cittadino.getCF() + " (" + eventoAvverso.getNome() + ")");
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized Cittadino login(String username, String password) throws RemoteException{
        Cittadino cittadino = null;
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM " +
                            "vaccinazioni JOIN centrivaccinali ON vaccinazioni.idcentrovaccinale = centrivaccinali.idcentrovaccinale " +
                            "WHERE registrato = true AND username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String idVaccinazione = resultSet.getString(1);
                String nomeVaccinato = resultSet.getString(2);
                String cognomeVaccinato = resultSet.getString(3);
                String cfVaccinato = resultSet.getString(4);
                String email = resultSet.getString(10);

                cittadino = new Cittadino(nomeVaccinato, cognomeVaccinato, cfVaccinato, email, username, password, idVaccinazione);
                notifyUpdate(new java.util.Date() + " -- " + cittadino.getUsername() + " si è loggato");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return cittadino;
    }

    public synchronized boolean checkUsername(String username) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM vaccinazioni WHERE registrato = true AND username = ?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized boolean checkEmail(String email) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM vaccinazioni WHERE registrato = true AND email = ?");
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized boolean checkIdVaccinazione(String idVaccinazione) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM vaccinazioni WHERE registrato = true AND idvaccinazione = ?");
            preparedStatement.setString(1, idVaccinazione);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized boolean checkCF(String cf) throws RemoteException{
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM vaccinazioni WHERE registrato = true AND cfvaccinato = ?");
            preparedStatement.setString(1, cf);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public synchronized boolean checkVaccinazioneEsistente(String idvaccinazione){
        try {
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM vaccinazioni WHERE registrato = false AND idvaccinazione = ?");
            preparedStatement.setString(1, idvaccinazione);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    public synchronized CentroVaccinale getCentroVaccinaleFromId(String id){
        try{
            PreparedStatement preparedStatement = DBManager
                    .getInstance()
                    .connection
                    .prepareStatement("SELECT * FROM centrivaccinali WHERE idcentrovaccinale = ?");
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String nome = resultSet.getString(2);
                String tipologia = resultSet.getString(3);
                Indirizzo indirizzo = new Indirizzo(resultSet.getString(4));
                return new CentroVaccinale(nome, indirizzo, tipologia, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
