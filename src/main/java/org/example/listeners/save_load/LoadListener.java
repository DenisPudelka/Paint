package org.example.listeners.save_load;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public LoadListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = fc.showOpenDialog(mainFrame);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            mainFrame.getMainCanvas().loadCanvas(file);
        }
    }
}
