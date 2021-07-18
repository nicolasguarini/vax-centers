package centrivaccinali;

import java.util.Date;

public class Vaccinazione {
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
}
