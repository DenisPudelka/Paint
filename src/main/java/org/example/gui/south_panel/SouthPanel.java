package org.example.gui.south_panel;


import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.buttons.ButtonMoveListener;
import org.example.listeners.buttons.DeleteButtonListener;
import org.example.listeners.combobox.ComboBoxColorListener;
import org.example.listeners.combobox.ComboBoxShapeListener;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class SouthPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton moveButton;
    private JButton deleteButton;
    private JLabel labelOption;
    private JComboBox comboBoxShapes;
    private JComboBox comboBoxColors;
    private JLabel labelColor;
    private JLabel labelShape;

    public SouthPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        initializeListeners();
    }

    private void initializeListeners() {
        ComboBoxColorListener comboBoxColorListener = new ComboBoxColorListener(mainFrame);
        ComboBoxShapeListener comboBoxShapeListener = new ComboBoxShapeListener(mainFrame);
        ButtonMoveListener buttonMoveListener = new ButtonMoveListener(mainFrame);
        DeleteButtonListener deleteButtonListener = new DeleteButtonListener(mainFrame);
        comboBoxShapes.addActionListener(comboBoxShapeListener);
        comboBoxColors.addActionListener(comboBoxColorListener);
        moveButton.addActionListener(buttonMoveListener);
        deleteButton.addActionListener(deleteButtonListener);
    }

    private void initializeUI() {
        GridLayout gridLayout = new GridLayout(1, 7);
        this.setLayout(gridLayout);

        comboBoxShapeSetup();
        comboBoxColorSetup();
        labelColorSetup();
        labelShapeSetup();
        moveButtonSetup();
        deleteButtonSetup();
        labelSetup();

        this.add(comboBoxShapes);
        this.add(labelShape);
        this.add(comboBoxColors);
        this.add(labelColor);
        this.add(moveButton);
        this.add(deleteButton);
        this.add(labelOption);
    }
/*
    private void comboBoxShapeSetup(){
        String[] shapes = new String[] {"Tree", "House", "Turtle", "Star", "Circle", "Squer", "Hourglass"};
        comboBoxShapes = new JComboBox<>(shapes);
        comboBoxShapes.setSelectedIndex(4);
    }
*/
    private void comboBoxShapeSetup(){
        ImageIcon circleIcon = new ImageIcon(getClass().getResource("/icons/shapes/circle.png"));
        circleIcon.setDescription("Circle");

        ImageIcon hourglassIcon = new ImageIcon(getClass().getResource("/icons/shapes/hourglass.png"));
        hourglassIcon.setDescription("Hourglass");

        ImageIcon houseIcon = new ImageIcon(getClass().getResource("/icons/shapes/house.png"));
        houseIcon.setDescription("House");

        ImageIcon squareIcon = new ImageIcon(getClass().getResource("/icons/shapes/square.png"));
        squareIcon.setDescription("Square");

        ImageIcon starIcon = new ImageIcon(getClass().getResource("/icons/shapes/star.png"));
        starIcon.setDescription("Star");

        ImageIcon treeIcon = new ImageIcon(getClass().getResource("/icons/shapes/tree.png"));
        treeIcon.setDescription("Tree");

        ImageIcon turtleIcon = new ImageIcon(getClass().getResource("/icons/shapes/turtle.png"));
        turtleIcon.setDescription("Turtle");

        ImageIcon[] shapesIcons = {
                circleIcon,
                hourglassIcon,
                houseIcon,
                squareIcon,
                starIcon,
                treeIcon,
                turtleIcon
        };

        comboBoxShapes = new JComboBox<>(shapesIcons);
        comboBoxShapes.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setIcon((Icon) value);
                label.setText("");
                return label;
            }
        });
        comboBoxShapes.setSelectedIndex(4);
    }

    private void comboBoxColorSetup(){
        String[] colors = new String[] {"Red", "Green", "Blue", "Black", "Wight", "Cyan", "Magenta", "Yellow", "Violet", "Orange", "Brown", "Pink"};
        comboBoxColors = new JComboBox<>(colors);
        comboBoxColors.setSelectedIndex(0);
    }

    private void labelColorSetup(){
        labelColor = new JLabel("Red");
        labelColor.setForeground(Color.RED);
    }

    private void labelShapeSetup(){
        labelShape = new JLabel("Circle");
    }

    private void moveButtonSetup(){
        moveButton = new JButton("Move");
    }

    private void deleteButtonSetup(){
        deleteButton = new JButton("Delete");
    }

    private void labelSetup(){
        labelOption = new JLabel("...");
    }
}
