public class ArvoreG{
    public static class Arvore extends No implements InterfaceArvore{
        private No pai;
        private int size;
        private Object element;
        private Object filhos;

        public Arvore(){
            this.pai = null;
            this.size = 0;
            this.element = null;
            this.filhos = null;
        }

        public int size(){
            return this.size;
        }

        public boolean EInterno(){
            if (this.filhos != null){
                return true;
            }
            return false;
        }

        public boolean EExterno(){
            if (this.filhos == null){
                return true;
            }
            return false;
        }

        public boolean ERaiz(){
            if (this.pai == null){
                return true;
            }
            return false;
        }

        public No pai(No no){
            return no.getPai();
        }

        public Object filhos(No no){
            return no.getFilhos();
        }

        public int profundidade(No no){
            if (ERaiz()){
                return 0;
            }
            return 1 + profundidade(pai(no));
        }

        public int altura(No no){
            if (EExterno()){
                return 0;
            }
            int h = 0;
            foreach (object elements in filhos(no));
            {
                h = System.Math.Max(h, altura(no));
            }
            return 1 + h;
        }
    }
}