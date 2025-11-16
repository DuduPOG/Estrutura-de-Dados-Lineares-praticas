public class Seq_Lista {
    public static class SeqListaLigada extends No implements Seq_Interface{
        private int size;
        private No head;
        private No tail;
                
        public SeqListaLigada(){
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

        public No find(Object o){
            No current = this.head.getNext();
            No other_current = this.tail.getPrev();
            while (current != this.tail && other_current != this.head) {
                if (current.getValue() == o){
                    return current;
                }
                if (other_current.getValue() == o){
                    return other_current;
                }
                current = current.getNext();
                other_current = other_current.getNext();
            }
            return null;
        }
        
        public No atRank(int index) throws ESeqIndice, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
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

        public int rankOf(No no) throws ElementoInexistente{
            No current = this.head.getNext();
            int index = 0;
            while (current != no && current != this.tail) { 
                current = current.getNext();
                index++;
            }
            if (current == this.tail){
                throw new ElementoInexistente("Esse nó não existe na sequência");
            }
            return index;
        }

        @Override
        public boolean isEmpty(){
            return this.size == 0;
        }

        @Override
        public boolean isFirst(Object n){
            if (isEmpty()){
                return false;
            }
            return this.head.getNext().getValue() == n;
        }

        @Override
        public boolean isLast(Object n){
            if (isEmpty()){
                return false;
            }
            return this.tail.getPrev().getValue() == n;
        }

        @Override
        public Object first() throws ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            return this.head.getNext().getValue();
        }

        @Override
        public Object last() throws ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            return this.tail.getPrev().getValue();
        }

        @Override
        public Object before(int p) throws ESeqIndice, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            if (p < 0 || p >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta sequência só tem um elemento");
            }
            if (p == this.size - 1){
                return this.tail.getPrev().getPrev().getValue();
            }
            if (p == 0){
                throw new ESeqIndice("Não existe um elemento antes do último elemento");
            }
            No current = atRank(p);
            return current.getPrev().getValue();
        }

        @Override
        public Object after(int p) throws ESeqIndice, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            if (p < 0 || p >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta sequência só tem um elemento");
            }
            if (p == this.size - 1){
                throw new ESeqIndice("Não existe um elemento depois do último elemento");
            }
            if (p == 0){
                return this.head.getNext().getNext().getValue();
            }
            No current = atRank(p);
            return current.getNext().getValue();
        }

        @Override
        public void insertBefore(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            No current = find(n);
            if (current == null){
                throw new ElementoInexistente("O elemento 'n' não está presente na sequência");
            }
            No toAdd = new No();
            toAdd.setValue(o);
            toAdd.setNext(current);
            toAdd.setPrev(current.getPrev());
            current.getPrev().setNext(toAdd);
            current.setPrev(toAdd);
            this.size++;
        }

        @Override
        public void insertAfter(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            No current = find(n);
            if (current == null){
                throw new ElementoInexistente("O elemento 'n' não está presente na sequência");
            }
            No toAdd = new No();
            toAdd.setValue(o);
            toAdd.setPrev(current);
            toAdd.setNext(current.getNext());
            current.getNext().setPrev(toAdd);
            current.setNext(toAdd);
            this.size++;
        }
        
        @Override
        public void swapElements(Object n, Object q) throws ElementoInexistente, ESeqVazia{
            if (this.size < 2){
                throw new ESeqVazia("Não é possível trocar elementos de uma sequência com menos de 2 elementos ou vazia");
            }
            No N = find(n);
            No Q = find(q);
            if (N == null || Q == null){
                throw new ElementoInexistente("Um dos elementos não existe");
            }
            Object aux = N.getValue();
            N.setValue(Q.getValue());
            Q.setValue(aux);
        }
        
        public Object removeNo(No no) {
            Object to_remove = no.getValue();
            no.getPrev().setNext(no.getNext());
            no.getNext().setPrev(no.getPrev());
            this.size--;
            return to_remove;
        }

        @Override
        public Object remove(Object n) throws ESeqVazia, ElementoInexistente{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível remover um elemento de uma sequência vazia");
            }
            if (this.head.getNext().getValue() == n){
                Object to_remove = this.head.getNext().getValue();
                this.head.setNext(this.head.getNext().getNext());
                this.head.getNext().setPrev(this.head);
                this.size--;
                return to_remove;
            }
            if (this.tail.getPrev().getValue() == n){
                Object to_remove = this.tail.getPrev().getValue();
                this.tail.setPrev(this.tail.getPrev().getPrev());
                this.tail.getPrev().setNext(this.tail);
                this.size--;
                return to_remove;
            }
            No to_remove = find(n);
            if (to_remove != null){
                return removeNo(to_remove);
            }
            throw new ElementoInexistente("Não é possível remover um elemento que não existe");
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
        public Object elemAtRank(int index) throws ESeqIndice, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Não é possível mostrar um elemento de uma sequência vazia");
            }
            if(index < 0 || index > this.size){
                throw new ESeqIndice("Índice inválido");
            }
            return atRank(index).getValue();
        }

        @Override
        public void insertAtRank(int index, Object o) throws ESeqIndice{
            if(index < 0 || index > this.size){
                throw new ESeqIndice("Índice inválido");
            }
            No to_add = new No();
            to_add.setValue(o);
            if (index == 0){
                to_add.setPrev(this.head);
                to_add.setNext(this.head.getNext());
                this.head.getNext().setPrev(to_add);
                this.head.setNext(to_add);
                this.size++;
                return;
            }
            if (index == this.size){
                to_add.setNext(this.tail);
                to_add.setPrev(this.tail.getPrev());
                this.tail.getPrev().setNext(to_add);
                this.tail.setPrev(to_add);
                this.size++;
                return;
            }
            No current = atRank(index);
            to_add.setNext(current);
            to_add.setPrev(current.getPrev());
            current.getPrev().setNext(to_add);
            current.setPrev(to_add);
            this.size++;
        }

        @Override
        public Object removeAtRank(int index) throws ESeqVazia, ESeqIndice{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível substituir elementos de uma sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            No to_remove = atRank(index);
            to_remove.getNext().setPrev(to_remove.getPrev());
            to_remove.getPrev().setNext(to_remove.getNext());
            this.size--;
            return to_remove.getValue();
        }

        @Override
        public Object replaceAtRank(int index, Object o) throws ESeqVazia, ESeqIndice{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível substituir elementos de uma sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            No old_no = atRank(index);
            Object old_element = old_no.getValue();
            old_no.setValue(o);
            return old_element;
        }

        @Override
        public Object replaceElement(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível substituir elementos de uma sequência vazia");
            }
            No to_replace = find(n);
            if (to_replace == null){
                throw new ElementoInexistente("Não é possível substituir um elemento que não existe");
            }
            Object replaced = to_replace.getValue();
            to_replace.setValue(o);
            return replaced;
        }
    }
}
 