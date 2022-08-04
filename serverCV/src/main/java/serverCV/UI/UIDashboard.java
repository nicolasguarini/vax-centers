package serverCV.UI;

import serverCV.ServerCV;

import javax.swing.*;
import java.awt.*;

public class UIDashboard extends JFrame {
    JLabel labelStatus = new JLabel("Server is starting...");

    public UIDashboard(){
        Font fontBig = new Font("Light", Font.PLAIN, 30);
        labelStatus.setFont(fontBig);
        labelStatus.setBounds(50, 25, 1000, 50);

        this.setTitle("Vax Centers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(null);
        this.setResizable(false);

        this.add(labelStatus);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if(ServerCV.startServer()){
            labelStatus.setText("Server is ready, listening on port " + ServerCV.PORT + "!");
        }else{
            labelStatus.setText("Error: unable to start the server");
        }
    }
}
