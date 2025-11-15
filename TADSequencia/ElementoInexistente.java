import java.util.NoSuchElementException;

public class ElementoInexistente extends NoSuchElementException{
    public ElementoInexistente (String err){
        super(err);
    }
}
