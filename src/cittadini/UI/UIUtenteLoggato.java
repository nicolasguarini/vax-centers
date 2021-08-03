package cittadini.UI;

import cittadini.Cittadino;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UIUtenteLoggato extends JFrame implements ActionListener {
    Cittadino cittadinoLoggato;
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../resources/images/logo.png")));
    
    JButton btnVisualizzaCentri = new JButton("VISUALIZZA CENTRI");
    JButton btnSegnalaEventi = new JButton("SEGNALA EVENTI AVVERSI");
    JButton btnLogout = new JButton("LOGOUT");
    Border border = new LineBorder(new Color(251, 186, 0), 2, true);

    public UIUtenteLoggato(Cittadino cittadinoLoggato) {
        this.cittadinoLoggato = cittadinoLoggato;
        setupFrame();
    }

    private void setupFrame() {
        JLabel labelTitolo = new JLabel("Ciao, " + cittadinoLoggato.getNome());
        labelTitolo.setBounds(430, 165, 500, 100);
        labelTitolo.setFont(new Font("Montserrat", Font.BOLD, 40));
        labelTitolo.setHorizontalTextPosition(JLabel.CENTER);

        btnVisualizzaCentri.setBounds(315, labelTitolo.getY() + 100 + 50, 300, 65);
        btnVisualizzaCentri.setFocusable(false);
        btnVisualizzaCentri.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnVisualizzaCentri.setBackground(new Color(232, 47, 125));
        btnVisualizzaCentri.setForeground(Color.WHITE);
        btnVisualizzaCentri.setBorder(border);
        btnVisualizzaCentri.addActionListener(this);

        btnSegnalaEventi.setBounds(btnVisualizzaCentri.getX() + 325, btnVisualizzaCentri.getY(), 300, 65);
        btnSegnalaEventi.setFocusable(false);
        btnSegnalaEventi.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnSegnalaEventi.setBackground(new Color(232, 47, 125));
        btnSegnalaEventi.setForeground(Color.WHITE);
        btnSegnalaEventi.setBorder(border);
        btnSegnalaEventi.addActionListener(this);

        btnLogout.setBounds(550, btnVisualizzaCentri.getY() + 85, 150, 50);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnLogout.setBackground(new Color(232, 47, 125));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBorder(border);
        btnLogout.addActionListener(this);

        this.setTitle("Home - area personale");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        this.setResizable(false);

        this.add(labelTitolo);
        this.add(btnVisualizzaCentri);
        this.add(btnSegnalaEventi);
        this.add(btnLogout);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogout) {
            UIManager.put("OptionPane.yesButtonText", "Si");
            int risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di fare logout?", "Conferma", JOptionPane.YES_NO_OPTION);
            if (risposta == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else if (e.getSource() == btnVisualizzaCentri) {
            new UICercaCentriVaccinali();
        } else if (e.getSource() == btnSegnalaEventi) {
            new UISegnalaEventoAvverso(cittadinoLoggato);
        }
    }
}
