//NICOLAS GUARINI 745508 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import common.EventoAvverso;
import cittadini.Cittadini;
import common.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Si occupa di creare e gestire la schermata di segnalazione evento avverso
 *
 * @see UILoginCittadino
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Filippo Alzati
 * @author Redon Kokaj
 */
public class UISegnalaEventoAvverso extends JFrame implements ActionListener {
    /**
     * Utente loggato che deve segnalare l'evento avverso
     */
    Cittadino utenteLoggato;

    /**
     * TextField dove l'utente inserirà il nome dell'evento avverso
     */
    JTextField tfNomeEventoAvverso = new JTextField();

    /**
     * TextField dove l'utente inserirà le note aggiuntive riguardo l'evento avverso
     */
    JTextArea taNoteAggiuntive = new JTextArea(3, 20);

    /**
     * Select dove l'utente selezionerà la severità dell'evento avverso
     */
    JComboBox<String> cbSeverita = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});

    /**
     * Bottone per inviare la segnalazione dell'evento avverso
     */
    JButton btnSegnala = new JButton("SEGNALA");

    /**
     * Bottone per annullare la segnalazione dell'evento avverso
     */
    JButton btnAnnulla = new JButton("ANNULLA");

    /**
     * Inizializza, imposta e gestisce l'interfaccia grafica della schermata per segnalare un evento avverso
     *
     * @param utenteLoggato utente che deve segnalare gli eventi avversi
     *
     * @author Domenico Rizzo
     */
    public UISegnalaEventoAvverso(Cittadino utenteLoggato){
        this.utenteLoggato = utenteLoggato;

        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1));
        this.setLocationRelativeTo(null);
        this.setTitle("Segnala Evento Avverso");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

        JLabel labelNomeEventoAvverso = new JLabel("Nome Evento Avverso:");
        labelNomeEventoAvverso.setFont(new Font("Helvetica", Font.BOLD, 15));
        tfNomeEventoAvverso.setPreferredSize(new Dimension(150, 30));
        tfNomeEventoAvverso.setFont(new Font("Helvetica", Font.PLAIN, 15));

        JLabel labelSeverita = new JLabel("Severita': ");
        labelSeverita.setFont(new Font("Helvetica", Font.BOLD, 15));
        cbSeverita.setPreferredSize(new Dimension(50, 30));
        cbSeverita.setFont(new Font("Helvetica", Font.PLAIN, 15));

        JLabel labelNoteAggiuntive = new JLabel("Note aggiuntive: ");
        labelNoteAggiuntive.setFont(new Font("Helvetica", Font.BOLD, 15));
        taNoteAggiuntive.setLineWrap(true);
        taNoteAggiuntive.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(taNoteAggiuntive);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnSegnala.setPreferredSize(new Dimension(200, 50));
        btnSegnala.setFocusable(false);
        btnSegnala.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnSegnala.setBackground(new Color(232, 47, 125));
        btnSegnala.setForeground(Color.WHITE);
        btnSegnala.setBorder(border);
        btnSegnala.addActionListener(this);
        btnSegnala.setOpaque(true);

        btnAnnulla.setPreferredSize(new Dimension(200, 50));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);
        btnAnnulla.setOpaque(true);

        JPanel panelNomeEventoAvverso = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNomeEventoAvverso.add(labelNomeEventoAvverso);
        panelNomeEventoAvverso.add(tfNomeEventoAvverso);

        JPanel panelSeverita = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSeverita.add(labelSeverita);
        panelSeverita.add(cbSeverita);

        JPanel panelNoteAggiuntive = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNoteAggiuntive.add(labelNoteAggiuntive);
        panelNoteAggiuntive.add(scrollPane);

        JPanel panelBottoni = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBottoni.add(btnSegnala);
        panelBottoni.add(btnAnnulla);

        this.add(panelNomeEventoAvverso);
        this.add(panelSeverita);
        this.add(panelNoteAggiuntive);
        this.add(panelBottoni);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Valida i dati inseriti dall'utente, mostrando un messaggio di errore nel caso non siano validi
     *
     * @param nomeEventoAvverso nome dell'evento avverso da segnalare
     * @param noteAggiuntive note aggiuntive sull'evento avverso da segnalare
     *
     * @return <code>true</code> se tutti i dati sono validi; <code>false</code> se c'è almeno un dato non valido
     *
     * @author Nicolas Guarini
     */
    boolean validaDati(String nomeEventoAvverso, String noteAggiuntive){
        String messaggio = "";

        if(nomeEventoAvverso.equals("")) messaggio += "Inserisci il nome dell'evento avverso";
        if(noteAggiuntive.length() > 250) messaggio += "Le note aggiuntive non possono superare i 250 caratteri";

        if(!messaggio.equals("")) {
            JOptionPane.showMessageDialog(this, messaggio);
            return false;
        }else
            return true;
    }

    /**
     * Preleva di dati dalle caselle di testo e se sono validi li registra.
     *
     * @author Nicolas Guarini
     */
    void segnalaEventoAvverso(){
        String nome = tfNomeEventoAvverso.getText();
        int severita = Integer.parseInt(Objects.requireNonNull(cbSeverita.getSelectedItem()).toString());
        String noteAggiuntive = taNoteAggiuntive.getText();

        if(validaDati(nome, noteAggiuntive)){
            boolean result = Cittadini.registraEventoAvverso(utenteLoggato, new EventoAvverso(nome, severita, noteAggiuntive));
            if(result){
                UIManager.put("OptionPane.yesButtonText", "Si");
                int risposta = JOptionPane.showConfirmDialog(null, "Evento registrato, desidera segnalarne un altro?", "Evento registrato", JOptionPane.YES_NO_OPTION);
                if(risposta == JOptionPane.YES_OPTION)
                    new UISegnalaEventoAvverso(utenteLoggato);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Errore durante la registrazione dell'evento avverso");
            }
        }
    }

    /**
     * Gestore dei click sui pulsanti della schermata
     *
     * @param e evento che deve essere gestito
     *
     * @author Nicolas Guarini
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSegnala){
            segnalaEventoAvverso();
        }else if(e.getSource() == btnAnnulla){
            this.dispose();
        }
    }
}
