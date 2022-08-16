package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface ServerInterface extends Remote {
    boolean registraCentroVaccinale(CentroVaccinale centroVaccinale) throws RemoteException;
    LinkedList<CentroVaccinale> getCentriVaccinali() throws RemoteException;
    boolean registraVaccinato(Vaccinazione vaccinazione) throws RemoteException;
    LinkedList<Vaccinazione> getVaccinazioni(CentroVaccinale centroVaccinale) throws RemoteException;
    boolean registraCittadino(Cittadino cittadino) throws RemoteException;
    LinkedList<Cittadino> getCittadini() throws RemoteException;
    boolean registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso) throws RemoteException;
    Cittadino login(String username, String password) throws RemoteException;
    boolean checkUsername(String username) throws RemoteException;
    boolean checkEmail(String email) throws RemoteException;
    boolean checkIdVaccinazione(String idVaccinazione) throws RemoteException;
    boolean checkCF(String cf) throws RemoteException;
    boolean checkVaccinazioneEsistente(String idvaccinazione) throws RemoteException;
    CentroVaccinale getCentroVaccinaleFromId(String id) throws RemoteException;
}
