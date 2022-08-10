//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini;

import centrivaccinali.CentriVaccinali;
import common.Cittadino;
import common.EventoAvverso;
import common.Vaccinazione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.LinkedList;

/**
 * Classe principale della sezione dedicata ai cittadini.
 * Mette a disposizione alle altre classi una serie di metodi che effettuano operazioni comuni o fanno da "ponte" con i file, comportandosi simbolicamente con un backend
 *
 * @see cittadini.UI.UICittadini
 *
 * @author Nicolas Guarini
 * @author Redon Kokaj
 * @author Domenico Rizzo
 * @author Filippo Alzati
 */
public class Cittadini {
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
     * Legge da file la lista serializzata di cittadini.
     * Se il file esiste deserializza la lista e la ritorna, altrimenti crea il file e lo inizializza con una lista vuota
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
     * @return password crittografata
     */
    public static String sha256(String password) {
        String encoded = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        }catch(Exception e){
            e.printStackTrace();
        }

        return encoded;
    }

    /**
     * Aggiunge il nuovo evento avverso alla lista <code>eventiAvversi</code> dell'oggetto di tipo <code>Vaccinazione</code>, e la serializza su file.
     *
     * @param cittadino cittadino che sta segnalando l'evento avverso
     * @param eventoAvverso evento avverso da segnalare
     *
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
