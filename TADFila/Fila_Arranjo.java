public class Fila_Arranjo {
    public static class FilaArray implements FilaInterface {
        private int tamanho;
        private int capacidade;
        private int primeiro;
        private int finalFila;
        private Object[] a;

        public FilaArray() {
            this.tamanho = 0;
            this.capacidade = 8;
            this.primeiro = 0;
            this.finalFila = this.primeiro;
            this.a = new Object[this.capacidade];
        }

        public void aumentar_capacidade(){
            int antiga_capacidade = this.capacidade;
            this.capacidade *= 2;
            Object[] b = new Object[this.capacidade];
            int ii;
            for (int i = 0; i < this.tamanho; ++i){
                ii = (this.primeiro + i) % antiga_capacidade;
                b[i] = this.a[ii];
            }
            this.a = b;
            this.primeiro = 0;
            this.finalFila = this.tamanho;
        }

        public void diminuir_capacidade(){
            int antiga_capacidade = this.capacidade;
            this.capacidade /= 2;
            Object[] b = new Object[this.capacidade];
            int ii;
            for (int i = 0; i < this.tamanho; ++i){
                ii = (this.primeiro + i) % antiga_capacidade;
                b[i] = this.a[ii];
            }
            this.a = b;
            this.primeiro = 0;
            this.finalFila = this.tamanho;
        }

        @Override
        public int tamanho(){
            return this.tamanho;
        }
        
        @Override
        public boolean estaVazia(){
            return this.primeiro == this.finalFila;
        }

        @Override
        public Object inicio() throws EFilaVazia {
            if (estaVazia()) {
                throw new EFilaVazia("A fila está vazia");
            }
            return this.a[this.primeiro];
        }

        @Override
        public void enfileirar(Object o){
            if (this.tamanho + 1 == this.capacidade){
                aumentar_capacidade();
            }
            this.a[this.finalFila] = o;
            ++this.tamanho;
            this.finalFila = (this.finalFila + 1) % this.capacidade;
        }

        @Override
        public Object desenfileirar() throws EFilaVazia {
            if (estaVazia()){
                throw new EFilaVazia("A fila está vazia");
            }
            if (this.tamanho * 1.0 / this.capacidade * 1.0 <= 1.0 / 3.0){
                diminuir_capacidade();
            }
            Object saindo = this.a[this.primeiro];
            this.primeiro = (this.primeiro + 1) % this.capacidade;
            --this.tamanho;
            return saindo;
        }
    }
}
