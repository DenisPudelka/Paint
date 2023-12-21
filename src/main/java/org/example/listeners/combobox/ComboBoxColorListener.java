package org.example.listeners.combobox;

import org.example.gui.MainFrame;
import org.example.gui.south_panel.SouthPanel;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.abstractClasses.GeometryShape;
import org.example.models.layers.Layer;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ComboBoxColorListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public ComboBoxColorListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        System.out.println("Color");
        Object color = mainFrame.getMenuPanel().getSouthPanel().getComboBoxColors().getSelectedItem();
        SouthPanel southPanel = mainFrame.getMenuPanel().getSouthPanel();
        southPanel.getColorIndicator().setColorSquare(getColor(color));
        Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
        if (currentLayer != null) {
            currentLayer.setCurrentColor(getColor(color));
        }
    }

    private Color getColor(Object color) {
        if (color instanceof Color) {
            int rgb = ((Color) color).getRGB();
            System.out.println(rgb);
            switch (rgb) {
                case -65536: // Red
                    return Color.RED;
                case -16711936: // Green
                    return Color.GREEN;
                case -16776961: // Blue
                    return Color.BLUE;
                case -16777216: // Black
                    return Color.BLACK;
                case -1:
                    return Color.WHITE;
                case -16711681: // Cyan
                    return Color.CYAN;
                case -65281: // Magenta
                    return Color.MAGENTA;
                case -256: // Yellow
                    return Color.YELLOW;
                case -8453889: // Violet
                    return new Color(127, 0, 255);
                case -43213: // Orange
                    return Color.ORANGE;
                case -5952982: // Brown
                    return new Color(165, 42, 42);
                case -16181: // Pink
                    return Color.PINK;
                default:
                    return Color.BLACK;
            }
        }
        return Color.BLACK;
    }

    private String getColorString(Object color) {
        if (color instanceof Color) {
            int rgb = ((Color) color).getRGB();
            System.out.println(rgb);
            switch (rgb) {
                case -65536: // Red
                    return "Red";
                case -16711936: // Green
                    return "Green";
                case -16776961: // Blue
                    return "Blue";
                case -16777216: // Black
                    return "Black";
                case -1:
                    return "White";
                case -16711681: // Cyan
                    return "Cyan";
                case -65281: // Magenta
                    return "Magenta";
                case -256: // Yellow
                    return "Yellow";
                case -8453889: // Violet
                    return "Violet";
                case -43213: // Orange
                    return "Orange";
                case -5952982: // Brown
                    return "Brown";
                case -16181: // Pink
                    return "Pink";
                default:
                    return "Black";
            }
        }
        return "Black";
    }
}
