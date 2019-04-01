package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:27
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 类或接口的符号引用
 * CONSTANT_Class_info {
 * u1 tag;
 * u2 name_index; 指向全限定类名常量项的索引
 * }
 */

public class ConstantClassInfo extends ConstantPoolInfo {
    private final int nameIndex;

    public ConstantClassInfo(byte tag, int nameIndex) {
        super(tag);
        this.nameIndex = nameIndex;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    @Override
    public String toString() {
        return "ConstantClassInfo{" +
                "nameIndex=" + nameIndex +
                "} " + super.toString();
    }
}
