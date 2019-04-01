package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-10:06
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 方法类型
 * CONSTANT_MethodType_info {
 *     u1 tag;
 *     u2 descriptor_index; 对常量池的有效索引，常量池在该索引处的项必须是 CONSTANT_Utf8_info
 * }
 */

public class ConstantMethodTypeInfo extends ConstantPoolInfo {
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
