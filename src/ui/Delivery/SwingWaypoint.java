package ui.Delivery;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A waypoint that is represented by a button on the map.
 *
 * @author Daniel Stahr
 */
public class SwingWaypoint extends DefaultWaypoint {
    private final JButton button;
    private final String text;

    public String getText() {
        return text;
    }

    interface ClickedListener {
        void clicked(SwingWaypoint waypoint);
    }

    public SwingWaypoint(String text, GeoPosition coord, ClickedListener listener) {
        super(coord);
        this.text = text;
        button = new JButton(text);
        // button.setSize(24, 24);
        // button.setPreferredSize(new Dimension(24, 24));
        button.addActionListener(actionEvent -> listener.clicked(this));
        button.setVisible(true);
    }

    JButton getButton() {
        return button;
    }

}
