public class NoArvoreB {
    int ordem;
    int numChaves;
    int[] chaves;
    NoArvoreB[] filhos;
    boolean folha;

    public NoArvoreB(int ordem, boolean folha) {
        this.ordem = ordem;
        this.folha = folha;
        this.chaves = new int[ordem - 1];
        this.filhos = new NoArvoreB[ordem];
        this.numChaves = 0;
    }

    public void percorrer() {
        int i;
        for (i = 0; i < numChaves; i++) {
            if (!folha) {
                filhos[i].percorrer();
            }
            System.out.print(chaves[i] + " ");
        }
        if (!folha) {
            filhos[i].percorrer();
        }
    }

    public NoArvoreB buscar(int chave) {
        int i = 0;
        while (i < numChaves && chave > chaves[i]) {
            i++;
        }
        if (i < numChaves && chaves[i] == chave) {
            return this;
        }
        if (folha) {
            return null;
        }
        return filhos[i].buscar(chave);
    }

    public void remover(int chave, int t) {
        int idx = 0;
        while (idx < numChaves && chaves[idx] < chave) {
            idx++;
        }

        if (idx < numChaves && chaves[idx] == chave) {
            if (folha) {
                removerDeFolha(idx);
            } else {
                removerDeNaoFolha(idx, t);
            }
        } else {
            if (folha) {
                System.out.println("A chave " + chave + " não existe na árvore.");
                return;
            }

            boolean flag = (idx == numChaves);

            if (filhos[idx].numChaves < t) {
                preencher(idx, t);
            }

            if (flag && idx > numChaves) {
                filhos[idx - 1].remover(chave, t);
            } else {
                filhos[Math.min(idx, numChaves)].remover(chave, t);
            }
        }
    }

    private void removerDeFolha(int idx) {
        for (int i = idx + 1; i < numChaves; i++) {
            chaves[i - 1] = chaves[i];
        }
        numChaves--;
    }

    private void removerDeNaoFolha(int idx, int t) {
        int chave = chaves[idx];

        if (filhos[idx].numChaves >= t) {
            int pred = pegarPredecessor(idx);
            chaves[idx] = pred;
            filhos[idx].remover(pred, t);
        }
        else if (filhos[idx + 1].numChaves >= t) {
            int succ = pegarSucessor(idx);
            chaves[idx] = succ;
            filhos[idx + 1].remover(succ, t);
        }
        else {
            juntar(idx);
            filhos[idx].remover(chave, t);
        }
    }

    private int pegarPredecessor(int idx) {
        NoArvoreB cur = filhos[idx];
        while (!cur.folha) {
            cur = cur.filhos[cur.numChaves];
        }
        return cur.chaves[cur.numChaves - 1];
    }

    private int pegarSucessor(int idx) {
        NoArvoreB cur = filhos[idx + 1];
        while (!cur.folha) {
            cur = cur.filhos[0];
        }
        return cur.chaves[0];
    }

    private void preencher(int idx, int t) {
        if (idx != 0 && filhos[idx - 1].numChaves >= t) {
            emprestarDoAnterior(idx);
        }
        else if (idx != numChaves && filhos[idx + 1].numChaves >= t) {
            emprestarDoProximo(idx);
        }
        else {
            if (idx != numChaves) {
                juntar(idx);
            } else {
                juntar(idx - 1);
            }
        }
    }

    private void emprestarDoAnterior(int idx) {
        NoArvoreB child = filhos[idx];
        NoArvoreB sibling = filhos[idx - 1];

        for (int i = child.numChaves - 1; i >= 0; i--) {
            child.chaves[i + 1] = child.chaves[i];
        }
        if (!child.folha) {
            for (int i = child.numChaves; i >= 0; i--) {
                child.filhos[i + 1] = child.filhos[i];
            }
        }

        child.chaves[0] = chaves[idx - 1];

        if (!child.folha) {
            child.filhos[0] = sibling.filhos[sibling.numChaves];
        }

        chaves[idx - 1] = sibling.chaves[sibling.numChaves - 1];

        child.numChaves += 1;
        sibling.numChaves -= 1;
    }

    private void emprestarDoProximo(int idx) {
        NoArvoreB child = filhos[idx];
        NoArvoreB sibling = filhos[idx + 1];

        child.chaves[child.numChaves] = chaves[idx];

        if (!child.folha) {
            child.filhos[child.numChaves + 1] = sibling.filhos[0];
        }

        chaves[idx] = sibling.chaves[0];


        for (int i = 1; i < sibling.numChaves; i++) {
            sibling.chaves[i - 1] = sibling.chaves[i];
        }
        if (!sibling.folha) {
            for (int i = 1; i <= sibling.numChaves; i++) {
                sibling.filhos[i - 1] = sibling.filhos[i];
            }
        }

        child.numChaves += 1;
        sibling.numChaves -= 1;
    }

    private void juntar(int idx) {
        NoArvoreB child = filhos[idx];
        NoArvoreB sibling = filhos[idx + 1];

        int t = (int) Math.ceil(ordem / 2.0);

        child.chaves[t - 1] = chaves[idx];

        for (int i = 0; i < sibling.numChaves; i++) {
            child.chaves[i + t] = sibling.chaves[i];
        }

        if (!child.folha) {
            for (int i = 0; i <= sibling.numChaves; i++) {
                child.filhos[i + t] = sibling.filhos[i];
            }
        }

        for (int i = idx + 1; i < numChaves; i++) {
            chaves[i - 1] = chaves[i];
        }
        for (int i = idx + 2; i <= numChaves; i++) {
            filhos[i - 1] = filhos[i];
        }

        child.numChaves += sibling.numChaves + 1;
        numChaves--;

    }
}
