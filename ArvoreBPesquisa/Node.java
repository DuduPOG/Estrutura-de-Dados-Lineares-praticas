public class Node {
    private Node pai;
    private Node FE;
    private Object element;
    private Node FD;

    public Node(){
        this.pai = null;
        this.FE = null;
        this.element = null;
        this.FD = null;
    }

    public void setPai(Node n){
        this.pai = n;
    }

    public void setFE(Node n){
        this.FE = n;
    }

    public void setElement(Node n){
        this.element = n;
    }

    public void setFD(Node n){
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