public class TesteListaArray extends  Lista_Arranjo{
    public static void main(String[] args) {
        try {
            ListaArray lista = new ListaArray();

            System.out.println("=== TESTES INICIAIS ===");
            System.out.println("Capacidade inicial: " + lista.get_capacity());
            System.out.println("Está vazio? " + lista.isEmpty());

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

            System.out.println("\n=== INSERÇÃO EM POSIÇÃO ESPECÍFICA ===");
            lista.insertAfter("B", "X");  // entre A e B
            System.out.println("Elemento na posição 2: " + lista.after(1));
            System.out.println("Tamanho atual: " + lista.size());

            System.out.println("\n=== REPLACE ELEMENT ===");
            Object antigo = lista.replaceElement("X", "Y");
            System.out.println("Substituído '" + antigo + "' por 'Y'");
            System.out.println("Elemento na posição 2: " + lista.after(1));

            System.out.println("\n=== REMOÇÃO DE ELEMENTO ===");
            Object removido = lista.remove("Y");
            System.out.println("Elemento removido: " + removido);
            System.out.println("Tamanho após remoção: " + lista.size());

            System.out.println("\n=== TESTE DE EXPANSÃO DE CAPACIDADE ===");
            for (int i = lista.size(); i < 40; i++) {
                lista.insertLast("Z");
            }
            System.out.println("Tamanho atual: " + lista.size());
            System.out.println("Capacidade atual: " + lista.get_capacity());

            System.out.println("\n=== TESTE DE REMOÇÕES MÚLTIPLAS ===");
            while (!lista.isEmpty() && lista.size() > 5) {
                lista.remove("Z");
            }
            lista.remove("A");
            System.out.println("Tamanho após remoções: " + lista.size());
            System.out.println("Capacidade após remoções: " + lista.get_capacity());

            System.out.println("\n=== TESTES DE NAVEGAÇÃO (SE EXISTIREM) ===");
            try {
                System.out.println("First: " + lista.first());
                System.out.println("Last: " + lista.last());
                System.out.println("Elemento na posição 1: " + lista.after(0));
            } catch (Exception e) {
                System.out.println("Erro em navegação: " + e.getMessage());
            }

            System.out.println("\n=== TESTE DE EXCEÇÕES ===");

            System.out.print("Tentando acessar posição inválida... ");
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
                ListaArray vazio = new ListaArray();
                vazio.remove(0);
            } catch (EListaVazia e) {
                System.out.println("OK! Exceção: " + e.getMessage());
            }

            System.out.println("\n=== TESTES FINALIZADOS ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
