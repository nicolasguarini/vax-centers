//NICOLAS GUARINI 745508 VA
//FILIPPO ALZATI 745495 VA
//REDON KOKAJ 744959 VA
//DOMENICO RIZZO 745304 VA

package cittadini.UI;

import centrivaccinali.CentriVaccinali;
import common.CentroVaccinale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;

/**
 * La classe <code>UICercaCentriVaccinali</code> si occupa di creare e gestire l'interfaccia utente della schermata per cercare i centri vaccinali
 *
 * @see centrivaccinali.UI.UICentriVaccinali
 *
 * @author Nicolas Guarini
 * @author Domenico Rizzo
 * @author Redon Kokaj
 * @author Filippo Alzati
 */
public class UICercaCentriVaccinali extends JFrame implements ActionListener {
    /**
     * Bottone per cercare per nome
     */
    JButton btnCercaPerNome = new JButton();

    /**
     * Bottone per cercare per comune e tipologia
     */
    JButton btnCercaPerComuneETipologia = new JButton();

    /**
     * Bottone per visualizzare tutti i centri vaccinali
     */
    JButton btnVisualizzaTutti = new JButton("VISUALIZZA TUTTI");

    /**
     * Bottone per annullare la ricerca
     */
    JButton btnAnnulla = new JButton("ANNULLA");

    /**
     * TextField dove l'utente inserir� il nome del centro vaccinale da ricercare
     */
    JTextField tfCercaPerNome = new JTextField();

    /**
     * TextField dove l'utente inserir� il comune del centro vaccinale da ricercare
     */
    JTextField tfCercaPerComune = new JTextField();

    /**
     * Select dove l'utente selezioner� la tipologia del centro vaccinale da ricercare
     */
    JComboBox<String> cbTipologie = new JComboBox<>(new String[]{"Ospedaliero", "Aziendale", "Hub"});

