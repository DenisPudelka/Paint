package org.example.gui.east_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.palette.NewPaletteButton;
import org.example.listeners.palette.PaletteComboBox;
import org.example.listeners.palette.RemovePaletteButton;
import org.example.models.color_palette.ColorPalette;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Palette extends JPanel {
    private MainFrame mainFrame;
    private JPanel buttonPanele;
    private JButton newPalette;
    private JButton removePallete;
    private JPanel comboPanel;
    private JScrollPane scrollPane;
    private JComboBox<String> paletteComboBox;

    public Palette(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        buttonPanele = new JPanel(new GridLayout(2,1));

        newPalette = new JButton("New Palette");
        removePallete = new JButton("Remove Palette");


        buttonPanele.add(newPalette);
        buttonPanele.add(removePallete);

        comboPanel = new JPanel();
        comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(comboPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        paletteComboBox = new JComboBox<>();
        for (ColorPalette palette : mainFrame.getMainCanvas().getPaletteManager().getPalette()) {
            paletteComboBox.addItem(palette.getName());
        }
        comboPanel.add(paletteComboBox);

        setupButtonsListener();
        this.add(buttonPanele, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void setupButtonsListener(){
        NewPaletteButton newPaletteButton = new NewPaletteButton(mainFrame);
        newPalette.addActionListener(newPaletteButton);
        RemovePaletteButton removePaletteButton = new RemovePaletteButton(mainFrame);
        removePallete.addActionListener(removePaletteButton);
        PaletteComboBox paletteComboBox1 = new PaletteComboBox(mainFrame);
        paletteComboBox.addActionListener(paletteComboBox1);
    }
}
