package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLoginController {

    @FXML private Button buttonLogin;
    @FXML private TextField email;
    @FXML private PasswordField senha;

    private Stage currentStage;

    public void abrirTelaInicial() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/TelaInicial.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Tela Inicial");
        stage.setScene(new Scene(root, 615, 700));
        stage.setResizable(false);
        stage.show();
    }

    public void initialize() {

        Platform.runLater(() -> {
            currentStage = (Stage) buttonLogin.getScene().getWindow();
        });

        buttonLogin.setOnAction(event -> {
           try {
               if (currentStage != null) {
                   currentStage.close();
               }
               if (email.getText().equals("emailteste@gmail.com") && senha.getText().equals("123456")) {
                   abrirTelaInicial();
               } else {
                   System.out.println("Erro ao efetuar login");
               }
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
        });
    }
}
