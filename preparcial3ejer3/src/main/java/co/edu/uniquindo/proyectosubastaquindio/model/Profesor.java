package co.edu.uniquindo.proyectosubastaquindio.model;

import java.io.Serializable;

public class Profesor extends Estudiante implements Serializable {
    private String programa;
    private String profesion;

    public Profesor()  {
        // Constructor vacío
    }

    public Profesor(String nombre, String apellido, char sexo, int edad, String codigo, String correo, String telefono, String programa, String profesion) {
        super(nombre, apellido, sexo, edad, codigo, correo, telefono);
        this.programa = programa;
        this.profesion = profesion;
    }

    // Getters y setters adicionales
    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
