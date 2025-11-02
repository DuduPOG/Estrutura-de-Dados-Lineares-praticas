public class Vetor_Arranjo {
    public static class VetorArray implements Vetor_Interface {
        private int size;
        private int capacity;
        private int i;
        private int f;
        private Object[] a;

        public VetorArray(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.i = -1;
            this.f = this.i + 1;
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
        public int elemAtRank(int index) throws EVetorIndice, EVetorVazio{
            if(isEmpty()){
                throw new EVetorVazio("Não é possível mostrar um elemento de um vetor vazio");
            }
            if (index >= this.f){
                throw new EVetorIndice("Índice inválido");
            }
            return this.a[index];
        }
        
        @Override
        public void removeAtRank(Object o) throws EVetorIndice, EVetorVazio{

        }
        
        @Override
        public void insertAtRank(Object o) throws EVetorIndice, EVetorVazio{

        }

        @Override
        public void replaceAtRank(Object o, Object p) throws EVetorIndice, EVetorVazio{

        }
}

    public static void main(String[] args) {			
		VetorArray pp = new VetorArray(1);
		System.out.println("inserindo");
		for(int f = 0; f < 16; f++){
		  System.out.println(f);		  
		  pp.push_v(f);
          pp.push_p(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 16; f++){
			  System.out.print(f);
			  System.out.println(" - " + pp.pop_v());
              System.err.print(f);
              System.out.println(" . " + pp.pop_p());
		}
	}
}
