package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:28
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 双精度浮点型字面量
 * CONSTANT_Double_info {
 *     u1 tag;
 *     u8 bytes; 高位在前的 double
 * }
 */
public class ConstantDoubleInfo extends ConstantPoolInfo {
    private final double value;

    public ConstantDoubleInfo(byte tag, double value) {
        super(tag);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" +
                "value=" + value +
                "} " + super.toString();
    }
}
