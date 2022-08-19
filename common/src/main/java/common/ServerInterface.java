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
    /**
     * Metodo che inserisce un nuovo centro vaccinale nel database
     * @param centroVaccinale il centro vaccinale da aggiungere
     * @return esito dell'operazione d'inserimento
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean registraCentroVaccinale(CentroVaccinale centroVaccinale) throws RemoteException;

    /**
     * Metodo che ritorna tutti i centri vaccinali presenti nel database in una <code>LinkedList</code>
     * @return la lista di centri vaccinali registrati nel database
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    LinkedList<CentroVaccinale> getCentriVaccinali() throws RemoteException;

    /**
     * Metodo che registra una nuova vaccinazione all'interno del database
     * @param vaccinazione vaccinazione da registrare
     * @return esito dell'operazione di inserimento
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean registraVaccinato(Vaccinazione vaccinazione) throws RemoteException;

    /**
     * Metodo che ritorna la lista delle vaccinazioni presenti nel database effettuate in un centro vaccinale
     * @param centroVaccinale il centro del quale si vuole la lista delle vaccinazioni effettuate
     * @return lista delle vaccinazioni effettuate in un centro vaccinale
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    LinkedList<Vaccinazione> getVaccinazioni(CentroVaccinale centroVaccinale) throws RemoteException;

    /**
     * Metodo che registra un nuovo cittadino nel database
     * @param cittadino cittadino da registrare
     * @return esito dell'operazione d'inserimento
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean registraCittadino(Cittadino cittadino) throws RemoteException;

    /**
     * Metodo che ritorna la lista dei cittadini presenti all'interno del database
     * @return lista dei cittadini registrati
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    LinkedList<Cittadino> getCittadini() throws RemoteException;

    /**
     * Metodo che registra un nuovo evento avverso segnalato da un cittadino
     * @param cittadino cittadino che segnala l'evento avverso
     * @param eventoAvverso evento avverso segnalato
     * @return esito dell'operazione d'inserimento
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso) throws RemoteException;

    /**
     * Metodo che effettua il login di un cittadino che vuole accedere all'area riservata
     * @param username username del cittadino
     * @param password password (crittografata) del cittadino
     * @return oggetto di tipo {@link Cittadino} nel caso in cui il login sia andato a buon fine, <code>null</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    Cittadino login(String username, String password) throws RemoteException;

    /**
     * Metodo che controlla se un dato username è già presente all'interno del database
     * @param username l'username da controllare
     * @return <code>true</code> se l'username non è già utilizzato, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkUsername(String username) throws RemoteException;

    /**
     * Metodo che controlla se un'email è già presente all'interno del database
     * @param email l'email da controllare
     * @return <code>true</code> se l'email non è già utilizzata, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkEmail(String email) throws RemoteException;

    /**
     * Metodo che controlla se un'id vaccinazione è già stato utilizzato per registrare una vaccinazione
     * @param idVaccinazione l'id da controllare
     * @return <code>true</code> se l'id vaccinazione non è già utilizzato, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkIdVaccinazione(String idVaccinazione) throws RemoteException;

    /**
     * Metodo che controlla se un codice fiscale è già stato utilizzato per registrare una vaccinazione
     * @param cf codice fiscale da controllare
     * @return <code>true</code> se il CF non è già stato utilizzato, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkCF(String cf) throws RemoteException;

    /**
     * Metodo che controlla se la vaccinazione del cittadino che si intende registrare esiste o meno
     * @param idvaccinazione id della vaccinazione che si vuole controllare
     * @return <code>true</code> se la vaccinazione esiste, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkVaccinazioneEsistente(String idvaccinazione) throws RemoteException;

    /**
     * Metodo che controlla se esiste un centro vaccinale con un determinato nome
     * @param nomeCentroVaccinale nome del centro vaccinale da controllare
     * @return <code>true</code> se esiste un centro con quel nome, <code>false</code> altrimenti
     * @throws RemoteException superclasse comune per una serie di eccezioni relative alla comunicazione che possono verificarsi durante l'esecuzione di una chiamata al metodo remoto
     */
    boolean checkNomeCentroVaccinale(String nomeCentroVaccinale) throws RemoteException;
}
