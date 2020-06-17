package charlene.core.javaclass.constant;

/**
 * 双精度浮点型字面量.
 * <pre>
 * CONSTANT_Double_info {
 *     u1 tag;
 *     u8 bytes; 高位在前的 double
 * }
 * </pre>
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @since 2020-01-25
 */
public class ConstantDoubleInfo extends AbstractConstantPoolInfo {
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
