public class No {
    private No prev;
    private Object value;
    private No next;

    public No(){
        this.prev = null;
        this.value = null;
        this.next = null;
    }

    public void setPrev(No o){
        this.prev = o;
    }

    public void setValue(Object o){
        this.value = o;
    }

    public void setNext(No o){
        this.next = o;
    }

    public No getPrev(){
        return this.prev;
    }

    public Object getValue(){
        return this.value;
    }

    public No getNext(){
        return this.next;
    }
}
