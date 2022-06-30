//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * La classe <code>UICentriVaccinali</code> si occupa di creare e gestire l'interfaccia utente della schermata principale della sezione "Centri Vaccinali"
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class UICentriVaccinali extends JFrame implements ActionListener {
    /**
     * Bottone per registrare un nuovo centro vaccinale
     */
    JButton btnRegistraCentroVaccinale = new JButton("REGISTRA CENTRO VACCINALE");

    /**
     * Bottone per registrare un nuovo vaccinato
     */
    JButton btnRegistraVaccinato = new JButton("REGISTRA VACCINATO");

    /**
     * Bottone per tornare alla schermata principale
     */
    JButton btnIndietro = new JButton("INDIETRO");

    /**
     * Inizializza, imposta e visualizza la schermata principale della sezione "Centri Vaccinali"
     *
     * @see centrivaccinali.CentriVaccinali
     * @see UIRegistraCentroVaccinale
     * @see UIRegistraVaccinato
     *
     * @author Domenico Rizzo
     */
    public UICentriVaccinali() {
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgCentriVaccinali = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/centri.jpg")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);

        JLabel labelTesto = new JLabel();
        labelTesto.setText("CENTRI VACCINALI");
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 32));
		labelTesto.setBounds(60, 90, 300, 100);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(imgCentriVaccinali);
		labelSfondo.setBounds(0, 0, 850, 720);

        btnRegistraCentroVaccinale.setBounds(60, 210, 300, 50);
        btnRegistraCentroVaccinale.setFocusable(false);
        btnRegistraCentroVaccinale.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistraCentroVaccinale.setBackground(new Color(232, 47, 125));
        btnRegistraCentroVaccinale.setForeground(Color.WHITE);
        btnRegistraCentroVaccinale.setBorder(border);
        btnRegistraCentroVaccinale.addActionListener(this);
        btnRegistraCentroVaccinale.setOpaque(true);

        btnRegistraVaccinato.setBounds(60, 280, 300, 50);
        btnRegistraVaccinato.setFocusable(false);
        btnRegistraVaccinato.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistraVaccinato.setBackground(new Color(232, 47, 125));
        btnRegistraVaccinato.setForeground(Color.WHITE);
        btnRegistraVaccinato.setBorder(border);
        btnRegistraVaccinato.addActionListener(this);
        btnRegistraVaccinato.setOpaque(true);

        btnIndietro.setBounds(140, 350, 150, 50);
        btnIndietro.setFocusable(false);
        btnIndietro.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnIndietro.setBackground(new Color(232, 47, 125));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBorder(border);
        btnIndietro.addActionListener(this);
        btnIndietro.setOpaque(true);

        JPanel panelBtn = new JPanel();
		panelBtn.setBounds(850, 0, 425, 720);
		panelBtn.setLayout(null);
        panelBtn.add(labelTesto);
        panelBtn.add(btnRegistraCentroVaccinale);
        panelBtn.add(btnRegistraVaccinato);
        panelBtn.add(btnIndietro);
		
		JPanel panelSfondo = new JPanel();
		panelSfondo.setBounds(0, 0, 850, 720);
		panelSfondo.setLayout(null);
        panelSfondo.add(labelSfondo);

		this.add(panelSfondo);
        this.add(panelBtn);
        this.setTitle("Home - Centri vaccinali");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(imgLogo.getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Gestisce il click dei pulsanti della schermata
     * <p>
     *     Nello specifico, apre la schermata relativa al bottone cliccato dall'utente
     * </p>
     *
     * @param e l'evento che deve essere processato
     *
     * @see UICentriVaccinali
     *
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIndietro) {
            new UIStartMenu();
            this.dispose();
        } else if (e.getSource() == btnRegistraCentroVaccinale) {
            new UIRegistraCentroVaccinale();
        } else if (e.getSource() == btnRegistraVaccinato) {
            if(CentriVaccinali.getCentriVaccinali().size() == 0)
                JOptionPane.showMessageDialog(this, "Devi registrare un centro vaccinale prima!");
            else
                new UIRegistraVaccinato();
        }
    }
}
