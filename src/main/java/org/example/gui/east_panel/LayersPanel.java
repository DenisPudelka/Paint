package org.example.gui.east_panel;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.keyboard.DeleteLayerKeyboardListener;
import org.example.listeners.keyboard.NewLayerKeyboardAction;
import org.example.listeners.layer.LayerEventLastener;
import org.example.listeners.buttons.NewLayerJButtonListener;
import org.example.listeners.buttons.RemoveLayerJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class LayersPanel extends JPanel{
    private MainFrame mainFrame;
    private JList layers;
    private JButton addNewLayer;
    private JButton removeLayer;
    private JPanel buttons;
    private DefaultListModel listModel;
    private JScrollPane scrollPane;

    public LayersPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setElement();
        listenerSetup();
    }

    private void setElement(){
        this.setLayout(new BorderLayout());
        setButtons();
        setLayers();
        add(buttons, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setLayers(){
        listModel = new DefaultListModel<>();
        listModel.addElement("Layer 1");
        layers = new JList<>(listModel);
        layers.setSelectedIndex(0);

        scrollPane = new JScrollPane(layers);
    }

    private void setButtons(){
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(2,1));
        this.setJButtonAddNewLayer();
        this.setJButtonRemoveLayer();
        buttons.add(addNewLayer);
        buttons.add(removeLayer);
    }

    private void setJButtonAddNewLayer(){
        addNewLayer = new JButton("New Layer");
    }

    private void setJButtonRemoveLayer(){
        removeLayer = new JButton("Remove Layer");
    }

    private void listenerSetup(){
        NewLayerJButtonListener newLayerJButtonListener = new NewLayerJButtonListener(mainFrame);
        addNewLayer.addActionListener(newLayerJButtonListener);
        RemoveLayerJButton removeLayerJButton = new RemoveLayerJButton(mainFrame);
        removeLayer.addActionListener(removeLayerJButton);
        LayerEventLastener layerEventLastener = new LayerEventLastener(mainFrame, layers);
        layers.addListSelectionListener(layerEventLastener);

        shorcutNewLayerDeleteLayer();
    }

    private void shorcutNewLayerDeleteLayer(){
        InputMap inputMap = mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = mainFrame.getRootPane().getActionMap();

        NewLayerKeyboardAction newLayer = new NewLayerKeyboardAction(mainFrame);
        DeleteLayerKeyboardListener deleteLayer = new DeleteLayerKeyboardListener(mainFrame);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK), "newLayer");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK), "deleteLayer");

        actionMap.put("newLayer", newLayer);
        actionMap.put("deleteLayer", deleteLayer);
    }
}
