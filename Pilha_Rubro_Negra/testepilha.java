/*
 * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class testepilha {

    public static class PilhaArray implements Pilha {
        private int capacity;
        private Object[] a;
        private int size;
        private int size_vermelho;
        private int size_preto;
        private int t_p;
        private int t_v;

        public PilhaArray(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.t_p = this.capacity;
            this.t_v = -1;
            this.a = new Object[this.capacity];
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public int size_vermelho() {
            this.size_vermelho = this.t_v + 1;
            return this.size_vermelho;
        }

        @Override
        public int size_preto() {
            this.size_preto = this.capacity - this.t_p;
            return this.size_preto;
        }

        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override
        public boolean isEmpty_vermelho() {
            return this.t_v == -1;
        }

        @Override
        public boolean isEmpty_preto() {
            return this.t_p == this.capacity;
        }

        @Override
        public Object top_vermelho() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_vermelho()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return this.a[this.t_v];
        }

        @Override
        public Object top_preto() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_preto()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return this.a[this.t_p];
        }

        @Override
        public void push_vermelho(Object o) {
            if (this.t_p - this.t_v == 1) {
                int tam_pilha_p = this.size_preto();
                this.capacity *= 2;
                Object b[] = new Object[this.capacity];
                for (int i = 0; i < this.t_v + 1; ++i) {
                    b[i] = this.a[i];
                }
                int novo_topo = this.capacity - tam_pilha_p;
                for (int i = 0; i < tam_pilha_p; i++) {
                    b[novo_topo + i] = this.a[this.t_p + i];
                }
                this.t_p = novo_topo;
                this.a = b;
            }
            this.a[++this.t_v] = o;
            ++this.size;
        }

        @Override
        public void push_preto(Object o) {
            if (this.t_p - this.t_v == 1) {
                int tam_pilha_p = this.size_preto();
                this.capacity *= 2;
                Object b[] = new Object[this.capacity];
                for (int i = 0; i < this.t_v + 1; ++i) {
                    b[i] = this.a[i];
                }
                int novo_topo = this.capacity - tam_pilha_p;
                for (int i = 0; i < tam_pilha_p; i++) {
                    b[novo_topo + i] = this.a[this.t_p + i];
                }
                this.t_p = novo_topo;
                this.a = b;
            }
            this.a[--this.t_p] = o;
            ++this.size;
        }

        @Override
        public Object pop_vermelho() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_vermelho()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            Object last_value = this.a[this.t_v];
            --this.t_v;
            --this.size;
            if (this.size * 1.0 / this.capacity <= 1.0 / 3){
                int tam_pilha_p = this.size_preto();
                this.capacity /= 2;
                Object b[] = new Object[this.capacity];
                for(int i = 0; i < this.t_v + 1; ++i){
                    b[i] = this.a[i];
                }
                int novo_topo = this.capacity - tam_pilha_p;
                for (int i = 0; i < tam_pilha_p; i++) {
                    b[novo_topo + i] = this.a[this.t_p + i];
                }
                this.t_p = novo_topo;
                this.a = b;
            }
            return last_value;
        }

        @Override
        public Object pop_preto() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_preto()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            Object last_value = this.a[this.t_p];
            ++this.t_p;
            --this.size;
            if (this.size * 1.0 / this.capacity <= 1.0 / 3){
                int tam_pilha_p = this.size_preto();
                this.capacity /= 2;
                Object b[] = new Object[this.capacity];
                for(int i = 0; i < this.t_v + 1; ++i){
                    b[i] = this.a[i];
                }
                int novo_topo = this.capacity - tam_pilha_p;
                for (int i = 0; i < tam_pilha_p; i++) {
                    b[novo_topo + i] = this.a[this.t_p + i];
                }
                this.t_p = novo_topo;
                this.a = b;
            }
            return last_value;
        }
    }


	public static void main(String[] args) {			
		PilhaArray pp = new PilhaArray(1);
		System.out.println("inserindo");
		for(int f = 0; f < 65536; f++){		  
		  pp.push_vermelho(f);
          pp.push_preto(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 65536; f++){
			pp.pop_vermelho();
            pp.pop_preto();
		}
	}
}
