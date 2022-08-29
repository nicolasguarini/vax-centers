//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package serverCV;

import serverCV.UI.UIStartMenu;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Classe che contiene il punto di avvio del programma, e mantiene gli oggetti relativi alla comunicazione tramite RMI.
 *
 * @see ServerImpl
 * @see DBManager
 * @see serverCV.UI.UIDashboard
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 */
public class ServerCV {
    /**
     * Porta sulla quale ascolterà il server
     */
    static final int PORT = 1099;

    /**
     * Nome del servizio dell'applicazione
     */
    static final String REGISTRY_NAME = "ServerCV";

    /**
     * Oggetto che implementa l'interfaccia <code>ServerInterface</code> e che concretizza le operazioni che vengono estese ai client
     */
    static ServerImpl server;

    /**
     * Oggetto <code>Registry</code> che mette a disposizione metodi per salvare e ritornare i riferimenti degli oggetti remoti
     */
    static Registry registry;

    /**
     * Variabile booleana che tiene traccia dello stato corrente del server
     */
    static boolean running = false;

    /**
     * Punto di avvio dell'applicazione server
     * @see UIStartMenu
     * @param args array di stringhe passate tramite parametri da riga di comando
     */
    public static void main(String[] args){
        new UIStartMenu();
    }

    /**
     * Metodo che imposta la connessione RMI istanziando un nuovo registry e un nuovo oggetto remoto.
     *
     * @return esito dell'operazione di creazione della connessione RMI
     *
     * @author Nicolas Guarini
     */
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

    /**
     * Metodo per terminare l'attività dell'oggetto remoto e quindi effettuare il suo unexport e l'unbind del servizio.
     *
     * @return esito dell'operazione di terminazione della connessione RMI
     *
     * @author Nicolas Guarini
     */
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

    /**
     * Metodo che aggiunge un nuovo oggetto <code>LogListener</code> alla lista dei listener interessati all'aggiornamento dei log
     *
     * @param toAdd oggetto che implementa l'interfaccia {@link LogListener} da aggiungere alla lista dei listener
     *
     * @author Nicolas Guarini
     */
    public static void addListener(LogListener toAdd){
        server.addListener(toAdd);
    }

    /**
     * Metodo che ritorna la proprietà private PORT
     *
     * @return porta sul quale è in ascolto il server
     *
     * @author Nicolas Guarini
     */
    public static int getPort(){
        return PORT;
    }
}
