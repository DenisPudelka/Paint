package org.example.listeners;

import org.example.gui.MainFrame;
import org.example.listeners.general.GeneralEventListener;
import org.example.models.helpClasses.GeometryShape;
import org.example.models.enums.Shapes;
import org.example.models.layers.CanvasMain;
import org.example.models.layers.Layer;

import java.awt.event.MouseEvent;

public class CanvasListener extends GeneralEventListener {
    private MainFrame mainFrame;
    private int initialClickX;
    private int initialClickY;
    private int initialShapeX;
    private int initialShapeY;

    public CanvasListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        initialClickX = e.getX();
        initialClickY = e.getY();
        if (mainFrame.getMainCanvas().isMoveOption()) {
            GeometryShape shape = mainFrame.getMainCanvas().findShapeAt(e.getX(), e.getY());
            initialClickX = e.getX();
            initialClickY = e.getY();
            mainFrame.getMainCanvas().setCurrentShape(shape);
        } else if (mainFrame.getMainCanvas().isDeleteOption()) {
            GeometryShape shape = mainFrame.getMainCanvas().findShapeAt(e.getX(), e.getY());
            if(shape != null) {
                mainFrame.getMainCanvas().deleteSelectedShape(shape);
                mainFrame.getMainCanvas().setCurrentShape(null);
            }
        } else if (mainFrame.getMainCanvas().isBrushToolOption()){
            Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
            int radius = mainFrame.getMenuPanel().getSliderSizePanel().getSliderSize().getValue();
            if(currentLayer != null){
                currentLayer.startDrawingShape(mainFrame.getMainCanvas().getCurrentShapeEnums(), e.getX(), e.getY(), radius);
            }
        }else {
            Layer currentLayer = mainFrame.getMainCanvas().getLayersManager().getActiveLayer();
            if(currentLayer != null) {
                int radius = mainFrame.getMenuPanel().getSliderSizePanel().getSliderSize().getValue();
                mainFrame.getMainCanvas().startDrawingShape(e.getX(),e.getY(), radius);
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        CanvasMain canvas = mainFrame.getMainCanvas();
        if (canvas.isMoveOption()) {
            canvas.setCurrentShape(null);
        } else if (canvas.isBrushToolOption()) {
            Layer currentLayer = canvas.getLayersManager().getActiveLayer();
            if(currentLayer != null){
                currentLayer.finishDrawingShape();
            }
        }
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        CanvasMain canvas = mainFrame.getMainCanvas();
        if (canvas.isMoveOption() && canvas.getCurrentShapeEnums() != null) {
            GeometryShape shapeToMove = canvas.getLayersManager().getActiveLayer().getCurrentShape();
            if (shapeToMove != null) {
                int deltaX = e.getX() - initialClickX;
                int deltaY = e.getY() - initialClickY;
                shapeToMove.move(deltaX, deltaY);
                mainFrame.getMainCanvas().repaint();
                initialClickX = e.getX();
                initialClickY = e.getY();
            }
        } else if (canvas.isBrushToolOption()) {
            Layer currentLayer = canvas.getLayersManager().getActiveLayer();
            if(currentLayer != null){
                currentLayer.continueDrawingShape(e.getX(), e.getY());
            }
        }
    }

}
