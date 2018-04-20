package it.nextworks.nfvmano.timeo.common.exception;

/**
 * Created by Marco Capitani on 14/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class OptimizationFailedException extends Exception {

    public OptimizationFailedException() {
        super();
    }

    public OptimizationFailedException(Throwable throwable) {
        super(throwable);
    }

    protected OptimizationFailedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

    public OptimizationFailedException(String message) {
        super(message);
    }

    public OptimizationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
