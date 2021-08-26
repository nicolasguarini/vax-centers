package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import centrivaccinali.Vaccinazione;
import cittadini.Cittadini;
import cittadini.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

public class UIRegistraCittadino extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));
    JTextField tfNomeCittadino = new JTextField();
    JTextField tfCognomeCittadino = new JTextField();
    JTextField tfCodiceFiscaleCittadino = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();
    JTextField tfIDVaccinazione = new JTextField();
    JButton btnRegistra = new JButton("REGISTRATI");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);
    Font font1 = new Font("Light", Font.PLAIN, 18);
    Font font2 = new Font("Light", Font.PLAIN, 30);

    public UIRegistraCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(650, 610);
        this.setTitle("Registrazione cittadino");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelRegistraVaccinato = new JLabel("Registrazione cittadino");
        labelRegistraVaccinato.setFont(font2);
        labelRegistraVaccinato.setForeground(new Color(0, 0, 0));
        labelRegistraVaccinato.setBounds(50, 28, 500, 50);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setFont(font1);
        labelNome.setForeground(new Color(167, 164, 164));
        labelNome.setBounds(50, 90, 150, 50);
        
        JLabel labelCognome = new JLabel("Cognome");
        labelCognome.setFont(font1);
        labelCognome.setForeground(new Color(167, 164, 164));
        labelCognome.setBounds(360, 90, 150, 50);
        
        JLabel labelCF = new JLabel("Codice fiscale");
        labelCF.setFont(font1);
        labelCF.setForeground(new Color(167, 164, 164));
        labelCF.setBounds(50, 190, 150, 50);
        
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(font1);
        labelEmail.setForeground(new Color(167, 164, 164));
        labelEmail.setBounds(360, 190, 200, 50);
        
        JLabel labelNomeUtente = new JLabel("Nome utente");
        labelNomeUtente.setFont(font1);
        labelNomeUtente.setForeground(new Color(167, 164, 164));
        labelNomeUtente.setBounds(50, 290, 150, 50);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(font1);
        labelPassword.setForeground(new Color(167, 164, 164));
        labelPassword.setBounds(360, 290, 150, 50);

        JLabel labelIDVaccinazione = new JLabel("ID vaccinazione");
        labelIDVaccinazione.setFont(font1);
        labelIDVaccinazione.setForeground(new Color(167, 164, 164));
        labelIDVaccinazione.setBounds(50, 390, 300, 50);

        tfNomeCittadino.setPreferredSize(new Dimension(220, 30));
        tfNomeCittadino.setFont(font1);
        tfNomeCittadino.setBounds(50, 136, 220, 30);

        tfCognomeCittadino.setPreferredSize(new Dimension(220, 30));
        tfCognomeCittadino.setFont(font1);
        tfCognomeCittadino.setBounds(360, 136, 220, 30);

        tfCodiceFiscaleCittadino.setPreferredSize(new Dimension(220, 30));
        tfCodiceFiscaleCittadino.setFont(font1);
        tfCodiceFiscaleCittadino.setBounds(50, 236, 220, 30);

        tfEmail.setPreferredSize(new Dimension(220, 30));
        tfEmail.setFont(font1);
        tfEmail.setBounds(360, 236, 220, 30);

        tfNomeUtente.setPreferredSize(new Dimension(220, 30));
        tfNomeUtente.setFont(font1);
        tfNomeUtente.setBounds(50, 336, 220, 30);

        tfPasswordUtente.setPreferredSize(new Dimension(220, 30));
        tfPasswordUtente.setFont(font1);
        tfPasswordUtente.setBounds(360, 336, 220, 30);

        tfIDVaccinazione.setPreferredSize(new Dimension(220, 30));
        tfIDVaccinazione.setFont(font1);
        tfIDVaccinazione.setBounds(50, 436, 530, 30);

        btnRegistra.setPreferredSize(new Dimension(150, 40));
        btnRegistra.setFocusable(false);
        btnRegistra.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistra.setBackground(new Color(232, 47, 125));
        btnRegistra.setForeground(Color.WHITE);
        btnRegistra.setBorder(border);
        btnRegistra.addActionListener(this);
        btnRegistra.setBounds(170, 501, 150, 40);
        btnRegistra.setOpaque(true);
        
        btnAnnulla.setPreferredSize(new Dimension(150, 40));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);
        btnAnnulla.setBounds(330, 501, 150, 40);
        btnAnnulla.setOpaque(true);

        JLabel labelSfondo = new JLabel();
		labelSfondo.setBounds(0, 0, 650, 610);
        labelSfondo.add(labelRegistraVaccinato);
        labelSfondo.add(labelNome);
        labelSfondo.add(labelCognome);
        labelSfondo.add(labelCF);
        labelSfondo.add(labelIDVaccinazione);
        labelSfondo.add(labelEmail);
        labelSfondo.add(labelNomeUtente);
        labelSfondo.add(labelPassword);
        labelSfondo.add(labelIDVaccinazione);
        labelSfondo.add(tfNomeCittadino);
        labelSfondo.add(tfCognomeCittadino);
        labelSfondo.add(tfCodiceFiscaleCittadino);
        labelSfondo.add(tfNomeUtente);
        labelSfondo.add(tfEmail);
        labelSfondo.add(tfPasswordUtente);
        labelSfondo.add(tfIDVaccinazione);
        labelSfondo.add(btnRegistra);
        labelSfondo.add(btnAnnulla);
        
        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void registra(){
        String nome = tfNomeCittadino.getText();
        String cognome = tfCognomeCittadino.getText();
        String email = tfEmail.getText();
        String cf = tfCodiceFiscaleCittadino.getText();
        String username = tfNomeUtente.getText();
        String password = new String(tfPasswordUtente.getPassword());
        String idVaccinazione = tfIDVaccinazione.getText();
        CentroVaccinale centroVaccinale = getCentroVaccinale(idVaccinazione);

        if (validaDati(nome, cognome, cf, email, username, password, idVaccinazione, centroVaccinale)){
            Cittadino cittadino = new Cittadino(Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase(), Character.toUpperCase(cognome.charAt(0)) + cognome.substring(1).toLowerCase(), cf.toUpperCase(), email, username, Cittadini.sha256(password), idVaccinazione, centroVaccinale);
            Cittadini.registraCittadino(cittadino);
            this.dispose();
        }
    }

    boolean validaDati(String nome, String cognome, String cf, String email, String username, String password, String idVaccinazione, CentroVaccinale centroVaccinale){
        String messaggio = "";

        if(nome.equals("") || cognome.equals("") || cf.equals("") || email.equals("") || username.equals("") || password.equals("") || idVaccinazione.equals("")){
            JOptionPane.showMessageDialog(this, "Inserisci tutti i dati!");
            return false;
        }

        if(nome.matches(".*\\d.*")) messaggio += "Il nome non può contenere cifre! \n";
        if(cognome.matches(".*\\d.*")) messaggio += "Il cognome non può contenere cifre! \n";
        if(!cf.matches("([A-Za-z]{6})([0-9]{2})([A-Za-z])([0-9]{2})([A-Za-z])([0-9]{3})([A-Za-z])")) messaggio += "Il codice fiscale inserito non rispetta il formato corretto! \n";
        if(!email.matches("^[\\w-]+@([\\w-]+\\.)+[\\w-]{2,4}$")) messaggio += "Email non valida! \n";
        if(!username.matches("^[a-zA-Z0-9_-]{3,15}$")) messaggio += "L'username deve essere compreso tra 3 e 15 caratteri alfanumerici! \n";
        if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$")) messaggio += "La password deve contenere 6 caratteri, \nun carattere maiuscolo, minuscolo, un numero e nessuno spazio! \n";
        if(!idVaccinazione.matches("[0-9]{16}")) messaggio += "L'id della vaccinazione deve contenere 16 cifre! \n";

        if(centroVaccinale == null) messaggio += "L'ID vaccinazione fa riferimento a un centro vaccinale che non esiste";
        if(!checkUsername(username)) messaggio += "L'username esiste già \n";
        if(!checkEmail(email)) messaggio += "L'email esiste già \n";
        if(!checkIdVaccinazioneGiaRegistrata(idVaccinazione)) messaggio += "L'id vaccinazione è già stato registrato! \n";
        if(centroVaccinale != null && !checkIdVaccinazioneEsistente(centroVaccinale, idVaccinazione)) messaggio += "La vaccinazione non esiste\n";
        if(!checkCF(cf)) messaggio += "Il codice fiscale esiste già \n";
        
        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    boolean checkUsername(String username){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getUsername().equalsIgnoreCase(username)) return false;

        return true;
    }

    boolean checkEmail(String email){
        for(Cittadino i : Cittadini.getCittadini())
            if (i.getEmail().equalsIgnoreCase(email)) return false;

        return true;
    }

    boolean checkIdVaccinazioneGiaRegistrata(String idVaccinazione){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getIdVaccinazione().equals(idVaccinazione)) return false;

        return true;
    }

    CentroVaccinale getCentroVaccinale(String idVaccinazione){
        String idCentroVaccinale = idVaccinazione.substring(0, 5);
        for(CentroVaccinale centroVaccinale : CentriVaccinali.getCentriVaccinali()){
            if(centroVaccinale.getId().equals(idCentroVaccinale))
                return centroVaccinale;
        }

        return null;
    }

    boolean checkIdVaccinazioneEsistente(CentroVaccinale centroVaccinale, String idVaccinazione){
        LinkedList<Vaccinazione> vaccinazioni = CentriVaccinali.getVaccinazioni(centroVaccinale.getNome());
        for(Vaccinazione i : vaccinazioni){
            if(i.getIdVaccinazione().equals(idVaccinazione))
                return true;
        }

        return false;
   }

    boolean checkCF(String cf){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getCF().equalsIgnoreCase(cf)) return false;

        return true;
    }

    String[] getCentriArray(){
        LinkedList<CentroVaccinale> centriVaccinali = CentriVaccinali.getCentriVaccinali();
        String[] centriArray = new String[centriVaccinali.size()];

        for(int i = 0; i<centriVaccinali.size(); i++){
            centriArray[i] = centriVaccinali.get(i).getNome() + ", " + centriVaccinali.get(i).getIndirizzo();
        }

        return centriArray;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistra) {
            registra();
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}