package org.example.models.layers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.listeners.CanvasListener;
import org.example.models.abstractClasses.GeometryShape;
import org.example.models.color_palette.PaletteManager;
import org.example.models.enums.Shapes;
import org.example.models.undoredo.CommandManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;

@Getter
@Setter
@NoArgsConstructor
public class CanvasMain extends JPanel implements Serializable {
    private LayersManager layersManager;
    private transient MainFrame mainFrame;
    private Shapes currentShapeEnums;
    private boolean moveOption;
    private boolean deleteOption;
    private boolean brushToolOption;
    private transient CommandManager commandManager;
    private PaletteManager paletteManager;

    public CanvasMain(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setBackground(Color.WHITE);

        LayersManager initialLayerManager = new LayersManager(mainFrame);
        this.layersManager = initialLayerManager;

        this.commandManager = new CommandManager();

        this.paletteManager = new PaletteManager();

        listenersSetup();
        currentShapeEnums = Shapes.CIRCLE;
        moveOption = false;
        deleteOption = false;
        brushToolOption = false;
    }

    private void listenersSetup(){
        CanvasListener canvasListener = new CanvasListener(mainFrame);
        addMouseMotionListener(canvasListener);
        addMouseListener(canvasListener);
    }

    public void toggleMoveOption() {
        this.moveOption = !moveOption;
    }
    public void toggleDeleteOption() {
        this.deleteOption = !deleteOption;
    }
    public void toggleBrushOption() {
        this.brushToolOption = !brushToolOption;
    }

    public GeometryShape findShapeAt(int x, int y) {
        Layer activeLayer = layersManager.getActiveLayer();
        if(activeLayer != null){
            return activeLayer.findShapeAt(x,y);
        }
        return null;
    }

    public void deleteSelectedShape(GeometryShape shape) {
        Layer activeLayer = layersManager.getActiveLayer();
        if(activeLayer != null){
            activeLayer.deleteSelectedShape(shape);
        }
        repaint();
    }

    public void startDrawingShape(int x,int y,int radius){
        Layer activeLayer = layersManager.getActiveLayer();
        if(activeLayer != null){
            activeLayer.startDrawingShape(this.currentShapeEnums, x,y,radius);
        }
        repaint();
    }

    public void setCurrentShape(GeometryShape shape) {
        Layer activeLayer = layersManager.getActiveLayer();
        if(activeLayer != null) {
            activeLayer.setCurrentShape(shape);
        }
    }

    public void saveCanvas(File file){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this.layersManager);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadCanvas(File file){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            LayersManager loadLayersManager = (LayersManager) in.readObject();
            this.layersManager = loadLayersManager;
            for (Layer layer : this.layersManager.getLayers()) {
                layer.setMainFrame(this.mainFrame);
                layer.setManager(new CommandManager());
            }
            this.layersManager.setMainFrame(this.mainFrame);
            this.commandManager = new CommandManager();
            repaint();
        }catch (IOException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Layer activeLayer = layersManager.getActiveLayer();
        if(activeLayer != null && activeLayer.isVisible()) {
            for (Layer layer : this.layersManager.getLayers()) {
                if (layer.isVisible()) {
                    layer.paintComponent(graphics2D);
                }
            }
        }
    }
}
