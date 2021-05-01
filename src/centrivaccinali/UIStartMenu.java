package centrivaccinali;

import javax.swing.*;

public class UIStartMenu {
    JFrame frame = new JFrame();

    public UIStartMenu(){
        setupFrame();
    }

    void setupFrame(){
        frame.setTitle("Start Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
