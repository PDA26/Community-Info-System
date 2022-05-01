package ui.Community;

import javax.swing.*;
import ui.Community.communityMain;

public class Main {

    private static Main instance = new Main();
    public static Main getInstance() { return instance; }

    public static MainFrame currentFrame;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.init(new communityMain());
        currentFrame = frame;
    }

    public void changeFrame(JPanel jPanel) {
        MainFrame frame = new MainFrame();
        frame.init(jPanel);
        currentFrame.dispose();
        currentFrame = frame;
    }
}
