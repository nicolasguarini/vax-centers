package serverCV.UI;

import serverCV.LogListener;
import serverCV.ServerCV;

import javax.swing.*;
import java.awt.*;

public class UIDashboard extends JFrame implements LogListener {
    JLabel labelStatus = new JLabel("Server is starting...");
    JTextArea logTextArea = new JTextArea();

    public UIDashboard(){
        Font fontBig = new Font("Light", Font.PLAIN, 30);
        Font fontSmall = new Font("Light", Font.PLAIN, 18);
        labelStatus.setFont(fontBig);
        labelStatus.setBounds(50, 25, 1000, 50);

        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        logTextArea.setBounds(50, 100, 1000, 500);
        logTextArea.setEditable(false);
        logTextArea.setFont(fontSmall);
        this.add(logTextArea);
        this.add(labelStatus);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if(ServerCV.startServer()){
            labelStatus.setText("Server is ready, listening on port " + ServerCV.PORT + "!");
            logTextArea.append("Server listening on port " + ServerCV.PORT + "\n");
            ServerCV.addListener(this);
        }else{
            labelStatus.setText("Error: unable to start the server");
        }
    }

    @Override
    public void updateLog(String message) {
        System.out.println(message);
        logTextArea.append(message + "\n");
    }
}
