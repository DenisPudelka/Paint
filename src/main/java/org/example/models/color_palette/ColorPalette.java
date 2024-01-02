package org.example.models.color_palette;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ColorPalette {
    private String name;
    private List<Color> colors;

    public ColorPalette(String name) {
        this.name = name;
        this.colors = new ArrayList<>();
        initializeDefaultColors();
    }

    public ColorPalette(String name, boolean empty) {
        this.name = name;
        this.colors = new ArrayList<>();
        if(!empty) {
            initializeDefaultColors();
        }
    }

    private void initializeDefaultColors(){
        this.colors.add(new Color(239,118,122));
        this.colors.add(new Color(69,105,114));
        this.colors.add(new Color(73,190,170));
        this.colors.add(new Color(73,220,177));
        this.colors.add(new Color(238,184,104));
    }

    public void addColor(Color color){
        this.colors.add(color);
    }

    public void removeColor(Color color){
        this.colors.remove(color);
    }
}
