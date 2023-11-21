package org.example.listeners.save_load;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public SaveListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String savePath = getSavePath();
        mainFrame.getMainCanvas().saveCanvas(new File(savePath));
    }

    private String getSavePath(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(mainFrame);

        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            if(!fileToSave.getAbsolutePath().toLowerCase().endsWith(".ser")){
                fileToSave = new File(fileToSave + ".ser");
            }
            return fileToSave.getAbsolutePath();
        }
        return null;
    }
}
