//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import cittadini.Cittadini;
import common.Cittadino;

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

/**
 * Si occupa di creare e gestire l'interfaccia grafica e parte della logica dietro al login di un cittadino
 *
 * @see UICittadini
 * @see Cittadini
 * @see Cittadino
 *
 * @author Domenico Rizzo
 * @author Nicolas Guarini
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class UILoginCittadino extends JFrame implements ActionListener {
    /**
     * TextField dove l'utente inserir� l'username con il quale vuole effettuare il login
     */
    JTextField tfNomeUtente = new JTextField();

    /**
     * TextField dove l'utente inserir� la password con la quale vuole effettuare il login
     */
    JPasswordField tfPasswordUtente = new JPasswordField();

    /**
     * Bottone per effettuare il login
     */
    JButton btnLogin = new JButton("LOGIN");

    /**
     * Bottone per annullare il login
     */
    JButton btnAnnulla = new JButton("ANNULLA");

    /**
     * Inizializza, imposta e visualizza la schermata di login cittadino
     *
     * @author Domenico Rizzo
     */
    public UILoginCittadino() {
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 18);
        Font font2 = new Font("Light", Font.PLAIN, 30);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(470, 430);
        this.setTitle("Login cittadino");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

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
        btnLogin.setOpaque(true);
        
        btnAnnulla.setPreferredSize(new Dimension(150, 40));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);
        btnAnnulla.setBounds(230, 316, 170, 40);
        btnAnnulla.setOpaque(true);

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

    /**
     * Confronta username e password inseriti con quelli presenti nei file di salvataggio, e quando trova un'occorrenza apre la schermata dell'area personale del cittadino
     *
     * @author Nicolas Guarini
     * @author Redon Kokaj
     */
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

    /**
     * Effettua la validazione dei dati mosrando un messaggio di errore con i relativi dettagli nel caso in cui dei dati non fossero validi
     *
     * @author Redon Kokaj
     *
     * @param nomeUtente: username inserito dall'utente
     * @param password: password inserita dall'utente
     * @return <code>true</code>> se tutti i dati sono validi; <code>false</code> se c'� almeno un dato non valido
     */
    boolean validaDati(String nomeUtente, String password){
        String messaggio = "";

        if(nomeUtente.equals("") || password.equals(""))
            messaggio += "Inserisci tutti i dati \n";

        if(!messaggio.equals("")){
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else return true;
    }

    /**
     * Gestore dei click sui pulsanti della schermata
     *
     * @param e: evento che deve essere processato
     *
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            login();
        } else if (e.getSource() == btnAnnulla) {
            this.dispose();
        }
    }
}