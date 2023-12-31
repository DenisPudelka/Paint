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
    private ColorIndicator colorIndicator;
    private JLabel labelDrawingTool;

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
        //labelColorSetup();
        colorIndicatorSetup();
        labelShapeSetup();
        moveButtonSetup();
        deleteButtonSetup();
        labelSetup();

        this.add(comboBoxShapes);
        this.add(labelDrawingTool);
        this.add(comboBoxColors);
        //this.add(labelColor);
        this.add(colorIndicator);
        this.add(moveButton);
        this.add(deleteButton);
        this.add(labelOption);
    }

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
                label.setText(((ImageIcon) value).getDescription());
                return label;
            }
        });
        comboBoxShapes.setSelectedIndex(0);
    }

    private void comboBoxColorSetup(){
        Color[] colors = {
                new Color(255, 0, 0),
                new Color(0, 255, 0),
                new Color(0, 0, 255),
                new Color(0,0,0),
                new Color(255,255,255),
                new Color(0,255,255),
                new Color(255,0,255),
                new Color(255,255,0),
                new Color(255, 87, 51),
                new Color(127, 0, 255),
                new Color(165,42,42),
                new Color(255,192,203)
        };

        comboBoxColors = new JComboBox<>(colors);
        comboBoxColors.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground((Color) value);
                label.setText("Color");
                return label;
            }
        });
    }

    private void labelColorSetup(){
        labelColor = new JLabel("Red");
        labelColor.setForeground(Color.RED);
    }

    private void colorIndicatorSetup(){
        colorIndicator = new ColorIndicator(mainFrame);
    }

    private void labelShapeSetup(){
        labelDrawingTool = new JLabel("Drawing Tool: Shape Circle");
    }

    private void moveButtonSetup(){
        moveButton = new JButton("Move");
    }

    private void deleteButtonSetup(){
        deleteButton = new JButton("Delete");
    }

    private void labelSetup(){
        labelOption = new JLabel("Action: none");
    }
}
