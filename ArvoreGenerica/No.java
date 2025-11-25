public class No{
    private No pai;
    private Object element;
    private Object[] Filhos;

    public No(){
        this.pai = null;
        this.element = null;
        this.Filhos = new Object[8];
    }

    public void setPai(No no){
        this.pai = no;
    }

    public void setElement(Object o){
        this.element = o;
    }

    public void setFilho(No no, int index){
        this.Filhos[index] = no;
    }

    public No getPai(){
        return this.pai;
    }

    public Object getElement(){
        return this.element;
    }

    public Object getFilhos(){
        return this.Filhos;
    }
}