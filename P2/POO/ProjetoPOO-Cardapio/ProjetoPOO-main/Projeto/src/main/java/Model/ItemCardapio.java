package Model;

public class ItemCardapio {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public ItemCardapio(String nome, String descricao, double preco, int quantidade) {
        this.nome = nome; this.descricao = descricao; this.preco = preco; this.quantidade = quantidade;
    }

    public ItemCardapio(String nome, String descricao, double preco) {
        this(nome, descricao, preco, 0);
    }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public double getPreco() { return preco; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double calcularTotal() { return preco * quantidade; }
}
