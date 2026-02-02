import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private No pai;
    private int element;
    private No FE;
    private No FD;

    public No() {
        this.pai = null;
        this.element = 0;
        this.FE = null;
        this.FD = null;
    }

    public No(No pai, int element) {
        this.pai = pai;
        this.element = element;
        this.FE = null;
        this.FD = null;
    }

    public int getElement() {
        return this.element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public No pai() {
        return this.pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public boolean hasLeft() {
        return this.FE != null;
    }

    public boolean hasRight() {
        return this.FD != null;
    }

    public No getFE() {
        return this.FE;
    }

    public void setFE(No fe) {
        this.FE = fe;
    }

    public No getFD() {
        return this.FD;
    }

    public void setFD(No fd) {
        this.FD = fd;
    }

    public int numFilhos() {
        int qtd = 0;
        if (this.FE != null){
            qtd++;
        }
        if (this.FD != null){
            qtd++;
        }
        return qtd;
    }

    public Iterator<No> filhos() {
        ArrayList<No> filhos = new ArrayList<>();
        if (this.FE != null){
           filhos.add(this.FE); 
        } 
        if (this.FD != null){
            filhos.add(this.FD);
        }
        return filhos.iterator();
    }
}
 