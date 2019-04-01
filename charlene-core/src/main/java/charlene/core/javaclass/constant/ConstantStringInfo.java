package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:39
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 字符串类型字面量
 * CONSTANT_String_info {
 * u1 tag;
 * u2 string_index; 字符串字面量的索引
 * }
 */

public class ConstantStringInfo extends ConstantPoolInfo {
    private final int index;

    public ConstantStringInfo(byte tag, int index) {
        super(tag);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "ConstantStringInfo{" +
                "index=" + index +
                "} " + super.toString();
    }
}
