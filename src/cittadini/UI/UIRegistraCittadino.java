package cittadini.UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UIRegistraCittadino extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JTextField tfNomeCittadino = new JTextField();
    JTextField tfCognomeCittadino = new JTextField();
    JTextField tfCodiceFiscaleCittadino = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();
    JTextField tfIDVaccinazione = new JTextField();

    JButton btnRegistra = new JButton("REGISTRATI");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIRegistraCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setSize(750, 200);
        this.setTitle("Registra cittadino");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelNomeCittadino = new JLabel("Nome:");
        labelNomeCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCognomeCittadino = new JLabel("Cognome:");
        labelCognomeCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelCodiceFiscaleCittadino = new JLabel("Codice fiscale:");
        labelCodiceFiscaleCittadino.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelNomeUtente = new JLabel("Nome utente:");
        labelNomeUtente.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelPasswordUtente = new JLabel("Password:");
        labelPasswordUtente.setFont(new Font("Helvetica", Font.BOLD, 15));
        JLabel labelIDVaccinazione = new JLabel("ID vaccinazione:");
        labelIDVaccinazione.setFont(new Font("Helvetica", Font.BOLD, 15));

        tfNomeCittadino.setPreferredSize(new Dimension(150, 30));
        tfNomeCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCognomeCittadino.setPreferredSize(new Dimension(150, 30));
        tfCognomeCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfCodiceFiscaleCittadino.setPreferredSize(new Dimension(150, 30));
        tfCodiceFiscaleCittadino.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfEmail.setPreferredSize(new Dimension(100, 30));
        tfEmail.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfNomeUtente.setPreferredSize(new Dimension(100, 30));
        tfNomeUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfPasswordUtente.setPreferredSize(new Dimension(100, 30));
        tfPasswordUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfIDVaccinazione.setPreferredSize(new Dimension(100, 30));
        tfIDVaccinazione.setFont(new Font("Helvetica", Font.PLAIN, 15));

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

        JPanel panelRegistrazioneCittadino1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino1.add(labelNomeCittadino);
        panelRegistrazioneCittadino1.add(tfNomeCittadino);
        panelRegistrazioneCittadino1.add(labelCognomeCittadino);
        panelRegistrazioneCittadino1.add(tfCognomeCittadino);

        JPanel panelRegistrazioneCittadino2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino2.add(labelCodiceFiscaleCittadino);
        panelRegistrazioneCittadino2.add(tfCodiceFiscaleCittadino);
        panelRegistrazioneCittadino2.add(labelEmail);
        panelRegistrazioneCittadino2.add(tfEmail);

        JPanel panelRegistrazioneCittadino3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino3.add(labelNomeUtente);
        panelRegistrazioneCittadino3.add(tfNomeUtente);
        panelRegistrazioneCittadino3.add(labelPasswordUtente);
        panelRegistrazioneCittadino3.add(tfPasswordUtente);

        JPanel panelRegistrazioneCittadino4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistrazioneCittadino4.add(labelIDVaccinazione);
        panelRegistrazioneCittadino4.add(tfIDVaccinazione);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        this.add(panelRegistrazioneCittadino1);
        this.add(panelRegistrazioneCittadino2);
        this.add(panelRegistrazioneCittadino3);
        this.add(panelRegistrazioneCittadino4);
        this.add(panelBottoni);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void registra() {
        if (tfNomeCittadino.getText().equals("") || tfCognomeCittadino.getText().equals("") || tfCodiceFiscaleCittadino.getText().equals("") 
        || tfEmail.getText().equals("") || tfNomeUtente.getText().equals("") || tfPasswordUtente.getText().equals("") || tfIDVaccinazione.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Devi inserire tutti i dati per poterti registrare", "ERRORE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registrazione effettuata");
            this.dispose();
        }

        //TODO: Creare memorizzazione effettiva della registrazione
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