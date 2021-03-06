//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import centrivaccinali.Vaccinazione;
import cittadini.Cittadini;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 * La classe <code>UIRegistraVaccinato</code> si occupa di gestire il form di registrazione a sistema di una somministrazione di vaccino, validando i dati e inviandoli al backend che li processerà
 *
 * @see CentriVaccinali
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 */
public class UIRegistraVaccinato extends JFrame implements ActionListener {
    /**
     * Select dove l'utente selezionerà il centro vaccinale dove è stata effettuata la vaccinazione tra quelli registrati
     */
    JComboBox<String> selectCentroVaccinale = new JComboBox<>(getCentriArray());

    /**
     * TextField dove l'utente inserirà il nome del vaccinato
     */
    JTextField tfNomeVaccinato = new JTextField();

    /**
     * TextField dove l'utente inserirà il cognome del vaccinato
     */
    JTextField tfCognomeVaccinato = new JTextField();

    /**
     * TextField dove l'utente inserirà il codice fiscale del vaccinato
     */
    JTextField tfCodiceFiscaleVaccinato = new JTextField();

    /**
     * TextField dove l'utente inserirà la data di somministrazione del vaccino
     */
    JTextField tfDataSomministrazioneVaccino= new JTextField();

    /**
     * Select dove l'utente selezionerà il vaccino somministrato tra "Pfizer", "AstraZeneca", "Moderna" e "J&J"
     */
    JComboBox<String> selectNomeVaccino = new JComboBox<>(new String[] { "Pfizer", "AstraZeneca", "Moderna", "J&J" });

    /**
     * Bottone per effettuare la registrazione
     */
    JButton btnRegistra = new JButton("REGISTRA");

    /**
     * Bottone per annullare la registrazione
     */
    JButton btnAnnulla = new JButton("ANNULLA");

    /**
     * Inizializza, imposta e visualizza il form di registrazione di una vaccinazione
     *
     * @see CentriVaccinali
     * @see UICentriVaccinali
     *
     * @author Domenico Rizzo
     * @author Nicolas Guarini
     * @author Redon Kokaj
     */
    public UIRegistraVaccinato() {
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 18);
        Font font2 = new Font("Light", Font.PLAIN, 30);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(650, 630);
        this.setTitle("Registra Vaccinato");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

        JLabel labelRegistraVaccinato = new JLabel("Registra vaccinato");
        labelRegistraVaccinato.setFont(font2);
        labelRegistraVaccinato.setForeground(new Color(0, 0, 0));
        labelRegistraVaccinato.setBounds(50, 28, 500, 50);

        JLabel labelNomeCentroVaccinale = new JLabel("Centro vaccinale");
        labelNomeCentroVaccinale.setFont(font1);
        labelNomeCentroVaccinale.setForeground(new Color(167, 164, 164));
        labelNomeCentroVaccinale.setBounds(50, 90, 150, 50);

        JLabel labelNomeVaccinato = new JLabel("Nome");
        labelNomeVaccinato.setFont(font1);
        labelNomeVaccinato.setForeground(new Color(167, 164, 164));
        labelNomeVaccinato.setBounds(50, 190, 150, 50);
        
        JLabel labelCognomeVaccinato = new JLabel("Cognome");
        labelCognomeVaccinato.setFont(font1);
        labelCognomeVaccinato.setForeground(new Color(167, 164, 164));
        labelCognomeVaccinato.setBounds(360, 190, 150, 50);
        
        JLabel labelCodiceFiscaleVaccinato = new JLabel("Codice fiscale");
        labelCodiceFiscaleVaccinato.setFont(font1);
        labelCodiceFiscaleVaccinato.setForeground(new Color(167, 164, 164));
        labelCodiceFiscaleVaccinato.setBounds(50, 290, 150, 50);
        
        JLabel labelDataSomministrazioneVaccino = new JLabel("Data (gg/mm/aaaa)");
        labelDataSomministrazioneVaccino.setFont(font1);
        labelDataSomministrazioneVaccino.setForeground(new Color(167, 164, 164));
        labelDataSomministrazioneVaccino.setBounds(360, 290, 250, 50);
        
