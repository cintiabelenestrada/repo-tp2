package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "categorias")
public class Categoria {

    //#region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_identificador")
    private long identificador;

    @Column(name = "categoria_estado")
    private boolean estado;

    @NotEmpty(message = "Debes introducir un nombre")
	@Size(min = 5, max = 15, message = "El nombre solo puede contener entre 5 y 15 caracteres")
	@Pattern(regexp = "[a-zA-Z]+", message = "Debe contener solo letras")
    @Column(name = "categoria_nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> listaProductos;
    //#endregion

    //#region Constructors
    public Categoria() {
        this.estado = true;
    }

    public Categoria(
            long identificador,
            boolean estado,
            String nombre,
            List<Producto> listaProductos) {

        this.identificador = identificador;
        this.estado = estado;
        this.nombre = nombre;
        this.listaProductos = listaProductos;

    }
    //#endregion

    //#region Getters and Setters
    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    //#endregion

}
