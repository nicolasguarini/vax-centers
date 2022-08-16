package serverCV.UI;

import serverCV.LogListener;
import serverCV.ServerCV;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Objects;

public class UIDashboard extends JFrame implements LogListener {
    JLabel labelStatus = new JLabel("Server is starting...");
    JTextArea logTextArea = new JTextArea();
    JScrollPane scrollPane;

    public UIDashboard(){
        ImageIcon imgLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/logo.png")));
        Font fontBig = new Font("Light", Font.PLAIN, 30);
        Font fontSmall = new Font("Monospaced", Font.PLAIN, 18);
        labelStatus.setFont(fontBig);
        labelStatus.setBounds(50, 25, 1000, 50);

        this.setTitle("Vax Centers -- Server dashboard");
        this.setIconImage(imgLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        logTextArea.setBounds(50, 100, 1000, 500);
        logTextArea.setEditable(false);
        logTextArea.setFont(fontSmall);
        scrollPane = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 100, 1000, 500);
        this.add(scrollPane);
        this.add(labelStatus);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if(ServerCV.startServer()){
            labelStatus.setText("Server is ready, listening on port " + ServerCV.PORT + "!");
            logTextArea.append(new Date() + " -- Server listening on port " + ServerCV.PORT + "\n");
            ServerCV.addListener(this);
        }else{
            labelStatus.setText("Error: unable to start the server");
        }
    }

    @Override
    public void updateLog(String message) {
        System.out.println(message);
        logTextArea.append(message + "\n");

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
}
