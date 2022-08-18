//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;
import common.CentroVaccinale;
import common.Indirizzo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 * La classe <code>UIRegistraCentroVaccinale</code> si occupa di gestire il form di registrazione di un nuovo centro vaccinale, validando i dati e inviandoli al server che li processerà
 *
 * @see CentriVaccinali
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 */
public class UIRegistraCentroVaccinale extends JFrame implements ActionListener {
    /**
     * TextField dove l'utente inserirà il nome del centro vaccinale
     */
    JTextField tfNomeCentroVaccinale = new JTextField();

    /**
     * TextField dove l'utente inserirà il nome dell'indirizzo
     */
    JTextField tfNomeIndirizzo = new JTextField();

    /**
     * TextField dove l'utente inserirò il numero civico
     */
    JTextField tfCivico = new JTextField();

    /**
     * TextField dove l'utente inserirà il comune
     */
    JTextField tfComune = new JTextField();

    /**
     * TextField dove l'utente inserirà la provincia
     */
    JTextField tfProvincia = new JTextField();

    /**
     * TextField dove l'utente inserirà il CAP
     */
    JTextField tfCAP = new JTextField();

    /**
     * Select dove l'utente selezionerà il qualificatore dell'indirizzo tra "Via", "Viale" e "Piazza"
     */
    JComboBox<String> qualificatoreIndirizzo = new JComboBox<>(new String[]{"Via", "Viale", "Piazza"});

    /**
     * Select dove l'utente selezionerà la tipologia del centro vaccinale tra "Ospedaliero", "Aziendale" e "Hub"
     */
    JComboBox<String> tipologiaCentroVaccinale = new JComboBox<>(new String[]{"Ospedaliero", "Aziendale", "Hub"});

    /**
     * Bottone per effettuare la registrazione
     */
    JButton btnRegistra = new JButton("REGISTRA");

    /**
     * Bottone per annullare la registrazione
     */
    JButton btnAnnulla = new JButton("ANNULLA");

    /**
     * Inizializza, imposta e visualizza il form di registrazione di un nuovo centro vaccinale
     *
     * @see CentriVaccinali
     * @see UICentriVaccinali
     *
     * @author Domenico Rizzo
     */
    public UIRegistraCentroVaccinale(){
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 18);
        Font font2 = new Font("Light", Font.PLAIN, 30);
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(650, 630);
        this.setTitle("Registra centro vaccinale");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

        JLabel labelRegistraVaccinato = new JLabel("Registra centro vaccinale");
        labelRegistraVaccinato.setFont(font2);
        labelRegistraVaccinato.setForeground(new Color(0, 0, 0));
        labelRegistraVaccinato.setBounds(50, 28, 500, 50);

        JLabel labelNomeCentroVaccinale = new JLabel("Nome centro vaccinale");
        labelNomeCentroVaccinale.setFont(font1);
        labelNomeCentroVaccinale.setForeground(new Color(167, 164, 164));
        labelNomeCentroVaccinale.setBounds(50, 90, 300, 50);

        JLabel labelNomeVaccinato = new JLabel("Indirizzo");
        labelNomeVaccinato.setFont(font1);
        labelNomeVaccinato.setForeground(new Color(167, 164, 164));
        labelNomeVaccinato.setBounds(50, 190, 150, 50);
        
        JLabel labelCognomeVaccinato = new JLabel("Civico");
        labelCognomeVaccinato.setFont(font1);
        labelCognomeVaccinato.setForeground(new Color(167, 164, 164));
        labelCognomeVaccinato.setBounds(360, 190, 150, 50);
        
        JLabel labelCodiceFiscaleVaccinato = new JLabel("Comune");
        labelCodiceFiscaleVaccinato.setFont(font1);
        labelCodiceFiscaleVaccinato.setForeground(new Color(167, 164, 164));
        labelCodiceFiscaleVaccinato.setBounds(50, 290, 150, 50);
        
        JLabel labelDataSomministrazioneVaccino = new JLabel("Provincia");
        labelDataSomministrazioneVaccino.setFont(font1);
        labelDataSomministrazioneVaccino.setForeground(new Color(167, 164, 164));
        labelDataSomministrazioneVaccino.setBounds(50, 390, 200, 50);
        
