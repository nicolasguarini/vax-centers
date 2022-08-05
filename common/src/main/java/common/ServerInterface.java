package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface ServerInterface extends Remote {
    boolean registraCentroVaccinale(CentroVaccinale centroVaccinale) throws RemoteException;
    LinkedList<CentroVaccinale> getCentriVaccinali() throws RemoteException;

}
