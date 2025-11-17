import java.util.NoSuchElementException;

public class NoInexistente extends NoSuchElementException{
    public NoInexistente (String err){
        super(err);
    }
}
