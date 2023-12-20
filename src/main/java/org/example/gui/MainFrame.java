package org.example.gui;

import lombok.Getter;
import org.example.gui.east_panel.EastPanel;
import org.example.gui.north_panel.NorthPanel;
import org.example.gui.south_panel.MenuPanel;
import org.example.listeners.keyboard.*;
import org.example.listeners.save_load.LoadListener;
import org.example.listeners.save_load.SaveListener;
import org.example.listeners.undoredo.RedoListener;
import org.example.listeners.undoredo.UndoListener;
import org.example.models.layers.CanvasMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;

@Getter
public class MainFrame extends JFrame {
    private JMenu jMenu;
    private JMenu edit;
    private JMenuBar jMenuBar;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem undo;
    private JMenuItem redo;
    private MenuPanel menuPanel;
    private EastPanel eastPanel;
    private NorthPanel northPanel;
    private CanvasMain mainCanvas;

    public MainFrame() throws HeadlessException {
        super("CanvasCraft Studio");

        setLayout(new BorderLayout());

        setSize(1200, 800);

        setMinimumSize(new Dimension(800, 600));

        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setMenuPanel();
        setCanvas();
        setEastPanel();
        setNorthPanel();
        jMenuSetup();
        JMenuEdit();

        setIconImage();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMenuPanel(){
        menuPanel = new MenuPanel(this);
        add(menuPanel, BorderLayout.SOUTH);
    }

    private void setCanvas(){
        mainCanvas = new CanvasMain(this);
        add(mainCanvas, BorderLayout.CENTER);
    }

    private void setEastPanel(){
        eastPanel = new EastPanel(this);
        add(eastPanel, BorderLayout.EAST);
    }

    private void setNorthPanel(){
        northPanel = new NorthPanel(this);
        add(northPanel, BorderLayout.NORTH);
    }

    private void jMenuSetup(){
        // create JMenuBar
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("File");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");

        SaveListener saveListener = new SaveListener(this);
        save.addActionListener(saveListener);

        LoadListener loadListener = new LoadListener(this);
        load.addActionListener(loadListener);

        jMenu.add(save);
        jMenu.add(load);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);

        shortcutSaveLoad();
    }

    private void JMenuEdit(){
        edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");

        UndoListener undoListener = new UndoListener(this);
        undo.addActionListener(undoListener);
        RedoListener redoListener = new RedoListener(this);
        redo.addActionListener(redoListener);

        edit.add(undo);
        edit.add(redo);
        this.jMenuBar.add(edit);

        shortcutUndoRedo();
    }

    private void shortcutUndoRedo(){
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        UndoKeyboardAction undoAction = new UndoKeyboardAction(this);
        RedoKeyboardListener redoAction = new RedoKeyboardListener(this);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK), "undo");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK), "redo");

        actionMap.put("undo", undoAction);
        actionMap.put("redo", redoAction);
    }

    private void shortcutSaveLoad(){
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        SaveKeyboardAction saveAction = new SaveKeyboardAction(this);
        LoadKeyboardAction loadAction = new LoadKeyboardAction(this);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "save");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), "load");

        actionMap.put("save", saveAction);
        actionMap.put("load", loadAction);
    }

    private void setIconImage(){
        ImageIcon icon16 = new ImageIcon(getClass().getResource("/icons/icon16.png"));
        ImageIcon icon24 = new ImageIcon(getClass().getResource("/icons/icon24.png"));
        ImageIcon icon32 = new ImageIcon(getClass().getResource("/icons/icon32.png"));
        ImageIcon icon64 = new ImageIcon(getClass().getResource("/icons/icon64.png"));
        this.setIconImages(Arrays.asList(icon16.getImage(), icon24.getImage(), icon32.getImage(), icon64.getImage()));
    }
}
