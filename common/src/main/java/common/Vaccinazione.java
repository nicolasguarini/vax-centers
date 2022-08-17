//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package common;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 * Modella le caratteristiche di una vaccinazione
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class Vaccinazione implements Serializable {
    /**
     * Proprieta' che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>Vaccinazione</code>
     */
    private static final long serialVersionUID = 5737449378412827456L;

    /**
     * Nome del vaccinato
     */
    private final String nome;

    /**
     * Cognome del vaccinato
     */
    private final String cognome;

    /**
     * Codice fiscale del vaccinato
     */
    private final String cf;

    /**
     * Identificatore di 16 cifre della vaccinazione
     */
    private final String id;

    /**
     * Nome del vaccino somministrato
     */
    private final String nomeVaccino;

    /**
     * Data della somministrazione
     */
    private final Date data;

    /**
     * Centro vaccinale dove è stata effettuata la somministrazione
     */
    private final CentroVaccinale centroVaccinale;

    /**
     * Eventi avversi segnalati dal vaccinato
     */
    private LinkedList<EventoAvverso> eventiAvversi = new LinkedList<>();

    /**
     * Costruttore che salva i parametri nelle proprietà private della classe
     *
     * @param nome: nome del vaccinato
     * @param cognome: cognome del vaccinato
     * @param cf: codice fiscale del vaccinato
     * @param id: id univoco vaccinazione di 16 cifre
     * @param data: data della vaccinazione
     * @param centroVaccinale: centro vaccinale dove è stata effettuata la vaccinazione
     * @param nomeVaccino: nome del vaccino somministrato
     *
     * @author Nicolas Guarini
     */
    public Vaccinazione(String nome, String cognome, String cf, String id, Date data, CentroVaccinale centroVaccinale, String nomeVaccino){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.id = id;
        this.nomeVaccino = nomeVaccino;
        this.centroVaccinale = centroVaccinale;
        this.data = data;
    }

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>eventiAvversi</code>
     *
     * @return lista degli eventi avversi
     *
     * @author Nicolas Guarini
     */
    public LinkedList<EventoAvverso> getEventiAvversi(){
        return eventiAvversi;
    }

    /**
     * Permette di salvare una lista di eventi avversi nella proprieta' privata <code>eventiAvversi</code>
     *
     * @param eventiAvversi gli eventi avversi relativi alla vaccinazione
     *
     * @author Nicolas Guarini
     */
    public void setEventiAvversi(LinkedList<EventoAvverso> eventiAvversi){
        this.eventiAvversi = eventiAvversi;
    }

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>id</code>
     *
     * @return id univoco vaccinazione di 16 cifre
     *
     * @author Nicolas Guarini
     */
    public String getIdVaccinazione(){return id;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>cf</code>
     *
     * @return codice fiscale del vaccinato
     *
     * @author Nicolas Guarini
     */
    public String getCf(){return cf;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>nome</code>
     *
     * @return nome del vaccinato
     *
     * @author Nicolas Guarini
     */
    public String getNomeVaccinato(){return nome;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>cognome</code>
     *
     * @return cognome del vaccinato
     *
     * @author Nicolas Guarini
     */
    public String getCognomeVaccinato(){return cognome;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>data</code>
     *
     * @return data della vaccinazione
     *
     * @author Nicolas Guarini
     */
    public Date getDataVaccinazione(){return data;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>centroVaccinale</code>
     *
     * @return centro vaccinale dove e' stata effettuata la vaccinazione
     *
     * @author Nicolas Guarini
     */
    public CentroVaccinale getCentroVaccinale(){return centroVaccinale;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprieta' privata <code>nomeVaccino</code>
     *
     * @return nome del vaccino somministrato
     *
     * @author Nicolas Guarini
     */
    public String getNomeVaccino(){return nomeVaccino;}
}
