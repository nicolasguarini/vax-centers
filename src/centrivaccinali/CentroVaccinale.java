//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe che modella le caratteristiche di un centro vaccinale
 *
 * @see centrivaccinali.UI.UICentriVaccinali
 * @see centrivaccinali.UI.UIRegistraCentroVaccinale
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class CentroVaccinale implements Serializable {
    /**
     * Proprietà che permette il funzionamento dei processi di serializzazione e deserializzazione degli oggetti di tipo <code>CentroVaccinale</code>
     */
    @Serial
    private static final long serialVersionUID = 4756400710762104818L;

    /**
     * Nome del centro vaccinale
     */
    private String nome;

    /**
     * Tipologia del centro vaccinale
     */
    private String tipologia;

    /**
     * Indirizzo del centro vaccinale
     */
    private Indirizzo indirizzo;

    /**
     * Identificatore di 5 cifre del centro vaccinale
     */
    private String id;

    /**
     * Costruttore che salva i parametri nelle proprietà private della classe
     *
     * @param nome: nome del centro vaccinale
     * @param indirizzo: indirizzo del centro vaccinale
     * @param tipologia: tipologia del centro vaccinale (ospedaliero / hub / aziendale)
     *
     * @author Nicolas Guarini
     */
    public CentroVaccinale(String nome, Indirizzo indirizzo, String tipologia, String id){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;
        this.id = id;
    }



    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>nome</code>
     *
     * @return: nome del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public String getNome(){return nome;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>indirizzo</code>
     *
     * @return: indirizzo del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public Indirizzo getIndirizzo(){return indirizzo;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>indirizzo.comune</code>
     *
     * @return: comune del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public String getComune(){return indirizzo.getComune();}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>tipologia</code>
     *
     * @return: tipologia del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public String getTipologia(){return tipologia;}

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>id</code>
     *
     * @return: ID di 5 cifre del centro vaccinale
     *
     * @author Nicolas Guarini
     */
    public String getId(){return id;}
}
