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
            this.head = new No();
            this.tail = new No();
            this.head.next = this.tail;
            this.tail.prev = this.head;
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
        public boolean isFirst(Object n) throws EListaVazia{
            if (isEmpty()){
                return false;
            }
            return this.head.next.value == n;
        }

        @Override
        public boolean isLast(Object n) throws EListaVazia{
            if (isEmpty()){
                return false;
            }
            return this.tail.prev.value == n;
        }

        @Override
        public Object first() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.head.next.value;
        }

        @Override
        public Object last() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.tail.prev.value;
        }

        @Override
        public Object before(int p) throws EListaIndice, EListaVazia{
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (p == 0){
                throw new EListaIndice("Não existe um elemento antes do primeiro elemento");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Este é o único elemento da lista");
            }
            if (p == this.size - 1){
                return this.tail.prev.prev.value;
            }
            No current = this.head.next.next;
            int index = 1;
            while (current != this.tail){
                if (index == p){
                    break;
                }
                index++;
                current = current.next;
            }
            return current.prev.value;
        }

        @Override
        public Object after(int p) throws EListaIndice, EListaVazia{
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (p == this.size - 1){
                throw new EListaIndice("Não existe um elemento depois do último elemento");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Este é o único elemento da lista");
            }
            if (p == 0){
                return this.head.next.next.value;
            }
            No current = this.head.next.next;
            int index = 0;
            while (current != this.tail.prev){
                if (index == p){
                    break;
                }
                index++;
                current = current.next;
            }
            return current.next.value;
        }

        @Override
        public void insertBefore(Object n, Object o) throws ElementoInexistente, EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (n == this.head.next.value){
                No toAdd = new No();
                toAdd.prev = this.head;
                toAdd.value = o;
                toAdd.next = this.head.next;
                this.head.next.prev = toAdd;
                this.head.next = toAdd;
                this.size++;
                return;
            }
            if (n == this.tail.prev.value){
                No toAdd = new No();
                toAdd.prev = this.head.prev.prev;
                toAdd.value = o;
                toAdd.next = this.tail.prev;
                this.tail.prev.prev.next = toAdd;
                this.tail.prev.prev = toAdd;
                this.size++;
                return;
            }
            No current = this.head.next.next;
            while (current != this.tail){
                if (current.value == n){
                    No toAdd = new No();
                    toAdd.prev = current.prev;
                    toAdd.value = o;
                    toAdd.next = current.next;
                    current.prev.next = toAdd;
                    current.prev = toAdd;
                    this.size++;
                    return;
                }
            }
            throw new ElementoInexistente("O elemento 'n' não está presente na lista");
        }

        @Override
        public void insertAfter(Object n, Object o) throws ElementoInexistente, EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (n == this.head.next.value){
                No toAdd = new No();
                toAdd.prev = this.head.next;
                toAdd.value = o;
                toAdd.next = this.head.next.next;
                this.head.next.next.prev = toAdd;
                this.head.next.next = toAdd;
                this.size++;
                return;
            }
            if (n == this.tail.prev.value){
                No toAdd = new No();
                toAdd.prev = this.head.prev;
                toAdd.value = o;
                toAdd.next = this.tail;
                this.tail.prev.next = toAdd;
                this.tail.prev = toAdd;
                this.size++;
                return;
            }
            No current = this.head.next.next;
            while (current != this.tail){
                if (current.value == n){
                    No toAdd = new No();
                    toAdd.prev = current;
                    toAdd.value = o;
                    toAdd.next = current.next;
                    current.next.prev = toAdd;
                    current.next = toAdd;
                    this.size++;
                    return;
                }
            }
            throw new ElementoInexistente("O elemento 'n' não está presente na lista");
        }
        
        @Override
        public void swapElements(Object n, Object q) throws ElementoInexistente, EListaVazia{
            if (this.size < 2){
                throw new EListaVazia("Não é possível trocar elementos de uma lista com menos de 2 elementos ou vazia");
            }
            No N = null;
            No Q = null;
            No current = this.head.next;
            while (current != this.tail){
                if (current.value == n){
                    N = current;
                }
                if (current.value == q){
                    Q = current;
                }
                current = current.next;
            }
            if (N == null || Q == null){
                throw new ElementoInexistente("Um dos elementos não existe");
            }
            Object aux = N.value;
            N.value = Q.value;
            Q.value = aux;
        }
        
        @Override
        public Object remove(Object n) throws EListaVazia, ElementoInexistente{
            if (isEmpty()){
                throw new EListaVazia("Não é possível remover um elemento de uma lista vazia");
            }
            if (this.head.next.value == n){
                Object to_remove = this.head.next.value;
                this.head.next = this.head.next.next;
                this.size--;
                return to_remove;
            }
            if (this.tail.prev.value == n){
                Object to_remove = this.tail.prev.value;
                this.tail.prev = this.tail.prev.prev;
                this.size--;
                return to_remove;
            }
            No current = this.head.next.next;
            while (current != this.tail.prev){
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
            to_add.value = o;
            to_add.prev = this.head;
            to_add.next = this.head.next;
            this.head.next.prev = to_add;
            this.head.next = to_add;
            this.size++;           
        }

        @Override
        public void insertLast(Object o){
            No to_add = new No();
            to_add.value = o;
            to_add.prev = this.tail.prev;
            to_add.next = this.tail;
            this.tail.prev.next = to_add;
            this.tail.prev = to_add;
            this.size++;   
        }

        @Override
        public Object replaceElement(Object n, Object o) throws ElementoInexistente, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Não é possível substituir elementos de uma lista vazia");
            }
            if (n == this.head.next.value){
                Object replaced = this.head.next.value;
                this.head.next.value = o;
                return replaced;
            }
            if (n == this.tail.prev.value){
                Object replaced = this.tail.prev.value;
                this.tail.prev.value = o;
                return replaced;
            }
            No current = this.head.next.next;
            while (current != this.tail.prev){
                if (current.value == n){
                    break;
                }
                current = current.next;
            }
            if (current.value != n){
                throw new ElementoInexistente("Não é possível substituir um valor inexistente");
            }
            Object replaced = current.value;
            current.value = o;
            return replaced;
        }
    }
}
 