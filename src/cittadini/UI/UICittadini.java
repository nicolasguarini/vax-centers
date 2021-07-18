package cittadini.UI;

import centrivaccinali.UI.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UICittadini implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JFrame frame = new JFrame();
    JLabel labelTitle = new JLabel("PORTALE CITTADINI");
    JButton btnConsultaCentri = new JButton("CONSULTA I CENTRI");
    JButton btnRegistrati = new JButton("REGISTRATI");
    JButton btnLogIn = new JButton("LOGIN");
    JButton btnIndietro = new JButton("INDIETRO");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UICittadini() {
        setupFrame();
    }

    private void setupFrame() {
        labelTitle.setBounds(430, 165, 500, 100);
        labelTitle.setFont(new Font("Montserrat", Font.BOLD, 40));
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);

        btnConsultaCentri.setBounds(142, labelTitle.getY() + 100 + 50, 300, 65);
        btnConsultaCentri.setFocusable(false);
        btnConsultaCentri.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnConsultaCentri.setBackground(new Color(232, 47, 125));
        btnConsultaCentri.setForeground(Color.WHITE);
        btnConsultaCentri.setBorder(border);
        btnConsultaCentri.addActionListener(this);

        btnRegistrati.setBounds(btnConsultaCentri.getX() + 325, btnConsultaCentri.getY(), 300, 65);
        btnRegistrati.setFocusable(false);
        btnRegistrati.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistrati.setBackground(new Color(232, 47, 125));
        btnRegistrati.setForeground(Color.WHITE);
        btnRegistrati.setBorder(border);
        btnRegistrati.addActionListener(this);

        btnLogIn.setBounds(btnRegistrati.getX() + 325, btnRegistrati.getY(), 300, 65);
        btnLogIn.setFocusable(false);
        btnLogIn.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogIn.setBackground(new Color(232, 47, 125));
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setBorder(border);
        btnLogIn.addActionListener(this);

        btnIndietro.setBounds(550, btnConsultaCentri.getY() + 85, 150, 50);
        btnIndietro.setFocusable(false);
        btnIndietro.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnIndietro.setBackground(new Color(232, 47, 125));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBorder(border);
        btnIndietro.addActionListener(this);

        frame.setTitle("Home - Cittadini");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(img.getImage());
        frame.setResizable(false);

        frame.add(labelTitle);
        frame.add(btnConsultaCentri);
        frame.add(btnRegistrati);
        frame.add(btnLogIn);
        frame.add(btnIndietro);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIndietro) {
            frame.dispose();
            new UIStartMenu();
        } else if (e.getSource() == btnConsultaCentri) {
            // TODO: Creare visualizzazione dei centri vaccinali
        } else if (e.getSource() == btnRegistrati) {
            // TODO: Creare gui per registrazione funzionante
        } else if (e.getSource() == btnLogIn) {
            new UILoginCittadino();
        }
    }
}
