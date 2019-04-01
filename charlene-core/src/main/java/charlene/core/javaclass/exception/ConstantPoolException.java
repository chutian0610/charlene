package charlene.core.javaclass.exception;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-30-16:38
 * @Project charlene
 * @Package charlene.deserializer
 * @Version 1.0
 * @Description Constant Pool Exception
 */

public class ConstantPoolException extends ClassFileFormatExecption {
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
