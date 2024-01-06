package org.example.listeners.menu.undoredo;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import java.awt.event.ActionEvent;

public class RedoListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public RedoListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        mainFrame.getMainCanvas().getLayersManager().getActiveLayer().getManager().redo();
        mainFrame.getMainCanvas().repaint();
    }
}
