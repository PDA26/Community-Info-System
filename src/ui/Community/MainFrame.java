package ui.Community;

import javax.swing.*;

public class MainFrame extends JFrame{

    public MainFrame() {

    }

    public void init(JPanel panel) {
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,800,600);
        setVisible(true);
    }
}
