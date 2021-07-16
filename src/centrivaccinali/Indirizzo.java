package centrivaccinali;

import java.io.Serializable;

public class Indirizzo implements Serializable {
    private static final long serialVersionUID = -1709094232830800244L;
    private String qualificatore;
    private String nome;
    private String numeroCivico;
    private String comune;
    private String provincia;
    private String CAP;

    public Indirizzo(String qualificatore, String nome, String numeroCivico, String comune, String provincia, String CAP) {
        this.qualificatore = qualificatore;
        this.nome = nome;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.CAP = CAP;
    }

    public String toString(){
        return qualificatore + " " + nome + " " + numeroCivico + ", " + comune + " (" + provincia + ") " + CAP;
    }
}
