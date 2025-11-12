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
        public Object before(Object p) throws EListaIndice, ElementoInexistente, EListaVazia{
            if (p == this.head.next.value){
                throw new EListaIndice("Não existe um elemento antes do primeiro elemento");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Este é o único elemento da lista");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            No current = this.head.next.next;
            while (current != this.tail){
                if (current.value == p){
                    return current.prev.value;
                }
                current = current.next;
            }
            throw new ElementoInexistente("Não existe um elemento 'p'");
        }

        @Override
        public Object after(Object p) throws EListaIndice, ElementoInexistente, EListaVazia{
            if (p == this.tail.prev.value){
                throw new EListaIndice("Não existe um elemento depois do último elemento");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Este é o único elemento da lista");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            No current = this.head.next.next;
            while (current != this.tail.prev){
                if (current.value == p){
                    return current.next.value;
                }
                current = current.next;
            }
            throw new ElementoInexistente("Não existe um elemento 'p'");
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
            No current = this.head.next;
            for (int i = 1; i < this.size - 2; ++i){
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
 