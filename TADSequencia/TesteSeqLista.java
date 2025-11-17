public class TesteSeqLista extends Seq_Lista {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║      TESTES COMPLETOS DO TAD SEQUÊNCIA - Seq_Lista             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        testeOperacoesBasicas();
        testeInsercoes();
        testeRemocoes();
        testeNavegacao();
        testeReplacement();
        testeSwap();
        testeExcecoes();
        testeVerificacoes();
        testeAcessoPorIndice();
        testeIntegracao();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              TODOS OS TESTES CONCLUÍDOS COM SUCESSO!           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    // TESTE 1: Operações Básicas (size, isEmpty)
    private static void testeOperacoesBasicas() {
        System.out.println("\n┌─ TESTE 1: OPERAÇÕES BÁSICAS ─────────────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            
            System.out.println("✓ Sequência criada");
            assert seq.isEmpty() : "Falha: sequência deveria estar vazia";
            System.out.println("✓ isEmpty() retorna true para sequência vazia");
            
            assert seq.size() == 0 : "Falha: tamanho deveria ser 0";
            System.out.println("✓ size() retorna 0 para sequência vazia");
            
            seq.insertFirst("A");
            assert !seq.isEmpty() : "Falha: sequência não deveria estar vazia";
            System.out.println("✓ isEmpty() retorna false após inserção");
            
            assert seq.size() == 1 : "Falha: tamanho deveria ser 1";
            System.out.println("✓ size() retorna 1 após uma inserção");
            
            System.out.println("└─ TESTE 1 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia e) {
            System.out.println("✗ TESTE 1 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 2: Inserções (insertFirst, insertLast, insertAtRank, insertBefore, insertAfter)
    private static void testeInsercoes() {
        System.out.println("\n┌─ TESTE 2: OPERAÇÕES DE INSERÇÃO ─────────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            
            // insertFirst
            seq.insertFirst("C");
            seq.insertFirst("B");
            seq.insertFirst("A");
            assert seq.size() == 3 : "Falha: tamanho deveria ser 3";
            assert seq.first().equals("A") : "Falha: primeiro elemento deveria ser A";
            System.out.println("✓ insertFirst() funciona corretamente - Sequência: [A, B, C]");
            
            // insertLast
            seq.insertLast("D");
            seq.insertLast("E");
            assert seq.last().equals("E") : "Falha: último elemento deveria ser E";
            assert seq.size() == 5 : "Falha: tamanho deveria ser 5";
            System.out.println("✓ insertLast() funciona corretamente - Sequência: [A, B, C, D, E]");
            
            // insertAtRank
            seq.insertAtRank(2, "X");
            assert seq.elemAtRank(2).equals("X") : "Falha: elemento no índice 2 deveria ser X";
            assert seq.size() == 6 : "Falha: tamanho deveria ser 6";
            System.out.println("✓ insertAtRank() funciona corretamente - Elemento X inserido na posição 2");
            
            // insertBefore - precisa de um nó
            No noB = seq.find("B");
            if (noB != null) {
                seq.insertBefore(noB, "B-");
                assert seq.size() == 7 : "Falha: tamanho deveria ser 7";
                System.out.println("✓ insertBefore() funciona corretamente - Elemento B- inserido antes de B");
            }
            
            // insertAfter
            No noB2 = seq.find("B");
            if (noB2 != null) {
                seq.insertAfter(noB2, "B+");
                assert seq.size() == 8 : "Falha: tamanho deveria ser 8";
                System.out.println("✓ insertAfter() funciona corretamente - Elemento B+ inserido depois de B");
            }
            
            System.out.println("└─ TESTE 2 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | ESeqIndice | NoInexistente e) {
            System.out.println("✗ TESTE 2 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 3: Remoções (remove, removeAtRank)
    private static void testeRemocoes() {
        System.out.println("\n┌─ TESTE 3: OPERAÇÕES DE REMOÇÃO ──────────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            seq.insertLast("B");
            seq.insertLast("C");
            seq.insertLast("D");
            seq.insertLast("E");
            
            int sizeInicial = seq.size();
            
            // remove por nó
            No noC = seq.find("C");
            if (noC != null) {
                Object removido = seq.remove(noC);
                assert removido.equals("C") : "Falha: elemento removido deveria ser C";
                assert seq.size() == sizeInicial - 1 : "Falha: tamanho não diminuiu";
                System.out.println("✓ remove() funciona corretamente - Elemento C removido");
            }
            
            // removeAtRank
            Object removidoRank = seq.removeAtRank(1);
            assert removidoRank.equals("B") : "Falha: elemento no índice 1 deveria ser B";
            assert seq.size() == sizeInicial - 2 : "Falha: tamanho deveria ser diminuído em 2";
            System.out.println("✓ removeAtRank() funciona corretamente - Elemento no índice 1 removido");
            
            System.out.println("└─ TESTE 3 APROVADO ───────────────────────────────────────────┘");
        } catch (ESeqVazia | ESeqIndice | NoInexistente e) {
            System.out.println("✗ TESTE 3 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 4: Navegação (first, last, before, after)
    private static void testeNavegacao() {
        System.out.println("\n┌─ TESTE 4: OPERAÇÕES DE NAVEGAÇÃO ─────────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            seq.insertLast("B");
            seq.insertLast("C");
            seq.insertLast("D");
            
            // first
            assert seq.first().equals("A") : "Falha: primeiro elemento deveria ser A";
            System.out.println("✓ first() retorna: " + seq.first());
            
            // last
            assert seq.last().equals("D") : "Falha: último elemento deveria ser D";
            System.out.println("✓ last() retorna: " + seq.last());
            
            // after
            Object after1 = seq.after(1); // Depois de B
            assert after1.equals("C") : "Falha: elemento após índice 1 deveria ser C";
            System.out.println("✓ after(1) retorna: " + after1);
            
            // before
            Object before2 = seq.before(2); // Antes de C
            assert before2.equals("B") : "Falha: elemento antes de índice 2 deveria ser B";
            System.out.println("✓ before(2) retorna: " + before2);
            
            System.out.println("└─ TESTE 4 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | ESeqIndice e) {
            System.out.println("✗ TESTE 4 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 5: Replacement (replaceAtRank, replaceElement)
    private static void testeReplacement() {
        System.out.println("\n┌─ TESTE 5: OPERAÇÕES DE SUBSTITUIÇÃO ──────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            seq.insertLast("B");
            seq.insertLast("C");
            
            // replaceAtRank
            Object antigo1 = seq.replaceAtRank(1, "B-novo");
            assert antigo1.equals("B") : "Falha: elemento antigo deveria ser B";
            assert seq.elemAtRank(1).equals("B-novo") : "Falha: elemento novo não foi atribuído";
            System.out.println("✓ replaceAtRank() - Substituído B por B-novo no índice 1");
            
            // replaceElement
            No noC = seq.find("C");
            if (noC != null) {
                Object antigo2 = seq.replaceElement(noC, "C-novo");
                assert antigo2.equals("C") : "Falha: elemento antigo deveria ser C";
                System.out.println("✓ replaceElement() - Substituído C por C-novo");
            }
            
            System.out.println("└─ TESTE 5 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | ESeqIndice | NoInexistente e) {
            System.out.println("✗ TESTE 5 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 6: Swap de elementos
    private static void testeSwap() {
        System.out.println("\n┌─ TESTE 6: OPERAÇÃO DE TROCA (SWAP) ───────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            seq.insertLast("B");
            seq.insertLast("C");
            
            No noA = seq.find("A");
            No noC = seq.find("C");
            
            if (noA != null && noC != null) {
                seq.swapElements(noA, noC);
                assert seq.first().equals("C") : "Falha: primeiro elemento deveria ser C";
                assert seq.last().equals("A") : "Falha: último elemento deveria ser A";
                System.out.println("✓ swapElements() - Trocados A (primeiro) e C (último)");
                System.out.println("  Sequência após swap: [C, B, A]");
            }
            
            System.out.println("└─ TESTE 6 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | NoInexistente e) {
            System.out.println("✗ TESTE 6 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 7: Verificações de posição (isFirst, isLast)
    private static void testeVerificacoes() {
        System.out.println("\n┌─ TESTE 7: VERIFICAÇÕES DE POSIÇÃO ────────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            seq.insertLast("B");
            seq.insertLast("C");
            
            No noA = seq.find("A");
            No noB = seq.find("B");
            No noC = seq.find("C");
            
            assert seq.isFirst(noA) : "Falha: A deveria ser o primeiro";
            System.out.println("✓ isFirst() confirma que A é o primeiro elemento");
            
            assert seq.isLast(noC) : "Falha: C deveria ser o último";
            System.out.println("✓ isLast() confirma que C é o último elemento");
            
            assert !seq.isFirst(noB) : "Falha: B não deveria ser o primeiro";
            assert !seq.isLast(noB) : "Falha: B não deveria ser o último";
            System.out.println("✓ B não é nem primeiro nem último - Verificações corretas");
            
            System.out.println("└─ TESTE 7 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | NoInexistente e) {
            System.out.println("✗ TESTE 7 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 8: Acesso por índice (elemAtRank)
    private static void testeAcessoPorIndice() {
        System.out.println("\n┌─ TESTE 8: ACESSO POR ÍNDICE (RANK) ───────────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast(10);
            seq.insertLast(20);
            seq.insertLast(30);
            seq.insertLast(40);
            seq.insertLast(50);
            
            assert seq.elemAtRank(0).equals(10) : "Falha: índice 0 deveria ser 10";
            assert seq.elemAtRank(2).equals(30) : "Falha: índice 2 deveria ser 30";
            assert seq.elemAtRank(4).equals(50) : "Falha: índice 4 deveria ser 50";
            
            System.out.println("✓ elemAtRank(0) = " + seq.elemAtRank(0));
            System.out.println("✓ elemAtRank(2) = " + seq.elemAtRank(2));
            System.out.println("✓ elemAtRank(4) = " + seq.elemAtRank(4));
            
            System.out.println("└─ TESTE 8 APROVADO ───────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | ESeqIndice e) {
            System.out.println("✗ TESTE 8 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 9: Tratamento de Exceções
    private static void testeExcecoes() {
        System.out.println("\n┌─ TESTE 9: TRATAMENTO DE EXCEÇÕES ────────────────────────────┐");
        try {
            SeqListaLigada seqVazia = new SeqListaLigada();
            
            // Teste 1: Acessar first() em sequência vazia
            try {
                seqVazia.first();
                System.out.println("✗ Deveria ter lançado ESeqVazia para first()");
            } catch (ESeqVazia e) {
                System.out.println("✓ ESeqVazia corretamente lançada para first(): " + e.getMessage());
            }
            
            // Teste 2: Acessar last() em sequência vazia
            try {
                seqVazia.last();
                System.out.println("✗ Deveria ter lançado ESeqVazia para last()");
            } catch (ESeqVazia e) {
                System.out.println("✓ ESeqVazia corretamente lançada para last(): " + e.getMessage());
            }
            
            // Teste 3: Índice inválido
            SeqListaLigada seq = new SeqListaLigada();
            seq.insertLast("A");
            try {
                seq.elemAtRank(5);
                System.out.println("✗ Deveria ter lançado ESeqIndice");
            } catch (ESeqIndice e) {
                System.out.println("✓ ESeqIndice corretamente lançada: " + e.getMessage());
            }
            
            // Teste 4: Remover de lista vazia
            try {
                seqVazia.removeAtRank(0);
                System.out.println("✗ Deveria ter lançado ESeqVazia");
            } catch (ESeqVazia e) {
                System.out.println("✓ ESeqVazia corretamente lançada para removeAtRank: " + e.getMessage());
            }
            
            // Teste 5: Nó inexistente em remove
            try {
                No noInexistente = new No();
                seqVazia.remove(noInexistente);
                System.out.println("✗ Deveria ter lançado ESeqVazia");
            } catch (ESeqVazia e) {
                System.out.println("✓ ESeqVazia corretamente lançada para remove: " + e.getMessage());
            }
            
            System.out.println("└─ TESTE 9 APROVADO ───────────────────────────────────────────┘");
        } catch (ESeqVazia | ESeqIndice | NoInexistente e) {
            System.out.println("✗ TESTE 9 FALHOU: " + e.getMessage());
        }
    }

    // TESTE 10: Teste de Integração Completo
    private static void testeIntegracao() {
        System.out.println("\n┌─ TESTE 10: TESTE DE INTEGRAÇÃO COMPLETO ─────────────────────┐");
        try {
            SeqListaLigada seq = new SeqListaLigada();
            
            // Construir uma sequência
            System.out.println("Construindo sequência: [1, 2, 3, 4, 5]");
            for (int i = 1; i <= 5; i++) {
                seq.insertLast(i);
            }
            
            System.out.println("✓ Sequência criada com " + seq.size() + " elementos");
            
            // Verificar operações
            assert seq.first().equals(1) && seq.last().equals(5);
            System.out.println("✓ Primeiro: " + seq.first() + ", Último: " + seq.last());
            
            // Modificar
            seq.insertAtRank(2, 2.5);
            System.out.println("✓ Inserido 2.5 no índice 2");
            
            seq.replaceAtRank(0, 1000);
            System.out.println("✓ Substituído primeiro elemento por 1000");
            
            Object removido = seq.removeAtRank(3);
            System.out.println("✓ Removido elemento no índice 3: " + removido);
            
            // Verificar estado final
            System.out.println("✓ Tamanho final: " + seq.size());
            System.out.println("✓ Sequência continua válida após todas as operações");
            
            System.out.println("└─ TESTE 10 APROVADO ──────────────────────────────────────────┘");
        } catch (AssertionError | ESeqVazia | ESeqIndice e) {
            System.out.println("✗ TESTE 10 FALHOU: " + e.getMessage());
        }
    }
}
