public class Vetor_Arranjo {
    public static class VetorArray implements Vetor_Interface {
        private int size;
        private int capacity;
        private int f;
        private Object[] a;

        public VetorArray() {
            this.size = 0;
            this.capacity = 8;
            this.f = -1;
            this.a = new Object[this.capacity];
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
        public Object elemAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível mostrar um elemento de um vetor vazio");
            }
            if (index > this.f || index < 0){
                throw new EVetorIndice("Índice inválido");
            }
            return this.a[index];
        }
        
        @Override
        public Object removeAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível remover um elemento de um vetor vazio");
            }
            if (index > this.f || index < 0){
                throw new EVetorIndice("Índice inválido");
            }
            if (this.size * 1.0 / this.capacity * 1.0 <= 1.0 / 3.0){
                this.capacity/=2;
                Object[] b = new Object[this.capacity];
                for (int i = 0; i < this.size; ++i){
                    b[i] = this.a[i];
                }
                this.a = b;
            }
            Object to_remove = this.a[index];
            for(int i = index; i < this.f - 1; ++i){
                this.a[i] = this.a[i + 1];
            }
            this.size--;
            this.f--;
            return to_remove;
        }
        
        @Override
        public void insertAtRank(int index, Object o) throws EVetorIndice{
            if (index > this.f || index < 0){
                throw new EVetorIndice("Índice inválido");
            }
            if(this.f == this.capacity - 1){
                this.capacity *= 2;
                Object[] b = new Object[this.capacity];
                for(int i = 0; i < index; ++i){
                    b[i] = this.a[i];
                }
                for(int i = index + 1; i < this.f; ++i){
                    b[i] = this.a[i - 1];
                }
                b[index] = o;
                this.f++;
                this.a = b;
                ++this.size;
            } else{
            for(int i = this.f; i > index; --i){
                this.a[i] = this.a[i - 1];
            }
            this.a[index] = o;
            this.f++;
            ++this.size;
            }
        }

        @Override
        public Object replaceAtRank(int index, Object o) throws EVetorIndice, EVetorVazio{
            if (isEmpty()){
                throw new EVetorVazio("Não é possível substituir elemento de um vetor vazio");
            }
            if (index > this.f || index < 0){
                throw new EVetorIndice("Índice inválido");
            }
            Object old_element = this.a[index];
            this.a[index] = o;
            return  old_element;
        }
}

    public static void main(String[] args) {			
	}
}
