package ui.SuperMarket.viewOrder;

import javax.swing.*;
import java.awt.*;

public class UpdateOrderStatusJPanel extends JPanel{

    /**
     * components
     */
    private static JPanel upJPanel;
    private static JPanel downJPanel;

    JLabel titleJLabel = new JLabel("Are you sure to ship this Order?");
    JButton noJButton = new JButton("NO");
    JButton okJButton = new JButton("OK");

    public UpdateOrderStatusJPanel() {

        InitData();
        InitViews();

    }

    private void InitData() {

    }

    private void InitViews() {

        CreateUpJPanel();
        CreateDownJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForUp = new GridBagConstraints();
        constraintsForUp.gridx = 0;
        constraintsForUp.gridy = 0;
        constraintsForUp.weightx = 0;
        constraintsForUp.weighty = 0;
        constraintsForUp.fill = GridBagConstraints.CENTER;
        panelContainer.add(upJPanel, constraintsForUp);

        GridBagConstraints constraintsForDown = new GridBagConstraints();
        constraintsForDown.gridx = 0;
        constraintsForDown.gridy = 1;
        constraintsForDown.weightx = 1.0;
        constraintsForDown.weighty = 0;
        constraintsForDown.fill = GridBagConstraints.HORIZONTAL;
        panelContainer.add(downJPanel, constraintsForDown);

        JFrame jFrame = new JFrame("");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(400, 200));
        jFrame.setContentPane(panelContainer);
        jFrame.setVisible(true);

    }

    private void CreateUpJPanel() {

        upJPanel = new JPanel();
        upJPanel.setLayout(new BoxLayout(upJPanel, BoxLayout.Y_AXIS));

        upJPanel.add(Box.createVerticalStrut(10));
        upJPanel.add(titleJLabel);
        upJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateDownJPanel() {

        downJPanel = new JPanel();
        downJPanel.setLayout(new BoxLayout(downJPanel, BoxLayout.Y_AXIS));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalStrut(60));
        contentJPanel.add(noJButton);
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(okJButton);
        contentJPanel.add(Box.createHorizontalStrut(60));

        downJPanel.add(Box.createVerticalStrut(30));
        downJPanel.add(contentJPanel);
        downJPanel.add(Box.createVerticalStrut(10));

    }

    public static void main(String[] args) {
        //new UpdateOrderStatusJPanel();
    }

}
