package centrivaccinali;

import java.io.Serial;
import java.io.Serializable;

public class CentroVaccinale implements Serializable {
    @Serial
    private static final long serialVersionUID = 4756400710762104818L;
    private String nome, tipologia;
    private Indirizzo indirizzo;
    private String id;

    public CentroVaccinale(String nome, Indirizzo indirizzo, String tipologia){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;
        id = generaId();
    }

    String generaId(){
        String id = "";
        int size = CentriVaccinali.getCentriVaccinali().size() + 1;
        int length = String.valueOf(size).length();

        for(int i = 0; i < 5 - length; i++){
            id += "0";
        }

        id += String.valueOf(size);

        System.out.println(id); //TODO: DEBUG
        return id;
    }

    public String getNome(){return nome;}
    public Indirizzo getIndirizzo(){return indirizzo;}
    public String getComune(){return indirizzo.getComune();}
    public String getTipologia(){return tipologia;}
    public String getId(){return id;}
}
