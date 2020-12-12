 package com.mycompany.htbanve;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
<<<<<<< HEAD
        scene = new Scene(loadFXML("ChonChucNang"), 600, 400);
=======
        scene = new Scene(loadFXML("Login"), 600, 400);
>>>>>>> a536602cb47bb7472a8d04968f7e4db0b5639504
=======
        scene = new Scene(loadFXML("Login"), 600, 400);
>>>>>>> c5f908bad36a8657c677cd95d44c4f8a5715b39d
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}