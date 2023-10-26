package co.edu.uniquindo.proyectosubastaquindio.controller.service;

//import co.edu.uniquindio.banco.bancouq.mapping.dto.EmpleadoDto;
//import co.edu.uniquindio.banco.bancouq.model.Empleado;

import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;

import java.io.IOException;
import java.util.ArrayList;


public interface IModelFactoryService {
    public boolean agregarProducto(ArrayList<Estudiante>lista) throws IOException;
    public  ArrayList<Estudiante>ObtenerlistaProductosTxt() throws IOException;
    public void registrarAccionesSistema(String mensaje, int nivel, String accion);


}
