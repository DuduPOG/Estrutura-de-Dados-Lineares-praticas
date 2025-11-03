public class Vetor_Lista {
    public static class VetorListaLigada implements Vetor_Interface {
        private int size;
        private No head;
        private No tail;
        private int f;
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
            this.f = this.size;
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

        public Object find(int index){
            int current_index = 0;
            No current = this.head;
            while(current_index != index){
                current = current.next;
                ++current_index;
            }
            return current.value;
        }

        @Override
        public Object elemAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível mostrar um elemento de um vetor vazio");
            }
            if (index >= this.f){
                throw new EVetorIndice("Índice inválido");
            }
            return this.a[index];
        }
        
        @Override
        public Object removeAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível remover um elemento de um vetor vazio");
            }
            if (index >= this.f){
                throw new EVetorIndice("Índice inválido");
            }
            Object to_remove = this.a[index];
            for(int i = index; i < this.f - 1; ++i){
                this.a[i] = this.a[i + 1];
            }
            this.size--;
            return to_remove;
        }
        
        @Override
        public void insertAtRank(int index, Object o) throws EVetorIndice {
            if(this.f == this.capacity - 1){
                this.capacity *= 2;
                Object[] b = new Object[this.capacity];
                for(int i = 0; i < index; ++i){
                    b[i] = this.a[i];
                }
                for(int i = index + 1; i < this.f; ++i){
                    b[i] = this.a[i - 1];
                }
                b[index] = o;
                this.a = b;
                ++this.size;
            } else{
            for(int i = this.f; i > index; --i){
                this.a[i] = this.a[i - 1];
            }
            this.a[index] = o;
            ++this.size;
            }
        }

        @Override
        public Object replaceAtRank(int index, Object o) throws EVetorIndice{
            if (index >= this.f){
                throw new EVetorIndice("Índice inválido");
            }
            Object old_element = find(index);
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
