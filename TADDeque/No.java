public class No {
    Object value;
    No next;
    No prev;

    public No() {
        this.value = null;
        this.next = null;
        this.prev = null;
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
