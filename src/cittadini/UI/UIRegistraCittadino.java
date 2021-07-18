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
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();

    JButton btnRegistra = new JButton("REGISTRA");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIRegistraCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setLocationRelativeTo(null);
        this.setSize(720, 200);
        this.setTitle("Registrazione cittadino");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelNomeUtente = new JLabel("Nome utente:");
        labelNomeUtente.setFont(new Font("Helvetica", Font.BOLD, 15));

        JLabel labelPasswordUtente = new JLabel("Password:");
        labelPasswordUtente.setFont(new Font("Helvetica", Font.BOLD, 15));

        tfNomeUtente.setPreferredSize(new Dimension(150, 30));
        tfNomeUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));
        tfPasswordUtente.setPreferredSize(new Dimension(150, 30));
        tfPasswordUtente.setFont(new Font("Helvetica", Font.PLAIN, 15));

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

        JPanel panelRegistraCittadino1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistraCittadino1.add(labelNomeUtente);
        panelRegistraCittadino1.add(tfNomeUtente);

        JPanel panelRegistraCittadino2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelRegistraCittadino2.add(labelPasswordUtente);
        panelRegistraCittadino2.add(tfPasswordUtente);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnRegistra);
        panelBottoni.add(btnAnnulla);

        this.add(panelRegistraCittadino1);
        this.add(panelRegistraCittadino2);
        this.add(panelBottoni);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void registra() {
        String NomeUtente = tfNomeUtente.getText();
        String PasswordUtente = tfPasswordUtente.getText();
        if (tfNomeUtente.getText().equals("") || tfPasswordUtente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "ERRORE: devi inserire i dati");
        } else {
            JOptionPane.showMessageDialog(this, "Registrazione effettuata");
            this.dispose();
        }
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