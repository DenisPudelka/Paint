package org.example.gui.north_panel;

import org.example.gui.MainFrame;
import org.example.listeners.palette.PaletteColorPicker;
import org.example.models.color_palette.ColorPalette;

import javax.swing.*;
import java.awt.*;

public class PaletteDisplayPanel extends JPanel {
    private MainFrame mainFrame;
    private JLabel paletteNameLabel;
    private JPanel colorsPanel;

    public PaletteDisplayPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        initializeListeners();
    }

    private void initializeListeners() {

    }

    private void initializeUI() {
        setLayout(new FlowLayout());
        paletteNameLabel = new JLabel("Palette of Colors");
        colorsPanel = new JPanel(new FlowLayout());

        add(paletteNameLabel);
        add(colorsPanel);
    }

    public void updatePalette(ColorPalette palette){
        paletteNameLabel.setText(palette.getName());
        colorsPanel.removeAll();

        for(Color color : palette.getColors()){
            JButton colorButton = new JButton();
            colorButton.setBackground(color);
            colorButton.setPreferredSize(new Dimension(20,20));
            colorButton.setActionCommand(colorToHexString(color));
            colorButton.addActionListener(new PaletteColorPicker(mainFrame));

            colorsPanel.add(colorButton);
        }
        colorsPanel.revalidate();
        colorsPanel.repaint();
    }

    private String colorToHexString(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
