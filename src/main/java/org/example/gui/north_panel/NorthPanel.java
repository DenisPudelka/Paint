package org.example.gui.north_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.buttons.BrushButtonListener;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class NorthPanel extends JPanel {
    private MainFrame mainFrame;
    private PaletteDisplayPanel paletteDisplayPanel;
    private JButton brushTool;

    public NorthPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        initializeListeners();
    }

    private void initializeListeners() {
        BrushButtonListener brushButtonListener = new BrushButtonListener(mainFrame);
        brushTool.addActionListener(brushButtonListener);
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        setupComboBox();
        paletteDisplayPanel = new PaletteDisplayPanel(mainFrame);

        add(brushTool, BorderLayout.WEST);
        add(paletteDisplayPanel, BorderLayout.CENTER);
    }

    private void setupComboBox(){
        brushTool = new JButton("Brush");
    }
}
