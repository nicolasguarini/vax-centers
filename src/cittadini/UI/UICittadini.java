package cittadini.UI;

import centrivaccinali.UI.UIStartMenu;

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

public class UICittadini extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/cittadini.jpg")));
    JButton btnConsultaCentri = new JButton("CONSULTA I CENTRI");
    JButton btnRegistrati = new JButton("REGISTRATI");
    JButton btnLogIn = new JButton("LOGIN");
    JButton btnIndietro = new JButton("INDIETRO");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UICittadini() {
        setupFrame();
    }

    private void setupFrame() {
        JLabel labelTesto = new JLabel();
        labelTesto.setText("PORTALE CITTADINI");
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 32));
		labelTesto.setBounds(55, 90, 500, 100);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(img2);
		labelSfondo.setBounds(0, 0, 850, 720);

        btnConsultaCentri.setBounds(60, 210, 300, 50);
        btnConsultaCentri.setFocusable(false);
        btnConsultaCentri.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnConsultaCentri.setBackground(new Color(232, 47, 125));
        btnConsultaCentri.setForeground(Color.WHITE);
        btnConsultaCentri.setBorder(border);
        btnConsultaCentri.addActionListener(this);

        btnRegistrati.setBounds(60, 280, 300, 50);
        btnRegistrati.setFocusable(false);
        btnRegistrati.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistrati.setBackground(new Color(232, 47, 125));
        btnRegistrati.setForeground(Color.WHITE);
        btnRegistrati.setBorder(border);
        btnRegistrati.addActionListener(this);

        btnLogIn.setBounds(60, 350, 300, 50);
        btnLogIn.setFocusable(false);
        btnLogIn.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogIn.setBackground(new Color(232, 47, 125));
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setBorder(border);
        btnLogIn.addActionListener(this);

        btnIndietro.setBounds(140, 420, 150, 50);
        btnIndietro.setFocusable(false);
        btnIndietro.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnIndietro.setBackground(new Color(232, 47, 125));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBorder(border);
        btnIndietro.addActionListener(this);

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
        this.setIconImage(img.getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIndietro) {
            this.dispose();
            new UIStartMenu();
        } else if (e.getSource() == btnConsultaCentri) {
            new UICercaCentriVaccinali();
        } else if (e.getSource() == btnRegistrati) {
            new UIRegistraCittadino();
        } else if (e.getSource() == btnLogIn) {
            new UILoginCittadino();
        }
    }
}
