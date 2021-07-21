package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

public class UICercaCentriVaccinali extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JButton btnCercaPerNome = new JButton("CERCA");
    JButton btnCercaPerComuneETipologia = new JButton("CERCA");
    JButton btnVisualizzaTutti = new JButton("VISUALIZZA TUTTI");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);
    JTextField tfCercaPerNome = new JTextField();
    JTextField tfCercaPerComune = new JTextField();
    JComboBox cbTipologie = new JComboBox(new String[]{"Ospedaliero", "Aziendale", "Hub"});

    public UICercaCentriVaccinali(){
        JPanel panelCercaPerNome = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCercaPerNome = new JLabel("Cerca per nome: ");
        labelCercaPerNome.setFont(new Font("Helvetica", Font.BOLD, 15));
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
        tfCercaPerComune.setPreferredSize(new Dimension(150, 30));
        tfCercaPerComune.setFont(new Font("Helvetica", Font.PLAIN, 15));
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

        JPanel panelVisualizzaTutti = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnVisualizzaTutti.setPreferredSize(new Dimension(200, 35));
        btnVisualizzaTutti.setFocusable(false);
        btnVisualizzaTutti.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnVisualizzaTutti.setBackground(new Color(232, 47, 125));
        btnVisualizzaTutti.setForeground(Color.WHITE);
        btnVisualizzaTutti.setBorder(border);
        panelVisualizzaTutti.add(btnVisualizzaTutti);

        btnVisualizzaTutti.addActionListener(this);
        btnCercaPerNome.addActionListener(this);
        btnCercaPerComuneETipologia.addActionListener(this);

        this.setTitle("Cerca Centri Vaccinali");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 15, 15));
        this.setIconImage(img.getImage());
        this.setResizable(false);

        this.add(panelCercaPerNome);
        this.add(panelCercaPerComuneETipologia);
        this.add(panelVisualizzaTutti);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void cercaCentriVaccinali(String nome){
        LinkedList<CentroVaccinale> centriDaVisualizzare = new LinkedList<>();
        for(CentroVaccinale i : CentriVaccinali.getCentriVaccinali())
            if(i.getNome().contains(nome)) centriDaVisualizzare.add(i);

        new UIVisualizzaCentriVaccinali(centriDaVisualizzare);
        this.dispose();
    }

    public void cercaCentriVaccinali(String comune, String tipologia){
        LinkedList<CentroVaccinale> centriDaVisualizzare = new LinkedList<>();
        for(CentroVaccinale i : CentriVaccinali.getCentriVaccinali())
            if(i.getComune().equals(comune) && i.getTipologia().equals(tipologia))
                centriDaVisualizzare.add(i);

        new UIVisualizzaCentriVaccinali(centriDaVisualizzare);
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVisualizzaTutti){
            new UIVisualizzaCentriVaccinali(CentriVaccinali.getCentriVaccinali());
        }else if(e.getSource() == btnCercaPerNome){
            String nome = tfCercaPerNome.getText();
            if(!nome.equals("")){
                cercaCentriVaccinali(nome);
            }else{
                JOptionPane.showMessageDialog(this, "Inserisci il nome da ricercare");
            }
        }else if(e.getSource() == btnCercaPerComuneETipologia){
            String comune = tfCercaPerComune.getText();
            String tipologia = cbTipologie.getSelectedItem().toString();
            if(!comune.equals("")){
                cercaCentriVaccinali(comune, tipologia);
            }else{
                JOptionPane.showMessageDialog(this, "Inserisci il comune");
            }
        }
    }
}
