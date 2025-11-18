public class testeFila extends Fila_Arranjo {
    public static void main(String[] args) {			
		FilaArray pp = new FilaArray();
		System.out.println("inserindo");
		for(int f = 0; f < 16; f++){
		  System.out.println(f);		  
		  pp.enfileirar(f);
		}
		System.out.println("retirando");
		for(int f = pp.tamanho(); f > 0; --f){
			  System.out.print(f);
			  pp.desenfileirar();
		}
	}
}