        JLabel labelIDVaccinazione = new JLabel("CAP");
        labelIDVaccinazione.setFont(font1);
        labelIDVaccinazione.setForeground(new Color(167, 164, 164));
        labelIDVaccinazione.setBounds(360, 290, 150, 50);

        JLabel labelNomeVaccino = new JLabel("Tipologia centro");
        labelNomeVaccino.setFont(font1);
        labelNomeVaccino.setForeground(new Color(167, 164, 164));
        labelNomeVaccino.setBounds(360, 390, 150, 50);
        
        tfNomeCentroVaccinale.setPreferredSize(new Dimension(530, 30));
        tfNomeCentroVaccinale.setFont(font1);
        tfNomeCentroVaccinale.setBounds(50, 136, 530, 30);

        qualificatoreIndirizzo.setPreferredSize(new Dimension(220, 30));
        qualificatoreIndirizzo.setFont(font1);
        qualificatoreIndirizzo.setBounds(50, 236, 70, 30);

        tfNomeIndirizzo.setPreferredSize(new Dimension(220, 30));
        tfNomeIndirizzo.setFont(font1);
        tfNomeIndirizzo.setBounds(123, 236, 146, 30);

        tfCivico.setPreferredSize(new Dimension(220, 30));
        tfCivico.setFont(font1);
        tfCivico.setBounds(360, 236, 220, 30);

        tfComune.setPreferredSize(new Dimension(220, 30));
        tfComune.setFont(font1);
        tfComune.setBounds(50, 336, 220, 30);

        tfCAP.setPreferredSize(new Dimension(220, 30));
        tfCAP.setFont(font1);
        tfCAP.setBounds(360, 336, 220, 30);

        tfProvincia.setPreferredSize(new Dimension(220, 30));
        tfProvincia.setFont(font1);
        tfProvincia.setBounds(50, 436, 220, 30);

