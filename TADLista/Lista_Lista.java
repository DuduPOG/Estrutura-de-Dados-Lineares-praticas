public class Lista_Lista {
    public static class ListaListaLigada implements Lista_Interface {
        private int size;
        private No head;
        private No tail;
        
        public ListaListaLigada(){
            this.size = 0;
            this.head = new No();
            this.tail = new No();
            this.head.setNext(this.tail);
            this.tail.setPrev(this.head);
        }

        @Override
        public int size(){
            return this.size;
        }

        public No atRank(int index) throws EListaIndice, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (index < 0 || index >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            No current;
            if (index < this.size / 2){
                current = this.head.getNext();
                for (int i = 0; i < index; ++i){
                    current = current.getNext();
                }
            } else {
                current = this.tail.getPrev();
                for (int i = this.size - 1; i > index; --i){
                    current = current.getPrev();
                }
            }
            return current;
        }
        
        @Override
        public boolean isEmpty(){
            return this.size == 0;
        }

        @Override
        public boolean isFirst(No n){
            if (isEmpty()){
                return false;
            }
            return this.head.getNext() == n;
        }

        @Override
        public boolean isLast(No n){
            if (isEmpty()){
                return false;
            }
            return this.tail.getPrev() == n;
        }

        @Override
        public No first() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.head.getNext();
        }

        @Override
        public No last() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.tail.getPrev();
        }

        @Override
        public No before(int p) throws EListaIndice, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == 0){
                throw new EListaIndice("Não existe um elemento antes do primeiro elemento");
            }
            return atRank(p).getPrev();
        }

        @Override
        public No after(int p) throws EListaIndice, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == this.size - 1){
                throw new EListaIndice("Não existe um elemento depois do último elemento");
            }
            return atRank(p).getNext();
        }

        @Override
        public No insertBefore(No n, Object o) throws EListaVazia, NoInexistente{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (n.getPrev() == null || n.getNext() == null){
                throw new NoInexistente("Este nó não pertence à sequência");
            }
            No toAdd = new No();
            toAdd.setValue(o);
            toAdd.setNext(n);
            toAdd.setPrev(n.getPrev());
            n.getPrev().setNext(toAdd);
            n.setPrev(toAdd);
            this.size++;
            return toAdd;
        }

        @Override
        public No insertAfter(No n, Object o) throws EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (n.getPrev() == null || n.getNext() == null){
                throw new NoInexistente("Este nó não pertence à sequência");
            }
            No toAdd = new No();
            toAdd.setValue(o);
            toAdd.setPrev(n);
            toAdd.setNext(n.getNext());
            n.getNext().setPrev(toAdd);
            n.setNext(toAdd);
            this.size++;
            return toAdd;
        }
        
        @Override
        public void swapElements(No n, No q) throws EListaVazia, NoInexistente{
            if (this.size < 2){
                throw new EListaVazia("Não é possível trocar elementos de uma lista com menos de 2 elementos ou vazia");
            }
            Object aux = n.getValue();
            n.setValue(q.getValue());
            q.setValue(aux);
        }
        
        @Override
        public Object remove(No n) throws EListaVazia, NoInexistente{
            if (isEmpty()){
                throw new EListaVazia("Não é possível remover um elemento de uma lista vazia");
            }
            Object to_remove = n.getValue();
            n.getPrev().setNext(n.getNext());
            n.getNext().setPrev(n.getPrev());
            this.size--;
            return to_remove;
        }
        
        @Override
        public void insertFirst(Object o){
            No to_add = new No();
            to_add.setValue(o);
            to_add.setPrev(this.head);
            to_add.setNext(this.head.getNext());
            this.head.getNext().setPrev(to_add);
            this.head.setNext(to_add);
            this.size++;           
        }

        @Override
        public void insertLast(Object o){
            No to_add = new No();
            to_add.setValue(o);
            to_add.setPrev(this.tail.getPrev());
            to_add.setNext(this.tail);
            this.tail.getPrev().setNext(to_add);
            this.tail.setPrev(to_add);
            this.size++;   
        }

        @Override
        public Object replaceElement(No n, Object o) throws ElementoInexistente, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Não é possível substituir um nó de uma sequência vazia");
            }
            if (n.getPrev() == null || n.getNext() == null){
                throw new NoInexistente("Este nó não pertence à sequência");
            }
            Object replaced = n.getValue();
            n.setValue(o);
            return replaced;
        }
    }
}
 