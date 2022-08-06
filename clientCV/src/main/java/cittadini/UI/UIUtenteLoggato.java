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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Si occupa di gestire la schermata dell'area personale dell'utente che ha effettuato il login
 *
 * @see UILoginCittadino
 *
 * @author Nicolas Guarini
 * @author Redon Kokaj
 * @author Domenico Rizzo
 * @author Filippo Alzati
 */
public class UIUtenteLoggato extends JFrame implements ActionListener {
    /**
     * Cittadino attualmente loggato
     */
    Cittadino cittadinoLoggato;

    /**
     * Bottone per cercare e visualizzare i centri vaccinali e i relativi dettagli
     */
    JButton btnVisualizzaCentri = new JButton();

    /**
     * Bottone per segnalare degli eventi avversi
     */
    JButton btnSegnalaEventi = new JButton();

    /**
     * Bottone per visualizzare le informazioni riguardo l'utente loggato
     */
    JButton btnInfo = new JButton();

    /**
     * Bottone per effettuare il logout
     */
    JButton btnLogout = new JButton("LOGOUT");

    /**
     * Inizializza, imposta e visualizza la schermata dell'area personale dell'utente loggato
     *
     * @author Domenico Rizzo
     */
    public UIUtenteLoggato(Cittadino cittadinoLoggato) {
        this.cittadinoLoggato = cittadinoLoggato;

        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgLogin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/login.jpg")));
        ImageIcon imgCentri = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/centriicon.png")));
        ImageIcon imgEventi = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/eventiicon.png")));
        ImageIcon imgInfo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/userinfo.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Border border2 = new LineBorder(new Color(232, 47, 125), 2, true);

        JLabel labelTesto = new JLabel("Ciao, " + cittadinoLoggato.getNome());
        labelTesto.setBounds(160, 40, 500, 100);
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 40));
        labelTesto.setHorizontalTextPosition(JLabel.CENTER);

        JLabel labelTestoCentri = new JLabel();
        labelTestoCentri.setText("Visualizza centri");
        labelTestoCentri.setFont(new Font("Montserrat", Font.BOLD, 15));
        labelTestoCentri.setBounds(177, 445, 300, 100);

        JLabel labelTestoEventi = new JLabel();
        labelTestoEventi.setText("Segnala eventi avversi");
        labelTestoEventi.setFont(new Font("Montserrat", Font.BOLD, 15));
        labelTestoEventi.setBounds(553, 445, 300, 100);

        JLabel labelTestoUtente = new JLabel();
        labelTestoUtente.setText("Informazioni profilo");
        labelTestoUtente.setFont(new Font("Montserrat", Font.BOLD, 15));
        labelTestoUtente.setBounds(965, 445, 300, 100);

        btnVisualizzaCentri.setBounds(190, 327, 100, 107);
        btnVisualizzaCentri.setIcon(imgCentri);
        btnVisualizzaCentri.setFocusable(false);
        btnVisualizzaCentri.setBackground(new Color(232, 47, 125));
        btnVisualizzaCentri.setBorder(border2);
        btnVisualizzaCentri.addActionListener(this);
        btnVisualizzaCentri.setOpaque(true);

        btnSegnalaEventi.setBounds(590, 327, 100, 107);
        btnSegnalaEventi.setIcon(imgEventi);
        btnSegnalaEventi.setFocusable(false);
        btnSegnalaEventi.setBackground(new Color(232, 47, 125));
        btnSegnalaEventi.setBorder(border2);
        btnSegnalaEventi.addActionListener(this);
        btnSegnalaEventi.setOpaque(true);

        btnInfo.setBounds(990, 327, 100, 107);
        btnInfo.setIcon(imgInfo);
        btnInfo.setFocusable(false);
        btnInfo.setBackground(new Color(232, 47, 125));
        btnInfo.setBorder(border2);
        btnInfo.addActionListener(this);
        btnInfo.setOpaque(true);

        btnLogout.setBounds(975, 75, 150, 50);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogout.setBackground(new Color(232, 47, 125));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBorder(border);
        btnLogout.addActionListener(this);
        btnLogout.setOpaque(true);

        JLabel labelSfondo = new JLabel();
        labelSfondo.add(labelTesto);
        labelSfondo.setIcon(imgLogin);
        labelSfondo.setBounds(0, 0, 1280, 720);
        labelSfondo.add(btnSegnalaEventi);
        labelSfondo.add(btnVisualizzaCentri);
        labelSfondo.add(btnInfo);
        labelSfondo.add(btnLogout);
        labelSfondo.add(labelTestoCentri);
        labelSfondo.add(labelTestoEventi);
        labelSfondo.add(labelTestoUtente);

        this.setTitle("Home - area personale");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(imgLogo.getImage());
        this.setResizable(false);
        this.add(labelSfondo);
        this.setVisible(true);
    }

    /**
     * Gestore dei click sui pulsanti della schermata
     *
     * @param e evento che deve essere gestito
     *
     * @author Domenico Rizzo
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogout) {
            UIManager.put("OptionPane.yesButtonText", "Si");
            int risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di fare logout?", "Conferma", JOptionPane.YES_NO_OPTION);
            if (risposta == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else if (e.getSource() == btnVisualizzaCentri) {
            new UICercaCentriVaccinali();
        } else if (e.getSource() == btnSegnalaEventi) {
            new UISegnalaEventoAvverso(cittadinoLoggato);
        } else if (e.getSource() == btnInfo){
            new UIInfoUtente(cittadinoLoggato);
        }
    }
}
