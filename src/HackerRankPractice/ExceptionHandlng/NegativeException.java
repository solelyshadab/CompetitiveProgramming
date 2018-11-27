package HackerRankPractice.ExceptionHandlng;

public class NegativeException extends Exception {
    String message;
    public NegativeException(String message){
       this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
