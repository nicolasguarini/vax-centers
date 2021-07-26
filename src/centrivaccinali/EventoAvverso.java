package centrivaccinali;

import java.io.Serializable;

public class EventoAvverso implements Serializable {
    String nome, noteAggiuntive;
    int severita;

    public EventoAvverso(String nome, int severita, String noteAggiuntive){
        this.nome = nome;
        this.severita = severita;
        this.noteAggiuntive = noteAggiuntive;
    }
}
