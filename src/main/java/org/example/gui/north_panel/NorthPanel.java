package org.example.gui.north_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
        BasicBrushButtonListener brushButtonListener = new BasicBrushButtonListener(mainFrame);
        basicBrush.addActionListener(brushButtonListener);

        AirBrushButtonListener airBrushButtonListener = new AirBrushButtonListener(mainFrame);
        airBrush.addActionListener(airBrushButtonListener);

        CalligraphyBrushButtonListener calligraphyBrushButtonListener = new CalligraphyBrushButtonListener(mainFrame);
        calligraphyBrush.addActionListener(calligraphyBrushButtonListener);

        PencilButtonListener pencilButtonListener = new PencilButtonListener(mainFrame);
        pencil.addActionListener(pencilButtonListener);

        WatercolorBrushButtonListener watercolorBrushButtonListener = new WatercolorBrushButtonListener(mainFrame);
        waterColorBrush.addActionListener(watercolorBrushButtonListener);
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
        basicBrush = new JButton();
        basicBrush.setBackground(Color.WHITE);
        basicBrush.setIcon(createIcon("/icons/brushes/basic_brush/24x24.png"));

        airBrush = new JButton();
        airBrush.setBackground(Color.WHITE);
        airBrush.setIcon(createIcon("/icons/brushes/air_brush/24x24.png"));

        calligraphyBrush = new JButton();
        calligraphyBrush.setBackground(Color.WHITE);
        calligraphyBrush.setIcon(createIcon("/icons/brushes/caligraphy/24x24.png"));

        waterColorBrush = new JButton();
        waterColorBrush.setBackground(Color.WHITE);
        waterColorBrush.setIcon(createIcon("/icons/brushes/water_brush/24x24.png"));

        eraser = new JButton();
        eraser.setBackground(Color.WHITE);
        eraser.setIcon(createIcon("/icons/brushes/eraser/24x24.png"));

        pencil = new JButton();
        pencil.setBackground(Color.WHITE);
        pencil.setIcon(createIcon("/icons/brushes/pencil/24x24.png"));
    }

    private ImageIcon createIcon(String path){
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found: " + path);
            return null;
        }
    }
}
