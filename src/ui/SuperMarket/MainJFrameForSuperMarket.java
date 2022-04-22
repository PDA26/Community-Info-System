package ui.SuperMarket;


import javax.swing.*;
import java.awt.*;

public class MainJFrameForSuperMarket extends JFrame {

    public MainJFrameForSuperMarket(){
    }

    public void init(JPanel panel){
        /*add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,400,800,800);
        setVisible(true);*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setOpaque(true);
        //setSize(new Dimension(800, 800));
        setBounds(400,100,800,800);
        getContentPane().add(panel);
        setVisible(true);
    }

}
