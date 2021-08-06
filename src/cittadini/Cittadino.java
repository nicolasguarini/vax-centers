package cittadini;

import centrivaccinali.CentroVaccinale;

import java.io.Serial;
import java.io.Serializable;

public class Cittadino implements Serializable {
    @Serial
    private static final long serialVersionUID = -3712425753326956399L;
    String nome, cognome, cf, email, username, password, idVaccinazione;
    CentroVaccinale centroVaccinale;

    public Cittadino(String nome, String cognome, String cf, String email, String username, String password, String idVaccinazione, CentroVaccinale centroVaccinale){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.email = email;
        this.idVaccinazione = idVaccinazione;
        this.centroVaccinale = centroVaccinale;
    }

    public String toString(){ //DEBUG
        return nome + " " + cognome;
    }

    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getIdVaccinazione(){return idVaccinazione;}
    public String getCF(){return cf;}
    public String getNome(){return nome;}
    public String getCognome(){return cognome;}
    public CentroVaccinale getCentroVaccinale(){return centroVaccinale;}
}
