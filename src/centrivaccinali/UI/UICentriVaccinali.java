package centrivaccinali.UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * La classe <code>UICentriVaccinali</code> si occupa di creare e gestire l'interfaccia utente della schermata principale della sezione "Centri Vaccinali"
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 */
public class UICentriVaccinali extends JFrame implements ActionListener {
    JLabel labelTitle = new JLabel("CENTRI VACCINALI");
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JButton btnRegistraCentroVaccinale = new JButton("REGISTRA CENTRO VACCINALE");
    JButton btnRegistraVaccinato = new JButton("REGISTRA VACCINATO");
    JButton btnIndietro = new JButton("INDIETRO");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    /**
     * Inizializza, imposta e visualizza la schermata principale della sezione "Centri Vaccinali"
     *
     * @see centrivaccinali.CentriVaccinali
     * @see UIRegistraCentroVaccinale
     * @see UIRegistraVaccinato
     *
     * @author Nicolas Guarini
     */
    public UICentriVaccinali() {
        labelTitle.setBounds(430, 165, 500, 100);
        labelTitle.setFont(new Font("Montserrat", Font.BOLD, 40));
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);

        btnRegistraCentroVaccinale.setBounds(315, labelTitle.getY() + 100 + 50, 300, 65);
        btnRegistraCentroVaccinale.setFocusable(false);
        btnRegistraCentroVaccinale.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistraCentroVaccinale.setBackground(new Color(232, 47, 125));
        btnRegistraCentroVaccinale.setForeground(Color.WHITE);
        btnRegistraCentroVaccinale.setBorder(border);
        btnRegistraCentroVaccinale.addActionListener(this);

        btnRegistraVaccinato.setBounds(btnRegistraCentroVaccinale.getX() + 325, btnRegistraCentroVaccinale.getY(), 300, 65);
        btnRegistraVaccinato.setFocusable(false);
        btnRegistraVaccinato.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistraVaccinato.setBackground(new Color(232, 47, 125));
        btnRegistraVaccinato.setForeground(Color.WHITE);
        btnRegistraVaccinato.setBorder(border);
        btnRegistraVaccinato.addActionListener(this);

        btnIndietro.setBounds(550, btnRegistraCentroVaccinale.getY() + 85, 150, 50);
        btnIndietro.setFocusable(false);
        btnIndietro.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnIndietro.setBackground(new Color(232, 47, 125));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBorder(border);
        btnIndietro.addActionListener(this);

        this.add(labelTitle);
        this.add(btnRegistraCentroVaccinale);
        this.add(btnRegistraVaccinato);
        this.add(btnIndietro);

        this.setTitle("Home - Centri Vaccinali");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Gestisce il click dei pulsanti della schermata
     * <p>
     *     Nello specifico, apre la schermata relativa al bottone cliccato dall'utente
     * </p>
     *
     * @param e l'evento che deve venire processato
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
            new UIRegistraVaccinato();
        }
    }
}
