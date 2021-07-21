package cittadini.UI;

import cittadini.Cittadini;
import cittadini.Cittadino;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class UILoginCittadino extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();

    JButton btnLogin = new JButton("LOGIN");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UILoginCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setLocationRelativeTo(null);
        this.setSize(720, 200);
        this.setTitle("Login cittadino");
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

        btnLogin.setPreferredSize(new Dimension(200, 50));
        btnLogin.setFocusable(false);
        btnLogin.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogin.setBackground(new Color(232, 47, 125));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(border);
        btnLogin.addActionListener(this);

        btnAnnulla.setPreferredSize(new Dimension(200, 50));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);

        JPanel panelNomeUtente = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNomeUtente.add(labelNomeUtente);
        panelNomeUtente.add(tfNomeUtente);

        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPassword.add(labelPasswordUtente);
        panelPassword.add(tfPasswordUtente);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelBottoni.add(btnLogin);
        panelBottoni.add(btnAnnulla);

        this.add(panelNomeUtente);
        this.add(panelPassword);
        this.add(panelBottoni);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void login() {
        String nomeUtente = tfNomeUtente.getText();
        String password = new String(tfPasswordUtente.getPassword());
        String passwordHashed = Cittadini.sha256(password);

        if (validaDati(nomeUtente, password)) {
            for(Cittadino i : Cittadini.getCittadini()){
                if(i.getUsername().equals(nomeUtente) && i.getPassword().equals(passwordHashed)){
                    System.out.println("Loggato " + i.getUsername());
                    //TODO: new UIUtenteLoggato(i);
                    this.dispose();
                }
            }

            JOptionPane.showMessageDialog(this, "Nome utente o password non corretti\n");
        }
    }

    boolean validaDati(String nomeUtente, String password){
        String messaggio = "";

        if(nomeUtente.equals("") || password.equals(""))
            messaggio += "Inserisci tutti i dati \n";

        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            login();
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}