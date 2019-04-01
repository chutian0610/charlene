package charlene.core.javaclass.attribute;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-29-22:15
 * @Project charlene
 * @Package charlene.javaclass.attribute
 * @Version 1.0
 * @Description java class attribute
 * attribute_info {
 *     u2 attributeNameIndex; // 属性名,指向常量池中某个CONSTANT_Utf8_info的属性名
 *     u4 attribute_length; // 属性长度
 *     u1 info[attribute_length];
 * }
 */

public abstract class AttributeInfo {

    public final int attributeNameIndex;
    public final int attributeLength;

    public AttributeInfo(int attributeNameIndex, int attributeLength) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
    }

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }
}
