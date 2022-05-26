
package net.guides.springboot2.crud.exception;

/**
 *
 * @author ihsa
 */
public abstract class BusinessException extends Exception {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
    
    
    
}
