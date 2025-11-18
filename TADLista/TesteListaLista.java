public class TesteListaLista extends Lista_Lista{
    public static void main(String[] args) {
        try {
            ListaListaLigada lista = new ListaListaLigada();
            System.out.println("=== TESTES INICIAIS ===");
            System.out.println("Está vazio? " + lista.isEmpty());
            System.out.println("Tamanho: " + lista.size());

            System.out.println("\n=== INSERÇÃO EM FIRST ===");
            lista.insertFirst("C");
            lista.insertFirst("B");
            lista.insertFirst("A");
            System.out.println("Tamanho após insertFirst: " + lista.size());
            System.out.println("Primeiro elemento: " + lista.first().getValue());
            System.out.println("Último elemento: " + lista.last().getValue());

            System.out.println("\n=== INSERÇÃO EM LAST ===");
            lista.insertLast("D");
            lista.insertLast("E");
            System.out.println("Novo último elemento: " + lista.last().getValue());
            System.out.println("Tamanho atual: " + lista.size());

            System.out.println("\n=== INSERÇÃO APÓS ELEMENTO ESPECÍFICO ===");
            No noB = lista.atRank(1);  // Obtém o nó na posição 1 ("B")
            No noX = lista.insertAfter(noB, "X");
            System.out.println("Após 'B': " + lista.after(1).getValue());
            System.out.println("Tamanho atual: " + lista.size());

            System.out.println("\n=== REPLACE ELEMENT ===");
            Object antigo = lista.replaceElement(noX, "Y");
            System.out.println("Substituído '" + antigo + "' por 'Y'");
            System.out.println("Elemento depois de 'B': " + lista.after(1).getValue());

            System.out.println("\n=== REMOÇÃO DE ELEMENTO ===");
            No noY = lista.atRank(2);  // Obtém o nó com "Y"
            Object removido = lista.remove(noY);
            System.out.println("Elemento removido: " + removido);
            System.out.println("Tamanho após remoção: " + lista.size());

            System.out.println("\n=== TESTE COM VÁRIAS INSERÇÕES (LISTA NÃO TEM CAPACIDADE FIXA) ===");
            for (int i = lista.size(); i < 40; i++) {
                lista.insertLast("Z");
            }
            System.out.println("Tamanho atual após várias inserções: " + lista.size());

            System.out.println("\n=== TESTE DE REMOÇÕES MÚLTIPLAS ===");
            while (!lista.isEmpty() && lista.size() > 5) {
                No noZ = lista.last();  // Obtém o último nó
                lista.remove(noZ);
            }
            System.out.println("Tamanho após remoções: " + lista.size());

            System.out.println("\n=== TESTES DE NAVEGAÇÃO ===");
            try {
                System.out.println("First: " + lista.first().getValue());
                System.out.println("Last: " + lista.last().getValue());
                System.out.println("Elemento após o primeiro: " + lista.after(0).getValue());
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

            System.out.print("Tentando acessar elemento antes do primeiro... ");
            try {
                lista.before(0);
            } catch (EListaIndice e) {
                System.out.println("OK! Exceção: " + e.getMessage());
            }

            System.out.print("Tentando remover de lista vazia... ");
            try {
                ListaListaLigada vazio = new ListaListaLigada();
                No noVazio = new No();
                vazio.remove(noVazio);
            } catch (EListaVazia e) {
                System.out.println("OK! Exceção: " + e.getMessage());
            }

            System.out.println("\n=== TESTES FINALIZADOS ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 