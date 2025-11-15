public class testeFila {
    public static class FilaArray implements Fila {
        private int tamanho;
        private int capacidade;
        private int primeiro;
        private int finalFila;
        private Object[] a;

        public FilaArray(int capacidade) {
            this.tamanho = 0;
            this.capacidade = capacidade;
            this.primeiro = 0;
            this.finalFila = this.primeiro + 1;
            this.a = new Object[this.capacidade];
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
        public boolean estaCheia(){
            return this.primeiro + 1 == this.finalFila;
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
            if (estaCheia()){
                int antiga_capacidade = this.capacidade;
                this.capacidade *= 2;
                Object[] b = new Object[this.capacidade];
                for (int i = 0; i < this.tamanho; ++i){
                    int ii = (this.primeiro + i) % antiga_capacidade;
                    b[i] = this.a[ii];
                }
                this.a = b;
                this.primeiro = 0;
                this.a[this.finalFila] = o;
                this.finalFila = ++this.tamanho;
            } else {
            this.a[this.finalFila] = o;
            ++this.tamanho;
            this.finalFila = (this.finalFila + 1) % this.capacidade;
            }
        }

        @Override
        public Object desenfileirar() throws EFilaVazia {
            if (estaVazia()){
                throw new EFilaVazia("A fila está vazia");
            }
            Object saindo = this.a[this.primeiro];
            this.primeiro = (this.primeiro + 1) % this.capacidade;
            --this.tamanho;
            return saindo;
        }
    }

    public static void main(String[] args) {			
		FilaArray pp = new FilaArray(1);
		System.out.println("inserindo");
		for(int f = 0; f < 16; f++){
		  System.out.println(f);		  
		  pp.push_v(f);
          pp.push_p(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 16; f++){
			  System.out.print(f);
			  System.out.println(" - " + pp.pop_v());
              System.err.print(f);
              System.out.println(" . " + pp.pop_p());
		}
	}
}
