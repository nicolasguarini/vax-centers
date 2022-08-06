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
     * Proprietà che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>Vaccinazione</code>
     */
    private static final long serialVersionUID = 5737449378412827456L;

    /**
     * Nome del vaccinato
     */
    private String nome;

    /**
     * Cognome del vaccinato
     */
    private String cognome;

    /**
     * Codice fiscale del vaccinato
     */
    private String cf;

    /**
     * Identificatore di 16 cifre della vaccinazione
     */
    private String id;

    /**
     * Nome del vaccino somministrato
     */
    private String nomeVaccino;

    /**
     * Data della somministrazione
     */
    private Date data;

    /**
     * Centro vaccinale dove è stata effettuata la somministrazione
     */
    private CentroVaccinale centroVaccinale;

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

    public void setEventiAvversi(LinkedList<EventoAvverso> eventiAvversi){
        this.eventiAvversi = eventiAvversi;
    }

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>centroVaccinale.nome</code>
     *
     * @return nome del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public String getNomeCentroVaccinale(){ return centroVaccinale.getNome(); }

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>id</code>
     *
     * @return id univoco vaccinazione di 16 cifre
     *
     * @author Nicolas Guarini
     */
    public String getIdVaccinazione(){return id;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>cf</code>
     *
     * @return codice fiscale del vaccinato
     *
     * @author Nicolas Guarini
     */
    public String getCf(){return cf;}

    public String getNomeVaccinato(){return nome;}

    public String getCognomeVaccinato(){return cognome;}

    public Date getDataVaccinazione(){return data;}

    public CentroVaccinale getCentroVaccinale(){return centroVaccinale;}

    public String getNomeVaccino(){return nomeVaccino;}
}
