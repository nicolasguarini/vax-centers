//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package serverCV;

/**
 * Interfaccia che descrive il comportamento dei Listener, ovvero quelle entità che sono interessate
 * agli aggiornamenti ai messaggi di log del server.
 *
 * @author Nicolas Guarini
 */
public interface LogListener {
    /**
     * Metodo che gestisce l'aggiornamento dei messaggi di log, aggiungendo quello passato per parametro
     *
     * @param message il nuovo messaggio di log da aggiungere
     *
     * @author Nicolas Guarini
     */
    void updateLog(String message);
}
