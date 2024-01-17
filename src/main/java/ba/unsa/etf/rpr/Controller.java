package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static java.lang.Double.parseDouble;


public class Controller  {

    private Double prvi;
    private String odabrani;
    private boolean unos;

    @FXML
    private TextField rezultat;

    public Controller() {
        prvi = 0.0;
        odabrani = "";
        unos = false;
    }

    @FXML
    public void onButtonClick(ActionEvent klik) {
        Button button = (Button) klik.getSource();
        String tekst = button.getText();

        if (tekst.matches("[0-9\\.]")) {
            if (!unos) {
                unos = true;
                rezultat.clear();
            }
            rezultat.appendText(tekst);
        } else if (tekst.matches("[＋－×/%]")) {
            prvi = parseDouble(rezultat.getText());
            odabrani = tekst;
            unos = false;
        } else if (tekst.equals("=")) {
            Double drugi;
            if (unos) {
                drugi = parseDouble(rezultat.getText());
            } else {
                drugi = prvi;
            }
            prvi = izracunaj(odabrani, prvi, drugi);

            String result = removeTrailingZeros(prvi.toString());
            rezultat.setText(result);

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
            case "/":
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
}
