package ui.Delivery;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.WMSTileFactoryInfo;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LocationChooser {
    private JXMapKit JXMapKit1;
    private JPanel panel;
    private JTextField textField1;
    private JComboBox<SwingWaypoint> comboBox1;

    private void setupTest() {
        /*
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory factory = new DefaultTileFactory(info);
        factory.setThreadPoolSize(Runtime.getRuntime().availableProcessors());
        locationChooser.JXMapKit1.setTileFactory(factory);
        */

        GeoPosition frankfurt = new GeoPosition(50,  7, 0, 8, 41, 0);
        GeoPosition wiesbaden = new GeoPosition(50,  5, 0, 8, 14, 0);
        GeoPosition mainz     = new GeoPosition(50,  0, 0, 8, 16, 0);
        GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
        GeoPosition offenbach = new GeoPosition(50,  6, 0, 8, 46, 0);

        JXMapKit1.setAddressLocation(frankfurt);

        SwingWaypoint.ClickedListener listener = waypoint -> comboBox1.setSelectedItem(waypoint);
        Set<SwingWaypoint> waypoints = new HashSet<>(Arrays.asList(
                new SwingWaypoint("Frankfurt", frankfurt, listener),
                new SwingWaypoint("Wiesbaden", wiesbaden, listener),
                new SwingWaypoint("Mainz", mainz, listener),
                new SwingWaypoint("Darmstadt", darmstadt, listener),
                new SwingWaypoint("Offenbach", offenbach, listener)
        ));

        WaypointPainter<SwingWaypoint> waypointPainter = new SwingWaypointOverlayPainter();
        waypointPainter.setWaypoints(waypoints);

        JXMapKit1.getMainMap().setOverlayPainter(waypointPainter);

        for (SwingWaypoint waypoint : waypoints) {
            JXMapKit1.getMainMap().add(waypoint.getButton());
        }


    }

    public static void main(String[] args) {
        LocationChooser locationChooser = new LocationChooser();
        locationChooser.setupTest();

        JFrame frame = new JFrame("LocationChooser");
        frame.setContentPane(locationChooser.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
