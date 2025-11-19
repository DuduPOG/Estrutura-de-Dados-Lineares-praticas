public class TesteListaArray extends  Lista_Arranjo{
    public static void main(String[] args) {
        ListaArray lista = new ListaArray();
        System.out.println("Capacidade inicial: " + lista.get_capacity());
        System.out.println("Está vazio? " + lista.isEmpty());

        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        System.out.println("Tamanho após insertFirst: " + lista.size());
        System.out.println("Primeiro elemento: " + lista.first());
        System.out.println("Último elemento: " + lista.last());

        lista.insertLast("D");
        lista.insertLast("E");
        System.out.println("Novo último elemento: " + lista.last());
        System.out.println("Tamanho atual: " + lista.size());

        int indexX = lista.insertAfter("B", "X");
        System.out.println("Elemento inserido na posição: " + indexX);
        System.out.println("Elemento após 'B': " + lista.after(lista.find("B")));
        System.out.println("Tamanho atual: " + lista.size());

        Object antigo = lista.replaceElement("X", "Y");
        System.out.println("Substituído '" + antigo + "' por 'Y'");
        System.out.println("Elemento após 'B': " + lista.after(lista.find("B")));

        Object removido = lista.remove("Y");
        System.out.println("Elemento removido: " + removido);
        System.out.println("Tamanho após remoção: " + lista.size());

       for (int i = lista.size(); i < 40; i++) {
            lista.insertLast("Z");
        }
        System.out.println("Tamanho atual: " + lista.size());
        System.out.println("Capacidade atual: " + lista.get_capacity());

        while (!lista.isEmpty() && lista.size() > 5) {
            try {
                lista.remove("Z");
            } catch (ElementoInexistente e) {
                System.out.println("Elemento Z não encontrado, parando laço...");
                break;
            }
        }

        lista.remove(lista.last());
        System.out.println("Tamanho após remoções: " + lista.size());
        System.out.println("Capacidade após remoções: " + lista.get_capacity());

        System.out.println("First: " + lista.first());
        System.out.println("Last: " + lista.last());
        System.out.println("Elemento após o primeiro: " + lista.after(0));

        System.out.print("Tentando acessar posição inválida com before... ");
        try {
            lista.before(999);
        } catch (EListaIndice e) {
            System.out.println("OK! Recebida: " + e.getMessage());
        }

        System.out.print("Tentando acessar elemento antes do primeiro... ");
        try {
            lista.before(0);
        } catch (ElementoInexistente e) {
            System.out.println("OK! Exceção: " + e.getMessage());
        }

        System.out.print("Tentando remover elemento inexistente... ");
        try {
            lista.remove("NÃO EXISTE");
        } catch (ElementoInexistente e) {
            System.out.println("OK! Exceção: " + e.getMessage());
        }

        System.out.print("Tentando remover de lista vazia... ");
        try {
            ListaArray vazio = new ListaArray();
            vazio.remove("QUALQUER COISA");
        } catch (EListaVazia e) {
            System.out.println("OK! Exceção: " + e.getMessage());
        }
    }
}
 