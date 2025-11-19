import java.time.Duration;
import java.time.Instant;

public class testeFila extends Fila_Arranjo {
    public static void main(String[] args) {			
		FilaArray pp = new FilaArray();
		Instant inicio = Instant.now();
		System.out.println("inserindo");
		for(int f = 0; f < 131072; f++){		  
		  pp.enfileirar(f);
		}
		System.out.println("retirando");
		for(int f = pp.tamanho(); f > 0; --f){
			  pp.desenfileirar();
		}
		Instant fim = Instant.now();
        Duration tempoDecorrido = Duration.between(inicio, fim);
        long tempo = tempoDecorrido.toMillis();
		System.out.println("Tempo decorrido: " + tempo + " milissegundos");
	}
}
