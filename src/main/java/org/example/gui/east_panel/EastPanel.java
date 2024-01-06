package org.example.gui.east_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class EastPanel extends JPanel {
    private MainFrame mainFrame;
    private LayersPanel layersPanel;

    public EastPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        componentsSetup();
    }

    private void componentsSetup() {
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        layersPanel = new LayersPanel(mainFrame);
        this.add(layersPanel, BorderLayout.CENTER);
    }
}
