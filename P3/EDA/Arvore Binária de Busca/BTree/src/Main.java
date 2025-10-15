public class Main {
    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB(4);

        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(80);
        arvore.inserir(100);
        arvore.inserir(90);
        arvore.inserir(30);
        arvore.inserir(35);

        System.out.println("Percorrendo a Árvore B de ordem 4:");
        arvore.percorrer();

        int chaveBusca = 90;
        if (arvore.buscar(chaveBusca) != null) {
            System.out.println("\nChave " + chaveBusca + " encontrada!");
        } else {
            System.out.println("\nChave " + chaveBusca + " não encontrada!");
        }
    }
}
