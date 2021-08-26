package centrivaccinali;

import java.io.Serial;
import java.io.Serializable;

/**
 * Modella le caratteristiche di un evento avverso segnalato da un cittadino vaccinato
 *
 * @see cittadini.UI.UISegnalaEventoAvverso
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class EventoAvverso implements Serializable {
    @Serial
    private static final long serialVersionUID = 394107416364547627L;
    String nome, noteAggiuntive;
    int severita;

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
}
