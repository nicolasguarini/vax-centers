package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;
import centrivaccinali.Indirizzo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UIRegistraCentroVaccinale extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JTextField tfNomeCentroVaccinale = new JTextField();
    JTextField tfNomeIndirizzo = new JTextField();
    JTextField tfCivico = new JTextField();
    JTextField tfComune = new JTextField();
    JTextField tfProvincia = new JTextField();
    JTextField tfCAP = new JTextField();
    JComboBox qualificatoreIndirizzo = new JComboBox(new String[]{"Via", "Viale", "Piazza"});
    JComboBox tipologiaCentroVaccinale = new JComboBox(new String[]{"Ospedaliero", "Aziendale", "Hub"});
    JButton btnRegistra = new JButton("REGISTRA");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIRegistraCentroVaccinale(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setSize(720, 200);
        this.setTitle("Registra Centro Vaccinale");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelNomeCentroVaccinale = new JLabel("Nome centro vaccinale:");
        labelNomeCentroVaccinale.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelIndirizzo = new JLabel("Indirizzo:");
        labelIndirizzo.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCivico = new JLabel("Numero Civico:");
        labelCivico.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelComune = new JLabel("Comune:");
        labelComune.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelProvincia = new JLabel("Sigla Provincia:");
        labelProvincia.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCAP = new JLabel("CAP:");
        labelCAP.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelTipologiaCentro = new JLabel("Tipologia centro vaccinale:");
        labelTipologiaCentro.setFont(new Font("Helvetica", Font.BOLD, 15));

        tfNomeCentroVaccinale.setPreferredSize(new Dimension(150, 30));
        tfNomeCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfNomeIndirizzo.setPreferredSize(new Dimension(150, 30));
        tfNomeIndirizzo.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCivico.setPreferredSize(new Dimension(50, 30));
        tfCivico.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfComune.setPreferredSize(new Dimension(150, 30));
        tfComune.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfProvincia.setPreferredSize(new Dimension(50, 30));
        tfProvincia.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCAP.setPreferredSize(new Dimension(100, 30));
        tfCAP.setFont(new Font("Helvetica", Font.PLAIN, 15));
        qualificatoreIndirizzo.setFont(new Font("Helvetica", Font.PLAIN, 15));
        qualificatoreIndirizzo.setSelectedIndex(0);
        tipologiaCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tipologiaCentroVaccinale.setSelectedIndex(0);

        btnRegistra.setPreferredSize(new Dimension(200, 50));
        btnRegistra.setFocusable(false);
        btnRegistra.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRegistra.setBackground(new Color(232, 47, 125));
        btnRegistra.setForeground(Color.WHITE);
        btnRegistra.setBorder(border);
        btnRegistra.addActionListener(this);
        btnAnnulla.setPreferredSize(new Dimension(200, 50));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);

        JPanel panelNomeCentroVaccinale = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNomeCentroVaccinale.add(labelNomeCentroVaccinale);
        panelNomeCentroVaccinale.add(tfNomeCentroVaccinale);

        JPanel panelIndirizzoCentroVaccinale1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelIndirizzoCentroVaccinale1.add(labelIndirizzo);
        panelIndirizzoCentroVaccinale1.add(qualificatoreIndirizzo);
        panelIndirizzoCentroVaccinale1.add(tfNomeIndirizzo);

        JPanel panelIndirizzoCentroVaccinale2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelIndirizzoCentroVaccinale2.add(labelCivico);
        panelIndirizzoCentroVaccinale2.add(tfCivico);
        panelIndirizzoCentroVaccinale2.add(labelComune);
        panelIndirizzoCentroVaccinale2.add(tfComune);

        JPanel panelIndirizzoCentroVaccinale3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelIndirizzoCentroVaccinale3.add(labelProvincia);
        panelIndirizzoCentroVaccinale3.add(tfProvincia);
        panelIndirizzoCentroVaccinale3.add(labelCAP);
        panelIndirizzoCentroVaccinale3.add(tfCAP);

        JPanel panelTipologia = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelTipologia.add(labelTipologiaCentro);
        panelTipologia.add(tipologiaCentroVaccinale);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        this.add(panelNomeCentroVaccinale);
        this.add(panelIndirizzoCentroVaccinale1);
        this.add(panelIndirizzoCentroVaccinale2);
        this.add(panelIndirizzoCentroVaccinale3);
        this.add(panelTipologia);
        this.add(panelBottoni);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void registra(){
        String nome = tfNomeCentroVaccinale.getText();
        String qualificatore = qualificatoreIndirizzo.getSelectedItem().toString();
        String nomeIndirizzo = tfNomeIndirizzo.getText();
        String civico = tfCivico.getText();
        String comune = tfComune.getText();
        String provincia = tfProvincia.getText();
        String CAP = tfCAP.getText();
        String tipologiaCentro  = tipologiaCentroVaccinale.getSelectedItem().toString();

        if(validaDati(nome, nomeIndirizzo, civico, comune, provincia, CAP)){
            Indirizzo indirizzo = new Indirizzo(qualificatore, Character.toUpperCase(nomeIndirizzo.charAt(0)) + nomeIndirizzo.substring(1).toLowerCase(), civico, Character.toUpperCase(comune.charAt(0)) + comune.substring(1).toLowerCase(), provincia.toUpperCase(), CAP);
            CentroVaccinale centroVaccinale = new CentroVaccinale(Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase(), indirizzo, tipologiaCentro);

            CentriVaccinali.registraCentroVaccinale(centroVaccinale);
            this.dispose();
        }
    }

    boolean validaDati(String nome, String nomeIndirizzo, String civico, String comune, String provincia, String CAP){
        //PER LE ALTRE VALIDAZIONI TENERE QUESTA COME ESEMPIO CHE E' ON POINT
        String messaggio = "";

        if(nome.equals("") || nomeIndirizzo.equals("") || civico.equals("") || comune.equals("") || provincia.equals("") || CAP.equals("")){
            JOptionPane.showMessageDialog(this, "Inserisci tutti i dati!");
            return false;
        }

        if(nome.matches(".*\\d.*")) messaggio += "Il nome non può contenere cifre! \n";
        if(nomeIndirizzo.matches(".*\\d.*")) messaggio += "L'indirizzo non può contenere cifre! \n";
        if(comune.matches(".*\\d.*")) messaggio += "Il comune non può contenere cifre! \n";
        if(provincia.matches(".*\\d.*")) messaggio += "La sigla provincia non può contenere cifre (es: VA)! \n";
        if(!CAP.matches("^[0-9]*$")) messaggio += "Il CAP deve contenere solo cifre (es: 21020)! \n";
        if(CAP.length() != 5) messaggio += "Il CAP deve essere di 5 cifre! \n";
        if(provincia.length() != 2) messaggio += "La sigla provincia deve essere di 2 lettere! \n";

        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegistra){
            registra();
        }else if(e.getSource() == btnAnnulla){
            this.dispose();
        }
    }
}
