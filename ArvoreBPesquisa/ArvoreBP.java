import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBP {
    private No raiz;
    private int tamanho;

    public ArvoreBP() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public class No {
        private No pai;
        private int element;
        private No FE;
        private No FD;

        public No() {
            this.pai = null;
            this.element = 0;
            this.FE = null;
            this.FD = null;
        }

        public No(No pai, int element) {
            this.pai = pai;
            this.element = element;
            this.FE = null;
            this.FD = null;
        }

        public int getElement() {
            return this.element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public No pai() {
            return this.pai;
        }

        public void setPai(No pai) {
            this.pai = pai;
        }

        public boolean hasLeft() {
            return this.FE != null;
        }

        public boolean hasRight() {
            return this.FD != null;
        }

        public No getFE() {
            return this.FE;
        }

        public void setFE(No fe) {
            this.FE = fe;
        }

        public No getFD() {
            return this.FD;
        }

        public void setFD(No fd) {
            this.FD = fd;
        }

        public int numFilhos() {
            int qtd = 0;
            if (this.FE != null){
                qtd++;
            }
            if (this.FD != null){
                qtd++;
            }
            return qtd;
        }

        public Iterator<No> filhos() {
            ArrayList<No> filhos = new ArrayList<>();
            if (this.FE != null){
            filhos.add(this.FE); 
            } 
            if (this.FD != null){
                filhos.add(this.FD);
            }
            return filhos.iterator();
        }
    }

    public No raiz() {
        return this.raiz;
    }

    public int size() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public No pai(No no) {
        return no.pai();
    }

    public boolean ERaiz(No no) {
        return no == this.raiz;
    }

    public No getFE(No no) {
        return no.getFE();
    }

    public No getFD(No no) {
        return no.getFD();
    }

    public boolean hasLeft(No no) {
        return no.hasLeft();
    }

    public boolean hasRight(No no) {
        return no.hasRight();
    }

    public int profundidade(No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + profundidade(no.pai());
    }

    public int altura(No no) {
        if (no == null) return 0;
        return 1 + Math.max(altura(no.getFE()), altura(no.getFD()));
    }

    public No insert(int chave) {
        if (raiz == null) {
            raiz = new No(null, chave);
            tamanho++;
            return raiz;
        }

        No atual = raiz;
        No pai = null;

        while (atual != null) {
            pai = atual;
            if (chave < atual.getElement()) {
                atual = atual.getFE();
            } else {
                atual = atual.getFD();
            }
        }

        No novo = new No(pai, chave);
        if (chave < pai.getElement()) {
            pai.setFE(novo);
        } else {
            pai.setFD(novo);
        }
        tamanho++;
        return novo;
    }

    public void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getFE());
        System.out.print(no.getElement() + " ");
        emOrdem(no.getFD());
    }

    public void desenharArvore() {
        int h = altura(raiz);
        int largura = (int) Math.pow(2, h + 1) - 1;

        String[][] mat = new String[h + 1][largura];
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < largura; j++) {
                mat[i][j] = " ";
            }
        }

        preencherMatriz(raiz, mat, 0, 0, largura - 1);

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    private void preencherMatriz(No no, String[][] mat, int linha, int esq, int dir) {
        if (no == null) return;
        int meio = (esq + dir) / 2;
        mat[linha][meio] = String.valueOf(no.getElement());

        preencherMatriz(no.getFE(), mat, linha + 1, esq, meio - 1);
        preencherMatriz(no.getFD(), mat, linha + 1, meio + 1, dir);
    }

    public void remove(int chave) {
        raiz = removerRec(raiz, chave);
    }

    private No removerRec(No no, int chave) {
        if (no == null) return null;

        if (chave < no.getElement()) {
            no.setFE(removerRec(no.getFE(), chave));
        } else if (chave > no.getElement()) {
            no.setFD(removerRec(no.getFD(), chave));
        } else {
            if (no.getFE() == null) return no.getFD();
            if (no.getFD() == null) return no.getFE();
            
            No temp = no.getFD();
            while (temp.getFE() != null) temp = temp.getFE();
            no.setElement(temp.getElement());
            no.setFD(removerRec(no.getFD(), temp.getElement()));
        }
        tamanho--;
        return no;
    }

    public Iterator<No> nos() {
        ArrayList<No> lista = new ArrayList<>();
        preOrderList(raiz, lista);
        return lista.iterator();
    }

    private void preOrderList(No no, ArrayList<No> lista) {
        if (no == null){
            return;
        }
        lista.add(no);
        preOrderList(no.getFE(), lista);
        preOrderList(no.getFD(), lista);
    }

    public Iterator<Object> elements() {
        ArrayList<Object> elems = new ArrayList<>();
        Iterator<No> it = nos();
        while (it.hasNext()) {
            elems.add(it.next().getElement());
        }
        return elems.iterator();
    }
}
 