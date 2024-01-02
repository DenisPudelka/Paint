package org.example.gui.east_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.layer.LayerButton;
import org.example.listeners.layer.LayerCheckBox;
import org.example.models.layers.Layer;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class LayerPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton layerButton;
    private JCheckBox visibilityCheckBox;
    private int layerId;
    private boolean layerVisibility;

    public LayerPanel(MainFrame mainFrame, int layerId, boolean layerVisibility) {
        this.mainFrame = mainFrame;
        this.layerId = layerId;
        this.layerVisibility = layerVisibility;
        setUpComponents();
        listenerSetup();
    }

    private void setUpComponents() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));


        layerButton = new JButton();
        layerButton.setText("Layer " + layerId);

        visibilityCheckBox = new JCheckBox();
        visibilityCheckBox.setName(String.valueOf(layerId));
        visibilityCheckBox.setSelected(layerVisibility);

        this.add(layerButton, BorderLayout.CENTER);
        this.add(visibilityCheckBox, BorderLayout.EAST);
    }

    private void listenerSetup() {
        LayerCheckBox layerCheckBox = new LayerCheckBox(mainFrame, layerId);
        visibilityCheckBox.addActionListener(layerCheckBox);
        LayerButton layerButtonListener = new LayerButton(mainFrame, layerId);
        layerButton.addActionListener(layerButtonListener);
    }
}
