public class Lista_Arranjo {
    public static class ListaArray implements Array_Interface {
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

        public int find(Object o) throws ElementoInexistente{
            int j = this.size - 1;
            for(int i = 0; i <= this.size / 2 && j >= this.size / 2; ++i){
                if (this.a[i] == o){
                    return i;
                }
                if (this.a[j] == o){
                    return j;
                }
                j--;
            }
            throw new ElementoInexistente("Não existe esse elemento na lista");
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
            return this.a[p - 1];
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
            return this.a[p + 1];
        }

        @Override
        public int insertBefore(Object n, Object o) throws EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size == this.capacity){
                increase_capacity();
            }
            int index = find(n);
            for(int i = this.size - 1; i > index; --i){
                this.a[i] = this.a[i - 1];
            }
            this.a[index] = o;
            this.size++;
            return index;
        }

        @Override
        public int insertAfter(Object n, Object o) throws EListaVazia{
            if(isEmpty()){
                throw new EListaVazia("Lista vazia");
            }
            if (this.size == this.capacity){
                increase_capacity();
            }
            int index = find(n);
            for(int i = this.size - 1; i > index; --i){
                this.a[i] = this.a[i - 1];
            }
            this.a[index + 1] = o;
            this.size++;
            return index + 1;
        }
        
        @Override
        public void swapElements(Object n, Object q) throws EListaVazia{
            if (this.size < 2){
                throw new EListaVazia("Não é possível trocar elementos de uma lista com menos de 2 elementos ou vazia");
            }
            int NIndice = find(n);
            int QIndice = find(q);
            this.a[NIndice] = q;
            this.a[QIndice] = n;
        }
        
        @Override
        public Object remove(Object n) throws EListaVazia, ElementoInexistente{
            if (isEmpty()){
                throw new EListaVazia("Não é possível remover um elemento de uma lista vazia");
            }
            if (this.size * 1.0 / this.capacity * 1.0 <= 1.0 / 3.0 && this.capacity > 8){
                decrease_capacity();
            }
            int to_remove = find(n);
            for(int i = to_remove; i < this.size - 1; ++i){
                this.a[i] = this.a[i + 1];
            }
            this.size--;
            return n;
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
        public Object replaceElement(Object n, Object o) throws EListaVazia{
            if (isEmpty()){
                throw new EListaVazia("Não é possível substituir elementos de uma lista vazia");
            }
            int replaced = find(n);
            this.a[replaced] = o;
            return n;
        }
    }
}
 