package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:29
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 长整型字面量
 * CONSTANT_Long_info {
 * u1 tag;
 * u8 bytes; 高位在前的 long
 * }
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
