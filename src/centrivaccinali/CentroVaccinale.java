package centrivaccinali;

import java.util.Base64;

public class CentroVaccinale {
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

    public String getIdCentro(){ return idCentro; }
}
