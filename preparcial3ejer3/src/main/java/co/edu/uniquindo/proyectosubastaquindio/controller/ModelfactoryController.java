package co.edu.uniquindo.proyectosubastaquindio.controller;
import co.edu.uniquindo.proyectosubastaquindio.controller.service.ISubastaQuindioControllerService;
import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;
import co.edu.uniquindo.proyectosubastaquindio.model.SubastaQuindio;
import co.edu.uniquindo.proyectosubastaquindio.utils.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelfactoryController {


//------------------------------singlentton clase secreta------------------------------------
    private static class SingletonHolder implements ISubastaQuindioControllerService {
        private final static ModelfactoryController eINSTANCE = new ModelfactoryController();
    }

    SubastaQuindio subastaQuindio= new SubastaQuindio();

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {

        Persistencia.guardaRegistroLog(mensaje, nivel, accion);

    }
    //inicializador de variables



    // contrutor
    public ModelfactoryController() {
        //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();




        }
//------------------------------------------AGREGAR PRODUCTO-------------------------------------
    //se limpia la lista de subasta quindio, luego la que recibimos por parametros, se la seteamos
    public boolean agregarProducto(ArrayList<Estudiante>lista) throws IOException {

            subastaQuindio.limpiarLista();
           subastaQuindio.setListaProductos(lista);
            guardarResourceXML();
            guardarResourceBinario();
            //guardar en archico de txt
            Persistencia.guardarEstudiantes(subastaQuindio.getListaProductos());
            return true;
    }
    //----------------------------------------Obttener empleado txt---------------------
    public ArrayList<Estudiante>ObtenerlistaProductosTxt() throws IOException {
        ArrayList<Estudiante>productosTxt=Persistencia.cargarEstudiante();
        return  productosTxt;

    }

    //-----------------------------GUARDADO EN ARCHIVOS XML Y BINARIO----------------------------------------------
    //Xml
    private void guardarResourceXML() {
        Persistencia.guardarRecursoBancoXML(getSubastaQuindio(subastaQuindio));
    }

   //Binario
    private void guardarResourceBinario() {
        Persistencia.guardarRecursoBancoBinario(subastaQuindio);
    }
    private void cargarResourceBinario() {
        subastaQuindio = Persistencia.cargarRecursoBancoBinario();
    }


    //------------------------------------GETTER Y SETTERS---------------------------
    public SubastaQuindio getSubastaQuindio(SubastaQuindio subastaQuindio) {
        return this.subastaQuindio;
    }

    public void setSubastaQuindio(SubastaQuindio subastaQuindio) {
        this.subastaQuindio = subastaQuindio;
    }
}
