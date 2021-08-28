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
    @Serial
    private static final long serialVersionUID = 4756400710762104818L;
    private String nome, tipologia;
    private Indirizzo indirizzo;
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
    public CentroVaccinale(String nome, Indirizzo indirizzo, String tipologia){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;
        id = generaId();
    }

    /**
     * Genera un codice univoco di 5 cifre che identifica il centro vaccinale. Insieme al'ID relativo al vaccinato formerà l'ID vaccinazione
     *
     * @see centrivaccinali.UI.UIRegistraVaccinato
     *
     * @return ID numerico di 5 cifre che identfica il centro vaccinale
     *
     * @author Nicolas Guarini
     */
    String generaId(){
        String id = "";
        int size = CentriVaccinali.getCentriVaccinali().size() + 1;
        int length = String.valueOf(size).length();

        for(int i = 0; i < 5 - length; i++){
            id += "0";
        }

        id += String.valueOf(size);

        return id;
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
