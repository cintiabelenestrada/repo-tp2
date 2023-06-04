package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Image;

@Component
public class ImageList {

    // region Attributes
    private List<Image> imagenes;
    // endregion

    // region Constructors
    public ImageList() {

        this.imagenes = new ArrayList<Image>();

        imagenes.add(
                new Image(
                        "/images/sucursales-jujuy.png",
                        "Jujuy"));

        imagenes.add(
                new Image(
                        "/images/sucursales-salta.png",
                        "Salta"));

        imagenes.add(
                new Image(
                        "/images/sucursales-tucuman.jpg",
                        "Tucuman"));

    }
    // endregion

    // region Getters and Setters
    public List<Image> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Image> imagenes) {
        this.imagenes = imagenes;
    }
    // endregion

}
