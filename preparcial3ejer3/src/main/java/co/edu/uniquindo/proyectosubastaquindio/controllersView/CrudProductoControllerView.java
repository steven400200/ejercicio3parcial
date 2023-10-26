

package co.edu.uniquindo.proyectosubastaquindio.controllersView;


import co.edu.uniquindo.proyectosubastaquindio.model.Estudiante;
import co.edu.uniquindo.proyectosubastaquindio.model.enums.tipoArticulo;
import co.edu.uniquindo.proyectosubastaquindio.utils.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import co.edu.uniquindo.proyectosubastaquindio.controller.crudProductoController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CrudProductoControllerView implements Initializable {


    //-----------------------------atributo globales-----------------------------
    private crudProductoController productoControllerService;
    //listas
    private  ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
    private   ArrayList<Estudiante> listaEstudiantes =new ArrayList<>();

    crudProductoController crudProductoController=new crudProductoController();


    //---------------------------------atributos fxml-----------------------------

    @FXML
    private DatePicker dateFechaFinal;

    @FXML
    private DatePicker dateFechaInical;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnImportar;

    @FXML
    private ComboBox<tipoArticulo> comboTipoProducto;

    @FXML
    private ImageView imgFoto;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblFcehaInicial;

    @FXML
    private Label lblFechaInicial;

    @FXML
    private Label lblNombreAnunciante;

    @FXML
    private Label lblNombreProducto;

    @FXML
    private Label lblTipoProducto;

    @FXML
    private Label lblUrlFoto;

    @FXML
    private Label lblValor;

    @FXML
    private Pane paneBotones;

    @FXML
    private Pane paneCampos;

    @FXML
    private Pane panePrincipal;

    @FXML
    private Pane paneTable;

    @FXML
    private TableView<Estudiante> tableDatos;

    @FXML
    private TableColumn<Estudiante, String> columnaUno;

    @FXML
    private TableColumn<Estudiante, String> columnaDos;

    @FXML
    private TableColumn<Estudiante, String> columnaTres;

    @FXML
    private TableColumn<Estudiante, String> columnaCuatro;

    @FXML
    private TableColumn<Estudiante, String> columnaCinco;

    @FXML
    private TableColumn<Estudiante, String> columna6;

    @FXML
    private TableColumn<Estudiante, String> columna7;

    @FXML
    private TableColumn<Estudiante, String> columna8;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombreAnunciante;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtUrlFoto;

    @FXML
    private TextField txtValor;
    //-----------------------------------------------


    @FXML
    private Button btnEntrar;





    @FXML
    private Label lblContraseña;


    @FXML
    private Label lblusuario;


    @FXML
    private TextField txtContraseña;



    @FXML
    private TextField txtUsuario;

    @FXML
    private Pane panellogin;



    @FXML
    void entrar(ActionEvent event) {
        ArrayList<String> info=Persistencia.archivoPropiedades();
        String usuario=info.get(0);
        String clave= info.get(1);
        System.out.println(usuario +""+clave);
        if(txtUsuario.getText().equals(usuario)&& txtContraseña.getText().equals(clave)){
            panePrincipal.setDisable(false);

        }


    }


    // -----------------------------atributos java---------------------------------------

    //se crean atributos para obtener campos de texto
    private String  nombreProducto="";
    private String  descripcion="";
    private String  nombreAnunciante="";
    private String urlFoto="";
    private LocalDate fechaInicial=null;
    private LocalDate fechaFinal=null;
    private tipoArticulo tipoProducto =null;
    private float valorInicial=0;

    // se crea un objeto para poder manipular, la diferentes acciones
    private Estudiante estudianteActualizado =new Estudiante();
    private Estudiante estudianteSeleccionadoTabla = new Estudiante();




//---------------------------------------------------------------ACTUALIZAR--------------------------------------------------

//------------------------------------------------------AGREGAR-------------------------------------------------------------
    @FXML
    void agregar(ActionEvent event) throws IOException {
        //para que puedan editar el nombre
        txtNombreProducto.setDisable(false);

        //se guarda lo que se escribio en los txt
        nombreProducto= txtNombreProducto.getText();
        descripcion= txtDescripcion.getText();
        nombreAnunciante= txtNombreAnunciante.getText();
        urlFoto=txtUrlFoto.getText();
        fechaInicial = dateFechaInical.getValue();
        fechaFinal=dateFechaFinal.getValue();
        tipoProducto =comboTipoProducto.getValue();
        valorInicial=0;

        //se validan que todos los campos se hallan rellenado
         if (datosValidos() ) {
            try {
                //se captura exception si  en el campo de valor ingresan letras
                 valorInicial = Float.parseFloat(txtValor.getText());

                 // se verifica que el prodcuto no halla sido creado
                if( crudProductoController.verificarProductoCreado(nombreProducto)){

                    listaEstudiantes.clear();

                    //se manda la informacion del prodcuto al controllador
                  listaEstudiantes.addAll(crudProductoController.guardarProducto(nombreProducto,descripcion,nombreAnunciante,fechaInicial,fechaFinal,valorInicial, tipoProducto,urlFoto));

                    //se limbia el observableList para no sobreescribir la info en la tabla
                    estudiantes.clear();

                    // se agrega la informacion al observable
                    estudiantes.addAll(listaEstudiantes);

                    //se agrega la informaciona  la tabla
                    columnaUno.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
                    columnaDos.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
                    columnaTres.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("sexo"));
                    columnaCuatro.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("edad"));
                    columnaCinco.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("codigo"));
                    columna6.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("correo"));
                    columna7.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("telefono"));
                    tableDatos.setItems(estudiantes);

                    //se registra en el log que  se guardo un producto
                    registrarAcciones("Producto agregado",1, "Agregar Producto");
                    mostrarMensaje("Crear Producto","Producto creado","El producto fue creado ",Alert.AlertType.CONFIRMATION);
                    limpiarCamposProducto();

                }else {
                    mostrarMensaje("Crear Producto","El producto no se puede crear","Hay un prodcuto existente con el nombre "+nombreProducto+" \nCambiar el nombre",Alert.AlertType.INFORMATION);
                }


            // se envian mesnajes y registro del log, del manejo de la exception
            } catch (NumberFormatException e) {
                mostrarMensaje("Datos invalidos","campo valor","no se pueden ingresar letras \nen el campo valor debe ingresar un valor numerico", Alert.AlertType.ERROR);
                registrarAcciones("Exception Producto campo numerico",1, "En un campo llamado valor en la view de prodcuto se lanza exception por que ingresan letras y deben ser numeros");
            }
        }




    }
