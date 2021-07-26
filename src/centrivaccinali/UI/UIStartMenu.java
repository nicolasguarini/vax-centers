package centrivaccinali.UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import cittadini.UI.UICittadini;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UIStartMenu extends JFrame implements ActionListener {
    JLabel logo = new JLabel();
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JButton btnCentriVaccinali = new JButton("CENTRI VACCINALI");
    JButton btnCittadini = new JButton("CITTADINI");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIStartMenu(){
        logo.setIcon(img);
        logo.setBounds(538, 140, 212, 212);
        logo.setHorizontalTextPosition(JLabel.CENTER);

        btnCentriVaccinali.setBounds(415, 425, 200, 50);
        btnCentriVaccinali.setFocusable(false);
        btnCentriVaccinali.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCentriVaccinali.setBackground(new Color(232, 47, 125));
        btnCentriVaccinali.setForeground(Color.WHITE);
        btnCentriVaccinali.setBorder(border);
        btnCentriVaccinali.addActionListener(this);

        btnCittadini.setBounds(675, 425, 200, 50);
        btnCittadini.setFocusable(false);
        btnCittadini.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCittadini.setBackground(new Color(232, 47, 125));
        btnCittadini.setForeground(Color.WHITE);
        btnCittadini.setBorder(border);
        btnCittadini.addActionListener(this);

        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        this.setResizable(false);

        this.add(logo);
        this.add(btnCentriVaccinali);
        this.add(btnCittadini);

        this.setVisible(true);
    }

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
