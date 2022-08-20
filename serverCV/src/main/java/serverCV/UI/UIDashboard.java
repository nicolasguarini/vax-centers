//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package serverCV.UI;

import serverCV.LogListener;
import serverCV.ServerCV;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Objects;

/**
 * La classe <code>UIDashboard</code> si occupa di creare e gestire l'interfaccia grafica della schermata principale dell'applicazione server,
 * da qui è possibile visualizzare e gestire lo stato del server e visualizzare i log delle richieste gestite da quest'ultimo.
 *
 * @see ServerCV
 * @see LogListener
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 */
public class UIDashboard extends JFrame implements LogListener, ActionListener {
    /**
     * Label che mostra all'utente lo stato corrente in cui si trova il server
     */
    JLabel labelStatus = new JLabel("Server is starting...");

    /**
     * TextArea che mostra, all'interno di uno ScrollPane, i log delle richieste che vengono gestite dal server
     */
    JTextArea logTextArea = new JTextArea();

    /**
     * ScrollPane per permettere all'utente visualizzare i log in modo pratico e compatto
     */
    JScrollPane scrollPane;

    /**
     * Button per riavviare il server
     */
    JButton btnRestartServer = new JButton("RESTART");

    /**
     * Button per terminare il server
     */
    JButton btnStopServer = new JButton("STOP");

    /**
     * Button per generare il dataset di test
     */
    JButton btnDataset = new JButton("GENERA DATASET DI TEST");

    /**
     * Inizializza, imposta e visualizza la schermata principale dell'applicazione server.
     *
     * @author Domenico Rizzo
     */
    public UIDashboard(){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        Font fontBig = new Font("Light", Font.PLAIN, 30);
        Font fontSmall = new Font("Monospaced", Font.PLAIN, 18);
        labelStatus.setFont(fontBig);
        labelStatus.setBounds(50, 25, 1000, 50);

        btnRestartServer.setPreferredSize(new Dimension(150, 40));
        btnRestartServer.setFocusable(false);
        btnRestartServer.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnRestartServer.setBackground(new Color(232, 47, 125));
        btnRestartServer.setForeground(Color.WHITE);
        btnRestartServer.setBorder(new LineBorder(new Color(251, 186, 0), 2, true));
        btnRestartServer.addActionListener(this);
        btnRestartServer.setBounds(50, 90, 170, 40);
        btnRestartServer.setOpaque(true);

        btnStopServer.setPreferredSize(new Dimension(150, 40));
        btnStopServer.setFocusable(false);
        btnStopServer.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnStopServer.setBackground(new Color(232, 47, 125));
        btnStopServer.setForeground(Color.WHITE);
        btnStopServer.setBorder(new LineBorder(new Color(251, 186, 0), 2, true));
        btnStopServer.addActionListener(this);
        btnStopServer.setBounds(250, 90, 170, 40);
        btnStopServer.setOpaque(true);

        btnDataset.setPreferredSize(new Dimension(260, 40));
        btnDataset.setFocusable(false);
        btnDataset.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnDataset.setBackground(new Color(232, 47, 125));
        btnDataset.setForeground(Color.WHITE);
        btnDataset.setBorder(new LineBorder(new Color(251, 186, 0), 2, true));
        btnDataset.addActionListener(this);
        btnDataset.setBounds(450, 90, 260, 40);
        btnDataset.setOpaque(true);

        logTextArea.setBounds(50, 150, 1000, 500);
        logTextArea.setEditable(false);
        logTextArea.setFont(fontSmall);
        scrollPane = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 150, 1000, 500);

        this.setTitle("Vax Centers -- Server dashboard");
        this.setIconImage(imgLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        this.add(scrollPane);
        this.add(labelStatus);
        this.add(btnRestartServer);
        this.add(btnStopServer);
        this.add(btnDataset);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if(ServerCV.startServer()){
            labelStatus.setText("Server is ready, listening on port " + ServerCV.PORT + "!");
            logTextArea.append(new Date() + " -- Server listening on port " + ServerCV.PORT + "\n");
            ServerCV.addListener(this);
        }else{
            labelStatus.setText("Error: unable to start the server");
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                ServerCV.stopServer();
            }
        });
    }

    /**
     * Implementazione dell'interfaccia {@link LogListener} che permette l'aggiornamento della JTextArea tramite il pattern Observer
     *
     * @param message il messaggio da aggiungere alla lista dei log
     * @author Nicolas Guarini
     */
    @Override
    public void updateLog(String message) {
        System.out.println(message);
        logTextArea.append(message + "\n");

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }

    /**
     * Gestore dei click sui pulsanti della schermata. Nello specifico gestire le operazioni di riavvio e stop del server
     *
     * @param e l'evento da gestire
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRestartServer){
            updateLog(new Date() + " -- Restarting the server");
            if(ServerCV.stopServer() && ServerCV.startServer()){
                updateLog(new Date() + " -- Server restarted, now listening on port " + ServerCV.PORT);
                labelStatus.setText("Server is ready, listening on port " + ServerCV.PORT + "!");
            }else{
                updateLog(new Date() + " -- Error: unable to restart the server.");
                labelStatus.setText("Unable to restart the server.");
            }
        }else if(e.getSource() == btnStopServer){
            updateLog(new Date() + " -- Stopping the server");
            if(ServerCV.stopServer()){
                updateLog(new Date() + " -- Server stopped");
                labelStatus.setText("Server stopped.");
            }else{
                updateLog(new Date() + " -- Error: unable to stop the server.");
                labelStatus.setText("Unable to stop the server.");
            }
        }
    }
}