//-----------------------------------------------------------------ELIMINAR-----------------------------------
    @FXML
    void eliminar(ActionEvent event) throws IOException {

    }

    //----------------------------------------------IMPORTAR-----------------------------------------------------------------

    @FXML
    void importar(ActionEvent event) {




    }

    //-------------------------------------------------SELECCIONAR--------------------------------------------------------
    @FXML
    void selccionar(MouseEvent event) {

    }

    //--------------------------------------------------INITIALIZABLE----------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panePrincipal.setDisable(true);
        //se inicializan  objetos y clases
        comboTipoProducto.getItems().addAll(tipoArticulo.values());
        productoControllerService=new crudProductoController();


        try {
            //se cargan los prodcutos y se muestran en la tabla
            listaEstudiantes = crudProductoController.obtenerListaProductosTxt();
            estudiantes.addAll(listaEstudiantes);
            columnaUno.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombreProducto"));
            columnaDos.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("descripcion"));
            columnaTres.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("nombreAnunciante"));
            columnaCuatro.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("valorInicial"));
            columnaCinco.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("fechaPublicacion"));
            columna6.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("fechaFinalizacion"));
            columna7.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("tipo_Articulo"));
            columna8.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("urlFoto"));
            tableDatos.setItems(estudiantes);

            registrarAcciones("Productos cargados",1, "se carga la informacion del txt");

            limpiarCamposProducto();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //-----------------------------------------------log---------------------------------------------------------------

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        productoControllerService.registrarAcciones(mensaje, nivel, accion);

    }

    //------------------------------codigo reutilizable---------------------------------------
   //limpiar campos de texto
    private void limpiarCamposProducto() {
        txtNombreProducto.setText("");
        txtNombreAnunciante.setText("");
        txtUrlFoto.setText("");
        txtDescripcion.setText("");
        txtValor.setText("");
        dateFechaInical.setValue(null);
        dateFechaFinal.setValue(null);

    }

    //validar que no esten en campos nulls o vacios
    private boolean datosValidos() {
        String mensaje = "";
        if (txtNombreProducto.getText() == null || txtNombreProducto.getText() .equals(""))
            mensaje += "El campo del nombre debe rellnarlo  \n";
        if (txtDescripcion.getText() == null || txtDescripcion.getText().equals(""))
            mensaje += "El campo de la descripcion debe rellenarlo \n";
        if (txtUrlFoto.getText() == null || txtUrlFoto.getText().equals(""))
            mensaje += "El campo de url debe rellenarlo \n";
        if (dateFechaInical.getValue() == null)
            mensaje += "Debe escojer una fecha de publicacion  \n";
        if (dateFechaFinal.getValue() == null)
            mensaje += "Debe escojer una fecha de finalizacion \n";
        if (comboTipoProducto.getValue() == null)
            mensaje += "Debe escojer un tipo de producto \n";
        if(txtValor.getText()==null||txtValor.getText().equals(""))
            mensaje+="Debe  rellenar el campo vaor \n";
        if(txtNombreAnunciante.getText()==null||txtNombreProducto.getText().equals(""))
            mensaje+="Debe rellenar el campo de nombre anunciante"+"\n";
        if (mensaje.equals("")) {
            return true;
        } else {
            mostrarMensaje("Notificación cliente", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    //enviamos un mensaje
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }





}

