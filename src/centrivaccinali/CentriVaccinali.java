package centrivaccinali;

import centrivaccinali.UI.UIStartMenu;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class CentriVaccinali {
    public static void main(String[] args){
        new UIStartMenu();
    }

    public static void registraCentroVaccinale(CentroVaccinale centroVaccinale){
        LinkedList<CentroVaccinale> centriVaccinali = getCentriVaccinali();
        centriVaccinali.add(centroVaccinale);
        serializzaCentriVaccinali(centriVaccinali);
    }

    public static void registraVaccinazione(Vaccinazione vaccinazione){
        //TODO: implementare logica di registrazione vaccinazioni su file
    }

    static void serializzaCentriVaccinali(LinkedList<CentroVaccinale> centriVaccinali){
        final String filepath = "./data/CentriVaccinali.dati.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(centriVaccinali);
            objectOutputStream.close();
            System.out.println("Oggetto serializzato correttamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static LinkedList<CentroVaccinale> getCentriVaccinali(){
        LinkedList<CentroVaccinale> centriVaccinali = new LinkedList<CentroVaccinale>();

        try{
            File fileCentriVaccinali = new File("./data/CentriVaccinali.dati.txt");
            if(fileCentriVaccinali.createNewFile()) {
                System.out.println("File creaded: " + fileCentriVaccinali.getName());
            }else{
                System.out.println("File already exists");
                FileInputStream fileInputStream = new FileInputStream(fileCentriVaccinali);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                centriVaccinali = (LinkedList<CentroVaccinale>) objectInputStream.readObject();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return centriVaccinali;
    }
}
