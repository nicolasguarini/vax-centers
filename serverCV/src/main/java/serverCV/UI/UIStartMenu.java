//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package serverCV.UI;

import serverCV.ConnectionResult;
import serverCV.DBManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * La classe <code>UIStartMenu</code> si occupa di creare e gestire l'interfaccia grafica della schermata iniziale dell'applicazione server,
 * che permette il collegamento con il database e l'instaurazione della connessione del server.
 *
 * @see serverCV.ServerCV
 * @see serverCV.ServerImpl
 * @see DBManager
 * @see ConnectionResult
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 */
public class UIStartMenu extends JFrame implements ActionListener {
    /**
     * TextField dove l'utente potrà inserire l'indirizzo del server Postgres (default: localhost)
     */
    JTextField tfHost = new JTextField();

    /**
     * TextField dove l'utente potrà inserire la porta del server Postgres (default: 5432)
     */
    JTextField tfPort = new JTextField();

    /**
     * TextField dove l'utente potrà inserire l'username per accedere al server Postgres (default: postgres)
     */
    JTextField tfUsername = new JTextField();

    /**
     * TextField dove l'utente potrà inserire la password per accedere al server Postgres
     */
    JTextField tfPassword = new JPasswordField();

    /**
     * Button per avviare la procedura di connessione al server Postgres
     */
    JButton btnStartServer = new JButton("AVVIA SERVER");

    /**
     * Inizializza, imposta e visualizza la schermata iniziale dell'applicazione server.
     *
     * @author Domenico Rizzo
     */
    public UIStartMenu(){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgHome = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/serverhome.jpg")));
        ImageIcon imgHostph = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/hosticon.png")));
        ImageIcon imgPortph = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/porticon.png")));
        ImageIcon imgUsernameph = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/usericon.png")));
        ImageIcon imgPasswordph = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/passwordicon.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font fontSmall = new Font("Light", Font.PLAIN, 16);

        JLabel labelHost = new JLabel("Host (default: localhost)");
        labelHost.setFont(fontSmall);
        labelHost.setForeground(new Color(0, 0, 0));
        labelHost.setBounds(315, 268, 250, 50);

        tfHost.setPreferredSize(new Dimension(530, 30));
        tfHost.setBounds(290, 305, 335, 30);

        JLabel labelHostph = new JLabel();
        labelHostph.setIcon(imgHostph);
        labelHostph.setBounds(292, 285, 16, 16);

        JLabel labelPort = new JLabel("Porta (default: 5432)");
        labelPort.setFont(fontSmall);
        labelPort.setForeground(new Color(0, 0, 0));
        labelPort.setBounds(675, 268, 250, 50);

        tfPort.setPreferredSize(new Dimension(530, 30));
        tfPort.setBounds(655, 305, 335, 30);

        JLabel labelPortph = new JLabel();
        labelPortph.setIcon(imgPortph);
        labelPortph.setBounds(657, 285, 16, 16);

        JLabel labelUsername = new JLabel("Username (default: postgres)");
        labelUsername.setFont(fontSmall);
        labelUsername.setForeground(new Color(0, 0, 0));
        labelUsername.setBounds(315, 367, 250, 50);

        tfUsername.setPreferredSize(new Dimension(530, 30));
        tfUsername.setBounds(290, 405, 335, 30);

        JLabel labelUsernameph = new JLabel();
        labelUsernameph.setIcon(imgUsernameph);
        labelUsernameph.setBounds(292, 385, 16, 16);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(fontSmall);
        labelPassword.setForeground(new Color(0, 0, 0));
        labelPassword.setBounds(675, 367, 250, 50);

        tfPassword.setPreferredSize(new Dimension(530, 30));
        tfPassword.setBounds(655, 405, 335, 30);

        JLabel labelPasswordph = new JLabel();
        labelPasswordph.setIcon(imgPasswordph);
        labelPasswordph.setBounds(657, 385, 16, 16);

        btnStartServer.setPreferredSize(new Dimension(150, 40));
        btnStartServer.setFocusable(false);
        btnStartServer.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnStartServer.setBackground(new Color(232, 47, 125));
        btnStartServer.setForeground(Color.WHITE);
        btnStartServer.setBorder(border);
        btnStartServer.addActionListener(this);
        btnStartServer.setBounds(545, 490, 170, 40);
        btnStartServer.setOpaque(true);

        JLabel labelTesto = new JLabel();
        labelTesto.setText("Benvenuto");
        labelTesto.setFont(new Font("Montserrat", Font.BOLD, 24));
        labelTesto.setBounds(575, 140, 300, 100);

        JLabel labelDescrizione = new JLabel();
        labelDescrizione.setText("Per avviare il server si prega di compilare tutti i campi");
        labelDescrizione.setFont(new Font("Montserrat", Font.BOLD, 18));
        labelDescrizione.setBounds(410, 190, 500, 100);

        JLabel labelSfondo = new JLabel();
        labelSfondo.setIcon(imgHome);
        labelSfondo.setBounds(0, 0, 1280, 720);
        labelSfondo.add(labelTesto);
        labelSfondo.add(labelDescrizione);
        labelSfondo.add(labelHost);
        labelSfondo.add(labelHostph);
        labelSfondo.add(labelPort);
        labelSfondo.add(labelPortph);
        labelSfondo.add(labelUsername);
        labelSfondo.add(labelUsernameph);
        labelSfondo.add(labelPassword);
        labelSfondo.add(labelPasswordph);
        labelSfondo.add(tfHost);
        labelSfondo.add(tfPort);
        labelSfondo.add(tfUsername);
        labelSfondo.add(tfPassword);
        labelSfondo.add(btnStartServer);

        JPanel panelSfondo = new JPanel();
        panelSfondo.setBounds(0, 0, 1280, 720);
        panelSfondo.setLayout(null);
        panelSfondo.add(labelSfondo);

        this.setTitle("Vax Centers");
        this.setIconImage(imgLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panelSfondo);
    }

    /**
     * Gestore dei click sul pulsante della schermata. Nello specifico analizza le informazioni inserite dall'utente e avvia la procedura di connessione al server Postgres
     * @param e l'evento da gestire
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String host = tfHost.getText();
        String port = tfPort.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        if(host.equals("")) host = "localhost";
        if(port.equals("")) port = "5432";
        if(username.equals("")) username = "postgres";
        if(password.equals("")){
            JOptionPane.showMessageDialog(this, "Inserisci la password!");
            return;
        }

        DBManager db = DBManager.getInstance();
        ConnectionResult result = db.connect(host, port, username, password);

        switch (result){
            case OK:
                this.dispose();
                new UIDashboard();
                break;
            case DB_CREATED:
                JOptionPane.showMessageDialog(this, "Il database e' stato creato con successo!");
                this.dispose();
                new UIDashboard();
                break;
            case FAILED:
                JOptionPane.showMessageDialog(this, "Errore: impossibile connettersi al database. \nControlla che le credenziali siano corrette oppure contatta l'amministratore di sistema!");
        }
    }
}
