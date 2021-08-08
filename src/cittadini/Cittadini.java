package cittadini;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import centrivaccinali.EventoAvverso;
import centrivaccinali.Vaccinazione;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.LinkedList;

public class Cittadini {
    public static void registraCittadino(Cittadino cittadino){
        LinkedList<Cittadino> cittadini = getCittadini();
        cittadini.add(cittadino);
        serializzaCittadini(cittadini);
    }

    public static LinkedList<Cittadino> getCittadini(){
        LinkedList<Cittadino> cittadini = new LinkedList<>();

        try{
            File fileCittadini = new File("./data/Cittadini_Registrati.dati.txt");
            if(fileCittadini.createNewFile()){
                serializzaCittadini(new LinkedList<>());
            }else{
                FileInputStream fileInputStream = new FileInputStream(fileCittadini);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                cittadini = (LinkedList<Cittadino>) objectInputStream.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return cittadini;
    }

    static void serializzaCittadini(LinkedList<Cittadino> cittadini){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("./data/Cittadini_Registrati.dati.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cittadini);
            objectOutputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String sha256(String password) {
        String encoded = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        }catch(Exception e){
            e.printStackTrace();
        }

        return encoded;
    }

    public static boolean checkUsername(String username){ //TODO: trasferire tutti questi check di merda nella classe dove vengono usati, qui non c'entrano niente e fanno solo confusione
        for(Cittadino i : getCittadini())
            if(i.getUsername().equalsIgnoreCase(username)) return false;

        return true;
    }

    public static boolean checkEmail(String email){
        for(Cittadino i : getCittadini())
            if (i.getEmail().equalsIgnoreCase(email)) return false;

        return true;
    }

    public static boolean checkIdVaccinazioneGiaRegistrata(String idVaccinazione){
        for(Cittadino i : getCittadini())
            if(i.getIdVaccinazione().equals(idVaccinazione)) return false;

        return true;
    }

    public static boolean checkIdVaccinazioneEsistente(String idVaccinazione, CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = CentriVaccinali.getVaccinazioni(centroVaccinale.getNome());
        for(Vaccinazione i : vaccinazioni){
            if(i.getIdVaccinazione().equals(idVaccinazione))
                return true;
        }

        return false;
    }

    public static boolean checkCF(String cf){
        for(Cittadino i : getCittadini())
            if(i.getCF().equalsIgnoreCase(cf)) return false;

        return true;
    }

    public static void registraEventoAvverso(Cittadino cittadino, EventoAvverso eventoAvverso){
        String nomeCentroVaccinale = cittadino.getCentroVaccinale().getNome();
        LinkedList<Vaccinazione> vaccinazioniCentroVaccinale = CentriVaccinali.getVaccinazioni(nomeCentroVaccinale);
        for(Vaccinazione i : vaccinazioniCentroVaccinale){
            if(i.getCf().equals(cittadino.cf)){
                i.getEventiAvversi().add(eventoAvverso);
                break;
            }
        }
        CentriVaccinali.serializzaVaccinazioni(vaccinazioniCentroVaccinale, nomeCentroVaccinale);
    }
}
