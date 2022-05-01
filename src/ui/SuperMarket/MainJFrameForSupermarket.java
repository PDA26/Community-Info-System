package ui.SuperMarket;


import javax.swing.*;
import java.awt.*;

public class MainJFrameForSupermarket extends JFrame {

    public MainJFrameForSupermarket(){
    }

    public void init(JPanel panel){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setOpaque(true);
        //setSize(new Dimension(800, 800));
        setBounds(400,100,800,800);
        getContentPane().add(panel);
        setVisible(true);
    }

}
