package co.edu.uniquindo.proyectosubastaquindio.controller.service;

import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;
import co.edu.uniquindo.proyectosubastaquindio.model.enums.tipoArticulo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IcrudProdcutoController {

     public ArrayList<Estudiante> guardarProducto(String nombreProdcuto, String descripcion, String nombreAnunciante, LocalDate fechaPublicacion, LocalDate fechaFinalizacion, float valorInicial, tipoArticulo tipo_Articulo, String url) throws IOException;

     public boolean verificarProductoCreado(String nombre) throws IOException ;

    public ArrayList<Estudiante> actualizarProducto(Estudiante p1) throws IOException;

    public ArrayList<Estudiante> eliminarProdcuto(Estudiante p1) throws IOException;

    public ArrayList<Estudiante> obtenerListaProductosTxt() throws IOException;

    void registrarAcciones(String mensaje, int nivel, String accion);
}

