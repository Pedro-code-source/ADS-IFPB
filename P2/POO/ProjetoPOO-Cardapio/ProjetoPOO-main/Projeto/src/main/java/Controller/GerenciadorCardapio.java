package Controller;

import Model.ItemCardapio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorCardapio {
    private List<ItemCardapio> itens;
    private final String ARQUIVO_DADOS = "cardapio.txt";

    public GerenciadorCardapio() {
        this.itens = new ArrayList<>();
        carregarDados();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
        salvarDados();
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
        salvarDados();
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemCardapio::calcularTotal).sum();
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (ItemCardapio item : itens) {
                writer.write(item.getNome() + "," + item.getDescricao() + "," + item.getPreco() + "," + item.getQuantidade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    String nome = partes[0];
                    String descricao = partes[1];
                    double preco = Double.parseDouble(partes[2]);
                    int quantidade = Integer.parseInt(partes[3]);
                    itens.add(new ItemCardapio(nome, descricao, preco, quantidade));
                }
            }
        } catch (IOException e) {
        }
    }

    public void limparCardapio() {
        itens.clear();
        salvarDados();
    }
}