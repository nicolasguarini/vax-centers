//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini;

import centrivaccinali.CentriVaccinali;
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
}
