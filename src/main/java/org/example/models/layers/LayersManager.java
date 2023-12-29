package org.example.models.layers;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.MainFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LayersManager implements Serializable {
    private List<Layer> layers;
    private transient MainFrame mainFrame;
    private Layer activeLayer;

    public LayersManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.layers = new ArrayList<>();
        Layer initialLayer = new Layer(mainFrame, true, 1);
        this.layers.add(initialLayer);
        this.activeLayer = initialLayer;
    }

    public Layer addLayer(){
        Layer newLayer = new Layer(this.mainFrame, true, layers.size()+1);
        this.layers.add(newLayer);
        return newLayer;
    }

    public void removeLayer(int indexLayer){
        if(indexLayer >= 0 && indexLayer < layers.size()){
            layers.remove(indexLayer);
        }
        if(!layers.isEmpty()){
            activeLayer = layers.get(layers.size() - 1);
        }else{
            activeLayer = null;
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
}
