package charlene.core.javaclass.exception;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:23
 * @Project charlene
 * @Package charlene.deserializer
 * @Version 1.0
 * @Description class file format exception
 */

public class ClassFileFormatExecption extends RuntimeException {

    private static final long serialVersionUID = -8154925009678576837L;

    public ClassFileFormatExecption() {
    }

    public ClassFileFormatExecption(String message) {
        super(message);
    }

    public ClassFileFormatExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassFileFormatExecption(Throwable cause) {
        super(cause);
    }

    public ClassFileFormatExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

