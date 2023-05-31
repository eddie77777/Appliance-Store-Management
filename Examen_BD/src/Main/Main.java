package Main;

import Panels.ComandaProdusPanel;
import Panels.MainPanel;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    static JFrame frame = new JFrame ("Altecs");

    public static void changeCurrentPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.repaint();
        frame.revalidate();
    }

    public static void main (String[] args) throws SQLException {
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add (new MainPanel());
        frame.pack();
        frame.setVisible (true);
    }
}