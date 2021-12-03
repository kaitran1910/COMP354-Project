public class SyntaxErrorException extends ArithmeticException {
    
    public SyntaxErrorException() {
        super("Syntax Error!");
    }
    
    public SyntaxErrorException(String message) {
        super(message);
    }
}
