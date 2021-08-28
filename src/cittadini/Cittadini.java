//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.EventoAvverso;
import centrivaccinali.Vaccinazione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
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
    /**
     * Registra un nuovo cittadino compiendo tre operazioni:
     *    1: Si fa restituire la lista dei cittadini registrati tramite il metodo {@link #getCittadini()};
     *    2: Aggiunge alla lista il nuovo cittadino:
     *    3: Serializza la lista aggiornata su file tramite il metodo {@link #serializzaCittadini(LinkedList)}
     *
     * @param cittadino cittadino da registrare
     *
     * @author Nicolas Guarini
     */
    public static void registraCittadino(Cittadino cittadino){
        LinkedList<Cittadino> cittadini = getCittadini();
        cittadini.add(cittadino);
        serializzaCittadini(cittadini);
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
            File fileCittadini = new File("data/Cittadini_Registrati.dati.txt");
            if(fileCittadini.createNewFile()){
                serializzaCittadini(new LinkedList<>());
            }else{
                FileInputStream fileInputStream = new FileInputStream(fileCittadini);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                cittadini = (LinkedList<Cittadino>) objectInputStream.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return cittadini;
    }

    /**
     * Serializza la lista di cittadini e scrive il risultato di tale operazione sul file <code>Cittadini_Registrati.dati.txt</code>
     *
     * @param cittadini lista da serializzare
     *
     * @author Nicolas Guarini
     */
    static void serializzaCittadini(LinkedList<Cittadino> cittadini){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("data/Cittadini_Registrati.dati.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cittadini);
            objectOutputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
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
    public static void registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso){
        String nomeCentroVaccinale = cittadino.getCentroVaccinale().getNome();
        LinkedList<Vaccinazione> vaccinazioniCentroVaccinale = CentriVaccinali.getVaccinazioni(nomeCentroVaccinale);
        for(Vaccinazione i : vaccinazioniCentroVaccinale){
            if(i.getCf().equals(cittadino.cf)){
                i.getEventiAvversi().add(eventoAvverso);
                break;
            }
        }
        CentriVaccinali.serializzaVaccinazioni(vaccinazioniCentroVaccinale, nomeCentroVaccinale);
    }
}
