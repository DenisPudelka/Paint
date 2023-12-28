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
    private JPanel palettePanel;
    private PaletteDisplayPanel paletteDisplayPanel;
    private Palette palette;
    private JPanel brushPanel;
    private JButton basicBrush;
    private JButton airBrush;
    private JButton calligraphyBrush;
    private JButton waterColorBrush;
    private JButton eraser;
    private JButton pencil;

    public NorthPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        initializeListeners();
    }

    private void initializeListeners() {
        BrushButtonListener brushButtonListener = new BrushButtonListener(mainFrame);
        basicBrush.addActionListener(brushButtonListener);
    }

    private void initializeUI() {
        setLayout(new GridLayout(1,2));

        brushPanel = new JPanel();
        brushPanel.setLayout(new FlowLayout());
        setupJButtonBrushes();
        brushPanel.add(basicBrush);
        brushPanel.add(airBrush);
        brushPanel.add(calligraphyBrush);
        brushPanel.add(waterColorBrush);
        brushPanel.add(eraser);
        brushPanel.add(pencil);

        palettePanel = new JPanel();
        palettePanel.setLayout(new FlowLayout());
        paletteDisplayPanel = new PaletteDisplayPanel(mainFrame);
        palette = new Palette(mainFrame);
        palettePanel.add(paletteDisplayPanel);
        palettePanel.add(palette);

        add(brushPanel);
        add(palettePanel);
    }

    private void setupJButtonBrushes(){
        basicBrush = new JButton("Basic Brush");
        airBrush = new JButton("Air Brush");
        calligraphyBrush = new JButton("Calligraphy Brush");
        waterColorBrush = new JButton("Watercolor Brush");
        eraser = new JButton("Eraser");
        pencil = new JButton("Pencil");
    }
}
