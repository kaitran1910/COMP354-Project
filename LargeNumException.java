public class LargeNumException extends ArithmeticException {
    public LargeNumException() {
        super("Error! Number is to large to display");
    }
    
    
    public LargeNumException(String message) {
        super(message);
    }
}
