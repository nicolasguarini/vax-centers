package serverCV;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBManager {
    Connection connection;
    String host;
    String port;
    String username;
    String password;
    boolean connected;
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
            String createDBQuery = "CREATE DATABASE " + dbName;
            statement.execute(createDBQuery);
            this.connection = DriverManager.getConnection("jdbc:postgresql:" + dbName, username, password);
            //TODO: create tables
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

