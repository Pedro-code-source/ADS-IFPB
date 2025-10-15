public class ArvoreB {
    private NoArvoreB raiz;
    private int ordem;

    public ArvoreB(int ordem) {
        this.raiz = null;
        this.ordem = ordem;
    }

    public void percorrer() {
        if (raiz != null) {
            raiz.percorrer();
        }
    }

    public NoArvoreB buscar(int chave) {
        if (raiz == null) return null;
        return raiz.buscar(chave);
    }

    public void inserir(int chave) {
        if (raiz == null) {
            raiz = new NoArvoreB(ordem, true);
            raiz.chaves[0] = chave;
            raiz.numChaves = 1;
        } else {
            if (raiz.numChaves == ordem - 1) {
                NoArvoreB novoNo = new NoArvoreB(ordem, false);
                novoNo.filhos[0] = raiz;
                dividirFilho(novoNo, 0, raiz);
                int i = 0;
                if (novoNo.chaves[0] < chave) {
                    i++;
                }
                inserirNaoCheio(novoNo.filhos[i], chave);
                raiz = novoNo;
            } else {
                inserirNaoCheio(raiz, chave);
            }
        }
    }

    private void inserirNaoCheio(NoArvoreB no, int chave) {
        int i = no.numChaves - 1;

        if (no.folha) {
            while (i >= 0 && chave < no.chaves[i]) {
                no.chaves[i + 1] = no.chaves[i];
                i--;
            }
            no.chaves[i + 1] = chave;
            no.numChaves++;
        } else {
            while (i >= 0 && chave < no.chaves[i]) {
                i--;
            }
            i++;
            if (no.filhos[i].numChaves == ordem - 1) {
                dividirFilho(no, i, no.filhos[i]);
                if (chave > no.chaves[i]) {
                    i++;
                }
            }
            inserirNaoCheio(no.filhos[i], chave);
        }
    }

    private void dividirFilho(NoArvoreB pai, int indice, NoArvoreB filhoCheio) {
        NoArvoreB novoNo = new NoArvoreB(ordem, filhoCheio.folha);
        novoNo.numChaves = ordem / 2 - 1;

        for (int j = 0; j < ordem / 2 - 1; j++) {
            novoNo.chaves[j] = filhoCheio.chaves[j + ordem / 2];
        }

        if (!filhoCheio.folha) {
            for (int j = 0; j < ordem / 2; j++) {
                novoNo.filhos[j] = filhoCheio.filhos[j + ordem / 2];
            }
        }

        filhoCheio.numChaves = ordem / 2 - 1;

        for (int j = pai.numChaves; j >= indice + 1; j--) {
            pai.filhos[j + 1] = pai.filhos[j];
        }

        pai.filhos[indice + 1] = novoNo;

        for (int j = pai.numChaves - 1; j >= indice; j--) {
            pai.chaves[j + 1] = pai.chaves[j];
        }

        pai.chaves[indice] = filhoCheio.chaves[ordem / 2 - 1];
        pai.numChaves++;
    }
}
