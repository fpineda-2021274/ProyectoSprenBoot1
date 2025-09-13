package com.franklinpineda.ConsesonariaP.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "repuesto")
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRepuesto;

    @Column
    @NotBlank(message = "El nombre del repuesto no puede estar vacío")
    private String nombreRepuesto;

    @Column
    @NotBlank(message = "La descripción del repuesto no puede estar vacía")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "idCategoria", foreignKey = @ForeignKey(name = "FK_repuesto_categoria"))
    private Categoria categoria;

    // Getters y Setters
    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}