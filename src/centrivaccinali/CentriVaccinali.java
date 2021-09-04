//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali;

import centrivaccinali.UI.UIStartMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 * La classe <code>CentriVaccinali</code> è la classe principale relativa alla logica della sezione dedicata ai Centri Vaccinali.
 * Mette a disposizione alle altre classi una serie di metodi che effettuano operazioni comuni o fanno da "ponte" con i file, comportandosi simbolicamente come un backend.
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class CentriVaccinali {
    /**
     * Il punto di avvio del programma.
     *
     * @param args: array di stringhe passate tramite parametri via riga di comando
     *
     * @author Nicolas Guarini
     * @author Domenico Rizzo
     * @author Filippo Alzati
     * @author Redon Kokaj
     */
    public static void main(String[] args){
        new UIStartMenu();
    }

    /**
     * Registra un nuovo centro vaccinale compiendo fondamentalmete tre operazioni:
     *   1: Si fa restituire la lista dei centri vaccinali registrati tramite il metodo {@link #getCentriVaccinali()}.
     *   2: Aggiunge alla lista il nuovo centro vaccinale da registrare.
     *   3: Serializza la lista aggiornata su file tramite il metodo {@link #serializzaCentriVaccinali(LinkedList)}.
     *
     * @see centrivaccinali.UI.UIRegistraCentroVaccinale
     *
     * @param centroVaccinale: centro vaccinale da registrare
     *
     * @author Nicolas Guarini
     */
    public static void registraCentroVaccinale(CentroVaccinale centroVaccinale){
        LinkedList<CentroVaccinale> centriVaccinali = getCentriVaccinali();
        centriVaccinali.add(centroVaccinale);
        serializzaCentriVaccinali(centriVaccinali);
    }

    /**
     * Legge da file la lista serializzata di centri vaccinali. Se il file esiste deserializza la lista e la ritorna, altrimenti crea il file e lo inizializza serializzandoci una lista vuota.
     *
     * @return Lista dei centri vaccinali registrati. Se non è salvato alcun centro vaccinale ritornerà una lista vuota
     */
    public static LinkedList<CentroVaccinale> getCentriVaccinali(){
        LinkedList<CentroVaccinale> centriVaccinali = new LinkedList<>();

        try{
            File fileCentriVaccinali = new File("data/CentriVaccinali.dati.txt");
            if(fileCentriVaccinali.createNewFile()) {
                serializzaCentriVaccinali(new LinkedList<>());
            }else{
                FileInputStream fileInputStream = new FileInputStream(fileCentriVaccinali);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                centriVaccinali = (LinkedList<CentroVaccinale>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return centriVaccinali;
    }

    /**
     * Serializza la lista di centri vaccinali e scrive il risultato di tale operazione sul file <code>CentriVaccinali.dati.txt</code>
     *
     * @param centriVaccinali: lista dei centri vaccinali da serializzare
     *
     * @author Nicolas Guarini
     */
    static void serializzaCentriVaccinali(LinkedList<CentroVaccinale> centriVaccinali){
        final String filepath = "data/CentriVaccinali.dati.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(centriVaccinali);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Registra una nuova vaccinazione su file, mediante quattro operazioni:
     *   1: recupera il nome del centro vaccinale dove è stata effettuata l'operazione (ci interessa il nome perchè i file che contengono i dati sulle vaccinazioni sono raggruppati per centro vaccinale mediante il nome dello stesso).
     *   2: si fa restituire la lista delle vaccinazioni per quel dato centro dal metodo {@link #getVaccinazioni(String)}.
     *   3: aggiunge la nuova vaccinazione alla lista.
     *   4: serializza la lista aggiornata mediante il metodo {@link #serializzaVaccinazioni(LinkedList, String)}
     *
     * @param vaccinazione: vaccinazione da registrare
     *
     * @author Nicolas Guarini
     */
    public static void registraVaccinazione(Vaccinazione vaccinazione){
        String nomeCentroVaccinale = vaccinazione.getNomeCentroVaccinale();
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(nomeCentroVaccinale);
        vaccinazioni.add(vaccinazione);
        serializzaVaccinazioni(vaccinazioni, nomeCentroVaccinale);
    }

    /**
     * Legge da file e deserializza la lista delle vaccinazioni relative a un dato centro vaccinale. Se il file non esiste lo crea e lo inizializza con una lista vuota.
     *
     * @param nomeCentroVaccinale: nome del centro vaccinale del quale vogliamo la lista delle vaccinazioni
     *
     * @return: Lista di vaccinazioni per un dato centro vaccinale, oppure una lista vuota nel caso in cui non ci sono vaccinazioni registrate.
     *
     * @author Nicolas Guarini
     */
    public static LinkedList<Vaccinazione> getVaccinazioni(String nomeCentroVaccinale){
        final String filepath = "data/Vaccinazioni_" + nomeCentroVaccinale + ".dati.txt";
        LinkedList<Vaccinazione> vaccinazioni = new LinkedList<>();

        try{
            File fileVaccinazioni = new File(filepath);
            if(fileVaccinazioni.createNewFile()){
                System.out.println("File created: " + fileVaccinazioni.getName());
                serializzaVaccinazioni(new LinkedList<Vaccinazione>(), nomeCentroVaccinale);
            }else{
                System.out.println("File already exist");
                FileInputStream fileInputStream = new FileInputStream(fileVaccinazioni);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                vaccinazioni = (LinkedList<Vaccinazione>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return vaccinazioni;
    }

    /**
     * Serializza una lista di vaccinazioni e scrive su file il risultato di tale operazione
     *
     * @see centrivaccinali.UI.UIRegistraVaccinato
     *
     * @param vaccinazioni: lista delle vaccinaizoni da serializzare
     * @param nomeCentroVaccinale: nome del centro vaccinale dove sono state effettuate le vaccinazioni
     *
     * @author Nicolas Guarini
     */
    public static void serializzaVaccinazioni(LinkedList<Vaccinazione> vaccinazioni, String nomeCentroVaccinale){
        final String filepath = "data/Vaccinazioni_" + nomeCentroVaccinale + ".dati.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vaccinazioni);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Conta le vaccinazioni registrate effettuate in un dato centro vaccinale
     *
     * @see cittadini.UI.UISegnalaEventoAvverso
     * @see cittadini.UI.UIVisualizzaCentriVaccinali
     *
     * @param centroVaccinale: centro vaccinale riguardo al quale vogliamo sapere il numero di segnalazioni
     * @return: numero di segnalazioni di eventi avversi per un dato centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public static int getNumSegnalazioniEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale.getNome());
        int count = 0;
        for(Vaccinazione v : vaccinazioni){
            count += v.getEventiAvversi().size();
        }
        return count;
    }

    /**
     * Calcola la severità media degli eventi avversi segnalati per un dato centro vaccinale
     *
     * @see cittadini.UI.UISegnalaEventoAvverso
     * @see cittadini.UI.UIVisualizzaCentriVaccinali
     *
     * @param centroVaccinale: centro vaccinale riguardo al quale vogliamo sapere la severità media degli eventi avversi segnalati
     * @return: media aritmetica della severità di tutti gli eventi avversi segnalati per un dato centro vaccinale
     */
    public static double getSeveritaMediaEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale.getNome());
        int countEventiAvversi = 0;
        int sommaSeverita = 0;
        double severitaMedia;

        for(Vaccinazione v : vaccinazioni){
            for(EventoAvverso e : v.getEventiAvversi()){
                countEventiAvversi += 1;
                sommaSeverita += e.getSeverita();
            }
        }

        if(countEventiAvversi == 0)
            return 0;
        else{
            severitaMedia = (double) sommaSeverita/countEventiAvversi;
            return Math.floor(severitaMedia * 100) / 100;
        }
    }
}
