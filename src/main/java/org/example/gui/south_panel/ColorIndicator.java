package org.example.gui.south_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ColorIndicator extends JPanel {
    private JLabel label;
    private JPanel colorSquare;
    private MainFrame mainFrame;

    public ColorIndicator(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        label = new JLabel("Selected Color: ");

        colorSquare = new JPanel();
        colorSquare.setPreferredSize(new Dimension(20,20));
        colorSquare.setBackground(Color.RED);

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 5,5));
        this.add(label);
        this.add(colorSquare);
    }

    public void setColorSquare(Color newColor){
        colorSquare.setBackground(newColor);
    }
}
