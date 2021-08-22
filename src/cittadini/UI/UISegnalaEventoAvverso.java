package cittadini.UI;

import centrivaccinali.EventoAvverso;
import cittadini.Cittadini;
import cittadini.Cittadino;

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

public class UISegnalaEventoAvverso extends JFrame implements ActionListener {
    Cittadino utenteLoggato;
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));
    JTextField tfNomeEventoAvverso = new JTextField();
    JTextArea taNoteAggiuntive = new JTextArea(3, 20);
    JComboBox<String> cbSeverita = new JComboBox<String>(new String[]{"1", "2", "3", "4", "5"});

    JButton btnSegnala = new JButton("SEGNALA");
    JButton btnAnnulla = new JButton("ANNULLA");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UISegnalaEventoAvverso(Cittadino utenteLoggato){
        this.utenteLoggato = utenteLoggato;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 1));
        this.setLocationRelativeTo(null);
        this.setTitle("Segnala Evento Avverso");
        this.setResizable(false);
        this.setIconImage(img.getImage());

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

        btnAnnulla.setPreferredSize(new Dimension(200, 50));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);

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

    void segnalaEventoAvverso(){
        String nome = tfNomeEventoAvverso.getText();
        int severita = Integer.parseInt(Objects.requireNonNull(cbSeverita.getSelectedItem()).toString());
        String noteAggiuntive = taNoteAggiuntive.getText();

        if(validaDati(nome, noteAggiuntive)){
            Cittadini.registraEventoAvverso(utenteLoggato, new EventoAvverso(nome, severita, noteAggiuntive));
            UIManager.put("OptionPane.yesButtonText", "Si");
            int risposta = JOptionPane.showConfirmDialog(null, "Evento registrato, desidera segnalarne un altro?", "Evento registrato", JOptionPane.YES_NO_OPTION);
            if(risposta == JOptionPane.YES_OPTION)
                new UISegnalaEventoAvverso(utenteLoggato);
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSegnala){
            segnalaEventoAvverso();
        }else if(e.getSource() == btnAnnulla){
            this.dispose();
        }
    }
}