        tipologiaCentroVaccinale.setPreferredSize(new Dimension(220, 30));
        tipologiaCentroVaccinale.setFont(font1);
        tipologiaCentroVaccinale.setSelectedIndex(0);
        tipologiaCentroVaccinale.setBounds(360, 436, 220, 30);

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
		labelSfondo.setBounds(0, 0, 650, 580);
        labelSfondo.add(labelRegistraVaccinato);
        labelSfondo.add(labelNomeCentroVaccinale);
        labelSfondo.add(labelNomeVaccinato);
        labelSfondo.add(labelCognomeVaccinato);
        labelSfondo.add(labelCodiceFiscaleVaccinato);
        labelSfondo.add(labelIDVaccinazione);
        labelSfondo.add(labelDataSomministrazioneVaccino);
        labelSfondo.add(labelNomeVaccino);
        labelSfondo.add(tfNomeCentroVaccinale);
        labelSfondo.add(qualificatoreIndirizzo);
        labelSfondo.add(tfNomeIndirizzo);
        labelSfondo.add(tfCivico);
        labelSfondo.add(tfComune);
        labelSfondo.add(tfProvincia);
        labelSfondo.add(tfCAP);
        labelSfondo.add(tipologiaCentroVaccinale);
        labelSfondo.add(btnRegistra);
        labelSfondo.add(btnAnnulla);
        
        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Preleva i dati dalle caselle di testo e dai menu a tendina,
     * li manda al metodo {@link #validaDati} e, se sono validi, crea un'istanza di {@link CentroVaccinale} che verrà usata per registrare effettivamente il nuovo centro nel database
     *
     * @see CentroVaccinale
     * @see CentriVaccinali
     *
     * @author Nicolas Guarini
     */
    private void registra(){
        String nome = tfNomeCentroVaccinale.getText();
        String qualificatore = Objects.requireNonNull(qualificatoreIndirizzo.getSelectedItem()).toString();
        String nomeIndirizzo = tfNomeIndirizzo.getText();
        String civico = tfCivico.getText();
        String comune = tfComune.getText();
        String provincia = tfProvincia.getText();
        String CAP = tfCAP.getText();
        String tipologiaCentro  = Objects.requireNonNull(tipologiaCentroVaccinale.getSelectedItem()).toString();
        String id = generaId();

        if(validaDati(nome, nomeIndirizzo, civico, comune, provincia, CAP, id)){
            Indirizzo indirizzo = new Indirizzo(qualificatore, nomeIndirizzo, civico, Character.toUpperCase(comune.charAt(0)) + comune.substring(1).toLowerCase(), provincia.toUpperCase(), CAP);
            CentroVaccinale centroVaccinale = new CentroVaccinale(nome, indirizzo, tipologiaCentro, id);
            boolean result = CentriVaccinali.registraCentroVaccinale(centroVaccinale);
            if(result) this.dispose();
            else JOptionPane.showMessageDialog(this, "Errore durante la registrazione del centro vaccinale");
        }
    }

    /**
     * Genera un codice univoco di 5 cifre che identifica il centro vaccinale. Insieme al'ID relativo al vaccinato formerà l'ID vaccinazione
     *
     * @return ID numerico di 5 cifre che identifica il centro vaccinale
     *
     * @author Nicolas Guarini
     */
    String generaId(){
        StringBuilder id = new StringBuilder();
        int size = CentriVaccinali.getCentriVaccinali().size() + 1;
        int length = String.valueOf(size).length();

        for(int i = 0; i < 5 - length; i++){
            id.append("0");
        }

        id.append(size);
        return id.toString();
    }

    /**
     * Effettua una seria di controlli sui dati inseriti dall'utente, e mostra un messaggio che riassume il motivo per il quale determinati dati non sono validi
     *
     * @param nome Il nome del centro da registrare
     * @param nomeIndirizzo Parte principale dell'indirizzo del centro da registrare
     * @param civico Numero civico del centro da registrare
     * @param comune Comune del centro da registrare
     * @param provincia Sigla della provincia del centro da registrare
     * @param CAP Codice di Avviamento Postale del centro da registrare
     * @param id ID di 5 cifre del centro vaccinale
     * @return <code>true</code> se i dati inseriti sono risultati validi, <code>false</code> se i dati inseriti non sono validi
     *
     * @author Redon Kokaj
     * @author Nicolas Guarini
     */
    boolean validaDati(String nome, String nomeIndirizzo, String civico, String comune, String provincia, String CAP, String id){
        String messaggio = "";

        if(nome.equals("") || nomeIndirizzo.equals("") || civico.equals("") || comune.equals("") || provincia.equals("") || CAP.equals("")){
            JOptionPane.showMessageDialog(this, "Inserisci tutti i dati!");
            return false;
        }

        if(nome.matches(".*\\d.*")) messaggio += "Il nome non può contenere cifre! \n";
        if(nomeIndirizzo.matches(".*\\d.*")) messaggio += "L'indirizzo non può contenere cifre! \n";
        if(comune.matches(".*\\d.*")) messaggio += "Il comune non può contenere cifre! \n";
        if(!provincia.matches("[A-Za-z]{2}")) messaggio += "La sigla provincia deve essere lunga 2 caratteri (es: VA)! \n";
        if(!CAP.matches("[0-9]{5}")) messaggio += "Il CAP deve contenere 5 cifre (es: 21020)! \n";
        if(checkCentroVaccinale(nome)) messaggio += "Il centro vaccinale esiste gia!";
        if(id.length() > 5) messaggio += "Numero massimo di centri vaccinali raggiunto";

        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    /**
     * Controlla se esiste già un centro vaccinale con lo stesso nome di quello passato per parametro
     *
     * @author Nicolas Guarini
     *
     * @param nomeCentroVaccinale nome del centro vaccinale da controllare
     * @return <code>true</code> se esiste già un centro vaccinale con lo stesso nome; <code>false</code> se non esiste
     */
    boolean checkCentroVaccinale(String nomeCentroVaccinale){
        //TODO: far gestire al server sta cosa
        LinkedList<CentroVaccinale> centriVaccinali = CentriVaccinali.getCentriVaccinali();
        for(CentroVaccinale v : centriVaccinali)
            if(v.getNome().equalsIgnoreCase(nomeCentroVaccinale))
                return true;

        return false;
    }

    /**
     * Gestisce il click dei pulsanti della schermata
     *
     * @param e L'evento che deve venire processato
     *
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegistra){
            registra();
        }else if(e.getSource() == btnAnnulla){
            this.dispose();
        }
    }
}
