package ListasEncadeadas;

public class ListaEncadeada<T> {
    private Node<T> inicio;
    private int size;


    public void addValue(T valor){
      Node<T> celula = new Node<>(valor);
      if (inicio == null){
          this.inicio = celula;
      }
      else{
          Node<T> atual = inicio;
          while (atual.getProximo() != null){
              atual = atual.getProximo();
          }
          atual.setProximo(celula);
      }
      size++;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio=" + inicio +
                '}';
    }
}
