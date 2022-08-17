package serverCV;

import serverCV.UI.UIStartMenu;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class ServerCV {
    public static final int PORT = 1099;
    public static final String REGISTRY_NAME = "ServerCV";

    public static ServerImpl server;
    static Registry registry;
    static boolean running = false;

    public static void main(String[] args){
        new UIStartMenu();
    }

    public static boolean startServer(){
        try{
            server = new ServerImpl();

            try {
                registry = LocateRegistry.createRegistry(PORT);
            }catch (ExportException e){
                registry = LocateRegistry.getRegistry(PORT);
            }

            registry.rebind(REGISTRY_NAME, server);
            running = true;
        }catch(RemoteException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean stopServer(){
        if(running){
            try {
                registry.unbind(REGISTRY_NAME);
                UnicastRemoteObject.unexportObject(server, true);
                running = false;
                return true;
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }

            return false;
        }else{
            return true;
        }
    }

    public static void addListener(LogListener toAdd){
        server.addListener(toAdd);
    }
}
