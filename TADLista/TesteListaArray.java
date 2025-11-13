public class TesteListaArray extends Lista_Arranjo{
    public static void main(String[] args) {
        try {
            ListaArray arrayTeste = new ListaArray();
            System.out.println("Capacidade inicial: " + arrayTeste.get_capacity());
            System.out.println("Está vazio? " + arrayTeste.isEmpty());

            // Inserindo os primeiros elementos
            arrayTeste.insertFirst("A");
            arrayTeste.insertFirst("B");
            arrayTeste.insertFirst("C");
            System.out.println("Tamanho após inserções: " + arrayTeste.size());
            System.out.println("Elemento na posição 1: " + arrayTeste.first());

            // Substituindo um elemento
            Object antigo = arrayTeste.replaceElement("C", "D");
            System.out.println("Substituído '" + antigo + "' por 'D'");
            System.out.println("Elemento na posição 1 agora: " + arrayTeste.first());

            // Removendo algum elemento
            Object removido = arrayTeste.remove("D");
            System.out.println("Removido: " + removido);
            System.out.println("Novo primeiro elemento: " + arrayTeste.first());
            System.out.println("Tamanho atual: " + arrayTeste.size());

            // Verificando a capacidade após inserções feitas por um laço
            for (int i = arrayTeste.size(); i < 20; i++) {
                arrayTeste.insertLast("E");
            }
            System.out.println("Capacidade após várias inserções: " + arrayTeste.get_capacity());
            System.out.println("Tamanho atual: " + arrayTeste.size());

            // Teste de redução de capacidade
            while (arrayTeste.size() > 5) {
                arrayTeste.remove("E");
            }
            System.out.println("Capacidade após várias remoções: " + arrayTeste.get_capacity());
            System.out.println("Tamanho final: " + arrayTeste.size());

            // Teste de exceções
            /*
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
             */
            } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
 