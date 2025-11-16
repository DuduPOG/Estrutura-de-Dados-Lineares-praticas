public class Seq_Lista extends No{
    public static class SeqListaLigada implements Seq_Interface {
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
        
        public No atRank(int index) throws ESeqIndice, ESeqVazia{
            No current = new No();
            return current;
        }

        public int rankOf(No no) throws ElementoInexistente{
            return 0;
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
                throw new ESeqVazia("Lista vazia");
            }
            return this.head.getNext().getValue();
        }

        @Override
        public Object last() throws ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Lista vazia");
            }
            return this.tail.getPrev().getValue();
        }

        @Override
        public Object before(int p) throws ESeqIndice, ESeqVazia{
            if (p < 0 || p >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (isEmpty()){
                throw new ESeqVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == 0){
                throw new ESeqIndice("Não existe um elemento antes do primeiro elemento");
            }
            if (p == this.size - 1){
                return this.tail.getPrev().getPrev().getValue();
            }
            if (p < this.size / 2){
                No current = this.head.getNext();
                int index = 0;
                while (current != this.tail.getPrev()){
                    if (index == p){
                        break;
                    }
                    index++;
                    current = current.getNext();
                }
                return current.getPrev().getValue();
            }
            No current = this.tail.getPrev();
            int index = this.size - 1;
            while (current != this.head.getNext()){
                if (index == p){
                    break;
                }
                index--;
                current = current.getPrev();
            }
            return current.getPrev().getValue();
        }

        @Override
        public Object after(int p) throws ESeqIndice, ESeqVazia{
            if (p < 0 || p >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (isEmpty()){
                throw new ESeqVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == this.size - 1){
                throw new ESeqIndice("Não existe um elemento depois do último elemento");
            }
            if (p == 0){
                return this.head.getNext().getNext().getValue();
            }
            if (p < this.size / 2){
               No current = this.head.getNext();
                int index = 0;
                while (current != this.tail.getPrev()){
                    if (index == p){
                        break;
                    }
                    index++;
                    current = current.getNext();
                }
                return current.getNext().getValue(); 
            }
            No current = this.tail.getPrev();
            int index = this.size - 1;
            while (current != this.head.getNext()){
                if (index == p){
                    break;
                }
                index--;
                current = current.getPrev();
            }
            return current.getNext().getValue(); 
        }

        @Override
        public void insertBefore(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Lista vazia");
            }
            if (n == this.head.getNext().getValue()){
                No toAdd = new No();
                toAdd.setPrev(this.head);
                toAdd.setValue(o);
                toAdd.setNext(this.head.getNext());
                this.head.getNext().setPrev(toAdd);
                this.head.setNext(toAdd);
                this.size++;
                return;
            }
            if (n == this.tail.getPrev().getValue()){
                No toAdd = new No();
                toAdd.setPrev(this.tail.getPrev().getPrev());
                toAdd.setValue(o);
                toAdd.setNext(this.tail.getPrev());
                this.tail.getPrev().getPrev().setNext(toAdd);
                this.tail.getPrev().setPrev(toAdd);
                this.size++;
                return;
            }
            No current = this.head.getNext().getNext();
            while (current != this.tail){
                if (current.getValue() == n){
                    No toAdd = new No();
                    toAdd.setPrev(current.getPrev());
                    toAdd.setValue(o);
                    toAdd.setNext(current);
                    current.getPrev().setNext(toAdd);
                    current.setPrev(toAdd);
                    this.size++;
                    return;
                }
                current = current.getNext();
            }
            throw new ElementoInexistente("O elemento 'n' não está presente na lista");
        }

        @Override
        public void insertAfter(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Lista vazia");
            }
            if (n == this.head.getNext().getValue()){
                No toAdd = new No();
                toAdd.setPrev(this.head.getNext());
                toAdd.setValue(o);
                toAdd.setNext(this.head.getNext().getNext());
                this.head.getNext().getNext().setPrev(toAdd);
                this.head.getNext().setNext(toAdd);
                this.size++;
                return;
            }
            if (n == this.tail.getPrev().getValue()){
                No toAdd = new No();
                toAdd.setPrev(this.tail.getPrev());
                toAdd.setValue(o);
                toAdd.setNext(this.tail);
                this.tail.getPrev().setNext(toAdd);
                this.tail.setPrev(toAdd);
                this.size++;
                return;
            }
            No current = this.head.getNext().getNext();
            while (current != this.tail){
                if (current.getValue() == n){
                    No toAdd = new No();
                    toAdd.setPrev(current);
                    toAdd.setValue(o);
                    toAdd.setNext(current.getNext());
                    current.getNext().setPrev(toAdd);
                    current.setNext(toAdd);
                    this.size++;
                    return;
                }
                current = current.getNext();
            }
            throw new ElementoInexistente("O elemento 'n' não está presente na lista");
        }
        
        @Override
        public void swapElements(Object n, Object q) throws ElementoInexistente, ESeqVazia{
            if (this.size < 2){
                throw new ESeqVazia("Não é possível trocar elementos de uma lista com menos de 2 elementos ou vazia");
            }
            No N = null;
            No Q = null;
            No current = this.head.getNext();
            while (current != this.tail){
                if (current.getValue() == n){
                    N = current;
                }
                if (current.getValue() == q){
                    Q = current;
                }
                current = current.getNext();
            }
            if (N == null || Q == null){
                throw new ElementoInexistente("Um dos elementos não existe");
            }
            Object aux = N.getValue();
            N.setValue(Q.getValue());
            Q.setValue(aux);
        }
        
        @Override
        public Object remove(Object n) throws ESeqVazia, ElementoInexistente{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível remover um elemento de uma lista vazia");
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
            No current = this.head.getNext().getNext();
            while (current != this.tail.getPrev()){
                if (current.getValue() == n){
                    break;
                }
                current = current.getNext();
            }
            if (current == this.tail.getPrev()){
                throw new ElementoInexistente("Não é possível remover um elemento que não existe");
            }
            Object to_remove = current.getValue();
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
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
        public Object elemAtRank(int index) throws ESeqIndice, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Não é possível mostrar um elemento de uma sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            if (index == 0){
                return this.head.getNext().getValue();
            }
            if (index == this.size - 1){
                return this.tail.getPrev().getValue();
            }
            No current = this.head.getNext();
            if (index < this.size / 2){
                for (int i = 0; i < index; i++){
                    current = current.getNext();
                }
            }else{
              current = this.tail.getPrev();
                for (int i = this.size - 1; i > index; --i){
                    current = current.getPrev();
                }     
            }   
            return current.getValue();
        }

        @Override
        public void insertAtRank(int index, Object o) throws ESeqIndice{
            if(index < 0 || index > this.size){
                throw new ESeqIndice("Índice inválido");
            } else {
                No to_add = new No();
                if (index == 0){
                    to_add.setValue(o);
                    to_add.setPrev(this.head);
                    to_add.setNext(this.head.getNext());
                    this.head.getNext().setPrev(to_add);
                    this.head.setNext(to_add);
                    this.size++;
                    return;
                }
                if (index == this.size){
                    to_add.setValue(o);
                    to_add.setNext(this.tail);
                    to_add.setPrev(this.tail.getPrev());
                    this.tail.getPrev().setNext(to_add);
                    this.tail.setPrev(to_add);
                    this.size++;
                    return;
                }
                to_add.setValue(o);
                if (index < this.size / 2){
                    No current = this.head.getNext().getNext();
                    for(int i = 1; i < index; ++i){
                        current = current.getNext();
                    }
                    to_add.setNext(current);
                    to_add.setPrev(current.getPrev());
                    current.getPrev().setNext(to_add);
                    current.setPrev(to_add);
                    this.size++;
                }else{
                    No current = this.tail.getPrev();
                    for(int i = this.size - 1; i > index; --i){
                        current = current.getPrev();
                    }
                    to_add.setNext(current);
                    to_add.setPrev(current.getPrev());
                    current.getPrev().setNext(to_add);
                    current.setPrev(to_add);
                    this.size++;
                }
            }
        }

        @Override
        public Object removeAtRank(int index) throws ESeqIndice, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Não é possível remover um elemento de uma sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            Object to_remove;
            if (index == 0) {
                to_remove = this.head.getNext().getValue();
                this.head.setNext(this.head.getNext().getNext());
                this.head.getNext().setPrev(this.head);
                this.size--;
                return to_remove;
            }
            if (index == this.size - 1) { 
                to_remove = this.tail.getPrev().getValue();
                this.tail.setPrev(this.tail.getPrev().getPrev());
                this.tail.getPrev().setNext(this.tail);
                this.size--;
                return to_remove;
            }
            if (index < this.size / 2){
                No current = this.head.getNext().getNext();
                for (int i = 1; i < index; ++i){
                    current = current.getNext();
                }
                to_remove = current.getValue();
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                this.size--;
                return to_remove;
            }else{
                No current = this.tail.getPrev().getPrev();
                for (int i = this.size - 2; i > index; --i){
                    current = current.getPrev();
                }
                to_remove = current.getValue();
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                this.size--;
                return to_remove;
            }
        }

        @Override
        public Object replaceAtRank(int index, Object o) throws ESeqIndice, ESeqVazia{
            if(isEmpty()){
                throw new ESeqVazia("Não é possível substituir elemento de uma sequência vazia");
            }
            if (index < 0 || index >= this.size){
                throw new ESeqIndice("Índice inválido");
            }
            Object old_element;
            if (index == 0){
                old_element = this.head.getNext().getValue();
                this.head.getNext().setValue(o);
                return old_element;
            }
            if (index == this.size - 1){
                old_element = this.tail.getPrev().getValue();
                this.tail.getPrev().setValue(o);
                return old_element;
            }
            if (index < this.size / 2){
                No current = this.head.getNext().getNext();
                for (int i = 1; i < index; ++i){
                    current = current.getNext();
                }
                old_element = current.getValue();
                current.setValue(o);
            }else{
                No current = this.tail.getPrev().getPrev();
                for (int i = this.size - 2; i < index; ++i){
                    current = current.getPrev();
                }
                old_element = current.getValue();
                current.setValue(o);
            }
            return old_element;
        }

        @Override
        public Object replaceElement(Object n, Object o) throws ElementoInexistente, ESeqVazia{
            if (isEmpty()){
                throw new ESeqVazia("Não é possível substituir elementos de uma lista vazia");
            }
            if (n == this.head.getNext().getValue()){
                Object replaced = this.head.getNext().getValue();
                this.head.getNext().setValue(o);
                return replaced;
            }
            if (n == this.tail.getPrev().getValue()){
                Object replaced = this.tail.getPrev().getValue();
                this.tail.getPrev().setValue(o);
                return replaced;
            }
            No current = this.head.getNext().getNext();
            while (current != this.tail.getPrev()){
                if (current.getValue() == n){
                    break;
                }
                current = current.getNext();
            }
            if (current.getValue() != n){
                throw new ElementoInexistente("Não é possível substituir um valor inexistente");
            }
            Object replaced = current.getValue();
            current.setValue(o);
            return replaced;
        }
    }
}
 