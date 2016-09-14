package prizeservice;

public class TechnicalFailureException extends Exception 
{
    private static final String defaultMessage = "TechnicalFailureException";
    
    public TechnicalFailureException() { super(defaultMessage); }
    public TechnicalFailureException(String message) { super(message); }
    public TechnicalFailureException(String message, Throwable cause) { super(message, cause); }
    public TechnicalFailureException(Throwable cause) { super(cause); }
}
