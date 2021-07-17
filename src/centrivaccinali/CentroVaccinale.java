package centrivaccinali;

import java.io.Serializable;
import java.util.Base64;

public class CentroVaccinale implements Serializable {
    private static final long serialVersionUID = 4756400710762104818L;
    private String nome;
    private Indirizzo indirizzo;
    private String tipologia;
    private String idCentro;

    public CentroVaccinale(String nome, Indirizzo indirizzo, String tipologia){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;

        generaIdCentro();
    }

    private void generaIdCentro(){
        idCentro = Base64.getEncoder().encodeToString((nome + indirizzo.toString() + tipologia).getBytes());
    }

    @Override
    public String toString(){
        return nome + " " + indirizzo + " " + tipologia;
    }

    public String getIdCentro(){ return idCentro; }
    public String getNome(){return nome;}
    public Indirizzo getIndirizzo(){return indirizzo;}
}
