package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:44
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 字段的符号引用
 * CONSTANT_Fieldref_info {
 *     u1 tag;
 *     u2 class_index; 指向声明字段的类或接口 CONSTANT_Class_info
 *     u2 name_and_type_index; 指向字段描述符 CONSTANT_NameAndType_info的索引项
 * }
 */

public class ConstantFieldRefInfo extends ConstantPoolInfo{
    private final int classIndex;
    private final int nameAndTypeIndex;
    public ConstantFieldRefInfo(byte tag, int classIndex, int nameAndTypeIndex) {
        super(tag);
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "ConstantFieldRefInfo{" +
                "classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                "} " + super.toString();
    }
}
