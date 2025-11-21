public class No {
    private No pai;
    private No FE;
    private Object element;
    private No FD;

    public No(){
        this.pai = null;
        this.FE = null;
        this.element = null;
        this.FD = null;
    }

    public void setPai(No n){
        this.pai = n;
    }

    public void setFE(No n){
        this.FE = n;
    }

    public void setElement(No n){
        this.element = n;
    }

    public void setFD(No n){
        this.FD = n;
    }

    public No getPai(){
        return this.pai;
    }

    public No getFE(){
        return this.FE;
    }

    public Object getElement(){
        return this.element;
    }

    public No getFD(){
        return this.FD;
    }
}