package co.edu.uniquindo.proyectosubastaquindio.controller;

import co.edu.uniquindo.proyectosubastaquindio.controller.service.IcrudProdcutoController;
import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;
import co.edu.uniquindo.proyectosubastaquindio.model.enums.tipoArticulo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class crudProductoController  {

    //-----------------------------------------VARABLES GLOBALES---------------------------------------------------------------
    static ModelfactoryController modelfactoryController = new ModelfactoryController();
     ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    //--------------------------------------------------GUARDAR PRODUCTOS----------------------------------------
     public ArrayList<Estudiante> guardarProducto(String nombre, String apellido, String sexo, int edad, String codigo, String correo, String telefono) throws IOException {
        //SE crea un producto y se le agrega la informacion que llega por parametros
        Estudiante estudiante = new Estudiante( nombre,  apellido,  sexo,  edad,  codigo,  correo,  telefono);
        //se llama al modelfactory para poder obtener la informacion del txt de prodcutos
        listaEstudiantes = modelfactoryController.ObtenerlistaProductosTxt();
        listaEstudiantes.add(estudiante);
        //se le vuelve a llamar el model factory para guardar la lista de productos en el txt
        modelfactoryController.agregarProducto(listaEstudiantes);
        return listaEstudiantes;

    }

    //-------------------------------------VERIFICAR PRODCUTO CREADO----------------------------------------
     public boolean verificarProductoCreado(String nombre) throws IOException {
        //se llama al modelfactory para poder obtener la informacion del txt de prodcutos
        listaEstudiantes = modelfactoryController.ObtenerlistaProductosTxt();

        // se busca a informacion con la lista obtenida
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getNombre().equals(nombre)) {
                modelfactoryController.agregarProducto(listaEstudiantes);
                return false;

            }
        }
        //se le vuelve a llamar el model factory para guardar la lista de productos en el txt
        modelfactoryController.agregarProducto(listaEstudiantes);
        return true;

    }

    //------------------------------------ACTUALIZAR PRODUCTO-----------------------------------------------


    //----------------------------------ELIMINAR PRODUCTO-----------------------------------------------------


    //-----------------------------OBTENER INFORMACION DE PRODCUTOS DESDE EL TXT---------------------------------------------------
     public ArrayList<Estudiante> obtenerListaProductosTxt() throws IOException {
        ArrayList<Estudiante> listaProductosTxt = modelfactoryController.ObtenerlistaProductosTxt();
        return listaProductosTxt;
    }


    //--------------------------------------------LOG--------------------------------------------------------------------------
    public void registrarAcciones(String mensaje, int nivel, String accion) {
        modelfactoryController.registrarAccionesSistema(mensaje, nivel, accion);
    }


}
