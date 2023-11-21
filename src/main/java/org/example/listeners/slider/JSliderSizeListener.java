package org.example.listeners.slider;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseWheelEvent;

public class JSliderSizeListener extends GeneralEventListener {
    private MainFrame mainFrame;
    private int previousValue;

    public JSliderSizeListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.isControlDown()) {
            int rotation = e.getWheelRotation();
            JSlider slider = mainFrame.getMenuPanel().getSliderSizePanel().getSliderSize();
            int changeAmount = rotation * slider.getMinorTickSpacing();
            int newValue = slider.getValue() - changeAmount;
            if (newValue >= slider.getMinimum() && newValue <= slider.getMaximum()) {
                slider.setValue(newValue);
            } else {
                System.out.println("Attempted Value out of bounds: " + newValue);
            }
        }
    }
}
