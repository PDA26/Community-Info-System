package ui.SuperMarket.mainJPanel;

import ui.SuperMarket.viewItemMenu.ViewItemMenuForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMarketForm {

    /**
     * components
     */
    //logo of supermarket
    private JLabel logoOfSuperMarket;
//    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");
    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");

    private JPanel mainMarketJPanel;
    private JPanel contentJPanel;
    private JButton viewItemMenuButton;
    private JButton viewOrderButton;
    private JButton backToMainButton;
    private JLabel titleJLabel;

    public MainMarketForm() {

        setLogo();

        viewItemMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ViewItemMenuForm viewItemMenuForm = new ViewItemMenuForm();
                JPanel panel = viewItemMenuForm.getPanel();
                contentJPanel.add("View Item Menu", panel);
                CardLayout layout = (CardLayout) contentJPanel.getLayout();
                layout.next(contentJPanel);
//                contentJPanel.add("View Item Menu", new ViewItemMenuForm().getPanel());
//                ((CardLayout) contentJPanel.getLayout()).next(contentJPanel);
//                ((CardLayout) contentJPanel.getLayout()).show(contentJPanel, "Main Market Interface");

//                MainProcess.getInstance().changeFrame(new ViewItemMenuForm().getPanel());



            }
        });

        viewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public JPanel getPanel() {

        return mainMarketJPanel;

    }

    public void setLogo() {

        imagePath.setImage(imagePath.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        logoOfSuperMarket.setIcon(imagePath);
        logoOfSuperMarket.setSize(100, 100);

    }

}
