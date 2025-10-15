package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class TelaInicialController {

    @FXML public CheckBox checkBoxMediaCalabresa;
    @FXML public CheckBox checkBoxFamiliaCalabresa;
    @FXML public CheckBox checkBoxGiganteCalabresa;
    @FXML public CheckBox checkBoxMediaCatupiry;
    @FXML public CheckBox checkBoxFamiliaCatupiry;
    @FXML public CheckBox checkBoxGiganteCatupiry;
    @FXML public CheckBox checkBoxMediaPepperoni;
    @FXML public CheckBox checkBoxFamiliaPepperoni;
    @FXML public CheckBox checkBoxGigantePepperoni;

    @FXML private VBox vBoxHamb;
    @FXML private VBox vBoxPizza;
    @FXML private VBox vBoxPastel;
    @FXML private VBox vBoxBebidas;
    @FXML private ScrollPane scrollPane;
    @FXML private Button buttonHamb;
    @FXML private Button buttonPizza;
    @FXML private Button buttonPastel;
    @FXML private Button buttonBebida;
    @FXML private Button buttonMaisSmash;
    @FXML private Button buttonMaisSalada;
    @FXML private Button buttonMaisBacon;
    @FXML private Button buttonMaisPastelFrango;
    @FXML private Button buttonMaisPastelCarne;
    @FXML private Button buttonMaisPastelCamarao;
    @FXML private Button buttonMaisPastelQueijo;
    @FXML private Button buttonMaisCalabresa;
    @FXML private Button buttonMaisFrangoCatupiry;
    @FXML private Button buttonMaisPepperoni;
    @FXML private Button buttonMenosSmash;
    @FXML private Button buttonMenosSalada;
    @FXML private Button buttonMenosBacon;
    @FXML private Button buttonMenosPastelFrango;
    @FXML private Button buttonMenosPastelCarne;
    @FXML private Button buttonMenosPastelCamarao;
    @FXML private Button buttonMenosPastelQueijo;
    @FXML private Button buttonMenosCalabresa;
    @FXML private Button buttonMenosFrangoCatupiry;
    @FXML private Button buttonMenosPepperoni;
    @FXML private Button buttonCarrinho;
    @FXML private Button buttonMaisAguaMineral;
    @FXML private Button buttonMenosAguaMineral;
    @FXML private Button buttonMaisAguaComGas;
    @FXML private Button buttonMenosAguaComGas;
    @FXML private Button buttonMaisCocaLata;
    @FXML private Button buttonMenosCocaLata;
    @FXML private Button buttonMaisGuaranaLata;
    @FXML private Button buttonMenosGuaranaLata;
    @FXML private Button buttonMaisCocaLitro;
    @FXML private Button buttonMenosCocaLitro;
    @FXML private Button buttonMaisGuaranaLitro;
    @FXML private Button buttonMenosGuaranaLitro;
    @FXML private Button buttonMaisSucoLaranja;
    @FXML private Button buttonMenosSucoLaranja;
    @FXML private Button buttonMaisSucoGoiaba;
    @FXML private Button buttonMenosSucoGoiaba;
    @FXML private Label labelAguaMineral;
    @FXML private Label labelAguaComGas;
    @FXML private Label labelCocaLata;
    @FXML private Label labelGuaranaLata;
    @FXML private Label labelCocaLitro;
    @FXML private Label labelGuaranaLitro;
    @FXML private Label labelSucoLaranja;
    @FXML private Label labelSucoGoiaba;
    @FXML private Label labelSmash;
    @FXML private Label labelSalada;
    @FXML private Label labelBacon;
    @FXML private Label labelPastelFrango;
    @FXML private Label labelPastelCarne;
    @FXML private Label labelPastelCamarao;
    @FXML private Label labelPastelQueijo;
    @FXML private Label labelCalabresa;
    @FXML private Label labelFrangoCatupiry;
    @FXML private Label labelPepperoni;
    @FXML private Label labelTotal;

    private Stage currentStage;

    private GerenciadorCardapio gerenciadorCardapio;
    private ItemManager itemManager;

    public void setGerenciadorCardapio(GerenciadorCardapio gerenciadorCardapio) {
        this.gerenciadorCardapio = gerenciadorCardapio;
        atualizarTotal();
    }

    public void setItemManager(ItemManager itemManager){
        this.itemManager = itemManager;
    }

    public void abrirCarrinho() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Carrinho.fxml"));
        Parent root = loader.load();

        CarrinhoController carrinhoController = loader.getController();
        carrinhoController.setGerenciadorCardapio(gerenciadorCardapio);
        carrinhoController.exibirItens();
        
        Stage stage = new Stage();
        stage.setTitle("Carrinho");
        stage.setScene(new Scene(root, 615, 700));
        stage.setResizable(false);
        stage.show();
    }

    public void scrollHamb() {
        scrollPane.setVvalue(vBoxHamb.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollPastel() {
        scrollPane.setVvalue(vBoxPastel.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollPizza() {
        scrollPane.setVvalue(vBoxPizza.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollBebida() {
        scrollPane.setVvalue(vBoxBebidas.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    @FXML public void initialize() {
        if(gerenciadorCardapio == null){
            gerenciadorCardapio = new GerenciadorCardapio();
            itemManager = new ItemManager(gerenciadorCardapio, this);
        }
        Platform.runLater(() -> {
            currentStage = (Stage) buttonCarrinho.getScene().getWindow();
        });


        //Adicionar
        buttonMaisSmash.setOnAction(event -> {
            itemManager.adicionarItem("Smash Burguer", "Pão Brioche, Carne Smash 80g, Ovo, Cheddar e Molho da Casa.", 14.90, 1, labelSmash);
        });

        buttonMaisSalada.setOnAction(event -> {
            itemManager.adicionarItem("Smash Salada", "Pão Brioche, Carne Smash 80g, Alface, Cebola Crocante, Tomate, Picles e Molho da Casa.", 17.90, 1, labelSalada);
        });

        buttonMaisBacon.setOnAction(event -> {
           itemManager.adicionarItem("Smash Bacon", "Pão Brioche, Carne Smash 80g, Bacon, Cheddar e Molho da Casa.", 16.90, 1, labelBacon);
        });

        buttonMaisPastelFrango.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Frango", "Frango Desfiado", 12.00, 1, labelPastelFrango);
        });

        buttonMaisPastelCarne.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Carne", "Carne Moída", 12.00, 1, labelPastelCarne);
        });

        buttonMaisPastelCamarao.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Camarão", "Camarão", 18.00, 1, labelPastelCamarao);
        });

        buttonMaisPastelQueijo.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Queijo", "Queijo e Milho", 12.00, 1, labelPastelQueijo);
        });

        buttonMaisCalabresa.setOnAction(event -> {
            itemManager.adicionarPizza("Calabresa", "Molho, Mussarela, Calabresa, Tomate, Cebola, Azeitona e Orégano.", 35.00, 40.00, 45.00, 1, labelCalabresa);
        });

        buttonMaisFrangoCatupiry.setOnAction(event -> {
            itemManager.adicionarPizza("Frango Catupiry", "Molho, Mussarela, Frango, Tomate, Catupiry e Orégano.", 35.00, 40.00, 45.00, 1, labelFrangoCatupiry);
        });

        buttonMaisPepperoni.setOnAction(event -> {
            itemManager.adicionarPizza("Pepperoni", "Molho, Mussarela, Pepperoni e Orégano.", 35.00, 40.00, 45.00, 1, labelPepperoni);
        });

        buttonMaisAguaMineral.setOnAction(event -> {
            itemManager.adicionarItem("Água Mineral", "Água Mineral", 2.00, 1, labelAguaMineral);
        });

        buttonMaisAguaComGas.setOnAction(event -> {
            itemManager.adicionarItem("Água Com Gas", "Água Com Gas", 3.00, 1, labelAguaComGas);
        });

        buttonMaisCocaLata.setOnAction(event ->{
            itemManager.adicionarItem("Coca Lata","Coca Lata",5.00,1,labelCocaLata);
        });

        buttonMaisGuaranaLata.setOnAction(event ->{
            itemManager.adicionarItem("Guarana Lata", "Guarana Lata",4.50,1,labelGuaranaLata);
        });

        buttonMaisCocaLitro.setOnAction(event ->{
            itemManager.adicionarItem("Coca Litro","Coca Litro",10.00,1,labelCocaLitro);
        });

        buttonMaisGuaranaLitro.setOnAction(event ->{
            itemManager.adicionarItem("Guarana Litro","Guarana Litro", 9.00,1,labelGuaranaLitro);
        });

        buttonMaisSucoLaranja.setOnAction(event -> {
            itemManager.adicionarItem("Suco Laranja", "Suco Laranja", 5.00,1,labelSucoLaranja);
        });

        buttonMaisSucoGoiaba.setOnAction(event -> {
            itemManager.adicionarItem("Suco Goiaba", "Suco Goiaba", 5.00,1,labelSucoGoiaba);
        });




        //Remover
        buttonMenosSmash.setOnAction(event -> {
            itemManager.removerItem("Smash Burguer", labelSmash);
        });

        buttonMenosSalada.setOnAction(event -> {
            itemManager.removerItem("Smash Salada", labelSalada);
        });

        buttonMenosBacon.setOnAction(event -> {
            itemManager.removerItem("Smash Bacon", labelBacon);
        });

        buttonMenosPastelFrango.setOnAction(event -> {
            itemManager.removerItem("Pastel Frango", labelPastelFrango);
        });

        buttonMenosPastelCarne.setOnAction(event -> {
            itemManager.removerItem("Pastel Carne", labelPastelCarne);
        });

        buttonMenosPastelCamarao.setOnAction(event -> {
            itemManager.removerItem("Pastel Camarão", labelPastelCamarao);
        });

        buttonMenosPastelQueijo.setOnAction(event -> {
            itemManager.removerItem("Pastel Queijo", labelPastelQueijo);
        });

        buttonMenosCalabresa.setOnAction(event -> {
            itemManager.removerItem("Calabresa", labelCalabresa);
        });

        buttonMenosFrangoCatupiry.setOnAction(event -> {
            itemManager.removerItem("Frango Catupiry", labelFrangoCatupiry);
        });

        buttonMenosPepperoni.setOnAction(event -> {
            itemManager.removerItem("Pepperoni", labelPepperoni);
        });

        buttonMenosAguaMineral.setOnAction(event -> {
            itemManager.removerItem("Mineral",labelAguaMineral);
        });

        buttonMenosAguaComGas.setOnAction(event -> {
            itemManager.removerItem("Com Gas",labelAguaComGas);
        });

        buttonMenosCocaLata.setOnAction(event -> {
            itemManager.removerItem("Coca Lata",labelCocaLata);
        });

        buttonMenosGuaranaLata.setOnAction(event -> {
            itemManager.removerItem("Guarana Lata",labelGuaranaLata);
        });

        buttonMenosCocaLitro.setOnAction(event -> {
            itemManager.removerItem("Coca Litro",labelCocaLitro);
        });

        buttonMenosGuaranaLitro.setOnAction(event -> {
            itemManager.removerItem("Guarana Litro",labelGuaranaLitro);
        });

        buttonMenosSucoGoiaba.setOnAction(event -> {
            itemManager.removerItem("Suco Goiaba",labelSucoGoiaba);
        });

        buttonMenosSucoLaranja.setOnAction(event -> {
            itemManager.removerItem("Suco Laranja",labelSucoLaranja);
        });


        //Verificação CheckBox
        checkBoxMediaCalabresa.setOnAction(event -> {
            if (checkBoxMediaCalabresa.isSelected()) {
                checkBoxFamiliaCalabresa.setSelected(false);
                checkBoxFamiliaCalabresa.setDisable(true);
                checkBoxGiganteCalabresa.setSelected(false);
                checkBoxGiganteCalabresa.setDisable(true);
            } else {
                checkBoxFamiliaCalabresa.setDisable(false);
                checkBoxGiganteCalabresa.setDisable(false);
            }
        });

        checkBoxFamiliaCalabresa.setOnAction(e -> {
            if (checkBoxFamiliaCalabresa.isSelected()) {
                checkBoxMediaCalabresa.setSelected(false);
                checkBoxMediaCalabresa.setDisable(true);
                checkBoxGiganteCalabresa.setSelected(false);
                checkBoxGiganteCalabresa.setDisable(true);
            } else {
                checkBoxMediaCalabresa.setDisable(false);
                checkBoxGiganteCalabresa.setDisable(false);
            }
        });

        checkBoxGiganteCalabresa.setOnAction(e -> {
            if (checkBoxGiganteCalabresa.isSelected()) {
                checkBoxFamiliaCalabresa.setSelected(false);
                checkBoxFamiliaCalabresa.setDisable(true);
                checkBoxMediaCalabresa.setSelected(false);
                checkBoxMediaCalabresa.setDisable(true);
            } else {
                checkBoxFamiliaCalabresa.setDisable(false);
                checkBoxMediaCalabresa.setDisable(false);
            }
        });

        checkBoxMediaCatupiry.setOnAction(e -> {
            if (checkBoxMediaCatupiry.isSelected()) {
                checkBoxFamiliaCatupiry.setSelected(false);
                checkBoxFamiliaCatupiry.setDisable(true);
                checkBoxGiganteCatupiry.setSelected(false);
                checkBoxGiganteCatupiry.setDisable(true);
            } else {
                checkBoxFamiliaCatupiry.setDisable(false);
                checkBoxGiganteCatupiry.setDisable(false);
            }
        });

        checkBoxFamiliaCatupiry.setOnAction(e -> {
            if (checkBoxFamiliaCatupiry.isSelected()) {
                checkBoxGiganteCatupiry.setSelected(false);
                checkBoxGiganteCatupiry.setDisable(true);
                checkBoxMediaCatupiry.setSelected(false);
                checkBoxMediaCatupiry.setDisable(true);
            } else {
                checkBoxGiganteCatupiry.setDisable(false);
                checkBoxMediaCatupiry.setDisable(false);
            }
        });

        checkBoxGiganteCatupiry.setOnAction(e -> {
            if (checkBoxGiganteCatupiry.isSelected()) {
                checkBoxFamiliaCatupiry.setSelected(false);
                checkBoxFamiliaCatupiry.setDisable(true);
                checkBoxMediaCatupiry.setSelected(false);
                checkBoxMediaCatupiry.setDisable(true);
            } else {
                checkBoxFamiliaCatupiry.setDisable(false);
                checkBoxMediaCatupiry.setDisable(false);
            }
        });

        checkBoxMediaPepperoni.setOnAction(e -> {
            if (checkBoxMediaPepperoni.isSelected()) {
                checkBoxFamiliaPepperoni.setSelected(false);
                checkBoxFamiliaPepperoni.setDisable(true);
                checkBoxGigantePepperoni.setSelected(false);
                checkBoxGigantePepperoni.setDisable(true);
            } else {
                checkBoxFamiliaPepperoni.setDisable(false);
                checkBoxGigantePepperoni.setDisable(false);
            }
        });

        checkBoxFamiliaPepperoni.setOnAction(e -> {
            if (checkBoxFamiliaPepperoni.isSelected()) {
                checkBoxGigantePepperoni.setSelected(false);
                checkBoxGigantePepperoni.setDisable(true);
                checkBoxMediaPepperoni.setSelected(false);
                checkBoxMediaPepperoni.setDisable(true);
            } else {
                checkBoxGigantePepperoni.setDisable(false);
                checkBoxMediaPepperoni.setDisable(false);
            }
        });

        checkBoxGigantePepperoni.setOnAction(e -> {
            if (checkBoxGigantePepperoni.isSelected()) {
                checkBoxFamiliaPepperoni.setSelected(false);
                checkBoxFamiliaPepperoni.setDisable(true);
                checkBoxMediaPepperoni.setSelected(false);
                checkBoxMediaPepperoni.setDisable(true);
            } else {
                checkBoxFamiliaPepperoni.setDisable(false);
                checkBoxMediaPepperoni.setDisable(false);
            }
        });


        //Scroll
        buttonHamb.setOnAction(event -> {
            scrollHamb();
        });

        buttonPizza.setOnAction(event -> {
            scrollPizza();
        });

        buttonPastel.setOnAction(event -> {
            scrollPastel();
        });

        buttonBebida.setOnAction(event -> {
            scrollBebida();
        });

        //Abrir Carrinho
        buttonCarrinho.setOnAction(event -> {
            try {
                if (currentStage != null) {
                    currentStage.close();
                }
                abrirCarrinho();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void atualizarTotal() {
        double total = gerenciadorCardapio.calcularTotal();
        labelTotal.setText(String.format("%.2f", total));
    }
}
