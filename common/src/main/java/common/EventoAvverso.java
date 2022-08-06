//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package common;

import java.io.Serializable;

/**
 * Modella le caratteristiche di un evento avverso segnalato da un cittadino vaccinato
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class EventoAvverso implements Serializable {
    /**
     * Proprietà che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>EventoAvverso</code>
     */
    private static final long serialVersionUID = 394107416364547627L;

    /**
     * Nome dell'evento avverso
     */
    private String nome;

    /**
     * Note aggiuntive sull'evento avverso
     */
    private String noteAggiuntive;

    /**
     * Severità dell'evento avverso da 1 a 5
     */
    private int severita;

    /**
     * Costruttore che salva i parametri nelle proprietà private della classe
     *
     * @param nome: nome dell'evento avverso
     * @param severita: severità dell'evento avverso (da 1 a 5)
     * @param noteAggiuntive: note aggiuntive (campo facoltativo)
     */
    public EventoAvverso(String nome, int severita, String noteAggiuntive){
        this.nome = nome;
        this.severita = severita;
        this.noteAggiuntive = noteAggiuntive;
    }

    /**
     * Ritorna la proprietà privata <code>severita</code>
     *
     * @return proprietà privata <code>severita</code>
     *
     * @author Nicolas Guarini
     */
    public int getSeverita(){
        return severita;
    }

    public String getNome() {return nome;}

    public String getNoteAggiuntive(){return noteAggiuntive;}
}
