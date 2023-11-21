package org.example.gui.north_panel;

import org.example.gui.MainFrame;
import org.example.listeners.palette.PaletteComboBox;
import org.example.models.abstractClasses.GeometryShape;
import org.example.models.color_palette.ColorPalette;
import org.example.models.layers.Layer;

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
        setLayout(new BorderLayout());
        paletteNameLabel = new JLabel("Initial Palette");
        colorsPanel = new JPanel(new FlowLayout());

        add(paletteNameLabel, BorderLayout.NORTH);
        add(colorsPanel, BorderLayout.CENTER);
    }

    public void updatePalette(ColorPalette palette){
        paletteNameLabel.setText(palette.getName());
        colorsPanel.removeAll();

        for(Color color : palette.getColors()){
            JButton colorButton = new JButton();
            colorButton.setBackground(color);
            colorButton.setPreferredSize(new Dimension(30,30));
            colorButton.addActionListener(e -> {
                Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
                if(currentLayer != null){
                    currentLayer.setCurrentColor(color);
                }
            });
            colorsPanel.add(colorButton);
        }
        colorsPanel.revalidate();
        colorsPanel.repaint();
    }
}
