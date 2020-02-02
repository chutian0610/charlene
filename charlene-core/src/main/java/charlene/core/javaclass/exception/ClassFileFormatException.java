package charlene.core.javaclass.exception;

/**
 * class file format exception.
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ClassFileFormatException extends RuntimeException {

    private static final long serialVersionUID = -8154925009678576837L;

    public ClassFileFormatException() {
    }

    public ClassFileFormatException(String message) {
        super(message);
    }

    public ClassFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassFileFormatException(Throwable cause) {
        super(cause);
    }

    public ClassFileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
