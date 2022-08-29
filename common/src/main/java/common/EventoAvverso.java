//NICOLAS GUARINI 745508 VA
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
     * Proprieta' che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>EventoAvverso</code>
     */
    private static final long serialVersionUID = 394107416364547627L;

    /**
     * Nome dell'evento avverso
     */
    private final String nome;

    /**
     * Note aggiuntive sull'evento avverso
     */
    private final String noteAggiuntive;

    /**
     * Severita' dell'evento avverso da 1 a 5
     */
    private final int severita;

    /**
     * Costruttore che salva i parametri nelle proprietà private della classe
     *
     * @param nome nome dell'evento avverso
     * @param severita severità dell'evento avverso (da 1 a 5)
     * @param noteAggiuntive note aggiuntive (campo facoltativo)
     */
    public EventoAvverso(String nome, int severita, String noteAggiuntive){
        this.nome = nome;
        this.severita = severita;
        this.noteAggiuntive = noteAggiuntive;
    }

    /**
     * Ritorna la proprieta' privata <code>severita</code>
     *
     * @return proprieta' privata <code>severita</code>
     *
     * @author Nicolas Guarini
     */
    public int getSeverita(){
        return severita;
    }

    /**
     * Ritorna la proprieta' privata <code>nome</code>
     *
     * @return proprieta' privata <code>nome</code>
     *
     * @author Nicolas Guarini
     */
    public String getNome() {return nome;}

    /**
     * Ritorna la proprieta' privata <code>noteAggiuntive</code>
     *
     * @return proprieta' privata <code>noteAggiuntive</code>
     *
     * @author Nicolas Guarini
     */
    public String getNoteAggiuntive(){return noteAggiuntive;}
}
