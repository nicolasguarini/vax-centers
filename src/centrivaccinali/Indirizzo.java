package centrivaccinali;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe che modella le caratteristiche di un indirizzo
 *
 * @see centrivaccinali.UI.UIRegistraVaccinato
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class Indirizzo implements Serializable {
    @Serial
    private static final long serialVersionUID = -1709094232830800244L;

    private String qualificatore, nome, numeroCivico, comune, provincia, CAP;

    /**
     * Costruttore che salva i parametri nelle proprietà private della classe
     *
     * @param qualificatore: via / viale / piazza
     * @param nome: nome dell'indirizzo
     * @param numeroCivico: numero civico dell'indirizzo
     * @param comune: comune dell'indirizzo
     * @param provincia: provincia dell'indirizzo
     * @param CAP: codice di avviamento postale di 5 cifre dell'indirizzo
     *
     * @author Nicolas Guarini
     */
    public Indirizzo(String qualificatore, String nome, String numeroCivico, String comune, String provincia, String CAP) {
        this.qualificatore = qualificatore;
        this.nome = nome;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.CAP = CAP;
    }

    /**
     * Permette di accedere a metodi e classi esterne alla proprietà privata <code>comune</code>
     *
     * @return: comune dell'indirizzo
     *
     * @author Nicolas Guarini
     */
    public String getComune(){return comune;}

    /**
     * Raggruppa in una stringa le principali informazioni dell'indirizzo
     *
     * @return: string che contine le informazioni principali dell'indirizzo
     *
     * @author Nicolas Guarini
     */
    public String toString(){
        return qualificatore + " " + nome + " " + numeroCivico + ", " + comune + " (" + provincia + ") " + CAP;
    }
}
