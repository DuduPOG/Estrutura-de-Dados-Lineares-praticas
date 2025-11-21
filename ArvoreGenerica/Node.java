public class Node{
    private Node pai;
    private int element;
    private Node Filhos;

    public No(){
        this.pai = null;
        this.element = null;
        this.Filhos = null;
    }

    public setPai(Node n){
        this.pai = n;
    }

    public setElement(Node n){
        this.element = n;
    }

    public setFilhos(Node n){
        this.Filhos = n;
    }

    public getPai(){
        return this.pai;
    }

    public getElement(){
        return this.element;
    }

    public getFilhos(){
        return this.Filhos;
    }
}