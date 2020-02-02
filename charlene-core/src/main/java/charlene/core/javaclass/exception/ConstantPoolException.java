package charlene.core.javaclass.exception;

/**
 * Constant Pool Exception
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ConstantPoolException extends ClassFileFormatException {
    public ConstantPoolException() {
    }

    public ConstantPoolException(String message) {
        super(message);
    }

    public ConstantPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstantPoolException(Throwable cause) {
        super(cause);
    }

    public ConstantPoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
