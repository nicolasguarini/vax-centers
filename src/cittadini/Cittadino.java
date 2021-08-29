//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini;

import centrivaccinali.CentroVaccinale;

import java.io.Serial;
import java.io.Serializable;

/**
 * Modella le caratteristiche di un Cittadino
 *
 * @see cittadini.UI.UIRegistraCittadino
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class Cittadino implements Serializable {
    /**
     * Proprietà che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>Cittadino</code>
     */
    @Serial
    private static final long serialVersionUID = -3712425753326956399L;

    /**
     * Nome del cittadino
     */
    private String nome;

    /**
     * Cognome del cittadino
     */
    private String cognome;

    /**
     * Codice fiscale del cittadino
     */
    private String cf;

    /**
     * Email del cittadino
     */
    private String email;

    /**
     * Username del cittadino
     */
    private String username;

    /**
     * Password del cittadino
     */
    private String password;

    /**
     * ID vaccinazione
     */
    private String idVaccinazione;

    /**
     * Centro vaccinale dove è stata effettuata la vaccinazione
     */
    private CentroVaccinale centroVaccinale;

    /**
     * Costruttore che salva nelle proprietà private i dati passati per parametro
     *
     * @param nome nome del cittadino
     * @param cognome cognome del cittadino
     * @param cf codice fiscale del cittadino
     * @param email email del cittadino
     * @param username username del cittadino
     * @param password password del cittadino (crittografata con l'algoritmo <code>SHA256</code>
     * @param idVaccinazione id vaccinazione di 16 cifre che identifica la vaccinazione effettuata dal cittadino
     * @param centroVaccinale centro vaccinale dove è stata effettuata la vaccinazione
     *
     * @author Nicolas Guarini
     */
    public Cittadino(String nome, String cognome, String cf, String email, String username, String password, String idVaccinazione, CentroVaccinale centroVaccinale){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.email = email;
        this.idVaccinazione = idVaccinazione;
        this.centroVaccinale = centroVaccinale;
    }

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>username</code>
     *
     * @return: username del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getUsername(){return username;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>email</code>
     *
     * @return: email del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getEmail(){return email;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>password</code>
     *
     * @return: password del cittadino (crittografata con l'algoritmo <code>SHA256</code>
     * @author Nicolas Guarini
     */
    public String getPassword(){return password;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>idVaccinazione</code>
     *
     * @return: id vaccinazione del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getIdVaccinazione(){return idVaccinazione;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>cf</code>
     *
     * @return: codice fiscale del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getCF(){return cf;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>nome</code>
     *
     * @return: nome del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getNome(){return nome;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>cognome</code>
     *
     * @return: cognome del cittadino
     *
     * @author Nicolas Guarini
     */
    public String getCognome(){return cognome;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>centroVaccinale</code>
     *
     * @return: centro vaccinale dove il cittadino ha effettuato la vaccinazione
     *
     * @author Nicolas Guarini
     */
    public CentroVaccinale getCentroVaccinale(){return centroVaccinale;}
}
