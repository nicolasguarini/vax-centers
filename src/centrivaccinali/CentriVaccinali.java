package centrivaccinali;

import centrivaccinali.UI.UIStartMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class CentriVaccinali {
    public static void main(String[] args){
        new UIStartMenu();
    }

    public static void registraCentroVaccinale(CentroVaccinale centroVaccinale){
        LinkedList<CentroVaccinale> centriVaccinali = getCentriVaccinali();
        centriVaccinali.add(centroVaccinale);
        serializzaCentriVaccinali(centriVaccinali);
    }

    public static LinkedList<CentroVaccinale> getCentriVaccinali(){
        LinkedList<CentroVaccinale> centriVaccinali = new LinkedList<>();

        try{
            File fileCentriVaccinali = new File("data/CentriVaccinali.dati.txt");
            if(fileCentriVaccinali.createNewFile()) {
                serializzaCentriVaccinali(new LinkedList<>());
            }else{
                FileInputStream fileInputStream = new FileInputStream(fileCentriVaccinali);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                centriVaccinali = (LinkedList<CentroVaccinale>) objectInputStream.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return centriVaccinali;
    }

    static void serializzaCentriVaccinali(LinkedList<CentroVaccinale> centriVaccinali){
        final String filepath = "data/CentriVaccinali.dati.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(centriVaccinali);
            objectOutputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void registraVaccinazione(Vaccinazione vaccinazione){
        String nomeCentroVaccinale = vaccinazione.getNomeCentroVaccinale();
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(nomeCentroVaccinale);
        vaccinazioni.add(vaccinazione);
        serializzaVaccinazioni(vaccinazioni, nomeCentroVaccinale);
    }

    public static LinkedList<Vaccinazione> getVaccinazioni(String nomeCentroVaccinale){
        final String filepath = "data/Vaccinazioni_" + nomeCentroVaccinale + ".dati.txt";
        LinkedList<Vaccinazione> vaccinazioni = new LinkedList<>();

        try{
            File fileVaccinazioni = new File(filepath);
            if(fileVaccinazioni.createNewFile()){
                System.out.println("File created: " + fileVaccinazioni.getName());
                serializzaVaccinazioni(new LinkedList<Vaccinazione>(), nomeCentroVaccinale);
            }else{
                System.out.println("File already exist");
                FileInputStream fileInputStream = new FileInputStream(fileVaccinazioni);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                vaccinazioni = (LinkedList<Vaccinazione>) objectInputStream.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return vaccinazioni;
    }

    public static void serializzaVaccinazioni(LinkedList<Vaccinazione> vaccinazioni, String nomeCentroVaccinale){ //O(n)
        final String filepath = "data/Vaccinazioni_" + nomeCentroVaccinale + ".dati.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vaccinazioni);
            objectOutputStream.close();
            System.out.println("Oggetto serializzato correttamente");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int getNumSegnalazioniEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale.getNome());
        int count = 0;
        for(Vaccinazione v : vaccinazioni){
            count += v.getEventiAvversi().size();
        }
        return count;
    }

    public static double getSeveritaMediaEventiAvversi(CentroVaccinale centroVaccinale){
        LinkedList<Vaccinazione> vaccinazioni = getVaccinazioni(centroVaccinale.getNome());
        int countEventiAvversi = 0;
        int sommaSeverita = 0;
        double severitaMedia;

        for(Vaccinazione v : vaccinazioni){
            for(EventoAvverso e : v.getEventiAvversi()){
                countEventiAvversi += 1;
                sommaSeverita += e.severita;
            }
        }

        if(countEventiAvversi == 0)
            return 0;
        else{
            severitaMedia = (double) sommaSeverita/countEventiAvversi;
            return Math.floor(severitaMedia * 100) / 100;
        }
    }
}
