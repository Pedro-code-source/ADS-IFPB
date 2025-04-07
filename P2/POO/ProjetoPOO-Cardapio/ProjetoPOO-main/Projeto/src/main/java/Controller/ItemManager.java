package Controller;

import Model.ItemCardapio;
import javafx.scene.control.Label;

public class ItemManager extends TelaInicialController{
    private GerenciadorCardapio gerenciadorCardapio;
    private TelaInicialController telaInicialController;

    public ItemManager(GerenciadorCardapio gerenciadorCardapio, TelaInicialController telaInicialController) {
        this.gerenciadorCardapio = gerenciadorCardapio;
        this.telaInicialController = telaInicialController;
    }

    public void atualizarLabel(Label label, int quantidade) {
        label.setText(String.valueOf(quantidade));
    }

    public void adicionarItem(String nome, String descricao, double preco, int quantidade, Label label) {
        ItemCardapio item = gerenciadorCardapio.getItens().stream()
                .filter(i -> i.getNome().equals(nome))
                .findFirst()
                .orElse(new ItemCardapio(nome, descricao, preco, 0));

        item.setQuantidade(item.getQuantidade() + quantidade);

        if (!gerenciadorCardapio.getItens().contains(item)) {
            gerenciadorCardapio.adicionarItem(item);
        }

        atualizarLabel(label, item.getQuantidade());
        telaInicialController.atualizarTotal();
    }

    public void adicionarPizza(String nome, String descricao, double precoMedia, double precoFamilia, double precoGigante, int quantidade, Label label) {
        double preco = 0;

        switch (nome) {
            case "Calabresa":
                if (telaInicialController.checkBoxMediaCalabresa.isSelected()) {
                    preco = precoMedia;
                } else if (telaInicialController.checkBoxFamiliaCalabresa.isSelected()) {
                    preco = precoFamilia;
                } else if (telaInicialController.checkBoxGiganteCalabresa.isSelected()) {
                    preco = precoGigante;
                } else {
                    return;
                }
                break;
            case "Frango Catupiry":
                if (telaInicialController.checkBoxMediaCatupiry.isSelected()) {
                    preco = precoMedia;
                } else if (telaInicialController.checkBoxFamiliaCatupiry.isSelected()) {
                    preco = precoFamilia;
                } else if (telaInicialController.checkBoxGiganteCatupiry.isSelected()) {
                    preco = precoGigante;
                } else {
                    return;
                }
                break;
            case "Pepperoni":
                if (telaInicialController.checkBoxMediaPepperoni.isSelected()) {
                    preco = precoMedia;
                } else if (telaInicialController.checkBoxFamiliaPepperoni.isSelected()) {
                    preco = precoFamilia;
                } else if (telaInicialController.checkBoxGigantePepperoni.isSelected()) {
                    preco = precoGigante;
                } else {
                    return;
                }
                break;
            default:
                return;
        }

        ItemCardapio item = gerenciadorCardapio.getItens().stream()
                .filter(i -> i.getNome().equals(nome))
                .findFirst()
                .orElse(new ItemCardapio(nome, descricao, preco, 0));
        item.setQuantidade(item.getQuantidade() + quantidade);

        if (!gerenciadorCardapio.getItens().contains(item)) {
            gerenciadorCardapio.adicionarItem(item);
        }

        atualizarLabel(label, item.getQuantidade());
        telaInicialController.atualizarTotal();
    }

    public void removerItem(String nome, Label label) {
        ItemCardapio item = gerenciadorCardapio.getItens().stream()
                .filter(i -> i.getNome().equals(nome))
                .findFirst()
                .orElse(null);

        if (item != null && item.getQuantidade() > 0) {
            item.setQuantidade(item.getQuantidade() - 1);

            if (item.getQuantidade() == 0) {
                gerenciadorCardapio.removerItem(item);
            }

            atualizarLabel(label, item.getQuantidade());
            telaInicialController.atualizarTotal();
        }
    }
}