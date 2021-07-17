package centrivaccinali.UI;

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

public class UIRegistraVaccinato extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JComboBox selectCentroVaccinale = new JComboBox(getCentriArray());
    JTextField tfNomeVaccinato = new JTextField();
    JTextField tfCognomeVaccinato = new JTextField();
    JTextField tfCodiceFiscaleVaccinato = new JTextField();
    JTextField tfDataSomministrazioneVaccino= new JTextField();
    JTextField tfIDVaccinazione = new JTextField();

    JComboBox selectNomeVaccino = new JComboBox(new String[] { "Pfizer", "AstraZeneca", "Moderna", "J&J" });
    JButton btnRegistra = new JButton("REGISTRA");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIRegistraVaccinato() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setSize(750, 200);
        this.setTitle("Registra Vaccinato");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        //CREAZIONE LABEL PER OGNI SEZIONE
        JLabel labelNomeCentroVaccinale = new JLabel("Centro vaccinale:");
        labelNomeCentroVaccinale.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelNomeVaccinato = new JLabel("Nome:");
        labelNomeVaccinato.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelCognomeVaccinato = new JLabel("Cognome:");
        labelCognomeVaccinato.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelCodiceFiscaleVaccinato= new JLabel("Codice fiscale:");
        labelCodiceFiscaleVaccinato.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelDataSomministrazioneVaccino = new JLabel("Data somministrazione:");
        labelDataSomministrazioneVaccino.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelNomeVaccino = new JLabel("Nome vaccino:");
        labelNomeVaccino.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelIDVaccinazione = new JLabel("ID vaccinazione:");
        labelIDVaccinazione.setFont(new Font("Helvetica", Font.BOLD, 15));

        //IMPOSTAZIONI DEI TEXTFIELD
        selectCentroVaccinale.setPreferredSize(new Dimension(400, 30));
        selectCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));

        tfNomeVaccinato.setPreferredSize(new Dimension(150, 30));
        tfNomeVaccinato.setFont(new Font("Helvetica", Font.PLAIN, 15));

        tfCognomeVaccinato.setPreferredSize(new Dimension(150, 30));
        tfCognomeVaccinato.setFont(new Font("Helvetica", Font.PLAIN, 15));

        tfCodiceFiscaleVaccinato.setPreferredSize(new Dimension(150, 30));
        tfCodiceFiscaleVaccinato.setFont(new Font("Helvetica", Font.PLAIN, 15));

        tfDataSomministrazioneVaccino.setPreferredSize(new Dimension(100, 30));
        tfDataSomministrazioneVaccino.setFont(new Font("Helvetica", Font.PLAIN, 15));

        selectNomeVaccino.setPreferredSize(new Dimension(100, 30));
        selectNomeVaccino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        selectNomeVaccino.setSelectedIndex(0);

        tfIDVaccinazione.setPreferredSize(new Dimension(100, 30));
        tfIDVaccinazione.setFont(new Font("Helvetica", Font.PLAIN, 15));

        //BOTTONI REGISTRA ED ANNULLA
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

        JPanel panelRegistrazioneVaccinati1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneVaccinati1.add(labelNomeCentroVaccinale);
        panelRegistrazioneVaccinati1.add(selectCentroVaccinale);

        JPanel panelRegistrazioneVaccinati2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneVaccinati2.add(labelNomeVaccinato);
        panelRegistrazioneVaccinati2.add(tfNomeVaccinato);
        panelRegistrazioneVaccinati2.add(labelCognomeVaccinato);
        panelRegistrazioneVaccinati2.add(tfCognomeVaccinato);

        JPanel panelRegistrazioneVaccinati3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneVaccinati3.add(labelCodiceFiscaleVaccinato);
        panelRegistrazioneVaccinati3.add(tfCodiceFiscaleVaccinato);
        panelRegistrazioneVaccinati3.add(labelIDVaccinazione);
        panelRegistrazioneVaccinati3.add(tfIDVaccinazione);

        JPanel panelRegistrazioneVaccinati4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneVaccinati4.add(labelDataSomministrazioneVaccino);
        panelRegistrazioneVaccinati4.add(tfDataSomministrazioneVaccino);
        panelRegistrazioneVaccinati4.add(labelNomeVaccino);
        panelRegistrazioneVaccinati4.add(selectNomeVaccino);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        this.add(panelRegistrazioneVaccinati1);
        this.add(panelRegistrazioneVaccinati2);
        this.add(panelRegistrazioneVaccinati3);
        this.add(panelRegistrazioneVaccinati4);
        this.add(panelBottoni);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    void registra(){
        //TODO: creare la funzione registra con validazione dell'input
        // PRENOTATO DA GUARO
    }

    String[] getCentriArray(){
        LinkedList<CentroVaccinale> centri = CentriVaccinali.getCentriVaccinali();
        int size = centri.size();
        String[] arCentri = new String[size];
        for(int i = 0; i < size; i++){
            CentroVaccinale centro = centri.get(i);
            arCentri[i] = centro.getNome() + ", " + centro.getIndirizzo().toString();
        }
        return arCentri;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistra) {
            registra();
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}