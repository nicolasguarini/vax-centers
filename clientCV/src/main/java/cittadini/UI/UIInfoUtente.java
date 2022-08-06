//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import common.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Si occupa di creare e gestire l'interfaccia grafica della schermata dove un utente loggato può visualizzare le informazioni relative al suo profilo
 *
 * @see UILoginCittadino
 *
 * @author Nicolas Guarini
 * @author Filippo Alzati
 * @author Redon Kokaj
 * @author Domenico Rizzo
 */
public class UIInfoUtente extends JFrame implements ActionListener {
    /**
     * Cittadino di cui si vogliono conoscere ulteriori informazioni
     */
    Cittadino cittadinoLoggato;

    /**
     * TextField dove verrà visualizzato il nome del cittadino
     */
    JTextField tfNome = new JTextField();

    /**
     * TextField dove verrà visualizzato il cognome del cittadino
     */
    JTextField tfCognome = new JTextField();

    /**
     * TextField dove verrà visualizzata l'email del cittadino
     */
    JTextField tfEmail = new JTextField();

    /**
     * TextField dove verrà visualizzato l'username del cittadino
     */
    JTextField tfUsername= new JTextField();

    /**
     * TextField dove verrà visualizzato il codice fiscale del cittadino
     */
    JTextField tfCF = new JTextField();

    /**
     * TextField dove verrà visualizzato l'id vaccinazione del cittadino
     */
    JTextField tfIDvaccinazione = new JTextField();

    /**
     * Bottone per chiudere la schermata attuale
     */
    JButton btnChiudi = new JButton("CHIUDI");

    /**
     * Inizializza, imposta e visualizza la schermata delle informazioni del profilo di un utente loggato
     *
     * @param cittadinoLoggato: oggetto <code>Cittadino</code> del quale vogliamo visualizzare le informazioni
     *
     * @author Domenico Rizzo
     */
    public UIInfoUtente(Cittadino cittadinoLoggato) {
        this.cittadinoLoggato = cittadinoLoggato;

        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgUser = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/usericon.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 16);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setSize(500, 650);
        this.setTitle("Informazioni utente");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

        tfNome.setBounds(40, 231, 200, 30);
        tfNome.setFont(font1);
        tfNome.setEditable(false);
        tfNome.setText(cittadinoLoggato.getNome());

        tfCognome.setBounds(261, 231, 200, 30);
        tfCognome.setFont(font1);
        tfCognome.setEditable(false);
        tfCognome.setText(cittadinoLoggato.getCognome());

        tfEmail.setBounds(40, 331, 200, 30);
        tfEmail.setFont(font1);
        tfEmail.setEditable(false);
        tfEmail.setText(cittadinoLoggato.getEmail());

        tfUsername.setBounds(261, 331, 200, 30);
        tfUsername.setFont(font1);
        tfUsername.setEditable(false);
        tfUsername.setText(cittadinoLoggato.getUsername());

        tfCF.setBounds(40, 431, 200, 30);
        tfCF.setFont(font1);
        tfCF.setEditable(false);
        tfCF.setText(cittadinoLoggato.getCF());

        tfIDvaccinazione.setBounds(261, 431, 200, 30);
        tfIDvaccinazione.setFont(font1);
        tfIDvaccinazione.setEditable(false);
        tfIDvaccinazione.setText(cittadinoLoggato.getIdVaccinazione());

        btnChiudi.setBounds(175, 531, 150, 40);
        btnChiudi.setFocusable(false);
        btnChiudi.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnChiudi.setBackground(new Color(232, 47, 125));
        btnChiudi.setForeground(Color.WHITE);
        btnChiudi.setBorder(border);
        btnChiudi.addActionListener(this);
        btnChiudi.setOpaque(true);

        JLabel TestoNome = new JLabel("Nome");
        TestoNome.setBounds(40, 182, 50, 50);
        TestoNome.setForeground(new Color(167, 164, 164));
        TestoNome.setFont(font1);

        JLabel TestoCognome = new JLabel("Cognome");
        TestoCognome.setBounds(261, 182, 120, 50);
        TestoCognome.setForeground(new Color(167, 164, 164));
        TestoCognome.setFont(font1);

        JLabel TestoEmail= new JLabel("Email");
        TestoEmail.setBounds(40, 282, 120, 50);
        TestoEmail.setForeground(new Color(167, 164, 164));
        TestoEmail.setFont(font1);

        JLabel TestoUsername = new JLabel("Nome utente");
        TestoUsername.setBounds(261, 282, 120, 50);
        TestoUsername.setForeground(new Color(167, 164, 164));
        TestoUsername.setFont(font1);

        JLabel TestoCF = new JLabel("Codice fiscale");
        TestoCF.setBounds(40, 382, 120, 50);
        TestoCF.setForeground(new Color(167, 164, 164));
        TestoCF.setFont(font1);

        JLabel TestoIDvaccinazione = new JLabel("ID vaccinazione");
        TestoIDvaccinazione.setBounds(261, 382, 120, 50);
        TestoIDvaccinazione.setForeground(new Color(167, 164, 164));
        TestoIDvaccinazione.setFont(font1);

        JLabel labelIcona = new JLabel();
        labelIcona.setIcon(imgUser);
        labelIcona.setBounds(215, 55, 75, 75);

        JLabel labelSfondo = new JLabel();
        labelSfondo.add(labelIcona);
        labelSfondo.setBounds(0, 0, 500, 650);
        labelSfondo.add(TestoNome);
        labelSfondo.add(TestoCognome);
        labelSfondo.add(TestoEmail);
        labelSfondo.add(TestoUsername);
        labelSfondo.add(TestoCF);
        labelSfondo.add(TestoIDvaccinazione);
        labelSfondo.add(tfNome);
        labelSfondo.add(tfCognome);
        labelSfondo.add(tfEmail);
        labelSfondo.add(tfUsername);
        labelSfondo.add(tfCF);
        labelSfondo.add(tfIDvaccinazione);
        labelSfondo.add(btnChiudi);

        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Gestore dei click sui pulsanti della schermata
     *
     * @param e: evento che deve essere processato
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChiudi) {
            this.dispose();
        }
    }

}
