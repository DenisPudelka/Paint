package org.example.listeners.menu;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AboutAppListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public AboutAppListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pages as tabs
        tabbedPane.addTab("Getting Started", createGettingStartedPanel());
        tabbedPane.addTab("Usage Tips", createUsageTipsPanel());
        tabbedPane.addTab("Credits", createCreditsPanel());
        // Add more tabs as needed...

        // Create and show the dialog
        JDialog aboutDialog = new JDialog(mainFrame, "About CanvasCraft Studio", true);
        aboutDialog.getContentPane().add(tabbedPane);
        aboutDialog.setSize(400, 300);
        aboutDialog.setLocationRelativeTo(mainFrame);
        aboutDialog.setVisible(true);
    }

    private JPanel createGettingStartedPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // Add content to the panel

        String htmlText = "<html><body style='font-family:Arial; font-size:12px;'>"
                + "<h2 style='color:blue;'>Getting Started</h2>"
                + "<p>Welcome to CanvasCraft! Here are a few tips to get you started:</p>"
                + "<ul>"
                + "<li>Use the <b>Brush</b> tool to draw freehand.</li>"
                + "<li>Select shapes from the dropdown to draw predefined shapes.</li>"
                + "</ul>"
                + "</body></html>";

        JLabel label = new JLabel(htmlText);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createUsageTipsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // Add content to the panel
        JLabel label = new JLabel("<html><h2>Usage Tips</h2><p>Here are some tips...</p></html>");
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCreditsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // Add content to the panel
        JLabel label = new JLabel("<html><h2>Credits</h2><p>Made with love by the CanvasCraft team.</p></html>");
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
