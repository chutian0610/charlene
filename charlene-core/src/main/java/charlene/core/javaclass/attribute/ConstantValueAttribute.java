package charlene.core.javaclass.attribute;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-30-19:07
 * @Project charlene
 * @Package charlene.javaclass.attribute
 * @Version 1.0
 * @Description TODO
 * ConstantValue_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 constantvalue_index; // constant pool 中的有效索引,类型如下:
 * }
 * Field Type	                    Entry Type
 * long	                            CONSTANT_Long
 * float	                        CONSTANT_Float
 * double	                        CONSTANT_Double
 * int, short, char, byte, boolean	CONSTANT_Integer
 * String	                        CONSTANT_String
 */

public class ConstantValueAttribute extends AttributeInfo {
    private final int constantValueIndex;

    public ConstantValueAttribute(int attributeNameIndex, int attributeLength, int constantValueIndex) {
        super(attributeNameIndex, attributeLength);
        this.constantValueIndex = constantValueIndex;
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
