package org.example.listeners.palette;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.color_palette.ColorPalette;

import java.awt.event.ActionEvent;

public class RemovePaletteButton extends GeneralEventListener {
    private MainFrame mainFrame;

    public RemovePaletteButton(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String selectedPaletteName = (String) mainFrame.getEastPanel().getPalette().getPaletteComboBox().getSelectedItem();
        ColorPalette selectedPalette = mainFrame.getMainCanvas().getPaletteManager().getPaletteByName(selectedPaletteName);
        mainFrame.getMainCanvas().getPaletteManager().removePalette(selectedPalette);
        mainFrame.getEastPanel().getPalette().getPaletteComboBox().removeItem(selectedPaletteName);
    }
}
