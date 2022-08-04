package serverCV;

import common.ServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    public ServerImpl() throws RemoteException{
        super();
    }

    public String helloWorld() throws RemoteException{
        return "Hello, server!!";
    }
}
