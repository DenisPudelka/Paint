package org.example.listeners.palette;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.color_palette.ColorPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class NewPaletteButton extends GeneralEventListener {
    private MainFrame mainFrame;
    private int paletteCount = 0;
    public NewPaletteButton(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String newPaletteName = "Palette " + (++paletteCount);
        ColorPalette newColorPalette = new ColorPalette(newPaletteName);
        List<Color> chosenColors = new ArrayList<>();

        // Create and set up the dialog
        JDialog addDialog = new JDialog(mainFrame, "Add New Palette", true);
        addDialog.setLayout(new BorderLayout());

        // Users can see but not edit the default generated name for the palette
        JTextField paletteNameField = new JTextField(newPaletteName);
        paletteNameField.setEditable(false);

        JColorChooser colorChooser = new JColorChooser();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));
        JButton addColorButton = new JButton("Add Color");
        JButton removeColorButton = new JButton("Remove Color");
        JButton finalizePaletteButton = new JButton("Finalize Palette");
        JPanel colorsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add components to the dialog
        addDialog.add(paletteNameField, BorderLayout.NORTH);
        addDialog.add(colorChooser, BorderLayout.CENTER);
        buttonPanel.add(addColorButton);
        buttonPanel.add(removeColorButton);
        addDialog.add(buttonPanel, BorderLayout.EAST);
        addDialog.add(colorsPanel, BorderLayout.WEST);

        // Logic to add a color to the preview panel and chosenColors list
        addColorButton.addActionListener(ev -> {
            Color selectedColor = colorChooser.getColor();
            chosenColors.add(selectedColor);
            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(selectedColor);
            colorPanel.setPreferredSize(new Dimension(30, 30));
            colorsPanel.add(colorPanel);
            colorsPanel.revalidate();
            addDialog.pack();
        });

        removeColorButton.addActionListener(ev -> {
            if(!chosenColors.isEmpty()){
                int lastColorIndex = chosenColors.size() - 1;
                chosenColors.remove(lastColorIndex);
                colorsPanel.remove(lastColorIndex);
                colorsPanel.revalidate();
                colorsPanel.repaint();
                addDialog.pack();
            }
        });

        // Add finalize button last so it appears at the bottom
        addDialog.add(finalizePaletteButton, BorderLayout.SOUTH);

        // Logic to finalize the palette creation
        finalizePaletteButton.addActionListener(ev -> {
            chosenColors.forEach(newColorPalette::addColor);
            mainFrame.getMainCanvas().getPaletteManager().addPalette(newColorPalette);
            mainFrame.getNorthPanel().getPalette().getPaletteComboBox().addItem(newColorPalette.getName());
            addDialog.dispose(); // Close the dialog
        });

        // Show the dialog
        addDialog.pack();
        addDialog.setLocationRelativeTo(mainFrame);
        addDialog.setVisible(true);
    }
}
