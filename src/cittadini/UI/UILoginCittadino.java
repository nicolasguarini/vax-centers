package cittadini.UI;

import cittadini.Cittadini;
import cittadini.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UILoginCittadino extends JFrame implements ActionListener {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));
    JTextField tfNomeUtente = new JTextField();
    JPasswordField tfPasswordUtente = new JPasswordField();
    JButton btnLogin = new JButton("LOGIN");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);
    Font font1 = new Font("Light", Font.PLAIN, 18);
    Font font2 = new Font("Light", Font.PLAIN, 30);

    public UILoginCittadino() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(470, 430);
        this.setTitle("Login cittadino");
        this.setResizable(false);
        this.setIconImage(img.getImage());

        JLabel labelLoginCittadino = new JLabel("Login cittadino");
        labelLoginCittadino.setFont(font2);
        labelLoginCittadino.setForeground(new Color(0, 0, 0));
        labelLoginCittadino.setBounds(50, 28, 500, 50);

        JLabel labelNomeUtente = new JLabel("Nome utente");
        labelNomeUtente.setFont(font1);
        labelNomeUtente.setForeground(new Color(167, 164, 164));
        labelNomeUtente.setBounds(50, 90, 150, 50);
        
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(font1);
        labelPassword.setForeground(new Color(167, 164, 164));
        labelPassword.setBounds(50, 190, 150, 50);
        
        tfNomeUtente.setPreferredSize(new Dimension(220, 30));
        tfNomeUtente.setFont(font1);
        tfNomeUtente.setBounds(50, 136, 350, 30);

        tfPasswordUtente.setPreferredSize(new Dimension(220, 30));
        tfPasswordUtente.setFont(font1);
        tfPasswordUtente.setBounds(50, 236, 350, 30);

        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setFocusable(false);
        btnLogin.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogin.setBackground(new Color(232, 47, 125));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(border);
        btnLogin.addActionListener(this);
        btnLogin.setBounds(50, 316, 170, 40);
        
        btnAnnulla.setPreferredSize(new Dimension(150, 40));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);
        btnAnnulla.setBounds(230, 316, 170, 40);

        JLabel labelSfondo = new JLabel();
		labelSfondo.setBounds(0, 0, 470, 450);
        labelSfondo.add(labelLoginCittadino);
        labelSfondo.add(labelNomeUtente);
        labelSfondo.add(labelPassword);
        labelSfondo.add(tfNomeUtente);
        labelSfondo.add(tfPasswordUtente);
        labelSfondo.add(btnLogin);
        labelSfondo.add(btnAnnulla);
        
        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void login() {
        String nomeUtente = tfNomeUtente.getText();
        String password = new String(tfPasswordUtente.getPassword());
        String passwordHashed = Cittadini.sha256(password);
        boolean loggato = false;

        if (validaDati(nomeUtente, password)) {
            for(Cittadino i : Cittadini.getCittadini()){
                if(i.getUsername().equalsIgnoreCase(nomeUtente) && i.getPassword().equals(passwordHashed)){
                    loggato = true;
                    new UIUtenteLoggato(i);
                    this.dispose();
                }
            }

            if(!loggato)
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