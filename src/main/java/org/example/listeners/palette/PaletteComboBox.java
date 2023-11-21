package org.example.listeners.palette;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.color_palette.ColorPalette;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PaletteComboBox extends GeneralEventListener {
    private MainFrame mainFrame;

    public PaletteComboBox(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String name = mainFrame.getEastPanel().getPalette().getPaletteComboBox().getSelectedItem().toString();
        ColorPalette colorPalette = mainFrame.getMainCanvas().getPaletteManager().getPaletteByName(name);
        if(colorPalette != null){
            mainFrame.getNorthPanel().getPaletteDisplayPanel().updatePalette(colorPalette);
        }
    }
}
