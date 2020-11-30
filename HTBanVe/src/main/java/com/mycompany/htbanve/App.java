 package com.mycompany.htbanve;

import com.mycompany.htbanve.service.JdbcUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Muave"));
//        Scene scene = new Scene(root);
        
//        stage.setOnHidden(et ->{
//                Connection conn = null;
//            try {
//                conn = (Connection) JdbcUtils.getDataQLCXs();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                if(conn != null)
//                    try {
//                        conn.close();
//                    } catch (SQLException ex){
//                        
//                    }
//        });
        scene = new Scene(loadFXML("TrangChu"), 640, 480);
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
        launch();
    }

}