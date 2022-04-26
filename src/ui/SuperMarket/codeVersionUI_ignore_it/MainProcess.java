package ui.SuperMarket.codeVersionUI_ignore_it;

import ui.SuperMarket.codeVersionUI_ignore_it.mainJPanel_Code.MarketMainJPanel;

import javax.swing.*;

public class MainProcess {

    private static MainProcess instance = new MainProcess();

    public static MainProcess getInstance(){
        return instance;
    }

    public static MainJFrameForSupermarket currentFrame;

    public void changeFrame(JPanel jPanel){
        MainJFrameForSupermarket frame  = new MainJFrameForSupermarket();
        frame.init(jPanel);
        currentFrame.dispose();
        currentFrame = frame;
    }

    public void showDialog(String detail){
        JOptionPane.showMessageDialog(currentFrame,
                detail,"Error",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * run the pure code version of the Supermarket UI
     * @param args
     */
    public static void main(String[] args) {

        MainJFrameForSupermarket frame = new MainJFrameForSupermarket();
        frame.init(new MarketMainJPanel());
        currentFrame = frame;

    }

}
