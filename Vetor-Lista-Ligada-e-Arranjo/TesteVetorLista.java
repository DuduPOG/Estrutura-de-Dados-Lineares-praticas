public class TesteVetorLista extends Vetor_Lista{
    public static void main(String[] args) {			
		try {
            VetorListaLigada listaTeste = new VetorListaLigada();
            System.out.println("Tamanho inicial: " + listaTeste.size());
            System.out.println("Está vazio? " + listaTeste.isEmpty());

            // Inserindo os primeiros elementos
            listaTeste.insertAtRank(0, "A");
            listaTeste.insertAtRank(1, "B");
            listaTeste.insertAtRank(2, "C");
            System.out.println("Tamanho após inserções: " + listaTeste.size());
            System.out.println("Elemento na posição 1: " + listaTeste.elemAtRank(1));

            // Substituindo algum elemento
            Object antigo = listaTeste.replaceAtRank(1, "X");
            System.out.println("Substituído '" + antigo + "' por 'X'");
            System.out.println("Elemento na posição 1 agora: " + listaTeste.elemAtRank(1));

            // Removendo um elemento
            Object removido = listaTeste.removeAtRank(0);
            System.out.println("Removido: " + removido);
            System.out.println("Novo primeiro elemento: " + listaTeste.elemAtRank(0));
            System.out.println("Tamanho atual: " + listaTeste.size());

            // Aumento do tamanho por um laço
            for (int i = 0; i < 20; i++) {
                listaTeste.insertAtRank(listaTeste.size(), "E" + i);
            }
            System.out.println("Tamanho atual: " + listaTeste.size());

            // Teste de redução de tamanho
            while (listaTeste.size() > 5) {
                listaTeste.removeAtRank(listaTeste.size() - 1);
            }
            System.out.println("Tamanho final: " + listaTeste.size());

            // Teste de exceções
            try {
                listaTeste.elemAtRank(100);
            } catch (EVetorIndice e) {
                System.out.println("Exceção esperada: " + e.getMessage());
            }

            try {
                VetorListaLigada vazio = new VetorListaLigada();
                vazio.removeAtRank(0);
            } catch (EVetorVazio e) {
                System.out.println("Exceção esperada: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}