package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import cittadini.Cittadini;
import cittadini.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

public class UIRegistraCittadino extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JTextField tfNomeCittadino = new JTextField();
    JTextField tfCognomeCittadino = new JTextField();
    JTextField tfCodiceFiscaleCittadino = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();
    JTextField tfIDVaccinazione = new JTextField();
    JComboBox selectCentroVaccinale = new JComboBox(getCentriArray());

    JButton btnRegistra = new JButton("REGISTRATI");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIRegistraCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setSize(750, 200);
        this.setTitle("Registra cittadino");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelNomeCittadino = new JLabel("Nome:");
        labelNomeCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCognomeCittadino = new JLabel("Cognome:");
        labelCognomeCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCodiceFiscaleCittadino = new JLabel("Codice fiscale:");
        labelCodiceFiscaleCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelNomeUtente = new JLabel("Nome utente:");
        labelNomeUtente.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelPasswordUtente = new JLabel("Password:");
        labelPasswordUtente.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelIDVaccinazione = new JLabel("ID vaccinazione:");
        labelIDVaccinazione.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelSelezionaCentroVaccinale = new JLabel("Centro vaccinale: ");
        labelSelezionaCentroVaccinale.setFont(new Font("Helvetica", Font.BOLD, 15));

        selectCentroVaccinale.setPreferredSize(new Dimension(400, 30));
        selectCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));

        tfNomeCittadino.setPreferredSize(new Dimension(150, 30));
        tfNomeCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCognomeCittadino.setPreferredSize(new Dimension(150, 30));
        tfCognomeCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCodiceFiscaleCittadino.setPreferredSize(new Dimension(150, 30));
        tfCodiceFiscaleCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfEmail.setPreferredSize(new Dimension(100, 30));
        tfEmail.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfNomeUtente.setPreferredSize(new Dimension(100, 30));
        tfNomeUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfPasswordUtente.setPreferredSize(new Dimension(100, 30));
        tfPasswordUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfIDVaccinazione.setPreferredSize(new Dimension(100, 30));
        tfIDVaccinazione.setFont(new Font("Helvetica", Font.PLAIN, 15));

        btnRegistra.setPreferredSize(new Dimension(200, 50));
        btnRegistra.setFocusable(false);
        btnRegistra.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistra.setBackground(new Color(232, 47, 125));
        btnRegistra.setForeground(Color.WHITE);
        btnRegistra.setBorder(border);
        btnRegistra.addActionListener(this);

        btnAnnulla.setPreferredSize(new Dimension(200, 50));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);

        JPanel panelRegistrazioneCittadino1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino1.add(labelNomeCittadino);
        panelRegistrazioneCittadino1.add(tfNomeCittadino);
        panelRegistrazioneCittadino1.add(labelCognomeCittadino);
        panelRegistrazioneCittadino1.add(tfCognomeCittadino);

        JPanel panelRegistrazioneCittadino2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino2.add(labelCodiceFiscaleCittadino);
        panelRegistrazioneCittadino2.add(tfCodiceFiscaleCittadino);
        panelRegistrazioneCittadino2.add(labelEmail);
        panelRegistrazioneCittadino2.add(tfEmail);

        JPanel panelRegistrazioneCittadino3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino3.add(labelNomeUtente);
        panelRegistrazioneCittadino3.add(tfNomeUtente);
        panelRegistrazioneCittadino3.add(labelPasswordUtente);
        panelRegistrazioneCittadino3.add(tfPasswordUtente);

        JPanel panelCentroVaccinale = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCentroVaccinale.add(labelSelezionaCentroVaccinale);
        panelCentroVaccinale.add(selectCentroVaccinale);

        JPanel panelRegistrazioneCittadino4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino4.add(labelIDVaccinazione);
        panelRegistrazioneCittadino4.add(tfIDVaccinazione);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        this.add(panelRegistrazioneCittadino1);
        this.add(panelRegistrazioneCittadino2);
        this.add(panelRegistrazioneCittadino3);
        this.add(panelRegistrazioneCittadino4);
        this.add(panelCentroVaccinale);
        this.add(panelBottoni);
        this.pack();
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
        CentroVaccinale centroVaccinale = CentriVaccinali.getCentriVaccinali().get(selectCentroVaccinale.getSelectedIndex());

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

        if(!Cittadini.checkUsername(username)) messaggio += "L'username esiste già \n";
        if(!Cittadini.checkEmail(email)) messaggio += "L'email esiste già \n";
        if(!Cittadini.checkIdVaccinazioneGiaRegistrata(idVaccinazione)) messaggio += "L'id vaccinazione è già stato registrato! \n";
        if(!Cittadini.checkIdVaccinazioneEsistente(idVaccinazione, centroVaccinale)) messaggio += "La vaccinazione non esiste nel centro selezionato \n";
        if(!Cittadini.checkCF(cf)) messaggio += "Il codice fiscale esiste già \n";
        
        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
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