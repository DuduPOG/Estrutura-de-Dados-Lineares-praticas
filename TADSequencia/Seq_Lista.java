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
                other_current = other_current.getPrev();
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

        public int rankOf(No no) throws NoInexistente{
            No current = this.head.getNext();
            No other_current = this.tail.getPrev();
            int index = 0;
            int other_index = this.size - 1;
            while (current != no && current != this.tail && other_current != no && other_current != this.head) { 
                current = current.getNext();
                other_current = other_current.getPrev();
                index++;
                other_index--;
            }
            if (current == this.tail && other_current == this.head){
                throw new NoInexistente("Esse nó não existe na sequência");
            }
            if (current == no){
                return index;
            }
            return other_index;
        }

        @Override
        public boolean isEmpty(){
            return this.size == 0;
        }

        @Override
        public boolean isFirst(No no){
            if (isEmpty()){
                return false;
            }
            return 0 == rankOf(no);
        }

        @Override
        public boolean isLast(No no){
            if (isEmpty()){
                return false;
            }
            return this.size - 1 == rankOf(no);
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
        public Object before(int index) throws ESeqIndice, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new NoInexistente("Esta sequência só tem um nó");
            }
            if (index == this.size - 1){
                return this.tail.getPrev().getPrev().getValue();
            }
            if (index == 0){
                throw new ESeqIndice("Não existe um nó antes do último elemento");
            }
            No current = atRank(index);
            return current.getPrev().getValue();
        }

        @Override
        public Object after(int index) throws ESeqIndice, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (this.size < 2){
                throw new NoInexistente("Esta sequência só tem um nó");
            }
            if (index == this.size - 1){
                throw new ESeqIndice("Não existe um nó depois do último elemento");
            }
            if (index == 0){
                return this.head.getNext().getNext().getValue();
            }
            No current = atRank(index);
            return current.getNext().getValue();
        }

        @Override
        public void insertBefore(No no, Object o) throws ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            int NoIndex = rankOf(no);
            No current = atRank(NoIndex);
            if (current == null){
                throw new NoInexistente("O Nó 'no' não está presente na sequência");
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
        public void insertAfter(No no, Object o) throws NoInexistente, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Sequência vazia");
            }
            int NoIndex = rankOf(no);
            No current = atRank(NoIndex);
            if (current == null){
                throw new NoInexistente("O Nó 'no' não está presente na sequência");
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
        public void swapElements(No no, No q) throws NoInexistente, ESeqVazia{
            if (this.size < 2){
                throw new ESeqVazia("Não é possível trocar as posições dos nós de uma sequência com menos de 2 nós ou vazia");
            }
            int NoIndex = rankOf(no);
            No N = atRank(NoIndex);
            int QIndex = rankOf(q);
            No Q = atRank(QIndex);
            if (N == null || Q == null){
                throw new NoInexistente("Um dos nós não existe");
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
        public Object remove(No no) throws ESeqVazia, NoInexistente{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível remover um nó de uma sequência vazia");
            }
            if (this.head.getNext().getValue() == no){
                Object to_remove = this.head.getNext().getValue();
                this.head.setNext(this.head.getNext().getNext());
                this.head.getNext().setPrev(this.head);
                this.size--;
                return to_remove;
            }
            if (this.tail.getPrev().getValue() == no){
                Object to_remove = this.tail.getPrev().getValue();
                this.tail.setPrev(this.tail.getPrev().getPrev());
                this.tail.getPrev().setNext(this.tail);
                this.size--;
                return to_remove;
            }
            int toRemoveIndex = rankOf(no);
            No to_remove = atRank(toRemoveIndex);
            if (to_remove != null){
                return removeNo(to_remove);
            }
            throw new NoInexistente("Não é possível remover um nó que não existe");
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
                throw new ESeqVazia("Não é possível remover um nó de uma sequência vazia");
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
                throw new ESeqVazia("Não é possível substituir um nó de uma sequência vazia");
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
        public Object replaceElement(No no, Object o) throws NoInexistente, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível substituir um nó de uma sequência vazia");
            }
            int toReplaceIndex = rankOf(no);
            No to_replace = atRank(toReplaceIndex);
            if (to_replace == null){
                throw new NoInexistente("Não existe um nó com esse elemento");
            }
            Object replaced = to_replace.getValue();
            to_replace.setValue(o);
            return replaced;
        }
    }
}
 