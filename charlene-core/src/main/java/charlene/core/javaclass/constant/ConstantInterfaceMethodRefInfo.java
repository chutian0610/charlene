package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:52
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 接口中方法的符号引用
 * CONSTANT_InterfaceMethodref_info {
 *     u1 tag;
 *     u2 class_index; 指向声明方法的接口 CONSTANT_Class_info
 *     u2 name_and_type_index; 指向字段描述符 CONSTANT_NameAndType_info的索引项
 * }
 */

public class ConstantInterfaceMethodRefInfo extends ConstantPoolInfo {

    private final int classIndex;
    private final int nameAndTypeIndex;
    public ConstantInterfaceMethodRefInfo(byte tag, int classIndex, int nameAndTypeIndex) {
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
        return "ConstantInterfaceMethodRefInfo{" +
                "classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                "} " + super.toString();
    }
}
