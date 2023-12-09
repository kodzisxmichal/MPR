package pl.edu.pjatk.michalk;

public class CatAlreadyExistsException extends RuntimeException{
    public CatAlreadyExistsException(){
        super("Cat already exists");
    }
}
