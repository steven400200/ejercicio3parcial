package co.edu.uniquindo.proyectosubastaquindio.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SubastaQuindio implements Serializable {

    //--------------------------LISTA PRODUCTOS--------------------------

    ArrayList<Estudiante> listaEstudiantes =new ArrayList<Estudiante>();

    //-----------------------------METODOS-----------------

    public void limpiarLista(){
        listaEstudiantes.clear();
    }

    //------------------------------------GETTER Y SETTERS-----------------------------------------

    public ArrayList<Estudiante> getListaProductos() {
        return listaEstudiantes;
    }

    public void setListaProductos(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
