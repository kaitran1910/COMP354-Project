public class ZeroDivisionException extends ArithmeticException {
    public ZeroDivisionException() {
        super("Error! Division by Zero.");
    }
    
    public ZeroDivisionException(String message) {
        super(message);
    }
}
