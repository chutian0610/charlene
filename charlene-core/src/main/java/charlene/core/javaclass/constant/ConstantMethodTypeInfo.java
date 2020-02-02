package charlene.core.javaclass.constant;

/**
 * 方法类型.
 * <pre>
 * CONSTANT_MethodType_info {
 *     u1 tag;
 *     u2 descriptor_index; 对常量池的有效索引，常量池在该索引处的项必须是 CONSTANT_Utf8_info
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ConstantMethodTypeInfo extends AbstractConstantPoolInfo {
    private final int descriptorIndex;
    public ConstantMethodTypeInfo(byte tag, int descriptorIndex) {
        super(tag);
        this.descriptorIndex = descriptorIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public String toString() {
        return "ConstantMethodTypeInfo{" +
                "descriptorIndex=" + descriptorIndex +
                "} " + super.toString();
    }
}
