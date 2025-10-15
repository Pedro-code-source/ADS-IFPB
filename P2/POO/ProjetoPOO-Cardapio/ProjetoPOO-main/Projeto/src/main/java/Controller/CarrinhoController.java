package Controller;

import Model.ItemCardapio;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class CarrinhoController {

    private GerenciadorCardapio gerenciadorCardapio;

    @FXML private Label labelSubtotal;
    @FXML private Label valorTotalCarrinho;
    @FXML private Button buttonEditar;
    @FXML private Button buttonConfirmarPedido;
    @FXML private VBox carrinhoContainer;

    private Stage currentStage;

    public void setGerenciadorCardapio(GerenciadorCardapio gerenciadorCardapio) {
        this.gerenciadorCardapio = gerenciadorCardapio;
    }

    public void pedidoConfirmado() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/TelaPedidoConfirmado.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Pedido Confirmado");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void exibirItens() {
        carrinhoContainer.getChildren().clear();

        if (gerenciadorCardapio != null && !gerenciadorCardapio.getItens().isEmpty()) {
            int numeroItens = gerenciadorCardapio.getItens().size();
            for (int i = 0; i < numeroItens; i++) {
                ItemCardapio item = gerenciadorCardapio.getItens().get(i);
                HBox itemHBox = criarItemHBox(item);
                carrinhoContainer.getChildren().add(itemHBox);
            }


            Pane spacer = new Pane();
            spacer.setPrefHeight(90.0);
            carrinhoContainer.getChildren().add(spacer);

            double alturaItem = 80.0;
            double alturaTotal = numeroItens * alturaItem + 30.0;

            double alturaMaxima = 500.0;
            alturaTotal = Math.min(alturaTotal, alturaMaxima);

            carrinhoContainer.setPrefHeight(alturaTotal);

            ScrollPane scrollPane = findScrollPane(carrinhoContainer);
            if (scrollPane != null) {
                scrollPane.setPrefHeight(alturaTotal + 200);
            }

            double subtotal = 0;
            for (ItemCardapio item : gerenciadorCardapio.getItens()) {
                subtotal += item.getPreco() * item.getQuantidade();
            }

            double taxaEntrega = 5.00;
            double valorTotal = subtotal + taxaEntrega;

            valorTotalCarrinho.setText(String.format("%.2f", valorTotal));

            labelSubtotal.setText(String.format("%.2f", subtotal));
        } else {
            Label vazioLabel = new Label("Nenhum item adicionado");
            carrinhoContainer.getChildren().add(vazioLabel);
            carrinhoContainer.setPrefHeight(80.0);

            ScrollPane scrollPane = findScrollPane(carrinhoContainer);
            if (scrollPane != null) {
                scrollPane.setPrefHeight(280.0);
            }
        }
    }

    private ScrollPane findScrollPane(javafx.scene.Node node) {
        javafx.scene.Node parent = node.getParent();
        while (parent != null) {
            if (parent instanceof ScrollPane) {
                return (ScrollPane) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }

    private HBox criarItemHBox(ItemCardapio item) {
        HBox itemHBox = new HBox();
        itemHBox.setPrefHeight(80.0);
        itemHBox.setPrefWidth(600.0);
        itemHBox.setStyle("-fx-padding: 0 0 10 0;");

        Pane itemPane = new Pane();
        itemPane.setPrefHeight(50.0);
        itemPane.setPrefWidth(600.0);
        itemPane.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        Label nomeLabel = new Label(item.getNome());
        nomeLabel.setLayoutX(20.0);
        nomeLabel.setLayoutY(14.0);
        nomeLabel.setFont(Font.font(18.0));


        Label valorLabel = new Label(String.format("%.2f", item.getPreco()));
        valorLabel.setLayoutX(527.0);
        valorLabel.setLayoutY(27.0);
        valorLabel.setFont(Font.font(18.0));

        Label quantidadeLabel = new Label(String.valueOf(item.getQuantidade()));
        quantidadeLabel.setLayoutX(446.0);
        quantidadeLabel.setLayoutY(32.0);

        Label rsLabel = new Label("R$");
        rsLabel.setLayoutX(500.0);
        rsLabel.setLayoutY(27.0);
        rsLabel.setFont(Font.font(18.0));

        itemPane.getChildren().addAll(nomeLabel, valorLabel, quantidadeLabel, rsLabel);
        itemHBox.getChildren().add(itemPane);

        return itemHBox;
    }

    public void abrirTelaInicial() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TelaInicial.fxml"));
        Parent root = loader.load();

        TelaInicialController telaInicialController = loader.getController();
        telaInicialController.setGerenciadorCardapio(gerenciadorCardapio);
        telaInicialController.setItemManager(new ItemManager(gerenciadorCardapio, telaInicialController));

        Stage stage = new Stage();
        stage.setTitle("Tela Inicial");
        stage.setScene(new Scene(root, 615, 700));
        stage.show();
    }

    public void initialize() {

        Platform.runLater(() -> {
            currentStage = (Stage) buttonEditar.getScene().getWindow();
        });

        buttonEditar.setOnAction(event -> {
            try {
                if (currentStage != null) {
                    currentStage.close();
                }
                abrirTelaInicial();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        buttonConfirmarPedido.setOnAction(event -> {
            try {
                if (currentStage != null) {
                    currentStage.close();
                }
                gerenciadorCardapio.limparCardapio();
                pedidoConfirmado();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}