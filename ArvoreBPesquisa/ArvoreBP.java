import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBP {
    public static class ArvoreBinariaPesquisa extends No implements IArvore{
        private No raiz;
        private int tamanho;

        public ArvoreBinariaPesquisa() {
            this.raiz = null;
            this.tamanho = 0;
        }

        @Override
        public No raiz() {
            return this.raiz;
        }

        @Override
        public int size() {
            return this.tamanho;
        }

        @Override
        public boolean isEmpty() {
            return raiz == null;
        }

        @Override
        public No pai(No n) {
            return n.pai;
        }

        @Override
        public boolean ERaiz(No n) {
            return n == raiz;
        }

        @Override
        public int profunidade(No n) {
            if (n == raiz){
                return 0;
            }
            return 1 + depth(n.parent);
        }

        @Override
        public int altura(No n) {
            if (n == null || n.EExterno()){
                return 0;
            }
            return 1 + Math.max(height(n.left), height(n.right));
        }

        public No leftChild(No n) {
            return n.left;
        }

        public No rightChild(No n) {
            return n.right;
        }

        public boolean hasLeft(No n) {
            return n.hasLeft();
        }

        public boolean hasRight(No n) {
            return n.hasRight();
        }


        public No insert(int key) {

            if (raiz == null) {
                raiz = new No(null, key);
                tamanho++;
                return raiz;
            }

            No atual = raiz;
            No pai = null;

            while (atual != null) {
                pai = atual;
                int v = (int) atual.element;

                if (key < v){
                    atual = atual.left;
                }else{
                    atual = atual.right;
                }
            }

            No novo = new No(pai, key);

            if (key < (int) pai.element){
                pai.left = novo;
            }else{
                pai.right = novo;
            }
            tamanho++;
            return novo;
        }

        public void remove(int key) {
            No pai = null;
            No atual = raiz;

            while (atual != null && (int) atual.element != key) {
                pai = atual;
                if (key < (int) atual.element){
                    atual = atual.left;
                }else{
                    atual = atual.right;
                }
            }

            if (atual == null){
                return;
            }

            if (atual.left == null && atual.right == null) {

                if (pai == null) {
                    raiz = null;
                }
                else if (pai.left == atual){
                    pai.left = null;
                }else{
                    pai.right = null;
                }
                tamanho--;
                return;
            }

            if (atual.left == null || atual.right == null) {

                Node filho = (atual.left != null) ? atual.left : atual.right;

                if (pai == null){
                    raiz = filho;
                }else if (pai.left == atual){
                    pai.left = filho;
                }else{
                    pai.right = filho;
                }
                filho.parent = pai;
                tamanho--;
                return;
            }

            Node pSucc = atual;
            Node succ = atual.right;

            while (succ.left != null) {
                pSucc = succ;
                succ = succ.left;
            }

            atual.element = succ.element;

            if (pSucc.left == succ) {
                pSucc.left = succ.right;
                if (succ.right != null) succ.right.parent = pSucc;
            } else {
                pSucc.right = succ.right;
                if (succ.right != null) succ.right.parent = pSucc;
            }
            tamanho--;
        }

        public void preOrder(No n) {
            if (n == null){
                return;
            }
            System.out.print(n.element + " ");
            preOrder(n.left);
            preOrder(n.right);
        }

        public void inOrder(No n) {
            if (n == null){
                return;
            }
            inOrder(n.left);
            System.out.print(n.element + " ");
            inOrder(n.right);
        }

        public void postOrder(No n) {
            if (n == null){
                return;
            }
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.element + " ");
        }

        public Iterator<No> nodes() {
            ArrayList<No> lista = new ArrayList<>();
            preOrderList(raiz, lista);
            return lista.iterator();
        }

        private void preOrderList(No n, ArrayList<No> lista) {
            if (n == null){
                return;
            }
            lista.add(n);
            preOrderList(n.left, lista);
            preOrderList(n.right, lista);
        }

        public Iterator<Object> elements() {
            ArrayList<Object> elems = new ArrayList<>();
            Iterator<Node> it = nodes();
            while (it.hasNext()){
                elems.add(it.next().element);
            }
            return elems.iterator();
        }


        public void desenharArvore() {
            int h = altura(raiz);
            int largura = (int) Math.pow(2, h + 1) - 1;

            String[][] mat = new String[h + 1][largura];

            for (int i = 0; i <= h; i++){
                for (int j = 0; j < largura; j++){
                    mat[i][j] = " ";
                }
            }

            preencherMatriz(raiz, mat, 0, 0, largura - 1);

            for (int i = 0; i <= h; i++) {
                for (int j = 0; j < largura; j++){
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
        }

        private void preencherMatriz(No n, String[][] mat, int linha, int esq, int dir) {
            if (n == null){
                return;
            }
            int meio = (esq + dir) / 2;
            mat[linha][meio] = String.valueOf(n.element);

            preencherMatriz(n.left, mat, linha + 1, esq, meio - 1);
            preencherMatriz(n.right, mat, linha + 1, meio + 1, dir);
        }


        public class No {

            private No pai;
            private Object element;
            private No FE;
            private No FD;

            public No(No pai, Object element) {
                this.pai = pai;
                this.element = element;
            }

            public Object getElement() {
                return element;
            }

            public No pai() {
                return this.pai;
            }

            public boolean hasLeft() {
                return this.FE != null;
            }

            public boolean hasRight() {
                return this.FD != null;
            }

            public boolean EExterno() {
                return this == null && right == null;
            }

            public boolean EInterno() {
                return !(EExterno());
            }

            public int childrenNumber() {
                int c = 0;
                if (left != null){
                    c++;
                }
                if (right != null){
                    c++;
                }
                return c;
            }

            public Iterator<No> children() {
                ArrayList<No> f = new ArrayList<>();
                if (left != null){
                    f.add(left);
                }
                if (right != null){
                    f.add(right);
                }
                return f.iterator();
            }
        }
    }
}