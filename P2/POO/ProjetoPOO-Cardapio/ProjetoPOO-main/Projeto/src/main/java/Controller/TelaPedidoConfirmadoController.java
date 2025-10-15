package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPedidoConfirmadoController {

    @FXML Button buttonOk;

    public void initialize() {

        buttonOk.setOnAction(event -> {
            Platform.exit();
        });
    }
}
