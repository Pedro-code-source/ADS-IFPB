package ListasEncadeadas;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.addValue(2);
        lista.addValue(3);
        lista.addValue(5);
        lista.addValue(10);
        lista.addValue(20);
        System.out.println(lista);
        System.out.println(lista.size());
    }
}
