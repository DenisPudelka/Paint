package org.example.gui.south_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MenuPanel extends JPanel {
    private MainFrame mainFrame;
    private SliderSizePanel sliderSizePanel;
    private SouthPanel southPanel;

    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        componentsSetup();
    }

    private void componentsSetup(){
        GridLayout layout = new GridLayout(2,1);
        setLayout(layout);
        sliderSizePanel = new SliderSizePanel(mainFrame);
        southPanel = new SouthPanel(mainFrame);
        add(sliderSizePanel);
        add(southPanel);
    }
}
