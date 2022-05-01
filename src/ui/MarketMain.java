package ui;

import javax.sound.midi.MidiDevice;
import javax.swing.*;
import java.awt.*;

public class MarketMain extends JPanel{

    /**
     * components
     */
    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;

    JLabel titleJLabel = new JLabel("title");
    JLabel imageJLabel = new JLabel();
    JButton button01 = new JButton("button01");
    JButton button02 = new JButton("button02");
    JButton button03 = new JButton("button03");

    public MarketMain() {

        InitData();
        InitView();

    }

    private void InitData() {

    }

    private void InitView() {

        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 1;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.CENTER;
        panelContainer.add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        panelContainer.add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.HORIZONTAL;
        panelContainer.add(bottomJPanel, constraintsForBottom);

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);

    }

    private void CreateTopJPanel() {

       topJPanel  = new JPanel();
       topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

       topJPanel.add(Box.createVerticalStrut(10));
       topJPanel.add(titleJLabel);
       topJPanel.add(Box.createVerticalStrut(10));


    }

    private void CreateMiddleJPanel() {

        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel leftJPanel = new JPanel();
        leftJPanel.setLayout(new BoxLayout(leftJPanel, BoxLayout.X_AXIS));
        leftJPanel.add(Box.createHorizontalStrut(10));
        leftJPanel.add(imageJLabel);
        leftJPanel.add(Box.createHorizontalStrut(10));

        JPanel rightJPanel = new JPanel();
        rightJPanel.setLayout(new BoxLayout(rightJPanel, BoxLayout.Y_AXIS));
        rightJPanel.add(Box.createVerticalStrut(10));
        rightJPanel.add(button01);
        rightJPanel.add(Box.createRigidArea(new Dimension(10, 60)));
        rightJPanel.add(button02);
        rightJPanel.add(Box.createVerticalStrut(10));

        middleJPanel.add(leftJPanel);
        middleJPanel.add(rightJPanel);

    }

    private void CreateBottomJPanel() {

        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(button03);
        contentJPanel.add(Box.createHorizontalStrut(10));

        bottomJPanel.add(contentJPanel);

    }

    public static void main(String[] args) {
        new MarketMain();
    }
}
