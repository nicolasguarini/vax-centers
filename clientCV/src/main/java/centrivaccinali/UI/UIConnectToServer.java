package centrivaccinali.UI;

import centrivaccinali.CentriVaccinali;
import common.ServerInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class UIConnectToServer extends JFrame implements ActionListener {
    JTextField tfHost = new JTextField();
    JTextField tfPort = new JTextField();
    JButton btnConnect = new JButton("CONNECT");

    public UIConnectToServer(){
        Border border = new LineBorder(new Color(251, 186, 0), 2, true);
        Font fontSmall = new Font("Light", Font.PLAIN, 18);

        JLabel labelHost = new JLabel("Host (default: localhost)");
        labelHost.setFont(fontSmall);
        labelHost.setForeground(new Color(167, 164, 164));
        labelHost.setBounds(0, 0, 250, 30);
        tfHost.setPreferredSize(new Dimension(530, 30));
        tfHost.setBounds(250, 0, 530, 30);

        JLabel labelPort = new JLabel("Porta (default: 1099)");
        labelPort.setFont(fontSmall);
        labelPort.setForeground(new Color(167, 164, 164));
        labelPort.setBounds(0, 50, 250, 30);
        tfPort.setPreferredSize(new Dimension(530, 30));
        tfPort.setBounds(250, 50, 530, 30);

        btnConnect.setPreferredSize(new Dimension(150, 40));
        btnConnect.setFocusable(false);
        btnConnect.setFont(new Font("Montserrat", Font.BOLD, 15));
        btnConnect.setBackground(new Color(232, 47, 125));
        btnConnect.setForeground(Color.WHITE);
        btnConnect.setBorder(border);
        btnConnect.addActionListener(this);
        btnConnect.setBounds(300, 100, 170, 40);
        btnConnect.setOpaque(true);

        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        this.add(labelHost);
        this.add(labelPort);
        this.add(tfHost);
        this.add(tfPort);
        this.add(btnConnect);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String port = tfPort.getText();
        String host = tfHost.getText();

        if(port.equals("")) port = "1099";
        if(host.equals("")) host = "localhost";

        try {
            CentriVaccinali.registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));
            CentriVaccinali.server = (ServerInterface) CentriVaccinali.registry.lookup("ServerCV");

            this.dispose();
            new UIStartMenu();
        } catch (RemoteException | NotBoundException exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(this, "Impossibile connettersi al server remoto");
        }

    }
}
