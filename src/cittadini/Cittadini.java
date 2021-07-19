package cittadini;

import java.io.*;
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
                System.out.println("File created: " + fileCittadini.getName());
                serializzaCittadini(new LinkedList<Cittadino>());
            }else{
                System.out.println("File already exist");
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
            System.out.println("Oggetto serializzato correttamente");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String sha256(String password) {
        //TODO: criptare una stringa in sha-256  (NB due stringhe uguali devono dare LO STESSO hash!! FARE DELLE PROVE PER VERIFICARLO)
        return password;
    }

    public static boolean checkUsername(String username){
        LinkedList<Cittadino> cittadini = getCittadini();
        for(Cittadino i : cittadini)
            if(i.getUsername().equals(username)) return false;

        return true;
    }
}