        JLabel labelNomeVaccino = new JLabel("Nome vaccino");
        labelNomeVaccino.setFont(font1);
        labelNomeVaccino.setForeground(new Color(167, 164, 164));
        labelNomeVaccino.setBounds(50, 390, 150, 50);
        
        selectCentroVaccinale.setPreferredSize(new Dimension(530, 30));
        selectCentroVaccinale.setFont(font1);
        selectCentroVaccinale.setBounds(50,136,530,30);

        tfNomeVaccinato.setPreferredSize(new Dimension(220, 30));
        tfNomeVaccinato.setFont(font1);
        tfNomeVaccinato.setBounds(50, 236, 220, 30);

        tfCognomeVaccinato.setPreferredSize(new Dimension(220, 30));
        tfCognomeVaccinato.setFont(font1);
        tfCognomeVaccinato.setBounds(360, 236, 220, 30);

        tfCodiceFiscaleVaccinato.setPreferredSize(new Dimension(220, 30));
        tfCodiceFiscaleVaccinato.setFont(font1);
        tfCodiceFiscaleVaccinato.setBounds(50, 336, 220, 30);

        tfDataSomministrazioneVaccino.setPreferredSize(new Dimension(220, 30));
        tfDataSomministrazioneVaccino.setFont(font1);
        tfDataSomministrazioneVaccino.setBounds(360, 336, 220, 30);
        
        selectNomeVaccino.setPreferredSize(new Dimension(530, 30));
        selectNomeVaccino.setFont(font1);
        selectNomeVaccino.setSelectedIndex(0);
        selectNomeVaccino.setBounds(50, 436, 530, 30);

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
        labelSfondo.add(labelDataSomministrazioneVaccino);
        labelSfondo.add(labelNomeVaccino);
        labelSfondo.add(selectCentroVaccinale);
        labelSfondo.add(tfNomeVaccinato);
        labelSfondo.add(tfCognomeVaccinato);
        labelSfondo.add(tfCodiceFiscaleVaccinato);
        labelSfondo.add(tfDataSomministrazioneVaccino);
        labelSfondo.add(selectNomeVaccino);
        labelSfondo.add(btnRegistra);
        labelSfondo.add(btnAnnulla);
        
        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Preleva i dati inseriti dall'utente, e se sono validi viene istanziato un oggetto della classe Vaccinazione che verrà poi passato per parametro al metodo {@link #validaDati} che li salverà su file
     *
     * @author Nicolas Guarini
     */
    void registra() throws ParseException {
        CentroVaccinale centroVaccinale = CentriVaccinali.getCentriVaccinali().get(selectCentroVaccinale.getSelectedIndex());
        String nome = tfNomeVaccinato.getText();
        String cognome = tfCognomeVaccinato.getText();
        String cf = tfCodiceFiscaleVaccinato.getText();
        String idVaccinazione = generaIdVaccinazione(centroVaccinale);
        String nomeVaccino = Objects.requireNonNull(selectNomeVaccino.getSelectedItem()).toString();
        String strData = tfDataSomministrazioneVaccino.getText();

        if(validaDati(nome, cognome, cf, strData, idVaccinazione)){
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(tfDataSomministrazioneVaccino.getText());
            Vaccinazione vaccinazione = new Vaccinazione(nome, cognome, cf.toUpperCase(), idVaccinazione, data, centroVaccinale, nomeVaccino);
            CentriVaccinali.registraVaccinazione(vaccinazione);
            JOptionPane.showMessageDialog(this, "Vaccinazione registrata!\nCF: " + cf + "\n" + "Data vaccinazione: " + strData + "\n" + "ID Vaccinazione: " + idVaccinazione);
        }

        this.dispose();
    }

