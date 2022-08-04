package serverCV;

import com.sun.security.ntlm.Server;
import serverCV.UI.UIStartMenu;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerCV {
    public static final int PORT = 1099;

    static ServerImpl server;
    static Registry registry;

    public static void main(String[] args){
        new UIStartMenu();
    }

    public static boolean startServer(){
        try{
            server = new ServerImpl();
            registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("ServerCV", server);
            System.out.println("Server ready!!");
        }catch(RemoteException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
