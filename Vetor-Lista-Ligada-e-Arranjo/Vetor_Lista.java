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
            No current = this.head;
            for (int i = 0; i < index; i++){
                current = current.next;
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
            Object to_remove;
            if (index == 0) {
                to_remove = this.head.value;
                this.head = this.head.next;
                if (this.head == null){
                    this.tail = this.head;
                }else{
                    this.head.prev = null;
                }
                this.size--;
                return to_remove;
            }
            if (index == this.size - 1) { 
                to_remove = this.tail.value;
                this.tail = this.tail.prev;
                if (this.tail == null){
                    this.head = this.tail;
                }else{
                    this.tail.next = null; 
                }
                this.size--;
                return to_remove;
            }
            if (index < this.size / 2){
                No current = this.head;
                for (int i = 0; i < index; ++i){
                    current = current.next;
                }
                to_remove = current.value;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                this.size--;
                return to_remove;
            }else{
                No current = this.tail;
                for (int i = this.size - 1; i > index; --i){
                    current = current.prev;
                }
                to_remove = current.value;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                this.size--;
                return to_remove;
            }
        }
        
        @Override
        public void insertAtRank(int index, Object o) throws EVetorIndice {
            if(index < 0 || index > this.size){
                throw new EVetorIndice("Índice inválido");
            } else {
                if (index == 0){
                    No to_add = new No();
                    to_add.value = o;
                    to_add.prev = null;
                    to_add.next = this.head;
                    if (this.head == null){
                        this.tail = to_add;
                    }else{
                        this.head.prev = to_add;
                    }
                    this.head = to_add;
                    this.size++;
                    return;
                }
                if (index == this.size){
                    No to_add = new No();
                    to_add.value = o;
                    to_add.next = null;
                    to_add.prev = this.tail;
                    if (this.tail == null){
                        this.head = to_add;
                    }else{
                        this.tail.next = to_add; 
                    }
                    this.tail = to_add;
                    this.size++;
                    return;
                }
                No to_add = new No();
                to_add.value = o;
                if (index < this.size / 2){
                    No current = this.head;
                    for(int i = 0; i < index; ++i){
                        current = current.next;
                    }
                    to_add.next = current;
                    to_add.prev = current.prev;
                    current.prev.next = to_add;
                    current.prev = to_add;
                    this.size++;
                }else{
                    No current = this.tail;
                    for(int i = this.size - 1; i > index; --i){
                        current = current.prev;
                    }
                    to_add.next = current;
                    to_add.prev = current.prev;
                    current.prev.next = to_add;
                    current.prev = to_add;
                    this.size++;
                }
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
            Object old_element;
            No current = this.head;
            for (int i = 0; i < index; ++i){
                current = current.next;
            }
            old_element = current.value;
            current.value = o;
            return old_element;
        }
    }
}