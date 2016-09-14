package prizeservice;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid account number")
public class InvalidAccountNumberException extends Exception 
{   
    private static final String defaultMessage = "InvalidAccountNumberException";

    public InvalidAccountNumberException() { super(defaultMessage); }
    public InvalidAccountNumberException(String message) { super(message); }
    public InvalidAccountNumberException(String message, Throwable cause) { super(message, cause); }
    public InvalidAccountNumberException(Throwable cause) { super(cause); }
}
