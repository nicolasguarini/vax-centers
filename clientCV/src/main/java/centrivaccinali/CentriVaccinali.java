//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali;

import centrivaccinali.UI.UIConnectToServer;
import common.CentroVaccinale;
import common.EventoAvverso;
import common.ServerInterface;
import common.Vaccinazione;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.LinkedList;

/**
 * La classe <code>CentriVaccinali</code> è la classe principale relativa alla logica della sezione dedicata ai Centri Vaccinali.
 * Mette a disposizione alle altre classi una serie di metodi che effettuano operazioni comuni e/o si interfacciano con il server remoto, separando la logica applicativa da quella di presentazione.
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class CentriVaccinali {
    /**
     *  Oggetto che permette la comunicazione tra client e server, occupandosi di stabilire e mantenere la connessione con l'oggetto remoto.
     */
    static Registry registry;

    /**
     * Oggetto remoto che implementa i metodi dell'interfaccia <code>ServerInterface</code> fungendo da stub per il client.
     */
    static ServerInterface server;

    /**
     * Il punto di avvio del programma.
     *
     * @param args array di stringhe passate tramite parametri da riga di comando
     *
     * @author Nicolas Guarini
     * @author Domenico Rizzo
     * @author Filippo Alzati
     * @author Redon Kokaj
     */
    public static void main(String[] args){
        new UIConnectToServer();
    }

    /**
     * Contatta il server remoto inviandogli il centro vaccinale da registrare e attendendo l'esito dell'operazione
     *
     * @see centrivaccinali.UI.UIRegistraCentroVaccinale
     *
     * @param centroVaccinale centro vaccinale da registrare
     *
     * @author Nicolas Guarini
     * @return Esito dell'operazione d'inserimento nel database.
     */
    public static boolean registraCentroVaccinale(CentroVaccinale centroVaccinale){
        boolean result = false;
        try {
            result = CentriVaccinali.server.registraCentroVaccinale(centroVaccinale);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Contatta il server remoto, che ritornerà la lista dei centri vaccinali presenti nel database
     *
     * @author Nicolas Guarini
     * @return Lista dei centri vaccinali registrati. Se non è presente alcun centro vaccinale ritornerà una lista vuota
     */
    public static LinkedList<CentroVaccinale> getCentriVaccinali(){
        try {
            return CentriVaccinali.server.getCentriVaccinali();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    /**
     * Contatta il server remoto inviandogli l'oggetto <code>Vaccinazione</code> da registrare.
     *
     * @param vaccinazione vaccinazione da registrare
     *
     * @author Nicolas Guarini
     * @return Esito dell'operazione d'inserimento nel database.
     */
    public static boolean registraVaccinazione(Vaccinazione vaccinazione){
        boolean result = false;
        try{
            result = CentriVaccinali.server.registraVaccinato(vaccinazione);
        }catch (RemoteException e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Contatta il server remoto che ritornerà la lista delle vaccinazioni effettuate in un determinato centro vaccinale
     *
     * @param centroVaccinale Il centro vaccinale del quale vogliamo sapere le vaccinazioni effettuate
     *
     * @author Nicolas Guarini
     * @return Lista di vaccinazioni effettuate in un dato centro vaccinale
     */
    public static LinkedList<Vaccinazione> getVaccinazioni(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = new LinkedList<>();

        try{
            vaccinazioni = CentriVaccinali.server.getVaccinazioni(centroVaccinale);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return vaccinazioni;
    }

    /**
     * Conta le vaccinazioni registrate effettuate in un dato centro vaccinale
     *
     * @see cittadini.UI.UISegnalaEventoAvverso
     * @see cittadini.UI.UIVisualizzaCentriVaccinali
     *
     * @param centroVaccinale centro vaccinale riguardo al quale vogliamo sapere il numero di segnalazioni
     * @return  numero di segnalazioni di eventi avversi per un dato centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public static int getNumSegnalazioniEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale);

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
     * @param centroVaccinale centro vaccinale riguardo al quale vogliamo sapere la severità media degli eventi avversi segnalati
     * @return  media aritmetica della severità di tutti gli eventi avversi segnalati per un dato centro vaccinale
     */
    public static double getSeveritaMediaEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale);
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

    /**
     * Contatta il server remoto che ritornerà l'esito del controllo sul nome del centro vaccinale.
     *
     * @param nomeCentroVaccinale il nome del centro di cui si vuole controllare l'unicità del nome
     * @return <code>true</code> se esiste già un centro con lo stesso nome, <code>false</code> altrimenti.
     * @author Nicolas Guarini
     */
    public static boolean checkNomeCentroVaccinale(String nomeCentroVaccinale){
        try{
            return CentriVaccinali.server.checkNomeCentroVaccinale(nomeCentroVaccinale);
        }catch (RemoteException e){
            e.printStackTrace();
            return true;
        }
    }

    /**
     * Metodo che ritorna l'attributo privato <code>registry</code>
     * @return attributo privato <code>registry</code>
     * @author Nicolas Guarini
     */
    public static Registry getRegistry(){
        return registry;
    }

    /**
     * Metodo che ritorna l'attributo privato <code>server</code>
     * @return attributo privato <code>server</code>
     * @author Nicolas Guarini
     */
    public static ServerInterface getServer(){
        return server;
    }

    /**
     * Metodo che aggiorna l'attributo privato <code>registry</code>
     * @param registry il registry da impostare
     * @author Nicolas Guarini
     */
    public static void setRegistry(Registry registry){
        CentriVaccinali.registry = registry;
    }

    /**
     * Metodo che aggiorna l'attributo privato <code>server</code>
     * @param server il server da impostare
     * @author Nicolas Guarini
     */
    public static void setServer(ServerInterface server){
        CentriVaccinali.server = server;
    }
}
