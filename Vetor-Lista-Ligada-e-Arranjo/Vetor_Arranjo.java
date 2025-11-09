

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

    public static void main(String[] args) {
        try {
            VetorArray arrayTeste = new VetorArray();
            System.out.println("Capacidade inicial: " + arrayTeste.get_capacity());
            System.out.println("Está vazio? " + arrayTeste.isEmpty());

            // Inserindo os primeiros elementos
            arrayTeste.insertAtRank(0, "A");
            arrayTeste.insertAtRank(1, "B");
            arrayTeste.insertAtRank(2, "C");
            System.out.println("Tamanho após inserções: " + arrayTeste.size());
            System.out.println("Elemento na posição 1: " + arrayTeste.elemAtRank(1));

            // Substituindo um elemento
            Object antigo = arrayTeste.replaceAtRank(1, "X");
            System.out.println("Substituído '" + antigo + "' por 'X'");
            System.out.println("Elemento na posição 1 agora: " + arrayTeste.elemAtRank(1));

            // Removendo algum elemento
            Object removido = arrayTeste.removeAtRank(0);
            System.out.println("Removido: " + removido);
            System.out.println("Novo primeiro elemento: " + arrayTeste.elemAtRank(0));
            System.out.println("Tamanho atual: " + arrayTeste.size());

            // Verificando a capacidade após inserções feitas por um laço
            for (int i = arrayTeste.size(); i < 20; i++) {
                arrayTeste.insertAtRank(arrayTeste.size(), "E" + i);
            }
            System.out.println("Capacidade após várias inserções: " + arrayTeste.get_capacity());
            System.out.println("Tamanho atual: " + arrayTeste.size());

            // Teste de redução de capacidade
            while (arrayTeste.size() > 5) {
                arrayTeste.removeAtRank(arrayTeste.size() - 1);
            }
            System.out.println("Capacidade após várias remoções: " + arrayTeste.get_capacity());
            System.out.println("Tamanho final: " + arrayTeste.size());

            // Teste de exceções
            try {
                arrayTeste.elemAtRank(100);
            } catch (EVetorIndice e) {
                System.out.println("Exceção esperada: " + e.getMessage());
            }

            try {
                VetorArray vazio = new VetorArray();
                vazio.removeAtRank(0);
            } catch (EVetorVazio e) {
                System.out.println("Exceção esperada: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
