public class Lista_Arranjo {
    public static class ListaArray implements Lista_Interface {
        private int size;
        private int capacity;
        private Object[] a;
        

        public ListaArray(){
            this.size = 0;
            this.capacity = 8;
            this.a = new Object[this.capacity];
        }

        public void increase_capacity(){
            this.capacity *= 2;
            Object[] b = new Object[this.capacity];
            for (int i = 0; i < this.size; ++i){
                b[i] = this.a[i];
            }
            this.a = b;
        }

        public void decrease_capacity(){
            this.capacity /= 2;
            Object[] b = new Object[this.capacity];
            for (int i = 0; i < this.size; ++i){
                b[i] = this.a[i];
            }
            this.a = b;
        }

        @Override
        public int size(){
            return this.size;
        }
        
        public int get_capacity(){
            return this.capacity;
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
            return this.a[0] == n;
        }

        @Override
        public boolean isLast(Object n){
            if (isEmpty()){
                return false;
            }
            return this.a[this.size - 1] == n;
        }

        @Override
        public Object first() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.a[0];
        }

        @Override
        public Object last() throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            return this.a[this.size - 1];
        }

        @Override
        public Object before(int p) throws EListaIndice, ElementoInexistente, EListaVazia{
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == 0){
                throw new ElementoInexistente("Não existe um elemento antes do primeiro elemento");
            }
            if (p == this.size - 1){
                return this.a[this.size - 2];
            }
            Object before = null;
            for (int i = 1; i < this.size - 1; ++i){
                if (i == p){
                    before = this.a[i - 1];
                    break;
                }
            }
            return before;
        }

        @Override
        public Object after(int p) throws EListaIndice, ElementoInexistente, EListaVazia{
            if (p < 0 || p >= this.size){
                throw new EListaIndice("Índice inválido");
            }
            if (isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size < 2){
                throw new ElementoInexistente("Esta lista só tem um elemento");
            }
            if (p == this.size - 1){
                throw new EListaIndice("Não existe um elemento depois do último elemento");
            }
            if (p == 0){
                return this.a[1];
            }
            Object after = null;
            for (int i = 1; i < this.size - 1; ++i){
                if (i == p){
                    after = this.a[i + 1];
                    break;
                }
            }
            return after;
        }

        @Override
        public void insertBefore(Object n, Object o) throws ElementoInexistente, EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size == this.capacity){
                increase_capacity();
            }
            if (n == this.a[0]){
                for (int i = this.size; i > 0; --i){
                    this.a[i] = this.a[i - 1];
                }
                this.a[0] = o;
                this.size++;
                return;
            }
            if (n == this.a[this.size - 1]){
                this.a[this.size] = n;
                this.a[this.size - 1] = o;
                this.size++;
                return;
            }
            for (int i = 1; i < this.size - 1; ++i){
                if (this.a[i] == n){
                    for (int j = this.size; j > i; --j){
                        this.a[j] = this.a[j - 1];
                    }
                    this.a[i] = o;
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
            if (this.size == this.capacity){
                increase_capacity();
            }
            if (n == this.a[0]){
                for (int i = this.size; i > 1; --i){
                    this.a[i] = this.a[i - 1];
                }
                this.a[1] = o;
                this.size++;
                return;
            }
            if (n == this.a[this.size - 1]){
                this.a[this.size] = o;
                this.size++;
                return;
            }
            for (int i = 1; i < this.size - 1; ++i){
                if (this.a[i] == n){
                    for (int j = this.size; j > i + 1; --j){
                        this.a[j] = this.a[j - 1];
                    }
                    this.a[i + 1] = o;
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
            Object NValor = null;
            int NIndice = 0;
            Object QValor = null;
            int QIndice = 0;
            for (int i = 0; i < this.size; ++i){
                if (this.a[i] == n){
                    NValor = this.a[i];
                    NIndice = i;
                }
                if (this.a[i] == q){
                    QValor = this.a[i];
                    QIndice = i;
                }
            }
            if (NValor == null || QValor == null){
                throw new ElementoInexistente("Um dos elementos não existe");
            }
            Object aux = NValor;
            NValor = QValor;
            QValor = aux;
            this.a[NIndice] = NValor;
            this.a[QIndice] = QValor;
        }
        
        @Override
        public Object remove(Object n) throws EListaVazia, ElementoInexistente{
            if (isEmpty()){
                throw new EListaVazia("Não é possível remover um elemento de uma lista vazia");
            }
            if (this.size * 1.0 / this.capacity * 1.0 <= 1.0 / 3.0 && this.capacity > 8){
                decrease_capacity();
            }
            if (this.a[this.size - 1] == n){
                Object to_remove = this.a[this.size - 1];
                this.size--;
                return to_remove;
            }
            if (this.a[0] == n){
                Object to_remove = this.a[0];
                for (int i = 0; i < this.size - 1; ++i){
                    this.a[i] = this.a[i + 1];
                }
                this.size--;
                return to_remove;
            }
            Object to_remove = null;
            for (int i = 1; i < this.size; ++i){
                if (this.a[i] == n){
                    to_remove = this.a[i];
                    for (int j = i; j < this.size - 1; ++j){
                        this.a[j] = this.a[j + 1];
                    }
                    break;
                }
            }
            if (to_remove == null){
                throw new ElementoInexistente("Não é possível remover um elemento que não existe");
            }
            this.size--;
            return to_remove;
        }
        
        @Override
        public void insertFirst(Object o){
            if (this.size == this.capacity){
                increase_capacity();
            }
            for (int i = this.size; i > 0; --i){
                this.a[i] = this.a[i - 1];
            }
            this.a[0] = o;
            this.size++;
        }

        @Override
        public void insertLast(Object o){
            if (this.size == this.capacity){
                increase_capacity();
            }
            this.a[size] = o;
            this.size++;   
        }

        @Override
        public Object replaceElement(Object n, Object o) throws ElementoInexistente, EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Não é possível substituir elementos de uma lista vazia");
            }
            if (n == this.a[0]){
                Object replaced = this.a[0];
                this.a[0] = o;
                return replaced;
            }
            if (n == this.a[this.size - 1]){
                Object replaced = this.a[this.size - 1];
                this.a[this.size - 1] = o;
                return replaced;
            }
            Object replaced = null;
            for (int i = 1; i < this.size - 1; ++i){
                if (this.a[i] == n){
                    replaced = this.a[i];
                    this.a[i] = o;
                    break;
                }
            }
            if (replaced == null){
                throw new ElementoInexistente("Não é possível substituir um valor inexistente");
            }
            return replaced;
        }
    }
}
 