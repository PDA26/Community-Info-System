package ui.Delivery;

import model.OrderData.Order;
import model.SuperMarket.SuperMarket;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import java.util.*;

public class LocationChooser {
    private JXMapKit jxMapKit;
    private JPanel panel;
    private JTextField textFieldAddress;
    private JComboBox<String> comboBoxGrocery;

    public static String show(JComponent parent) {
        LocationChooser chooser = new LocationChooser();
        int option = JOptionPane.showConfirmDialog(parent,
                                                   chooser.panel,
                                                   "Choose Grocery",
                                                   JOptionPane.OK_CANCEL_OPTION,
                                                   JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            return chooser.getAddress();
        }
        return null;
    }

    public String getAddress() {
        return textFieldAddress.getText();
    }

    public JPanel getPanel() {
        return panel;
    }

    public LocationChooser() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory factory = new DefaultTileFactory(info);
        factory.setThreadPoolSize(Runtime.getRuntime().availableProcessors());
        jxMapKit.setTileFactory(factory);

        GeoPosition walgreens = new GeoPosition(42.4247377,-71.0704437);
        GeoPosition seven11 = new GeoPosition(42.4292229,-71.0631881);
        GeoPosition walmart = new GeoPosition(42.4437264,-71.0713724);

        GeoPosition median = new GeoPosition(
                (walgreens.getLatitude() + seven11.getLatitude() + walmart.getLatitude()) / 3.0,
                (walgreens.getLongitude() + seven11.getLongitude() + walmart.getLongitude()) / 3.0
        );

        jxMapKit.setMiniMapVisible(false);
        jxMapKit.setAddressLocation(median);
        jxMapKit.setZoom(5);

        SwingWaypoint.ClickedListener listener = waypoint -> comboBoxGrocery.setSelectedItem(waypoint.getText());
        Set<SwingWaypoint> waypoints = new HashSet<>(Arrays.asList(
                new SwingWaypoint("Walgreens", walgreens, listener),
                new SwingWaypoint("7-11", seven11, listener),
                new SwingWaypoint("Walmart", walmart, listener)
        ));

        WaypointPainter<SwingWaypoint> waypointPainter = new SwingWaypointOverlayPainter();
        waypointPainter.setWaypoints(waypoints);

        jxMapKit.getMainMap().setOverlayPainter(waypointPainter);

        for (SwingWaypoint waypoint : waypoints) {
            jxMapKit.getMainMap().add(waypoint.getButton());
        }

        comboBoxGrocery.addItem("Walgreens");
        comboBoxGrocery.addItem("7-11");
        comboBoxGrocery.addItem("Walmart");
        comboBoxGrocery.setSelectedIndex(-1);
        Map<String, String> address = new HashMap<>();
        address.put("Walgreens", "185 Centre St, Malden, MA 02148");
        address.put("7-11", "169 Salem St, Malden, MA 02148");
        address.put("Walmart", "100 Main St, Melrose, MA 02176");
        comboBoxGrocery.addActionListener(actionEvent -> {
            textFieldAddress.setText(address.get((String) comboBoxGrocery.getSelectedItem()));
        });

    }

    public static void main(String[] args) {
        LocationChooser locationChooser = new LocationChooser();
        JFrame frame = new JFrame("LocationChooser");
        frame.setContentPane(locationChooser.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
