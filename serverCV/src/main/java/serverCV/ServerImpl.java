package serverCV;

import common.CentroVaccinale;
import common.Indirizzo;
import common.ServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    public ServerImpl() throws RemoteException{
        super();
    }

    public boolean registraCentroVaccinale(CentroVaccinale centroVaccinale) throws RemoteException{
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
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    public LinkedList<CentroVaccinale> getCentriVaccinali() throws RemoteException {
        LinkedList<CentroVaccinale> centriVaccinali = new LinkedList<>();

        try {
            Statement statement = DBManager.getInstance().connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM centrivaccinali");
            while(resultSet.next()){
                System.out.println("NUOVA RIGA");
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String tipologia = resultSet.getString(3);
                Indirizzo indirizzo = new Indirizzo(resultSet.getString(4));
                centriVaccinali.add(new CentroVaccinale(nome, indirizzo, tipologia, id));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return centriVaccinali;
    }
}