    /**
     * Inizializza, imposta e visualizza la schermata adibita alla ricerca dei centri vaccinali
     *
     * @author Domenico Rizzo
     */
    public UICercaCentriVaccinali(){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        ImageIcon imgCerca = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/cerca.png")));
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font font1 = new Font("Light", Font.PLAIN, 18);
        Font font2 = new Font("Light", Font.PLAIN, 30);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(460, 390);
        this.setTitle("Cerca centro vaccinale");
        this.setResizable(false);
        this.setIconImage(imgLogo.getImage());

        JLabel labelCercaCentro = new JLabel("Cerca centro vaccinale");
        labelCercaCentro.setFont(font2);
        labelCercaCentro.setForeground(new Color(0, 0, 0));
        labelCercaCentro.setBounds(40, 25, 500, 50);

        JLabel labelCercaNome = new JLabel("Cerca per nome");
        labelCercaNome.setFont(font1);
        labelCercaNome.setForeground(new Color(167, 164, 164));
        labelCercaNome.setBounds(40, 80, 150, 50);
        
        JLabel labelCercaComuneTipologia = new JLabel("Cerca per comune e tipologia");
        labelCercaComuneTipologia.setFont(font1);
        labelCercaComuneTipologia.setForeground(new Color(167, 164, 164));
        labelCercaComuneTipologia.setBounds(40, 160, 300, 50);
        
        tfCercaPerNome.setPreferredSize(new Dimension(220, 30));
        tfCercaPerNome.setFont(font1);
        tfCercaPerNome.setBounds(40, 118, 315, 30);

        tfCercaPerComune.setPreferredSize(new Dimension(220, 30));
        tfCercaPerComune.setFont(font1);
        tfCercaPerComune.setBounds(40, 198, 185, 30);

        cbTipologie.setPreferredSize(new Dimension(220, 30));
        cbTipologie.setFont(font1);
        cbTipologie.setBounds(230, 198, 125, 30);

        btnCercaPerNome.setPreferredSize(new Dimension(50, 30));
        btnCercaPerNome.setIcon(imgCerca);
        btnCercaPerNome.setBounds(360, 118, 50, 30);
        btnCercaPerNome.addActionListener(this);
        btnCercaPerNome.setFocusable(false);
        btnCercaPerNome.setBackground(new Color(232, 47, 125));
        btnCercaPerNome.setBorder(border);
        btnCercaPerNome.setOpaque(true);

        btnCercaPerComuneETipologia.setPreferredSize(new Dimension(50, 30));
        btnCercaPerComuneETipologia.setIcon(imgCerca);
        btnCercaPerComuneETipologia.setBounds(360, 198, 50, 30);
        btnCercaPerComuneETipologia.addActionListener(this);
        btnCercaPerComuneETipologia.setFocusable(false);
        btnCercaPerComuneETipologia.setBackground(new Color(232, 47, 125));
        btnCercaPerComuneETipologia.setBorder(border);
        btnCercaPerNome.setOpaque(true);

        btnVisualizzaTutti.setPreferredSize(new Dimension(150, 40));
        btnVisualizzaTutti.setFocusable(false);
        btnVisualizzaTutti.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnVisualizzaTutti.setBackground(new Color(232, 47, 125));
        btnVisualizzaTutti.setForeground(Color.WHITE);
        btnVisualizzaTutti.setBorder(border);
        btnVisualizzaTutti.addActionListener(this);
        btnVisualizzaTutti.setBounds(53, 278, 170, 40);
        btnVisualizzaTutti.setOpaque(true);
        
        btnAnnulla.setPreferredSize(new Dimension(150, 40));
        btnAnnulla.setFocusable(false);
        btnAnnulla.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnAnnulla.setBackground(new Color(232, 47, 125));
        btnAnnulla.setForeground(Color.WHITE);
        btnAnnulla.setBorder(border);
        btnAnnulla.addActionListener(this);
        btnAnnulla.setBounds(228, 278, 170, 40);
        btnAnnulla.setOpaque(true);

        JLabel labelSfondo = new JLabel();
		labelSfondo.setBounds(0, 0, 450, 350);
        labelSfondo.add(labelCercaCentro);
        labelSfondo.add(labelCercaNome);
        labelSfondo.add(labelCercaComuneTipologia);
        labelSfondo.add(tfCercaPerNome);
        labelSfondo.add(tfCercaPerComune);
        labelSfondo.add(cbTipologie);
        labelSfondo.add(btnCercaPerNome);
        labelSfondo.add(btnCercaPerComuneETipologia);
        labelSfondo.add(btnVisualizzaTutti);
        labelSfondo.add(btnAnnulla);
        
        this.add(labelSfondo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Cerca i centri vaccinali per nome. (verranno visualizzati i centri vaccinali il cui nome contiene quello passato per parametro)
     *
     * @see UIVisualizzaCentriVaccinali
     *
     * @param nome: nome del centro vaccinale da ricercare
     *
     * @author Nicolas Guarini
     */
    public void cercaCentriVaccinali(String nome){
        LinkedList<CentroVaccinale> centriDaVisualizzare = new LinkedList<>();

        for(CentroVaccinale i : CentriVaccinali.getCentriVaccinali())
            if(i.getNome().toLowerCase().contains(nome.toLowerCase()))
                centriDaVisualizzare.add(i);

        if(!centriDaVisualizzare.isEmpty()){
            new UIVisualizzaCentriVaccinali(centriDaVisualizzare);
            this.dispose();
        }else
            JOptionPane.showMessageDialog(this, "La ricerca non ha prodotto risultati");
    }

    /**
     * Cerca i centri vaccinali per comune e tipologia
     *
     * @see UIVisualizzaCentriVaccinali
     *
     * @param comune: comune del centro vaccinale da ricercare
     * @param tipologia: tipologia del centro vaccinale da ricercare (ospedaliero / hub / aziendale)
     */
    public void cercaCentriVaccinali(String comune, String tipologia){
        LinkedList<CentroVaccinale> centriDaVisualizzare = new LinkedList<>();
        for(CentroVaccinale i : CentriVaccinali.getCentriVaccinali())
            if(i.getComune().toLowerCase().contains(comune) && i.getTipologia().equals(tipologia))
                centriDaVisualizzare.add(i);

        if(!centriDaVisualizzare.isEmpty()){
            new UIVisualizzaCentriVaccinali(centriDaVisualizzare);
            this.dispose();
        }else
            JOptionPane.showMessageDialog(this, "La ricerca non ha prodotto risultati");
    }

    /**
     * Gestore dei click dei pulsanti
     *
     * @param e: evento che deve essere processato
     *
     * @author Nicolas Guarini
     * @author Domenico Rizzo
     * @author Redon Kokaj
     * @author Filippo Alzati
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVisualizzaTutti){
            new UIVisualizzaCentriVaccinali(CentriVaccinali.getCentriVaccinali());
            this.dispose();
        }else if(e.getSource() == btnCercaPerNome){
            String nome = tfCercaPerNome.getText();
            if(!nome.equals("")){
                cercaCentriVaccinali(nome);
            }else{
                JOptionPane.showMessageDialog(this, "Inserisci il nome da ricercare");
            }
        }else if(e.getSource() == btnCercaPerComuneETipologia){
            String comune = tfCercaPerComune.getText();
            String tipologia = cbTipologie.getSelectedItem().toString();
            if(!comune.equals("")){
                cercaCentriVaccinali(comune.toLowerCase(), tipologia);
            }else{
                JOptionPane.showMessageDialog(this, "Inserisci il comune");
            }
        }else if(e.getSource() == btnAnnulla){
            this.dispose();
        }
    }
}
