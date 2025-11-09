public class Vetor_Arranjo {
    public static class VetorArray implements Vetor_Interface {
        private int n;
        private int capacity;
        private Object[] a;

        public VetorArray() {
            this.n = 0;
            this.capacity = 8;
            this.a = new Object[this.capacity];
        }

        public int get_capacity(){
            return this.capacity;
        }

        public Object get_array(){
            return this.a;
        }

        @Override
        public int size(){
            return this.n;
        }
    
        @Override
        public boolean isEmpty(){
            return this.n == 0;
        }
        
        @Override
        public Object elemAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível mostrar um elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.n){
                throw new EVetorIndice("Índice inválido");
            }
            return this.a[index];
        }
        
        @Override
        public Object removeAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível remover um elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.n){
                throw new EVetorIndice("Índice inválido");
            }
            Object to_remove = this.a[index];
            for(int i = index; i < this.n - 1; ++i){
                this.a[i] = this.a[i + 1];
            }
            this.n--;
            if (this.n * 1.0 / this.capacity * 1.0 <= 1.0 / 3.0 && this.capacity > 8){
                this.capacity/=2;
                Object[] b = new Object[this.capacity];
                for (int i = 0; i < this.n; ++i){
                    b[i] = this.a[i];
                }
                this.a = b;
            }
            return to_remove;
        }
        
        @Override
        public void insertAtRank(int index, Object o) throws EVetorIndice{
            if (index < 0 || index > this.n){
                throw new EVetorIndice("Índice inválido");
            }
            if(this.n == this.capacity){
                this.capacity *= 2;
                Object[] b = new Object[this.capacity];
                for(int i = 0; i < index; ++i){
                    b[i] = this.a[i];
                }
                if (index == this.n){
                    b[index] = o;
                    this.a = b;
                    this.n++;
                }else{
                for(int i = this.n; i > index; --i){
                    b[i] = this.a[i - 1];
                }
                b[index] = o;
                this.a = b;
                ++this.n;
                }
            } else{
              if (index == this.n){
                    this.a[index] = o;
                    this.n++;
                }else{
                for(int i = this.n; i > index; --i){
                    this.a[i] = this.a[i - 1];
                }
                this.a[index] = o;
                ++this.n;
                }
            }
        }

        @Override
        public Object replaceAtRank(int index, Object o) throws EVetorIndice, EVetorVazio{
            if (isEmpty()){
                throw new EVetorVazio("Não é possível substituir elemento de um vetor vazio");
            }
            if (index < 0 || index >= this.n){
                throw new EVetorIndice("Índice inválido");
            }
            Object old_element = this.a[index];
            this.a[index] = o;
            return  old_element;
        }
    }
}