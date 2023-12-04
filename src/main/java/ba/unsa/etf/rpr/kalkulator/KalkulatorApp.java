package ba.unsa.etf.rpr.kalkulator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;

import static java.lang.Double.parseDouble;

public class KalkulatorApp extends Application {

    private Double prvi;
    private String odabrani;
    private boolean unos;

    @FXML
    private TextField display;

    public KalkulatorApp() {
        prvi = 0.0;
        odabrani = "";
        unos = false;
    }

    @FXML
    public void onButtonClick(javafx.event.ActionEvent klik) {
        javafx.scene.control.Button button = (javafx.scene.control.Button) klik.getSource();
        String tekst = button.getText();

        if (tekst.matches("[0-9\\.]")) {
            if (!unos) {
                unos = true;
                display.clear();
            }
            display.appendText(tekst);
        } else if (tekst.matches("[＋－×÷%]")) {
            prvi = parseDouble(display.getText());
            odabrani = tekst;
            unos = false;
        } else if (tekst.equals("=")) {
            Double drugi;
            if (unos) {
                drugi = parseDouble(display.getText());
            } else {
                drugi = prvi;
            }
            prvi = izracunaj(odabrani, prvi, drugi);

            String result = removeTrailingZeros(prvi.toString());
            display.setText(result);

            unos = false;
        }
    }


    static Double izracunaj(String operator, Double a, Double b) {
        switch (operator) {
            case "＋":
                return a + b;
            case "－":
                return a - b;
            case "×":
                return a * b;
            case "÷":
                return a / b;
            case "%":
                return a % b;
            default:
        }
        return b;
    }

    private static String removeTrailingZeros(String value) {
        if (value.indexOf('.') > 0) {
            value = value.replaceAll("0*$", "").replaceAll("\\.$", "");
        }
        return value;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KalkulatorApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
