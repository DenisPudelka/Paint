package org.example.models.layers;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class LayersManager implements Serializable {
    private List<Layer> layers;
    private transient MainFrame mainFrame;
    private Layer activeLayer;
    private int nextLayerId;

    public LayersManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.layers = new ArrayList<>();
        Layer initialLayer = new Layer(mainFrame, true, 1);
        this.layers.add(initialLayer);
        this.activeLayer = initialLayer;
        this.nextLayerId = 2;
    }

    public Layer addLayer(){
        Layer newLayer = new Layer(this.mainFrame, true, nextLayerId++);
        this.layers.add(newLayer);
        return newLayer;
    }

    public void removeLayer(Layer deleteLayer){
        Iterator<Layer> iterator = layers.iterator();
        while (iterator.hasNext()){
            Layer layer = iterator.next();
            if(layer.getId() == deleteLayer.getId()){
                iterator.remove();
                break;
            }
        }
    }

    public Layer getActiveLayer(){
        return activeLayer;
    }

    public void setActiveLayer(Layer newActiveLayer){
        this.activeLayer = newActiveLayer;
    }

    public List<Layer> renderAll(){
        return this.layers;
    }

    public void clearLayers() {
        layers.clear();
        nextLayerId = 1;
        Layer initialLayer = new Layer(mainFrame, true, nextLayerId++);
        layers.add(initialLayer);
        activeLayer = initialLayer;
    }
}
