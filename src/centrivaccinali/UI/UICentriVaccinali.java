package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UICentriVaccinali implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JFrame frame = new JFrame();
    JLabel labelTitle = new JLabel("CENTRI VACCINALI");
    JButton btnRegistraCentroVaccinale = new JButton("REGISTRA CENTRO VACCINALE");
    JButton btnRegistraVaccinato = new JButton("REGISTRA VACCINATO");
    JButton btnIndietro = new JButton("INDIETRO");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UICentriVaccinali(){ setupFrame(); }

    private void setupFrame(){
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

        btnRegistraVaccinato.setBounds(btnRegistraCentroVaccinale.getX()+325, btnRegistraCentroVaccinale.getY(), 300, 65);
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

        frame.setTitle("Home - Centri Vaccinali");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(img.getImage());
        frame.setResizable(false);

        frame.add(labelTitle);
        frame.add(btnRegistraCentroVaccinale);
        frame.add(btnRegistraVaccinato);
        frame.add(btnIndietro);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnIndietro){
            frame.dispose();
            new UIStartMenu();
        } else if(e.getSource() == btnRegistraCentroVaccinale){
            new UIRegistraCentroVaccinale();
        }
    }
}
