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
import java.io.File;
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
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));
    ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/home.jpg")));
    JButton btnCentriVaccinali = new JButton("CENTRI VACCINALI");
    JButton btnCittadini = new JButton("CITTADINI");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    /**
     * Inizializza, imposta e visualizza il menu iniziale del programma
     *
     * @author Domenico Rizzo
     */
    public UIStartMenu(){
        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(img);
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

        btnCittadini.setBounds(655, 470, 200, 50);
        btnCittadini.setFocusable(false);
        btnCittadini.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCittadini.setBackground(new Color(232, 47, 125));
        btnCittadini.setForeground(Color.WHITE);
        btnCittadini.setBorder(border);
        btnCittadini.addActionListener(this);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(img2);
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

        createDataDirectory();

		this.add(panelSfondo);
        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Gestisce il click dei pulsanti della schermata
     *
     * @param e evento che deve venire processato
     *
     * @author Nicolas Guarini
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

    void createDataDirectory(){
        try{
            File dir = new File("./data");
            if (!dir.exists()){
                dir.mkdirs();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
