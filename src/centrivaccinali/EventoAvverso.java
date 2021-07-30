package centrivaccinali;

import java.io.Serial;
import java.io.Serializable;

public class EventoAvverso implements Serializable {
    @Serial
    private static final long serialVersionUID = 394107416364547627L;
    String nome, noteAggiuntive;
    int severita;

    public EventoAvverso(String nome, int severita, String noteAggiuntive){
        this.nome = nome;
        this.severita = severita;
        this.noteAggiuntive = noteAggiuntive;
    }
}
