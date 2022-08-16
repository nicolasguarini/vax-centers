//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini;

import centrivaccinali.CentriVaccinali;
import common.CentroVaccinale;
import common.Cittadino;
import common.EventoAvverso;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.LinkedList;

/**
 * Classe principale della sezione dedicata ai cittadini.
 * Mette a disposizione alle altre classi una serie di metodi che effettuano operazioni comuni e/o si interfacciano con il server remoto, separando la logica applictiva da quella di presentazione.
 *
 * @see cittadini.UI.UICittadini
 *
 * @author Nicolas Guarini
 * @author Redon Kokaj
 * @author Domenico Rizzo
 * @author Filippo Alzati
 */
public class Cittadini {
    /**
     * Contatta il server remoto chiedendo di registrare nel database un nuovo cittadino
     *
     * @param cittadino il cittadino da registrare nel database
     * @return esito dell'operazione di inserimento
     * @author Nicolas Guarini
     */
    public static boolean registraCittadino(Cittadino cittadino){
        boolean result = false;

        try{
            result = CentriVaccinali.server.registraCittadino(cittadino);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Contatta il server remoto che ritornerà la lista dei cittadini registrati nel database
     *
     * @return lista dei cittadini registrati
     *
     * @author Nicolas Guarini
     */
    public static LinkedList<Cittadino> getCittadini(){
        LinkedList<Cittadino> cittadini = new LinkedList<>();
        try{
            cittadini = CentriVaccinali.server.getCittadini();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return cittadini;
    }

    /**
     * Effettua l'hashing della password con l'argoritmo SHA-256. Il risultato di tale procedura è un array di byte, che verrà poi salvato nel formato <code>Base64</code> per poterlo gestire facilmente (essendo una stringa)
     * Si tratta di una misura di sicurezza fondamentale quando si ha a che fare con delle password.
     *
     * @param password password da crittografare
     *
     * @return password crittografata con l'algoritmo sha256
     * @author Nicolas Guarini
     */
    public static String sha256(String password) {
        String encodedPassword = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            encodedPassword = Base64.getEncoder().encodeToString(hash);
        }catch(Exception e){
            e.printStackTrace();
        }

        return encodedPassword;
    }

    /**
     * Contatta il server remoto chiedendo di registrare un nuovo evento avverso segnalato da un cittadino registrato
     *
     * @param cittadino cittadino registrato che sta segnalando l'evento avverso
     * @param eventoAvverso evento avverso da segnalare
     *
     * @return esito dell'operazione di registrazione dell'evento avverso
     * @author Nicolas Guarini
     */
    public static boolean registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso){
       boolean result = false;
       try{
           result = CentriVaccinali.server.registraEventoAvverso(cittadino, eventoAvverso);
       } catch (RemoteException e) {
           e.printStackTrace();
       }

       return result;
    }

    /**
     * Contatta il server remoto che controllerà se le credenziali corrispondono a un cittadino registrato
     *
     * @param username il nome utente del cittadino che vuole effettuare il login
     * @param password password (crittografata) del cittadino che vuole effettuare il login
     * @return oggetto di tipo <code>Cittadino</code> nel caso in cui il login sia avvenuto con successo, <code>null</code> altrimenti.
     * @author Nicolas Guarini
     */
    public static Cittadino login(String username, String password){
        Cittadino cittadino = null;
        try{
            cittadino = CentriVaccinali.server.login(username, password);
        }catch (RemoteException e){
            e.printStackTrace();
        }

        return cittadino;
    }

    /**
     * Contatta il server remoto che controllerà se l'username è già presente all'interno del database
     *
     * @param username il nome utente da controllare
     * @return <code>true</code> se l'username non è già utilizzato, <code>false</code> altrimenti
     * @author Nicolas Guarini
     */
    public static boolean checkUsername(String username){
        try{
            return CentriVaccinali.server.checkUsername(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Contatta il server remoto che controllerà se l'email è già presente all'interno del database
     *
     * @param email l'email da controllare
     * @return <code>true</code> se l'email non è già utilizzata, <code>false</code> altrimenti
     */
    public static boolean checkEmail(String email){
        try{
            return CentriVaccinali.server.checkEmail(email);
        }catch(RemoteException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Contatta il server remoto che controllerà se l'id vaccinazione è già stato utilizzato per registrare un utente
     *
     * @param idVaccinazione l'id da controllare
     * @return <code>true</code> se l'id vaccinazione non è già utilizzato, <code>false</code> altrimenti
     * @author Nicolas Guarini
     */
    public static boolean checkIdVaccinazione(String idVaccinazione){
        try{
            return CentriVaccinali.server.checkIdVaccinazione(idVaccinazione);
        }catch (RemoteException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Contatta il server remoto che controllerà se il codice fiscale è già stato utilizzato per registrare un utente
     *
     * @param cf il codice fiscale da controllare
     * @return <code>true</code> se il codice fiscale non è già utilizzato, <code>false</code> altrimenti
     * @author Nicolas Guarini
     */
    public static boolean checkCF(String cf){
        try {
            return CentriVaccinali.server.checkCF(cf);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Contatta il server remoto che controllerà se l'id vaccinazione è associato a una vaccinazione esistente
     *
     * @param idvaccinazione l'id vaccinazione da controllare
     * @return <code>true</code> se la vaccinazione esiste, <code>false</code> altrimenti
     * @author Nicolas Guarini
     */
    public static boolean checkVaccinazioneEsistente(String idvaccinazione){
        try{
            return CentriVaccinali.server.checkVaccinazioneEsistente(idvaccinazione);
        }catch (RemoteException exception){
            exception.printStackTrace();
            return false;
        }
    }

    public static CentroVaccinale getCentroVaccinaleFromId(String id){
        try{
            return CentriVaccinali.server.getCentroVaccinaleFromId(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
