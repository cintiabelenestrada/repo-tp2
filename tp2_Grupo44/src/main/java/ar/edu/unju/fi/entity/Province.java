package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "provincias")
public class Province {

    // #region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "identificador")
    private Long identificador;

    // @Column(name = "estado", columnDefinition = "boolean default true")
    private boolean estado;

    // @Column(name = "nombre")
    private String nombre;

    @OneToOne(mappedBy = "provincia")
    private Branch sucursal;
    // #endregion

    // #region Constructors
    public Province() {
        this.estado = true;
    }

    public Province(
            Long identificador,
            boolean estado,
            String nombre,
            Branch sucursal) {

        this.identificador = identificador;
        this.estado = estado;
        this.nombre = nombre;
        this.sucursal = sucursal;

    }
    // #endregion

    // #region Getters and Setters
    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
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

    public Branch getSucursal() {
        return sucursal;
    }

    public void setSucursal(Branch sucursal) {
        this.sucursal = sucursal;
    }
    // #endregion

}
