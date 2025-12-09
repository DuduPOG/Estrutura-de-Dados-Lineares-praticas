import java.util.Iterator;

public class Teste extends ArvoreBP {
    public static void main(String[] args) {

        ArvoreBP arvore = new ArvoreBP();

        System.out.println("Iniciando testes da Árvore Binária de Pesquisa...\n");

        // ===================== CRIAÇÃO =====================
        System.out.println("Teste: criação da árvore");

        assert arvore.isEmpty();
        assert arvore.size() == 0;
        assert arvore.raiz() == null;

        System.out.println("Árvore criada corretamente.\n");

        // ===================== INSERÇÃO =====================
        System.out.println("Teste: inserções");

        arvore.insert(50);
        assert !arvore.isEmpty();
        assert arvore.size() == 1;

        arvore.insert(30);
        arvore.insert(70);
        arvore.insert(20);
        arvore.insert(40);
        arvore.insert(60);
        arvore.insert(80);
        arvore.insert(50); // duplicado

        assert arvore.size() == 8;

        System.out.println("Inserções funcionando.\n");

        // ===================== NAVEGAÇÃO =====================
        System.out.println("Teste: navegação");

        No raiz = arvore.raiz();
        assert raiz != null;
        assert (int) raiz.getElement() == 50;

        No esq = arvore.getFE(raiz);
        No dir = arvore.getFD(raiz);

        assert esq != null;
        assert dir != null;
        assert (int) esq.getElement() == 30;
        assert (int) dir.getElement() == 70;

        No pai = arvore.pai(esq);
        assert pai == raiz;

        System.out.println("Navegação ok.\n");

        // ===================== PROFUNDIDADE E ALTURA =====================
        System.out.println("Teste: profundidade e altura");

        int profRaiz = arvore.profundidade(raiz);
        assert profRaiz == 0;

        int altura = arvore.altura(raiz);
        System.out.println("Altura da árvore: " + altura);

        No no20 = arvore.getFE(esq);
        if (no20 != null) {
            int altura20 = arvore.altura(no20);
            assert altura20 == 0;
        }

        System.out.println("Profundidade e altura ok.\n");

        // ===================== EM ORDEM =====================
        System.out.println("Percurso em ordem:");
        arvore.emOrdem(arvore.raiz());
        System.out.println("\n");

        // ===================== REMOÇÃO =====================
        System.out.println("Teste: remoções");

        int tamAntes = arvore.size();

        arvore.remove(20);
        assert arvore.size() == tamAntes - 1;

        arvore.remove(30);

        tamAntes = arvore.size();
        arvore.remove(50);
        assert arvore.size() == tamAntes - 1;

        System.out.println("Remoções funcionando.\n");

        // ===================== ITERADORES =====================
        System.out.println("Teste: iteradores");

        Iterator<No> itNos = arvore.nos();
        int c1 = 0;
        System.out.print("Nos: ");
        while (itNos.hasNext()) {
            System.out.print(itNos.next().getElement() + " ");
            c1++;
        }
        System.out.println();

        Iterator<Object> itEl = arvore.elements();
        int c2 = 0;
        System.out.print("Elementos: ");
        while (itEl.hasNext()) {
            System.out.print(itEl.next() + " ");
            c2++;
        }
        System.out.println();

        assert c1 == c2;

        System.out.println("Iteradores ok.\n");

        // ===================== DESENHO =====================
        System.out.println("Desenho da árvore:");
        arvore.desenharArvore();
        System.out.println();

        System.out.println("Todos os testes finalizados com sucesso.");
    }
}
 