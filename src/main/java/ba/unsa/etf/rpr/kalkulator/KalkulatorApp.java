package ba.unsa.etf.rpr.kalkulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KalkulatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KalkulatorApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        Thread.sleep(t);
    }
}