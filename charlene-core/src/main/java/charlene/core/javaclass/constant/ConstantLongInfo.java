package charlene.core.javaclass.constant;

/**
 * 长整型字面量.
 * <pre>
 * CONSTANT_Long_info {
 * u1 tag;
 * u8 bytes; 高位在前的 long
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ConstantLongInfo extends ConstantPoolInfo {
    private final long value;

    public ConstantLongInfo(byte tag, long value) {
        super(tag);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantLongInfo{" +
                "value=" + value +
                "} " + super.toString();
    }
}
