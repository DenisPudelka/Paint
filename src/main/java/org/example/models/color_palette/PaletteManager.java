package org.example.models.color_palette;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaletteManager {
    private List<ColorPalette> palette;
    private ColorPalette currentColorPalette;

    public PaletteManager() {
        this.palette = new ArrayList<>();
        ColorPalette initialPalette = new ColorPalette("Initial Palette");
        this.palette.add(initialPalette);
        this.currentColorPalette = initialPalette;
    }

    public ColorPalette getPaletteByName(String name){
        for(ColorPalette p : palette){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    public void addPalette(ColorPalette colorPalette){
        this.palette.add(colorPalette);
    }

    public void removePalette(ColorPalette colorPalette){
        this.palette.remove(colorPalette);
    }

    public void setCurrentPallete(ColorPalette colorPalette){
        this.currentColorPalette = colorPalette;
    }

    public void resetToDefaultPalette() {
        palette.clear();
        ColorPalette initialPalette = new ColorPalette("Initial Palette");
        palette.add(initialPalette);
        currentColorPalette = initialPalette;
    }
}
