package ba.unsa.etf.rpr;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import javafx.application.Application;

import java.io.IOException;

public class KalkulatorApp extends Application {

    public void start(Stage stage) throws  IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KalkulatorApp.class.getResource("kalkulator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
