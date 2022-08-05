//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import common.CentroVaccinale;

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

/**
 * Si occupa di gestire la schermata di visualizzazione dei centri vaccinali
 *
 * @see centrivaccinali.UI.UICentriVaccinali
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzzati
 * */
public class UIVisualizzaCentriVaccinali extends JFrame {
    /**
     * Inizializza, imposta e visualizza la schermata di visualizzazione dei centri vaccinali
     *
     * @param centriDaVisualizzare lista dei centri vaccinali da visualizzare
     *
     * @author Domenico Rizzo
     */
    public UIVisualizzaCentriVaccinali(LinkedList<CentroVaccinale> centriDaVisualizzare){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));

        this.setIconImage(imgLogo.getImage());
        this.setTitle("Risultati ricerca");

        JButton[] bottoni = new JButton[centriDaVisualizzare.size()];
        JPanel p = new JPanel(new GridLayout(bottoni.length, 2, 10,10));
        JLabel labelCentroVaccinale;

        for(int i = 0; i<bottoni.length; i++){
            CentroVaccinale c = centriDaVisualizzare.get(i);
            labelCentroVaccinale = new JLabel(c.getNome() + ", " + c.getComune());
            labelCentroVaccinale.setFont(new Font("Helvetica", Font.PLAIN, 15));
            bottoni[i] = new JButton("Info");
            bottoni[i].addActionListener(e -> infoCentroVaccinale(c));
            bottoni[i].setOpaque(true);

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

    /**
     * Mostra un popup con le informazioni rilevanti del centro vaccinale desiderato, come nome, indirizzo, tipologia, numero eventi avversi e severit� media degli stessi
     *
     * @see UISegnalaEventoAvverso
     *
     * @param centroVaccinale centro vaccinale di cui si desidera visualizzare le informazioni
     *
     * @author Nicolas Guarini
     */
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
