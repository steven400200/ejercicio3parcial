package co.edu.uniquindo.proyectosubastaquindio.controllersView;

import co.edu.uniquindo.proyectosubastaquindio.utils.Persistencia;
import javafx.application.Application;
import javafx.css.Stylesheet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class SubastaQuindioAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SubastaQuindioAplication.class.getResource("productoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 650);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        //RESPALDO
        launch();}


}
        



