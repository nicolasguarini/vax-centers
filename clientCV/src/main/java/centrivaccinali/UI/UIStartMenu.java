//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package centrivaccinali.UI;

import cittadini.UI.UICittadini;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * La classe <code>UIStartMenu</code> si occupa di gestire il menu iniziale del programma, dove l'utente può scegliere se entrare nella sezione dedicata ai centri vaccinali o quella dedicata ai cittadini
 *
 * @see centrivaccinali.CentriVaccinali
 * @see cittadini.Cittadini
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class UIStartMenu extends JFrame implements ActionListener {
    /**
     * Bottone per accedere alla sezione dedicata ai centri vaccinali
     */
    JButton btnCentriVaccinali = new JButton("CENTRI VACCINALI");

    /**
     * Bottone per accedere alla sezione dedicata ai cittadini
     */
    JButton btnCittadini = new JButton("CITTADINI");

    /**
     * Inizializza, imposta e visualizza il menu iniziale del programma
     *
     * @author Domenico Rizzo
     */
    public UIStartMenu(){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgHome = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/home.jpg")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);

        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(imgLogo);
		labelLogo.setBounds(535, 180, 212, 212);

        JLabel labelTesto = new JLabel();
        labelTesto.setText("Seleziona un metodo di accesso");
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 15));
		labelTesto.setBounds(520, 380, 300, 100);

        btnCentriVaccinali.setBounds(425, 470, 200, 50);
        btnCentriVaccinali.setFocusable(false);
        btnCentriVaccinali.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCentriVaccinali.setBackground(new Color(232, 47, 125));
        btnCentriVaccinali.setForeground(Color.WHITE);
        btnCentriVaccinali.setBorder(border);
        btnCentriVaccinali.addActionListener(this);
        btnCentriVaccinali.setOpaque(true);

        btnCittadini.setBounds(655, 470, 200, 50);
        btnCittadini.setFocusable(false);
        btnCittadini.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCittadini.setBackground(new Color(232, 47, 125));
        btnCittadini.setForeground(Color.WHITE);
        btnCittadini.setBorder(border);
        btnCittadini.addActionListener(this);
        btnCittadini.setOpaque(true);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(imgHome);
		labelSfondo.setBounds(0, 0, 1280, 720);
        labelSfondo.add(labelTesto);
        labelSfondo.add(btnCentriVaccinali);
        labelSfondo.add(btnCittadini);
        labelSfondo.add(labelLogo);

		JPanel panelInfo = new JPanel();
        panelInfo.setBounds(0, 0, 50, 50);
		panelInfo.setLayout(null);
        panelInfo.setBackground(Color.red);

		JPanel panelSfondo = new JPanel();
		panelSfondo.setBounds(0, 0, 1280, 720);
		panelSfondo.setLayout(null);
        panelSfondo.add(labelSfondo);

		this.add(panelSfondo);
        this.setTitle("Vax Centers");
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
     *
     * @param e evento che deve venire processato
     *
     * @author Domenico Rizzo
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnCentriVaccinali){
            this.dispose();
            new UICentriVaccinali();
        } else if(e.getSource() == btnCittadini){
            this.dispose();
            new UICittadini();
        }
    }
}
