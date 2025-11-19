public class TesteSeqLista extends Seq_Lista {
    public static void main(String[] args) {
        SeqListaLigada seq = new SeqListaLigada();
        
        System.out.println("Sequência criada");
        assert seq.isEmpty() : "Falha: sequência deveria estar vazia";
        System.out.println("isEmpty() retorna true para sequência vazia");
        
        assert seq.size() == 0 : "Falha: tamanho deveria ser 0";
        System.out.println("size() retorna 0 para sequência vazia");
        
        seq.insertFirst("A");
        assert !seq.isEmpty() : "Falha: sequência não deveria estar vazia";
        System.out.println("isEmpty() retorna false após inserção");
        
        assert seq.size() == 1 : "Falha: tamanho deveria ser 1";
        System.out.println("size() retorna 1 após uma inserção");

        seq.insertFirst("C");
        seq.insertFirst("B");
        seq.insertFirst("A");
        assert seq.size() == 3 : "Falha: tamanho deveria ser 3";
        assert seq.first().getValue().equals("A") : "Falha: primeiro elemento deveria ser A";
        System.out.println("insertFirst() funciona corretamente - Sequência: [A, B, C]");
        
        seq.insertLast("D");
        seq.insertLast("E");
        assert seq.last().getValue().equals("E") : "Falha: último elemento deveria ser E";
        assert seq.size() == 5 : "Falha: tamanho deveria ser 5";
        System.out.println("insertLast() funciona corretamente - Sequência: [A, B, C, D, E]");
        
        seq.insertAtRank(2, "X");
        assert seq.elemAtRank(2).equals("X") : "Falha: elemento no índice 2 deveria ser X";
        assert seq.size() == 6 : "Falha: tamanho deveria ser 6";
        System.out.println("insertAtRank() funciona corretamente - Elemento X inserido na posição 2");
        
        No noB = seq.find("B");
        if (noB != null) {
            seq.insertBefore(noB, "B-");
            assert seq.size() == 7 : "Falha: tamanho deveria ser 7";
            System.out.println("insertBefore() funciona corretamente - Elemento B- inserido antes de B");
        }
        
        No noB2 = seq.find("B");
        if (noB2 != null) {
            seq.insertAfter(noB2, "B+");
            assert seq.size() == 8 : "Falha: tamanho deveria ser 8";
            System.out.println("insertAfter() funciona corretamente - Elemento B+ inserido depois de B");
        }
        seq.insertLast("A");
        seq.insertLast("B");
        seq.insertLast("C");
        seq.insertLast("D");
        seq.insertLast("E");
        
        int sizeInicial = seq.size();
        
        No noC = seq.find("C");
        if (noC != null) {
            Object removido = seq.remove(noC);
            assert removido.equals("C") : "Falha: elemento removido deveria ser C";
            assert seq.size() == sizeInicial - 1 : "Falha: tamanho não diminuiu";
            System.out.println("remove() funciona corretamente - Elemento C removido");
        }
        
        Object removidoRank = seq.removeAtRank(1);
        assert removidoRank.equals("B") : "Falha: elemento no índice 1 deveria ser B";
        assert seq.size() == sizeInicial - 2 : "Falha: tamanho deveria ser diminuído em 2";
        System.out.println("removeAtRank() funciona corretamente - Elemento no índice 1 removido");
        
        seq.insertLast("A");
        seq.insertLast("B");
        seq.insertLast("C");
        seq.insertLast("D");
        
        Object primeiro = seq.first().getValue();
        assert primeiro.equals("A") : "Falha: primeiro elemento deveria ser A";
        System.out.println("first() retorna: " + primeiro);
        
        Object ultimo = seq.last().getValue();
        assert ultimo.equals("D") : "Falha: último elemento deveria ser D";
        System.out.println("last() retorna: " + ultimo);
        
        noC = seq.find("C");
        if (noC != null) {
            Object antesDeC = seq.before(noC).getValue();
            assert antesDeC.equals("B") : "Falha: elemento antes de C deveria ser B";
            System.out.println("before(C) retorna: " + antesDeC);
        }
        

        noB = seq.find("B");
        if (noB != null) {
            Object depoisDeB = seq.after(noB).getValue();
            assert depoisDeB.equals("C") : "Falha: elemento após B deveria ser C";
            System.out.println("after(B) retorna: " + depoisDeB);
        }
        seq.insertLast("A");
        seq.insertLast("B");
        seq.insertLast("C");

        Object antigo1 = seq.replaceAtRank(1, "B-novo");
        assert antigo1.equals("B") : "Falha: elemento antigo deveria ser B";
        assert seq.elemAtRank(1).equals("B-novo") : "Falha: elemento novo não foi atribuído";
        System.out.println("replaceAtRank() - Substituído B por B-novo no índice 1");
        

        noC = seq.find("C");
        if (noC != null) {
            Object antigo2 = seq.replaceElement(noC, "C-novo");
            assert antigo2.equals("C") : "Falha: elemento antigo deveria ser C";
            System.out.println("replaceElement() - Substituído C por C-novo");
        }
        seq.insertLast("A");
        seq.insertLast("B");
        seq.insertLast("C");
        
        No noA = seq.find("A");
        noC = seq.find("C");
        
        if (noA != null && noC != null) {
            seq.swapElements(noA, noC);
            primeiro = seq.first().getValue();
            ultimo = seq.last().getValue();
            assert primeiro.equals("C") : "Falha: primeiro elemento deveria ser C";
            assert ultimo.equals("A") : "Falha: último elemento deveria ser A";
            System.out.println("swapElements() - Trocados A (primeiro) e C (último)");
            System.out.println("Sequência após swap: [C, B, A]");
        }
        
        seq.insertLast("A");
        seq.insertLast("B");
        seq.insertLast("C");
        
        noA = seq.find("A");
        noB = seq.find("B");
        noC = seq.find("C");
        
        assert seq.isFirst(noA) : "Falha: A deveria ser o primeiro";
        System.out.println("isFirst() confirma que A é o primeiro elemento");
        
        assert seq.isLast(noC) : "Falha: C deveria ser o último";
        System.out.println("isLast() confirma que C é o último elemento");
        
        assert !seq.isFirst(noB) : "Falha: B não deveria ser o primeiro";
        assert !seq.isLast(noB) : "Falha: B não deveria ser o último";
        System.out.println("B não é nem primeiro nem último - Verificações corretas");
        
        seq.insertLast(10);
        seq.insertLast(20);
        seq.insertLast(30);
        seq.insertLast(40);
        seq.insertLast(50);
        
        assert seq.elemAtRank(0).equals(10) : "Falha: índice 0 deveria ser 10";
        assert seq.elemAtRank(2).equals(30) : "Falha: índice 2 deveria ser 30";
        assert seq.elemAtRank(4).equals(50) : "Falha: índice 4 deveria ser 50";
        
        System.out.println("elemAtRank(0) = " + seq.elemAtRank(0));
        System.out.println("elemAtRank(2) = " + seq.elemAtRank(2));
        System.out.println("elemAtRank(4) = " + seq.elemAtRank(4));

        SeqListaLigada seqVazia = new SeqListaLigada();
        try {
            seqVazia.first();
        } catch (ESeqVazia e) {
            System.out.println("ESeqVazia corretamente lançada para first(): " + e.getMessage());
        }
        
        try {
            seqVazia.last();
            System.out.println("Deveria ter lançado ESeqVazia para last()");
        } catch (ESeqVazia e) {
            System.out.println("ESeqVazia corretamente lançada para last(): " + e.getMessage());
        }
        
        seq.insertLast("A");
        try {
            seq.elemAtRank(5);
            System.out.println("Deveria ter lançado ESeqIndice");
        } catch (ESeqIndice e) {
            System.out.println("ESeqIndice corretamente lançada: " + e.getMessage());
        }
        
        try {
            seqVazia.removeAtRank(0);
        } catch (ESeqVazia e) {
            System.out.println("ESeqVazia corretamente lançada para removeAtRank: " + e.getMessage());
        }
        
        try {
            No noInexistente = new No();
            seqVazia.remove(noInexistente);
        } catch (ESeqVazia e) {
            System.out.println("ESeqVazia corretamente lançada para remove: " + e.getMessage());
        }
        System.out.println("Construindo sequência: [1, 2, 3, 4, 5]");
        for (int i = 1; i <= 5; i++) {
            seq.insertLast(i);
        }
        
        System.out.println("Sequência criada com " + seq.size() + " elementos");
        
        primeiro = seq.first().getValue();
        ultimo = seq.last().getValue();
        assert primeiro.equals(1) && ultimo.equals(5);
        System.out.println("Primeiro: " + primeiro + ", Último: " + ultimo);
        
        seq.insertAtRank(2, 2.5);
        System.out.println("Inserido 2.5 no índice 2");
        
        seq.replaceAtRank(0, 1000);
        System.out.println("Substituído primeiro elemento por 1000");
        
        Object removido = seq.removeAtRank(3);
        System.out.println("Removido elemento no índice 3: " + removido);
        
        System.out.println("Tamanho final: " + seq.size());
        System.out.println("Sequência continua válida após todas as operações");
    }
}
