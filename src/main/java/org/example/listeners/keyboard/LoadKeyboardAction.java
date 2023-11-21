package org.example.listeners.keyboard;

import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadKeyboardAction extends AbstractAction {
    private MainFrame mainFrame;

    public LoadKeyboardAction(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = fc.showOpenDialog(mainFrame);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            mainFrame.getMainCanvas().loadCanvas(file);
        }
    }
}
