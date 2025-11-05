public class Vetor_Lista {
    public static class VetorListaLigada implements Vetor_Interface {
        private int size;
        private No head;
        private No tail;
        private class No{
            No prev;
            Object value;
            No next;

            public No(){
                this.prev = null;
                this.value = null;
                this.next = null;
            }
        }
        public VetorListaLigada() {
            this.size = 0;
            this.head = null;
            this.tail = null;
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
        public Object elemAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível mostrar um elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.size){
                throw new EVetorIndice("Índice inválido");
            }
            int current_index = 0;
            No current = this.head;
            while(current_index != index){
                current = current.next;
                ++current_index;
            }
            return current.value;
        }
        
        @Override
        public Object removeAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível remover um elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.size){
                throw new EVetorIndice("Índice inválido");
            }
            if (index == 0){
                Object to_remove = this.head.value;
                this.head = this.head.next;
                this.head.prev = null;
                this.size--;
                return to_remove;
            }
            if (index == this.size - 1){
                Object to_remove = this.tail.value;
                this.tail = this.tail.prev;
                this.tail.next = null;
                this.size--;
                return to_remove;
            }
            Object to_remove = elemAtRank(index);
            int current_index = 0;
            No current = this.head;
            while (current.value != to_remove && current_index != index){
                current = current.next;
                current_index++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            this.size--;
            return to_remove;
        }
        
        @Override
        public void insertAtRank(int index, Object o) throws EVetorIndice {
            if(index < 0 || index >= this.size){
                throw new EVetorIndice("Índice inválido");
            } else {
                if (index == 0){
                    No to_add = new No();
                    to_add.value = o;
                    to_add.prev = null;
                    to_add.next = this.head.next;
                    this.head.next.prev = to_add;
                    this.head = to_add;
                    this.size++;
                    return;
                }
                if (index == this.size - 1){
                    No to_add = new No();
                    to_add.value = o;
                    to_add.next = null;
                    to_add.prev = this.tail.prev;
                    this.tail.prev.next = to_add;
                    this.tail = to_add;
                    this.size++;
                    return;
                }
                No to_add = new No();
                to_add.value = o;
                No current = this.head;
                for(int i = 0; i < index; ++i){
                    current = current.next;
                }
                to_add.next = current;
                to_add.prev = current.prev;
                current.prev.next = to_add;
                current.prev = to_add;
                this.size++;
            }
        }
        
        @Override
        public Object replaceAtRank(int index, Object o) throws EVetorIndice, EVetorVazio {
            if(isEmpty()){
                throw new EVetorVazio("Não é possível substituir elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.size){
                throw new EVetorIndice("Índice inválido");
            }
            Object old_element = elemAtRank(index);
            No current = this.head;
            while(current.value != old_element){
                current = current.next;
            }
            current.value = o;
            return  old_element;
        }
    }

    public static void main(String[] args) {			
		VetorListaLigada pp = new VetorListaLigada(1);
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
