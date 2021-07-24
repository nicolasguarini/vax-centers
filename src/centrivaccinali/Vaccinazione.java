package centrivaccinali;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Vaccinazione implements Serializable {
    private static final long serialVersionUID = 5737449378412827456L;
    String nome, cognome, cf, id, nomeVaccino;
    Date data;
    CentroVaccinale centroVaccinale;
    LinkedList<EventoAvverso> eventiAvversi = new LinkedList<>();

    public Vaccinazione(String nome, String cognome, String cf, String id, Date data, CentroVaccinale centroVaccinale, String nomeVaccino){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.id = id;
        this.nomeVaccino = nomeVaccino;
        this.centroVaccinale = centroVaccinale;
        this.data = data;
    }

    public void setEventiAvversi(LinkedList<EventoAvverso> eventiAvversi){
        this.eventiAvversi = eventiAvversi;
    }

    public LinkedList<EventoAvverso> getEventiAvversi(){
        return eventiAvversi;
    }

    public String getNomeCentroVaccinale(){ return centroVaccinale.getNome(); }
    public String getIdVaccinazione(){return id;}

    @Override
    public String toString(){ //a scopo di debug - si può togliere in produzione
        return nome + " " + cognome + " " + cf + " " + id + " " + nomeVaccino + " " + data + " " + centroVaccinale.getNome();
    }
}
