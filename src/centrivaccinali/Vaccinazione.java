package centrivaccinali;

import java.io.Serializable;
import java.util.Date;

public class Vaccinazione implements Serializable {
    private static final long serialVersionUID = 5737449378412827456L;
    String nome, cognome, cf, id, nomeVaccino;
    Date data;
    CentroVaccinale centroVaccinale;

    public Vaccinazione(String nome, String cognome, String cf, String id, Date data, CentroVaccinale centroVaccinale, String nomeVaccino){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.id = id;
        this.nomeVaccino = nomeVaccino;
        this.centroVaccinale = centroVaccinale;
        this.data = data;
    }

    public String getNomeCentroVaccinale(){ return centroVaccinale.getNome(); }

    @Override
    public String toString(){ //a scopo di debug - si può togliere in produzione
        return nome + " " + cognome + " " + cf + " " + id + " " + nomeVaccino + " " + data + " " + centroVaccinale.getNome();
    }
}
