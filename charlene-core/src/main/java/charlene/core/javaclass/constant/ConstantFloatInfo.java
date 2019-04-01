package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:28
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 浮点型字面量
 * CONSTANT_Float_info {
 *     u1 tag;
 *     u4 bytes; 高位在前的 float
 * }
 */

public class ConstantFloatInfo extends ConstantPoolInfo {
    private final float value;
    public ConstantFloatInfo(byte tag, float value) {
        super(tag);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantFloatInfo{" +
                "value=" + value +
                "} " + super.toString();
    }
}
