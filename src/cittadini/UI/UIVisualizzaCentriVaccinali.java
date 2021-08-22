package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Objects;

public class UIVisualizzaCentriVaccinali extends JFrame {
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/logo.png")));

    public UIVisualizzaCentriVaccinali(LinkedList<CentroVaccinale> centriDaVisualizzare){
        this.setIconImage(img.getImage());
        this.setTitle("Risultati ricerca");

        JButton bottoni[] = new JButton[centriDaVisualizzare.size()];
        JPanel p = new JPanel(new GridLayout(bottoni.length, 2, 10,10));
        JLabel labelCentroVaccinale;

        for(int i = 0; i<bottoni.length; i++){
            CentroVaccinale c = centriDaVisualizzare.get(i);
            labelCentroVaccinale = new JLabel(c.getNome() + ", " + c.getComune());
            labelCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));
            bottoni[i] = new JButton("Info");
            bottoni[i].addActionListener(e -> infoCentroVaccinale(c));

            p.add(labelCentroVaccinale);
            p.add(bottoni[i]);
        }

        JScrollPane scroll = new JScrollPane(p);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.getContentPane().add(scroll);
        this.setSize(500, 250);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void infoCentroVaccinale(CentroVaccinale centroVaccinale){
        String messaggio = "";
        messaggio += "Nome: " + centroVaccinale.getNome() + "\n";
        messaggio += "Indirizzo: " + centroVaccinale.getIndirizzo() + "\n";
        messaggio += "Tipologia: " + centroVaccinale.getTipologia() + "\n";
        messaggio += "Numero segnalazioni eventi avversi: " + CentriVaccinali.getNumSegnalazioniEventiAvversi(centroVaccinale) + "\n";
        messaggio += "Severita' media eventi avversi: " + CentriVaccinali.getSeveritaMediaEventiAvversi(centroVaccinale) + "\n";
        JOptionPane.showMessageDialog(this, messaggio);
    }

}
