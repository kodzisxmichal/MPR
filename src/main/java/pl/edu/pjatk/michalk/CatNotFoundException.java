package pl.edu.pjatk.michalk;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(){
        super("Cat not found");
    }
}
