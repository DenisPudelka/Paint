package org.example.gui.south_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.slider.JSliderSizeListener;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class SliderSizePanel extends JPanel {
    private JSlider sliderSize;
    private JLabel label;
    private MainFrame mainFrame;

    public SliderSizePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        commponetsSetup();
        listenersSetup();
    }

    private void listenersSetup(){
        JSliderSizeListener jSliderSizeListener = new JSliderSizeListener(mainFrame);
        sliderSize.addChangeListener(jSliderSizeListener);
        sliderSize.addMouseWheelListener(jSliderSizeListener);
    }

    private void commponetsSetup(){
        GridLayout layout = new GridLayout(1,1);
        setLayout(layout);

        labelSetup();
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sliderSizeSetup();
        sizePanel.add(label);
        sizePanel.add(sliderSize);

        add(sizePanel);
    }

    private void sliderSizeSetup(){
        sliderSize = new JSlider(JSlider.HORIZONTAL, 20,200,50);
        sliderSize.setMajorTickSpacing(10);
        sliderSize.setMinorTickSpacing(2);
        sliderSize.setPaintTicks(true);
        sliderSize.setSnapToTicks(true);
        sliderSize.setPaintLabels(true);
    }

    private void labelSetup(){
        label = new JLabel("Size");
    }
}
