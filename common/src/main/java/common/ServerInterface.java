//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 * Interfaccia remota che descrive il comportamento dell'oggetto remoto <code>ServerImpl</code>. <br>
 * NB: i singoli metodi sono documentati nell'implementazione dell'interfaccia
 *
 * @author Nicolas Guarini
 */
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
    boolean checkNomeCentroVaccinale(String nomeCentroVaccinale) throws RemoteException;
}
