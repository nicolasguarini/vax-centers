package cittadini;

import java.io.Serializable;

public class Cittadino implements Serializable {
    String nome, cognome, cf, email, username, password, idVaccinazione;

    public Cittadino(String nome, String cognome, String cf, String email, String username, String password, String idVaccinazione){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.email = email;
        this.idVaccinazione = idVaccinazione;
    }

    public String toString(){ //DEBUG
        return nome + " " + cognome;
    }

    public String getUsername(){return username;}
}
