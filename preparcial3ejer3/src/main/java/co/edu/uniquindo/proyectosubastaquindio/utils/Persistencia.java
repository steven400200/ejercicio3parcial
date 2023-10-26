package co.edu.uniquindo.proyectosubastaquindio.utils;

/*import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioExcepcion;
import co.edu.uniquindio.banco.bancouq.model.*;*/
import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;

import co.edu.uniquindo.proyectosubastaquindio.model.Profesor;
import co.edu.uniquindo.proyectosubastaquindio.model.SubastaQuindio;
import co.edu.uniquindo.proyectosubastaquindio.model.enums.tipoArticulo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Persistencia {


//--------------------------------------RUTAS----------------------------------------
    public static final String RUTA_ARCHIVO_PRODUCTOS = "C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\archivos\\productos.txt";

    public static final String RUTA_ARCHIVO_MODELO_PRODCUTOS_XML="C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\model.xml";

    public static final  String RUTA_ARCHIVO_MODELO_BANCO_BINARIO="C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\model.dat";
    public static final String RUTA_ARCHIVO_LOG ="C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\archivos\\log.txt";

    public static final String RUTA_ARCHIVO_PROFESORES="C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\archivos\\profesore.txt";
    public static final String RUTA_ARCHIVO_ESTUDIANTES="co/edu/uniquindo/proyectosubastaquindio/persistencia/archivos/estudiantes.txt";

    public static final String RUTA_ARCHIVO_MATERIAS="C:\\Users\\Yeraldin Noguera\\Desktop\\programcion3\\preparcial3ejer3\\src\\main\\resources\\co\\edu\\uniquindo\\proyectosubastaquindio\\persistencia\\archivos\\materias.txt";

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
//-------------------------------------------GUARDAR ARCHIVOS------------------------------
    public static void guardarEstudiantes(ArrayList<Estudiante> listaClientes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";

        for(Estudiante estudiante:listaClientes)
        {
            contenido+= estudiante.getNombre()+"@@"+estudiante.getApellido()+"@@"+estudiante.getCodigo()+"@@"+estudiante.getCorreo()
                    +"@@"+estudiante.getEdad()+"@@"+estudiante.getTelefono()+"@@"+estudiante.getSexo()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
    }
    public static void guardarProfesor(ArrayList<Profesor> listaProfesores) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";

        for(Profesor profesor:listaProfesores)
        {
            contenido+= profesor.getNombre()+"@@"+profesor.getApellido()+"@@"+profesor.getCodigo()+"@@"+profesor.getCorreo()
                    +"@@"+profesor.getEdad()+"@@"+profesor.getTelefono()+"@@"+profesor.getSexo()+"@@"+profesor.getProfesion()+"@@"+profesor.getPrograma()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PROFESORES, contenido, false);
    }




//	----------------------CARGAR ARCHIVOS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static ArrayList<Estudiante> cargarEstudiante() throws FileNotFoundException, IOException
    {
        ArrayList<Estudiante> estudiantes =new ArrayList<Estudiante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(linea.split("@@")[0]);
            estudiante.setApellido(linea.split("@@")[1]);
            estudiante.setCodigo(linea.split("@@")[2]);
            estudiante.setCorreo(linea.split("@@")[3]);
            estudiante.setEdad(Integer.parseInt((linea.split("--")[4])));
            estudiante.setTelefono((linea.split("@@")[5]));
            estudiante.setSexo((linea.split("@@")[6]));
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    public static ArrayList<Profesor> cargarProfesor() throws FileNotFoundException, IOException
    {
        ArrayList<Profesor> profesors =new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROFESORES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Profesor profesor = new Profesor();
            profesor.setNombre(linea.split("@@")[0]);
            profesor.setApellido(linea.split("@@")[1]);
            profesor.setCodigo(linea.split("@@")[2]);
            profesor.setCorreo(linea.split("@@")[3]);
            profesor.setEdad(Integer.parseInt((linea.split("--")[4])));
            profesor.setTelefono((linea.split("--")[5]));
            profesor.setSexo((linea.split("@@")[6]));
            profesor.setProfesion((linea.split("@@")[7]));
            profesor.setPrograma((linea.split("@@")[8]));
            profesors.add(profesor);
        }
        return profesors;
    }
    //------------------------------REGISTRO LOG-----------------------------------------
    public static void guardaRegistroLog(String mensaje, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensaje, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACIÓN  y XML

//BINARIO
    public static SubastaQuindio cargarRecursoBancoBinario() {

        SubastaQuindio subastaQuindio= null;

        try {
            subastaQuindio = (SubastaQuindio) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastaQuindio;
    }

    public static void guardarRecursoBancoBinario(SubastaQuindio subastaQuindio) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, subastaQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


//XML
    public static void guardarRecursoBancoXML(SubastaQuindio subastaQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PRODCUTOS_XML, subastaQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static ArrayList<String> archivoPropiedades() {
        ResourceBundle resourceBundle;


        resourceBundle = ResourceBundle.getBundle("loggin", new Locale("",""));
       String usuario= resourceBundle.getString("usuario");
        String clave =resourceBundle.getString("clave");
        ArrayList<String>info=new ArrayList<>();
        info.add(usuario);
        info.add(clave);
        return info;
    }










}
