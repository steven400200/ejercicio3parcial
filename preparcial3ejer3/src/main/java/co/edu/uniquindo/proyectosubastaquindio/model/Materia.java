package co.edu.uniquindo.proyectosubastaquindio.model;

import java.io.Serializable;

public class Materia implements Serializable {
    private String nombre;
    private String codigo;
    private String intensidadHoraria;
    private String tipo;

    public Materia() {
    }

    public Materia(String nombre, String codigo, String intensidadHoraria, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.intensidadHoraria = intensidadHoraria;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(String intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
