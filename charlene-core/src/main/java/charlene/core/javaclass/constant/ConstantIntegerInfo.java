package charlene.core.javaclass.constant;

/**
 * 整型字面量.
 * <pre>
 * CONSTANT_Integer_info {
 *     u1 tag;
 *     u4 bytes; 高位在前的 int
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @since 2020-01-25
 */

public class ConstantIntegerInfo extends AbstractConstantPoolInfo {
    private final int value;
    public ConstantIntegerInfo(byte tag, int value) {
        super(tag);
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConstantIntegerInfo{" +
                "value=" + value +
                "} " + super.toString();
    }
}