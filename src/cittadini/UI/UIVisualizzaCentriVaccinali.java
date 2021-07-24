package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.CentroVaccinale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class UIVisualizzaCentriVaccinali extends JFrame {
    public UIVisualizzaCentriVaccinali(LinkedList<CentroVaccinale> centriVaccinali){
        JPanel p = new JPanel();

        JButton bottoni[] = new JButton[centriVaccinali.size()];
        JLabel labelCentroVaccinale;

        p.setLayout(new GridLayout(bottoni.length, 2, 10,10));

        for(int i = 0; i<bottoni.length; i++){
            CentroVaccinale c = CentriVaccinali.getCentriVaccinali().get(i);
            labelCentroVaccinale = new JLabel(c.getNome() + ", " + c.getComune());
            labelCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));
            bottoni[i] = new JButton("Info");
            bottoni[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoCentroVaccinale(c);
                }
            });

            p.add(labelCentroVaccinale);
            p.add(bottoni[i]);
        }

        JScrollPane scroll = new JScrollPane(p);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.getContentPane().add(scroll);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    void infoCentroVaccinale(CentroVaccinale centroVaccinale){
        String messaggio = "";
        messaggio += "Nome: " + centroVaccinale.getNome() + "\n";
        messaggio += "Indirizzo: " + centroVaccinale.getIndirizzo() + "\n";
        messaggio += "Tipologia: " + centroVaccinale.getTipologia() + "\n";
        messaggio += "Numero segnalazioni eventi avversi: " + CentriVaccinali.getNumSegnalazioniEventiAvversi(centroVaccinale) + "\n";
        messaggio += "Severità media eventi avversi: " + CentriVaccinali.getSeveritaMediaEventiAvversi(centroVaccinale) + "\n";
        JOptionPane.showMessageDialog(this, messaggio);
    }

}
