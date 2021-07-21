package cittadini.UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class UICercaCentriVaccinali extends JFrame {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JButton btnCercaPerNome = new JButton("CERCA");
    JButton btnCercaPerComuneETipologia = new JButton("CERCA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UICercaCentriVaccinali(){
        JPanel panelCercaPerNome = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCercaPerNome = new JLabel("Cerca per nome: ");
        labelCercaPerNome.setFont(new Font("Helvetica", Font.BOLD, 15));
        JTextField tfCercaPerNome = new JTextField();
        tfCercaPerNome.setPreferredSize(new Dimension(150, 30));
        tfCercaPerNome.setFont(new Font("Helvetica", Font.PLAIN, 15));
        btnCercaPerNome.setPreferredSize(new Dimension(100, 30));
        btnCercaPerNome.setFocusable(false);
        btnCercaPerNome.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCercaPerNome.setBackground(new Color(232, 47, 125));
        btnCercaPerNome.setForeground(Color.WHITE);
        btnCercaPerNome.setBorder(border);
        panelCercaPerNome.add(labelCercaPerNome);
        panelCercaPerNome.add(tfCercaPerNome);
        panelCercaPerNome.add(btnCercaPerNome);

        JPanel panelCercaPerComuneETipologia = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCercaPerComuneETipologia = new JLabel("Cerca per comune e tipologia: ");
        labelCercaPerComuneETipologia.setFont(new Font("Helvetica", Font.BOLD, 15));
        JTextField tfCercaPerComune = new JTextField();
        tfCercaPerComune.setPreferredSize(new Dimension(150, 30));
        tfCercaPerComune.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JComboBox cbTipologie = new JComboBox(new String[]{"Ospedaliero", "Aziendale", "Hub"});
        cbTipologie.setFont(new Font("Helvetica", Font.PLAIN, 15));
        cbTipologie.setSelectedIndex(0);
        btnCercaPerComuneETipologia.setPreferredSize(new Dimension(100, 30));
        btnCercaPerComuneETipologia.setFocusable(false);
        btnCercaPerComuneETipologia.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnCercaPerComuneETipologia.setBackground(new Color(232, 47, 125));
        btnCercaPerComuneETipologia.setForeground(Color.WHITE);
        btnCercaPerComuneETipologia.setBorder(border);
        panelCercaPerComuneETipologia.add(labelCercaPerComuneETipologia);
        panelCercaPerComuneETipologia.add(tfCercaPerComune);
        panelCercaPerComuneETipologia.add(cbTipologie);
        panelCercaPerComuneETipologia.add(btnCercaPerComuneETipologia);

        this.setTitle("Cerca Centri Vaccinali");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setIconImage(img.getImage());
        this.setResizable(false);

        this.add(panelCercaPerNome);
        this.add(panelCercaPerComuneETipologia);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
