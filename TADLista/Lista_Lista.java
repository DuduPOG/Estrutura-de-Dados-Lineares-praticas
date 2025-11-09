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
        public Object remove(Object n) throws EListaVazia{

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

        }
    }
}
 