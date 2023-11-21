package org.example.listeners.combobox;

import org.example.gui.MainFrame;
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
        mainFrame.getMenuPanel().getSouthPanel().getLabelColor().setForeground(getColor(color));
        mainFrame.getMenuPanel().getSouthPanel().getLabelColor().setText(getColorString(color));
        Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
        if(currentLayer != null){
            currentLayer.setCurrentColor(getColor(color));
        }
    }

    private Color getColor(Object color) {
        String pickedColor = ((String) color).toLowerCase();
        switch (pickedColor) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            case "black":
                return Color.BLACK;
            case "wight":
                return Color.WHITE;
            case "cyan":
                return Color.CYAN;
            case "magenta":
                return Color.MAGENTA;
            case "yellow":
                return Color.YELLOW;
            case "violet":
                return new Color(127, 0, 255);
            case "orange":
                return Color.ORANGE;
            case "brown":
                return new Color(165, 42, 42);
            case "pink":
                return Color.PINK;
            default:
                return null;
        }
    }

    private String getColorString(Object color) {
        String pickedColor = ((String) color).toLowerCase();
        switch (pickedColor) {
            case "red":
                return "Red";
            case "green":
                return "Green";
            case "blue":
                return "Blue";
            case "black":
                return "Black";
            case "wight":
                return "Wight";
            case "cyan":
                return "Cyan";
            case "magenta":
                return "Magenta";
            case "yellow":
                return "Yellow";
            case "violet":
                return "Violet";
            case "orange":
                return "Orange";
            case "brown":
                return "Brown";
            case "pink":
                return "Pink";
            default:
                return null;
        }
    }
}
