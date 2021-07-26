package centrivaccinali;

import java.io.Serializable;

public class CentroVaccinale implements Serializable {
    private static final long serialVersionUID = 4756400710762104818L;
    private String nome, tipologia;
    private Indirizzo indirizzo;

    public CentroVaccinale(String nome, Indirizzo indirizzo, String tipologia){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;
    }

    public String getNome(){return nome;}
    public Indirizzo getIndirizzo(){return indirizzo;}
    public String getComune(){return indirizzo.getComune();}
    public String getTipologia(){return tipologia;}
}
