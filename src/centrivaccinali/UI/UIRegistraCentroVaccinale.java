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
        this.setLocationRelativeTo(null);
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

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        JPanel panelTipologia = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelTipologia.add(labelTipologiaCentro);
        panelTipologia.add(tipologiaCentroVaccinale);

        this.add(panelNomeCentroVaccinale);
        this.add(panelIndirizzoCentroVaccinale1);
        this.add(panelIndirizzoCentroVaccinale2);
        this.add(panelIndirizzoCentroVaccinale3);
        this.add(panelTipologia);
        this.add(panelBottoni);

        this.pack();
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
        Indirizzo indirizzo = new Indirizzo(qualificatore, nomeIndirizzo, civico, comune, provincia, CAP);
        String tipologiaCentro  = tipologiaCentroVaccinale.getSelectedItem().toString();

        //TODO: validazione input. se l'input non è valido mostrare un messaggio di errore con scritto qual è il problmea (JOptionPane.showMessageDialog(this, "messaggio");)
        // NB: non se l'input non è valido non bisogna eseguire il codice sottostante per ovvie ragioni

        CentroVaccinale centroVaccinale = new CentroVaccinale(nome, indirizzo, tipologiaCentro);

        CentriVaccinali.registraCentroVaccinale(centroVaccinale);
        this.dispose();
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