public class TesteListaLista {
    public static void main(String[] args) {
        try {
            Lista_Lista.ListaListaLigada lista = new Lista_Lista.ListaListaLigada();

            System.out.println("=== TESTES INICIAIS ===");
            System.out.println("Está vazio? " + lista.isEmpty());
            System.out.println("Tamanho: " + lista.size());

            System.out.println("\n=== INSERÇÃO EM FIRST ===");
            lista.insertFirst("C");
            lista.insertFirst("B");
            lista.insertFirst("A");
            System.out.println("Tamanho após insertFirst: " + lista.size());
            System.out.println("Primeiro elemento: " + lista.first());
            System.out.println("Último elemento: " + lista.last());

            System.out.println("\n=== INSERÇÃO EM LAST ===");
            lista.insertLast("D");
            lista.insertLast("E");
            System.out.println("Novo último elemento: " + lista.last());
            System.out.println("Tamanho atual: " + lista.size());

            System.out.println("\n=== INSERÇÃO APÓS ELEMENTO ESPECÍFICO ===");
            lista.insertAfter("B", "X");  // após o nó com conteúdo "B"
            System.out.println("Após 'B': " + lista.after(1));
            System.out.println("Tamanho atual: " + lista.size());

            System.out.println("\n=== REPLACE ELEMENT ===");
            Object antigo = lista.replaceElement("X", "Y");
            System.out.println("Substituído '" + antigo + "' por 'Y'");
            System.out.println("Elemento depois de 'B': " + lista.after(1));

            System.out.println("\n=== REMOÇÃO DE ELEMENTO ===");
            Object removido = lista.remove("Y");
            System.out.println("Elemento removido: " + removido);
            System.out.println("Tamanho após remoção: " + lista.size());

            System.out.println("\n=== TESTE COM VÁRIAS INSERÇÕES (LISTA NÃO TEM CAPACIDADE FIXA) ===");
            for (int i = lista.size(); i < 40; i++) {
                lista.insertLast("Z");
            }
            System.out.println("Tamanho atual após várias inserções: " + lista.size());

            System.out.println("\n=== TESTE DE REMOÇÕES MÚLTIPLAS ===");
            while (!lista.isEmpty() && lista.size() > 5) {
                lista.remove("Z");
            }
            System.out.println("Tamanho após remoções: " + lista.size());

            System.out.println("\n=== TESTES DE NAVEGAÇÃO ===");
            try {
                System.out.println("First: " + lista.first());
                System.out.println("Last: " + lista.last());
                System.out.println("Elemento após o primeiro: " + lista.after(0));
            } catch (Exception e) {
                System.out.println("Erro em navegação: " + e.getMessage());
            }

            System.out.println("\n=== TESTE DE EXCEÇÕES ===");

            System.out.print("Tentando acessar posição inexistente com before... ");
            try {
                lista.before(999);
            } catch (EListaIndice e) {
                System.out.println("OK! Recebida: " + e.getMessage());
            }

            System.out.print("Tentando remover elemento inexistente... ");
            try {
                lista.remove("NÃO EXISTE");
            } catch (Exception e) {
                System.out.println("OK! Exceção: " + e.getMessage());
            }

            System.out.print("Tentando remover de lista vazia... ");
            try {
                Lista_Lista.ListaListaLigada vazio = new Lista_Lista.ListaListaLigada();
                vazio.remove("QUALQUER COISA");
            } catch (EListaVazia e) {
                System.out.println("OK! Exceção: " + e.getMessage());
            }

            System.out.println("\n=== TESTES FINALIZADOS ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
