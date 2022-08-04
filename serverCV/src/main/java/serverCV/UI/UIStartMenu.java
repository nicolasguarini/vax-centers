package serverCV.UI;

import serverCV.ConnectionResult;
import serverCV.DBManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIStartMenu extends JFrame implements ActionListener {
    JTextField tfHost = new JTextField();
    JTextField tfPort = new JTextField();
    JTextField tfUsername = new JTextField();
    JTextField tfPassword = new JPasswordField();
    JButton btnStartServer = new JButton("AVVIA SERVER");

    public UIStartMenu(){
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font fontSmall = new Font("Light", Font.PLAIN, 18);

        JLabel labelHost = new JLabel("Host (default: localhost)");
        labelHost.setFont(fontSmall);
        labelHost.setForeground(new Color(167, 164, 164));
        labelHost.setBounds(0, 0, 250, 50);

        tfHost.setPreferredSize(new Dimension(530, 30));
        tfHost.setBounds(250, 0, 530, 30);

        JLabel labelPort = new JLabel("Porta (default: 5432)");
        labelPort.setFont(fontSmall);
        labelPort.setForeground(new Color(167, 164, 164));
        labelPort.setBounds(0, 50, 250, 50);

        tfPort.setPreferredSize(new Dimension(530, 30));
        tfPort.setBounds(250, 50, 530, 30);

        JLabel labelUsername = new JLabel("Username (default: postgres)");
        labelUsername.setFont(fontSmall);
        labelUsername.setForeground(new Color(167, 164, 164));
        labelUsername.setBounds(0, 100, 250, 50);

        tfUsername.setPreferredSize(new Dimension(530, 30));
        tfUsername.setBounds(250, 100, 530, 30);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(fontSmall);
        labelPassword.setForeground(new Color(167, 164, 164));
        labelPassword.setBounds(0, 150, 250, 50);

        tfPassword.setPreferredSize(new Dimension(530, 30));
        tfPassword.setBounds(250, 150, 530, 30);

        btnStartServer.setPreferredSize(new Dimension(150, 40));
        btnStartServer.setFocusable(false);
        btnStartServer.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnStartServer.setBackground(new Color(232, 47, 125));
        btnStartServer.setForeground(Color.WHITE);
        btnStartServer.setBorder(border);
        btnStartServer.addActionListener(this);
        btnStartServer.setBounds(300, 200, 170, 40);
        btnStartServer.setOpaque(true);

        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        this.add(labelHost);
        this.add(labelUsername);
        this.add(labelPassword);
        this.add(labelPort);
        this.add(tfPort);
        this.add(tfHost);
        this.add(tfUsername);
        this.add(tfPassword);
        this.add(btnStartServer);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

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
