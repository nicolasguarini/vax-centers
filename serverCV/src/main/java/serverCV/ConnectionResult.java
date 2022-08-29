//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package serverCV;

/**
 * Enumerazione sull'esito della procedura di connessione al server Postgres
 *
 * @see serverCV.UI.UIStartMenu
 * @see ServerCV
 * @see DBManager
 * @see ServerImpl
 *
 * @author Nicolas Guarini
 */
public enum ConnectionResult {
    OK, DB_CREATED, FAILED
}
