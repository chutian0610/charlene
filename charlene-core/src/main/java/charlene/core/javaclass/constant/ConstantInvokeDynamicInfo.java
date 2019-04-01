package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-10:09
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 动态方法调用点
 * CONSTANT_InvokeDynamic_info {
 *     u1 tag;
 *     u2 bootstrap_method_attr_index; 值必须是对当前 class中引导方法表 bootstrap_method[] 数组的有效索引
 *     u2 name_and_type_index; 对常量池的有效索引，CONSTANT_NameAndType_info 类型
 * }
 */

public class ConstantInvokeDynamicInfo extends ConstantPoolInfo {
    private final int bootstrapMethodAttrIndex;
    private final int nameAndTypeIndex;
    public ConstantInvokeDynamicInfo(byte tag, int bootstrapMethodAttrIndex, int nameAndTypeIndex) {
        super(tag);
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "ConstantInvokeDynamicInfo{" +
                "bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                "} " + super.toString();
    }
}
