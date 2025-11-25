public class ArvoreG{
    public static class Arvore extends No implements IArvore{
        private No raiz;
        private int size;
        private Object element;
        private Object[] filhos;

        public Arvore(){
            this.size = 0;
            this.element = null;
            this.filhos = null;
        }

        @Override
        public int size(){
            return this.size;
        }

        @Override
        public boolean isEmpty(){
            return this.size == 0;
        }

        @Override
        public boolean EInterno(No no){
            return this.filhos != null;
        }

        @Override
        public boolean EExterno(No no){
            return this.filhos == null;
        }

        @Override
        public boolean ERaiz(No no){
            return this.pai == null;
        }

        @Override
        public No pai(No no){
            return this.pai;
        }

        public Object filhos(No no){
            return this.filhos;
        }

        @Override
        public int profundidade(No no){
            if (ERaiz(no)){
                return 0;
            }
            return 1 + profundidade(pai(no));
        }

        @Override
        public int altura(No no){
            if (EExterno(no)){
                return 0;
            }
            int h = 0;
            for (Object o : filhos) {
                h = Math.max(h, altura(o));
            }
            return 1 + h;
        }

        @Override
        public Object replace(No no, Object o){
            Object oldElement = this.element;
            this.element = o;
            return oldElement;
        }
    }
}