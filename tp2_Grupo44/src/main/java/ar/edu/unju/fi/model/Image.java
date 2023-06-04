package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Image {

    // region Attributes
    private String nombre;
    private String identificador;
    // endregion

    // region Constructors
    public Image() {
    }

    public Image(
            String nombre,
            String identificador) {

        this.nombre = nombre;
        this.identificador = identificador;

    }
    // endregion

    // region Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    };
    // endregion

    // region Methods
    // endregion

}
