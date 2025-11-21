public class No{
    private No pai;
    private Object element;
    private No Filhos;

    public No(){
        this.pai = null;
        this.element = null;
        this.Filhos = null;
    }

    public void setPai(No n){
        this.pai = n;
    }

    public void setElement(No n){
        this.element = n;
    }

    public void setFilhos(No n){
        this.Filhos = n;
    }

    public No getPai(){
        return this.pai;
    }

    public Object getElement(){
        return this.element;
    }

    public No getFilhos(){
        return this.Filhos;
    }
}