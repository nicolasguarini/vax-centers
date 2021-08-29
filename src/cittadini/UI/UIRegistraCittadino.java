//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import centrivaccinali.Vaccinazione;
import cittadini.Cittadini;
import cittadini.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/**
 * Si occupa di creare e gestire la schermata di registrazione di un cittadino
 *
 * @see UILoginCittadino
 * @see UICittadini
 *
 * @author Nicolas Guarini
 * @author Filippo Alzati
 * @author Domenico Rizzo
 * @author Redon Kokaj
 */
public class UIRegistraCittadino extends JFrame implements ActionListener {
    /**
     * TextField dove l'utente inserirà il nome
     */
    JTextField tfNomeCittadino = new JTextField();

    /**
     * TextField dove l'utente inserirà il cognome
     */
    JTextField tfCognomeCittadino = new JTextField();

    /**
     * TextField dove l'utente inserirà il codice fiscale
     */
    JTextField tfCodiceFiscaleCittadino = new JTextField();

    /**
     * TextField dove l'utente inserirà l'email
     */
    JTextField tfEmail = new JTextField();

    /**
     * TextField dove l'utente inserirà l'username
     */
    JTextField tfNomeUtente = new JTextField();

    /**
     * TextField dove l'utente inserirà la password
     */
    JPasswordField tfPasswordUtente = new JPasswordField();

    /**
     * TextField dove l'utente inserirà l'id vaccinazione
     */
    JTextField tfIDVaccinazione = new JTextField();

    /**
     * Bottone per effettuare la registrazione
     */
    JButton btnRegistra = new JButton("REGISTRATI");

    /**
     * Bottone per annullare la registrazione
     */
    JButton btnAnnulla = new JButton("ANNULLA");


    /**
     * Inizializza, imposta e visualizza la schermata di registrazione
     *
     * @author Domenico Rizzo
     */
    public UIRegistraCittadino() {
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 18);
        Font font2 = new Font("Light", Font.PLAIN, 30);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(650, 610);
        this.setTitle("Registrazione cittadino");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

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

    /**
     * Preleva i dati dalle caselle di testo, e se sono validi istanzia un oggetto <code>Cittadino</code> e procederà a registrarlo
     *
     * @author Nicolas Guarini
     */
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

    /**
     * Valida i dati inseriti dall'utente mostrando un messaggio di errore nel caso in cui non siano validi
     *
     * @param nome: nome dell'utente da registrare
     * @param cognome: cognome dell'utente da registrare
     * @param cf: codice fiscale dell'utente da registrare
     * @param email: email dell'utente da registrare
     * @param username: username dell'utente da registrare
     * @param password: password dell'utente da registrare
     * @param idVaccinazione: id vaccinazione dell'utente da registrare
     * @param centroVaccinale: centro vaccinale dove è stata effettuata la registrazione
     * @return <code>true</code> se tutti i dati sono validi; <code>false</code> se c'è almeno un dato non valido
     *
     * @author Nicolas Guarini
     * @author Redon Kokaj
     */
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

    /**
     * Controlla che l'username non sia già stato registrato da un altro utente
     *
     * @param username: l'username da controllare
     * @return <code>true</code> se l'username è valido; <code>false</code> se l'username non è valido, quindi se è già esistente.
     *
     * @author Nicolas Guarini
     */
    boolean checkUsername(String username){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getUsername().equalsIgnoreCase(username)) return false;

        return true;
    }

    /**
     * Controlla che l'email non sia già stata registrata da un altro utente
     *
     * @param email email da controllare
     * @return <code>true</code> se l'email è valida; <code>false</code> se l'email non è valida, quindi se è già stata registrata
     *
     * @author Nicolas Guarini
     */
    boolean checkEmail(String email){
        for(Cittadino i : Cittadini.getCittadini())
            if (i.getEmail().equalsIgnoreCase(email)) return false;

        return true;
    }

    /**
     * Controlla che l'id vaccinazione non sia già stata registrata da un altro utente
     *
     * @param idVaccinazione id vaccinazione da controllare
     * @return <code>true</code> se l'id è valido; <code>false</code> se l'id non è valido, quini se è già stato registrato
     *
     * @author Nicolas Guarini
     */
    boolean checkIdVaccinazioneGiaRegistrata(String idVaccinazione){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getIdVaccinazione().equals(idVaccinazione)) return false;

        return true;
    }

    /**
     * Tramite le prime 5 cifre dell'id vaccinazione risale al centro vaccinale
     *
     * @param idVaccinazione id vaccinazione del quale vogliamo sapere il centro vaccinale
     * @return il centro vaccinale dove è stata effettuata la vaccinazione
     *
     * @author Nicolas Guarini
     */
    CentroVaccinale getCentroVaccinale(String idVaccinazione){
        String idCentroVaccinale = idVaccinazione.substring(0, 5);
        for(CentroVaccinale centroVaccinale : CentriVaccinali.getCentriVaccinali()){
            if(centroVaccinale.getId().equals(idCentroVaccinale))
                return centroVaccinale;
        }

        return null;
    }

    /**
     * Controlla che esista una vaccinazione con l'id inserito dall'utente
     *
     * @param centroVaccinale centro vaccinale dove è stata effettuata la vaccinazione
     * @param idVaccinazione id vaccinazione inserito dall'utente
     * @return <code>true</code> se l'id è valido; <code>false</code> se l'id non è valido
     *
     * @author Nicolas Guarini
     */
    boolean checkIdVaccinazioneEsistente(CentroVaccinale centroVaccinale, String idVaccinazione){
        LinkedList<Vaccinazione> vaccinazioni = CentriVaccinali.getVaccinazioni(centroVaccinale.getNome());
        for(Vaccinazione i : vaccinazioni){
            if(i.getIdVaccinazione().equals(idVaccinazione))
                return true;
        }

        return false;
   }

    /**
     * Controlla che non esista un altro cittadino registrato con lo stesso codice fiscale
     *
     * @param cf codice fiscale da controllare
     * @return <code>true</code> se il codice fiscale è valido; <code>false</code> se il codice fiscale non è valido.
     *
     * @author Nicolas Guarini
     */
    boolean checkCF(String cf){
        for(Cittadino i : Cittadini.getCittadini())
            if(i.getCF().equalsIgnoreCase(cf)) return false;

        return true;
    }

    /**
     * Gestore dei click sui pulsanti della schermata
     *
     * @param e evento che deve essere processato
     *
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistra) {
            registra();
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}