    /**
     * Effettua una seria di controlli sui dati inseriti dall'utente, e mostra un messaggio che riassume il motivo per il quale determinati dati non sono validi
     * @param nome nome del vaccinato
     * @param cognome cognome del vaccinato
     * @param cf codice fiscale del vaccinato
     * @param data data della somministrazione del vaccino
     * @param idVaccinazione id della vaccinazione
     * @return <code>true</code> se i dati sono risultati validi; <code>false</code> se i dati non sono risultati validi
     *
     * @author Redon Kokaj
     */
    boolean validaDati(String nome, String cognome, String cf, String data, String idVaccinazione){
        String messaggio = "";
        LocalDate data1 = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAttuale = LocalDate.now();
        String[] dataInserita = data.split("/");

        if(nome.equals("") || cognome.equals("") || cf.equals("") || data.equals("")){
            JOptionPane.showMessageDialog(this, "Inserisci tutti i dati!");
            return false;
        }

        if(nome.matches(".*\\d.*")) messaggio += "Il nome non può contenere cifre! \n";
        if(cognome.matches(".*\\d.*")) messaggio += "Il cognome non può contenere cifre! \n";
        if(!cf.matches("([A-Za-z]{6})([0-9]{2})([A-Za-z]{1})([0-9]{2})([A-Za-z]{1})([0-9]{3})([A-Za-z]{1})")) messaggio += "Il codice fiscale inserito non rispetta il formato corretto! \n";
        if(!data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) messaggio += "Inserire una data valida (gg/mm/aaaa)! \n";
        if(idVaccinazione.length() > 16) messaggio += "Numero massimo di vaccinazioni raggiunto";

        if((Integer.parseInt(dataInserita[0]) >= 1 && Integer.parseInt(dataInserita[0]) <= 31) && (Integer.parseInt(dataInserita[1]) >= 1 && Integer.parseInt(dataInserita[1]) <= 12) && (Integer.parseInt(dataInserita[2]) <= dataAttuale.get(ChronoField.YEAR_OF_ERA))) {
            if (data1.compareTo(dataAttuale) > 0)
                messaggio += "La data inserita e' una data futura rispetto a quella odierna! \n";
        }
        else
            messaggio += "La data inserita non e' corretta! \n";

        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    /**
     * Converte la lista dei centri vaccinali in un array
     *
     * @return Array contenente i centri vaccinali registrati
     *
     * @author Nicolas Guarini
     */
    String[] getCentriArray(){
        LinkedList<CentroVaccinale> centri = CentriVaccinali.getCentriVaccinali();
        int size = centri.size();
        String[] arCentri = new String[size];
        CentroVaccinale centro;

        for(int i = 0; i < size; i++){
            centro = centri.get(i);
            arCentri[i] = centro.getNome() + ", " + centro.getIndirizzo().toString();
        }
        return arCentri;
    }

    /**
     * Genera un codice di 11 cifre che identifica il cittadino vaccinato, quindi lo concatena all'id del centro vaccinale, formando un codice di 16 cifre che identifica la vaccinazione, e graie al quale è possibile risalire sia al centro vaccinale sia al cittadino vaccinato
     *
     * @param centroVaccinale: il centro vaccinale dove è stata effettuata la vaccinazione
     * @return ID completo della vaccinazione
     *
     * @author Nicolas Guarini
     */
    String generaIdVaccinazione(CentroVaccinale centroVaccinale){
        String idCentroVaccinale = centroVaccinale.getId();
        String idVaccinato = "";
        int size = Cittadini.getCittadini().size() + 1;
        int length = String.valueOf(size).length();

        for(int i = 0; i < 11 - length; i++){
            idVaccinato += "0";
        }

        idVaccinato += String.valueOf(size);
        return idCentroVaccinale + idVaccinato;
    }

    /**
     * Gestisce il click dei pulsanti della schermata
     *
     * @param e evento che deve venire processato
     *
     * @author Nicolas Guarini
     * @author Domenico Rizzo
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistra) {
            try{
                registra();
            }catch(ParseException exception){
                JOptionPane.showMessageDialog(this,"Errore: data non valida, inserirla nel formato corretto (gg/mm/aaaa) \n" + exception.getMessage());
            }
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}