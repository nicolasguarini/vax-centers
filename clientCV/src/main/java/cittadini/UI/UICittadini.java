//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.UI.UIStartMenu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Si occupa di creare e gestire l'interfaccia grafica della schermata iniziale della sezione dedicata ai cittadini
 *
 * @see UIRegistraCittadino
 * @see UILoginCittadino
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class UICittadini extends JFrame implements ActionListener {
    /**
     * Bottone per consultare i centri vaccinali
     */
    JButton btnConsultaCentri = new JButton("CONSULTA I CENTRI");

    /**
     * Bottone per effettuare la registrazione
     */
    JButton btnRegistrati = new JButton("REGISTRATI");

    /**
     * Bottone per effettuare il login
     */
    JButton btnLogIn = new JButton("LOGIN");

    /**
     * Bottone per tornare alla schermata iniziale
     */
    JButton btnIndietro = new JButton("INDIETRO");

    /**
     * Inizializza, imposta e visualizza la schermata iniziale della sezione <code>cittadini</code>
     *
     * @author Domenico Rizzo
     */
    public UICittadini() {
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgCittadini = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/cittadini.jpg")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);

        JLabel labelTesto = new JLabel();
        labelTesto.setText("PORTALE CITTADINI");
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 32));
        labelTesto.setBounds(55, 90, 500, 100);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(imgCittadini);
        labelSfondo.setBounds(0, 0, 850, 720);

        btnConsultaCentri.setBounds(60, 210, 300, 50);
        btnConsultaCentri.setFocusable(false);
        btnConsultaCentri.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnConsultaCentri.setBackground(new Color(232, 47, 125));
        btnConsultaCentri.setForeground(Color.WHITE);
        btnConsultaCentri.setBorder(border);
        btnConsultaCentri.addActionListener(this);
        btnConsultaCentri.setOpaque(true);

        btnRegistrati.setBounds(60, 280, 300, 50);
        btnRegistrati.setFocusable(false);
        btnRegistrati.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistrati.setBackground(new Color(232, 47, 125));
        btnRegistrati.setForeground(Color.WHITE);
        btnRegistrati.setBorder(border);
        btnRegistrati.addActionListener(this);
        btnRegistrati.setOpaque(true);

        btnLogIn.setBounds(60, 350, 300, 50);
        btnLogIn.setFocusable(false);
        btnLogIn.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogIn.setBackground(new Color(232, 47, 125));
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setBorder(border);
        btnLogIn.addActionListener(this);
        btnLogIn.setOpaque(true);

        btnIndietro.setBounds(140, 420, 150, 50);
        btnIndietro.setFocusable(false);
        btnIndietro.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnIndietro.setBackground(new Color(232, 47, 125));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBorder(border);
        btnIndietro.addActionListener(this);
        btnIndietro.setOpaque(true);

        JPanel panelBtn = new JPanel();
        panelBtn.setBounds(0, 0, 425, 720);
        panelBtn.setLayout(null);
        panelBtn.add(labelTesto);
        panelBtn.add(btnConsultaCentri);
        panelBtn.add(btnRegistrati);
        panelBtn.add(btnLogIn);
        panelBtn.add(btnIndietro);

        JPanel panelSfondo = new JPanel();
        panelSfondo.setBounds(425, 0, 850, 720);
        panelSfondo.setLayout(null);
        panelSfondo.add(labelSfondo);

        this.add(panelSfondo);
        this.add(panelBtn);
        this.setTitle("Home - Cittadini");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(imgLogo.getImage());
        this.setResizable(false);
        this.setVisible(true);
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
        if (e.getSource() == btnIndietro) {
            this.dispose();
            new UIStartMenu();
        } else if (e.getSource() == btnConsultaCentri) {
            if(CentriVaccinali.getCentriVaccinali().size() == 0)
                JOptionPane.showMessageDialog(this, "Nel sistema non � presente alcun centro vaccinale!");
            else
                new UICercaCentriVaccinali();
        } else if (e.getSource() == btnRegistrati) {
            new UIRegistraCittadino();
        } else if (e.getSource() == btnLogIn) {
            new UILoginCittadino();
        }
    }
}
