package org.example.listeners.menu.undoredo;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import java.awt.event.ActionEvent;

public class UndoListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public UndoListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        mainFrame.getMainCanvas().getLayersManager().getActiveLayer().getManager().undo();
        mainFrame.getMainCanvas().repaint();
    }
}
