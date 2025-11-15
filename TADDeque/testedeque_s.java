import java.time.Duration;
import java.time.Instant;

public class testedeque_s {
    public static class Deque_Simples_Ligacao implements Deque {
        private No head;
        private No tail;
        private int size;
        private class No {
            Object value;
            No next;

            public No() {
                this.value = null;
                this.next = null;
            }
        }

        public Deque_Simples_Ligacao() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.head == null;
        }


        @Override
        public Object first() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            return this.head.value;
        }

        @Override
        public Object last() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            return this.tail.value;
        }

        @Override
        public void push_front(Object o) {
            No novo_no = new No();
            novo_no.next = this.head;
            novo_no.value = o;
            if (isEmpty()){
                this.tail = novo_no;
            }
            this.head = novo_no;
            ++this.size;
        }

        @Override
        public void push_back(Object o) {
            No novo_no = new No();
            novo_no.next = null;
            novo_no.value = o;
            if (isEmpty()){
                this.head = novo_no;
            } else {
                this.tail.next = novo_no;    
            }
            this.tail = novo_no;
            ++this.size;
        }

        @Override
        public Object pop_front() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            Object to_remove = this.head.value;
            if (this.size == 1){
                this.head = null;
                this.tail = null;
                this.size = 0;
            } else {
                this.head = this.head.next;
                --this.size;
            }
            return to_remove;
        }

        @Override
        public Object pop_back() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            Object to_remove = this.tail.value;
            if (this.size == 1){
                this.head = null;
                this.tail = null;
                this.size = 0;
            } else {
                No to_delete = this.head;
                while (to_delete.next != this.tail){
                    to_delete = to_delete.next;
                }
                to_delete.next = null;
                this.tail = to_delete;
                --this.size;
            }
            return to_remove;
        }

    }

	public static void main(String[] args) {
        Instant inicio = Instant.now();	
		Deque_Simples_Ligacao pp = new Deque_Simples_Ligacao();
		System.out.println("inserindo");
		for(int f = 0; f < 32768; f++){		  
		  pp.push_front(f);
          pp.push_back(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 32768; f++){
            pp.pop_front();
            pp.pop_back();
		}
        Instant fim = Instant.now();
        Duration tempoDecorrido = Duration.between(inicio, fim);
        long tempo = tempoDecorrido.toMillis();
        System.out.println("Tempo decorrido: " + tempo + " milissegundos");
	}
}
