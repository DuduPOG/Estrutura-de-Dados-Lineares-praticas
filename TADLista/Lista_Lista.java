public class Lista_Lista {
    public static class ListaListaLigada implements Lista_Interface {
        private int size;
        private No head;
        private No tail;

        private class No {
            No prev;
            Object value;
            No next;

            public No(){
                this.prev = null;
                this.value = null;
                this.next = null;
            }
        }
        

        public ListaListaLigada(){
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
            return this.head == null;
        }

        @Override
        public boolean isFirst(Object n){
            return this.head.next.value == n;
        }

        @Override
        public boolean isLast(Object n){
            return this.tail.prev.value == n;
        }

        @Override
        public Object first(){
            return this.head.next.value;
        }

        @Override
        public Object last(){
            return this.tail.prev.value;
        }

        @Override
        public Object before(Object p) throws EListaIndice{

        }

        @Override
        public Object after(Object p) throws EListaIndice{

        }
        
        @Override
        public Object swapElements(Object n, Object q) throws EVetorIndice, EVetorVazio{

        }
        
        @Override
        public Object remove(Object n) throws EListaVazia, ElementoInexistente{
            if (isEmpty()){
                throw new EListaVazia("Não é possível remover um elemento de uma lista vazia");
            }
            No current = this.head.next;
            while (current != this.tail){
                if (current.value == n){
                    break;
                }
                current = current.next;
            }
            if (current == this.tail){
                throw new ElementoInexistente("Não é possível remover um elemento que não existe");
            }
            Object to_remove = current.value;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            this.size--;
            return to_remove;
        }
        
        @Override
        public void insertFirst(Object o){
            No to_add = new No();
            to_add.value = 0;
            to_add.prev = this.head;
            to_add.next = this.head.next;
            if (this.head.next == null){
                this.tail.prev = to_add;
            } else{
                this.head.next.prev = to_add;
            }
            this.head.next = to_add;
            this.size++;           
        }

        @Override
        public void insertLast(Object o){
            No to_add = new No();
            to_add.value = 0;
            to_add.prev = this.tail.prev;
            to_add.next = this.tail;
            if (this.tail.prev == null){
                this.head.next = to_add;
            } else{
                this.tail.prev.next = to_add;
            }
            this.tail.prev = to_add;
            this.size++;   
        }

        @Override
        public Object replaceElement(int n, Object o) throws EListaIndice, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Não é possível substituir elementos de uma lista vazia");
            }
            if (n < 0 || n >= this.size){
                throw new EListaIndice("Índice Ínvalido");
            }
            if (n == 0){
                Object replaced = this.head.next.value;
                this.head.next.value = o;
                return replaced;
            }
            if (n == this.size - 1){
                Object replaced = this.tail.prev.value;
                this.tail.prev.value = o;
                return replaced;
            }
            if (n < this.size / 2){
                No current = this.head.next;
                for (int i = 1; i < this.size; ++i){
                    current = current.next;
                }
                Object replaced = current.value;
                current.value = o;
                return replaced;
            }
            No current = this.head.next;
                for (int i = this.size - 1; i > n; ++i){
                    current = current.prev;
                }
                Object replaced = current.value;
                current.value = o;
                return replaced;
        }
    }
}
 