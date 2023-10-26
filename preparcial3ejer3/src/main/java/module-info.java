module co.edu.uniquindio.proyectosubastaquindio {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindo.proyectosubastaquindio.controllersView;
    exports co.edu.uniquindo.proyectosubastaquindio.controllersView ;
    opens  co.edu.uniquindo.proyectosubastaquindio.model ;
    exports co.edu.uniquindo.proyectosubastaquindio.model;



}