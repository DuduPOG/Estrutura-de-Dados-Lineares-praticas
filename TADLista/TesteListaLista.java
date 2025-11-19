public class TesteListaLista extends Lista_Lista{
    public static void main(String[] args) {
        ListaListaLigada lista = new ListaListaLigada();
        System.out.println("Está vazio? " + lista.isEmpty());
        System.out.println("Tamanho: " + lista.size());

        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        System.out.println("Tamanho após insertFirst: " + lista.size());
        System.out.println("Primeiro elemento: " + lista.first().getValue());
        System.out.println("Último elemento: " + lista.last().getValue());

        lista.insertLast("D");
        lista.insertLast("E");
        System.out.println("Novo último elemento: " + lista.last().getValue());
        System.out.println("Tamanho atual: " + lista.size());

        No noB = lista.atRank(1);
        No noX = lista.insertAfter(noB, "X");
        System.out.println("Após 'B': " + lista.after(1).getValue());
        System.out.println("Tamanho atual: " + lista.size());

        Object antigo = lista.replaceElement(noX, "Y");
        System.out.println("Substituído '" + antigo + "' por 'Y'");
        System.out.println("Elemento depois de 'B': " + lista.after(1).getValue());

        No noY = lista.atRank(2);
        Object removido = lista.remove(noY);
        System.out.println("Elemento removido: " + removido);
        System.out.println("Tamanho após remoção: " + lista.size());

        for (int i = lista.size(); i < 40; i++) {
            lista.insertLast("Z");
        }
        System.out.println("Tamanho atual após várias inserções: " + lista.size());

        while (!lista.isEmpty() && lista.size() > 5) {
            No noZ = lista.last();
            lista.remove(noZ);
        }
        System.out.println("Tamanho após remoções: " + lista.size());

        System.out.println("First: " + lista.first().getValue());
        System.out.println("Last: " + lista.last().getValue());
        System.out.println("Elemento após o primeiro: " + lista.after(0).getValue());


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
    }
}
 