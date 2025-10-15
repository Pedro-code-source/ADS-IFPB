import Pilhas.Pacote;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Queue<Pacote> filaDePacotes = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0;i < 6; i++){

            System.out.println("Digite um valor (De 1 a 3):");
            int valorDaPilha = sc.nextInt();
            Pacote pacote = new Pacote(valorDaPilha);

            if (pacote.getNumeracao() > 0 && pacote.getNumeracao() < 4){
                filaDePacotes.add(pacote);
            }

        }
        Stack<Pacote> pilha1 = new Stack<>();
        Stack<Pacote> pilha2 = new Stack<>();
        Stack<Pacote> pilha3 = new Stack<>();

        while (!filaDePacotes.isEmpty()){
            Pacote pacote = filaDePacotes.poll();

            switch (pacote.getNumeracao()){
                case 1:
                    pilha1.add(pacote);
                    break;
                case 2:
                    pilha2.add(pacote);
                    break;
                case 3:
                    pilha3.add(pacote);
                    break;
            }
        }
        for (Pacote pacote1 : pilha1){
            System.out.println(pacote1.getNumeracao());
        }
        for (Pacote pacote2 : pilha2){
            System.out.println(pacote2.getNumeracao());
        }
        for (Pacote pacote3 : pilha3){
            System.out.println(pacote3.getNumeracao());
        }
    }
}
