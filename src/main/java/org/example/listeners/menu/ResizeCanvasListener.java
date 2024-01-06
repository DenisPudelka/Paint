package org.example.listeners.menu;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResizeCanvasListener extends GeneralEventListener {
    private MainFrame mainFrame;

    public ResizeCanvasListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        JTextField widthField = new JTextField(5);
        JTextField heightField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Width:"));
        myPanel.add(widthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Height:"));
        myPanel.add(heightField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Width and Height Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());

                mainFrame.getMainCanvas().setDrawingAreaSize(width, height);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for width and height.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
