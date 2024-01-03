package org.example.models.layers;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;
import org.example.models.brushes.BasicBrushStrategy;
import org.example.models.brushes.BrushStrategy;
import org.example.models.helpClasses.ColorFactory;
import org.example.models.helpClasses.GeometryShape;
import org.example.models.brushes.Brush;
import org.example.models.enums.Shapes;
import org.example.models.interfaces.Command;
import org.example.models.shapes.*;
import org.example.models.undoredo.BrushStrokeCommand;
import org.example.models.undoredo.CommandManager;
import org.example.models.undoredo.DeleteCommand;
import org.example.models.undoredo.DrawShapeCommand;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Layer extends JPanel implements Serializable {
    private boolean visible;
    private int id;
    private transient MainFrame mainFrame;
    private List<GeometryShape> layerShapeList;
    private Brush currentBrushStroke;
    private GeometryShape currentShape;
    private transient CommandManager manager;
    private Color currentColor;

    public Layer(MainFrame mainFrame, boolean visible, int id) {
        this.mainFrame = mainFrame;
        this.visible = visible;
        this.id = id;
        this.layerShapeList = new ArrayList<>();
        this.manager = new CommandManager();
        this.currentColor = Color.RED;
    }

    public void startDrawingShape(Shapes currentShape, int x, int y, int radius){
        GeometryShape shape = createShape(currentShape, x, y, radius,currentColor);
        if(shape != null){
            Command drawCommand = new DrawShapeCommand(this, shape);
            this.manager.execute(drawCommand);
        }
    }

    public GeometryShape createShape(Shapes currentShape, int x, int y, int radius, Color color){
        Color colorFlyweight = ColorFactory.getColor(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue());

        GeometryShape shape;
        switch (currentShape){
            case HOURGLASS:
                shape = new Hourglass(x,y,radius, colorFlyweight);
                break;
            case TREE:
                shape = new Tree(x,y,radius, colorFlyweight);
                break;
            case HOUSE:
                shape = new House(x,y,radius, colorFlyweight);
                break;
            case STAR:
                shape = new Star(x,y,radius, colorFlyweight);
                break;
            case SQUARE:
                shape = new Square(x,y,radius, colorFlyweight);
                break;
            case TURTLE:
                shape = new Turtle(x,y,radius, colorFlyweight);
                break;
            case CIRCLE:
                shape = new Circle(x,y,radius, colorFlyweight);
                break;
            case BASIC_BRUSH:
                BrushStrategy basicBrushStrategy = new BasicBrushStrategy(radius, colorFlyweight);
                shape = new Brush(x,y, basicBrushStrategy);
                currentBrushStroke = (Brush) shape;
                break;
            default:
                shape = null;
                break;
        }
        return shape;
    }

    public void addShape(GeometryShape shape){
        layerShapeList.add(shape);
        mainFrame.repaint();
    }

    public void removeShape(GeometryShape shape){
        layerShapeList.remove(shape);
        mainFrame.repaint();
    }

    public GeometryShape findShapeAt(int x, int y) {
        for (GeometryShape shape : layerShapeList) {
            if (shape.containsPoint(x, y)) {
                currentShape = shape;
                return shape;
            }
        }
        return null;
    }

    public void deleteSelectedShape(GeometryShape shape) {
        currentShape = shape;
        if (currentShape != null) {
            Command deleteCommand = new DeleteCommand(shape, this);
            this.manager.execute(deleteCommand);
            currentShape = null;
        }
    }

    public void setCurrentShape(GeometryShape shape) {
        this.currentShape = shape;
    }

    public void continueDrawingShape(int x, int y){
        if(currentBrushStroke != null){
            currentBrushStroke.addPoint(x,y);
            mainFrame.repaint();
        }
    }

    public void finishDrawingShape() {
        if (currentBrushStroke != null) {
            BrushStrokeCommand command = new BrushStrokeCommand(this, currentBrushStroke);
            manager.execute(command);
            currentBrushStroke = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for(GeometryShape shape : layerShapeList) {
            shape.draw(graphics2D);
        }
    }

}
