package centrivaccinali;

import java.io.Serializable;

public class EventoAvverso implements Serializable {
    String nome;
    int severita;
    String noteAggiuntive;

    public EventoAvverso(String nome, int severita, String noteAggiuntive){
        this.nome = nome;
        this.severita = severita;
        this.noteAggiuntive = noteAggiuntive;
    }

    public String toString(){return nome;}
}
