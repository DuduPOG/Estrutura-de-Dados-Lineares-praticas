public class TesteVetorArray extends Vetor_Arranjo{
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
