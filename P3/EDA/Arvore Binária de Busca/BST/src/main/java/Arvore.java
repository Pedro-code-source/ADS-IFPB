public class Arvore {
        No root;

    public Arvore() {
        this.root = null;
    }

    public void inserir(No corrente, No no) {
        if (this.root == null) {
            this.root = no;
        } else {
            if (corrente.getNoEsquerdo() == null && no.getValor() < corrente.getValor()) {
                corrente.setNoEsquerdo(no);
            } else if (corrente.getNoDireito() == null && no.getValor() > corrente.getValor()) {
                corrente.setNoDireito(no);
            } else {
                if (no.getValor() < corrente.getValor()) {
                    this.inserir(corrente.getNoEsquerdo(), no);
                } else {
                    this.inserir(corrente.getNoDireito(), no);
                }
            }
        }
    }

    public No buscar(No no, int valor) {
        if (no == null || no.getValor() == valor) {
            return no;
        }

        if (valor < no.getValor()) {
            return buscar(no.getNoEsquerdo(), valor);
        } else {
            return buscar(no.getNoDireito(), valor);
        }
    }

    public No remover(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor < no.getValor()) {
            no.setNoEsquerdo(remover(no.getNoEsquerdo(), valor));
        } else if (valor > no.getValor()) {
            no.setNoDireito(remover(no.getNoDireito(), valor));
        } else {
            if (no.getNoEsquerdo() == null) {
                return no.getNoDireito();
            } else if (no.getNoDireito() == null) {
                return no.getNoEsquerdo();
            }

            No menorDireita = encontrarMenor(no.getNoDireito());
            no.setValor(menorDireita.getValor());
            no.setNoDireito(remover(no.getNoDireito(), menorDireita.getValor()));
        }

        return no;
    }

    private No encontrarMenor(No no) {
        while (no.getNoEsquerdo() != null) {
            no = no.getNoEsquerdo();
        }
        return no;
    }

    private int getAltura(No no) {
        return (no == null) ? -1 : no.getAltura();
    }

    public int altura(No no) {
        int esq = -1;
        int dir = -1;

        if (no.getNoEsquerdo() != null) {
            esq = altura(no.getNoEsquerdo());
        }
        if (no.getNoDireito() != null) {
            dir = altura(no.getNoDireito());
        }

        return Math.max(esq, dir) + 1;
    }
    private int getBalance(No no) {
        return (no == null) ? 0 : getAltura(no.getNoEsquerdo()) - getAltura(no.getNoDireito());
    }



    public void preOrder(No no) {
        if (no != null) {
            System.out.println(no.getValor());
            preOrder(no.getNoEsquerdo());
            preOrder(no.getNoDireito());
        }
    }

    public void inOrder(No no) {
        if (no != null) {
            inOrder(no.getNoEsquerdo());
            System.out.println(no.getValor());
            inOrder(no.getNoDireito());
        }
    }

    public void posOrder(No no) {
        if (no != null) {
            posOrder(no.getNoEsquerdo());
            posOrder(no.getNoDireito());
            System.out.println(no.getValor());
        }
    }

public void adicionarBalanceado(int valor) {
    root = inserirAvl(root, new No(valor));
}

private No inserirAvl(No corrente, No novo) {
    if (corrente == null) {
        return novo;
    }

    if (novo.getValor() < corrente.getValor()) {
        corrente.setNoEsquerdo(inserirAvl(corrente.getNoEsquerdo(), novo));
    } else if (novo.getValor() > corrente.getValor()) {
        corrente.setNoDireito(inserirAvl(corrente.getNoDireito(), novo));
    } else {
        return corrente;
    }

    corrente.setAltura(1 + Math.max(getAltura(corrente.getNoEsquerdo()), getAltura(corrente.getNoDireito())));

    int balance = getBalance(corrente);

    if (balance > 1 && novo.getValor() < corrente.getNoEsquerdo().getValor()) {
        return rotacaoDireita(corrente);
    }

    if (balance < -1 && novo.getValor() > corrente.getNoDireito().getValor()) {
        return rotacaoEsquerda(corrente);
    }

    if (balance > 1 && novo.getValor() > corrente.getNoEsquerdo().getValor()) {
        corrente.setNoEsquerdo(rotacaoEsquerda(corrente.getNoEsquerdo()));
        return rotacaoDireita(corrente);
    }

    if (balance < -1 && novo.getValor() < corrente.getNoDireito().getValor()) {
        corrente.setNoDireito(rotacaoDireita(corrente.getNoDireito()));
        return rotacaoEsquerda(corrente);
    }

    return corrente;
}

private No rotacaoDireita(No y) {
    No x = y.getNoEsquerdo();
    No T2 = x.getNoDireito();

    x.setNoDireito(y);
    y.setNoEsquerdo(T2);

    y.setAltura(1 + Math.max(getAltura(y.getNoEsquerdo()), getAltura(y.getNoDireito())));
    x.setAltura(1 + Math.max(getAltura(x.getNoEsquerdo()), getAltura(x.getNoDireito())));

    return x;
}

private No rotacaoEsquerda(No x) {
    No y = x.getNoDireito();
    No T2 = y.getNoEsquerdo();

    y.setNoEsquerdo(x);
    x.setNoDireito(T2);

    x.setAltura(1 + Math.max(getAltura(x.getNoEsquerdo()), getAltura(x.getNoDireito())));
    y.setAltura(1 + Math.max(getAltura(y.getNoEsquerdo()), getAltura(y.getNoDireito())));

    return y;
}
}
