package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:28
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 整型字面量
 * CONSTANT_Integer_info {
 *     u1 tag;
 *     u4 bytes; 高位在前的 int
 * }
 */

public class ConstantIntegerInfo extends ConstantPoolInfo {
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