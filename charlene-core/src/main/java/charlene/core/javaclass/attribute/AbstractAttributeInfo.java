package charlene.core.javaclass.attribute;

/**
 * 代表了jvm class 文件中的 attribute.
 *
 * <p>attribute 的通用结构如下:</p>
 * <pre>
 * attribute_info {
 *     u2 attributeNameIndex; // 属性名,指向常量池中某个CONSTANT_Utf8_info的属性名
 *     u4 attribute_length; // 属性长度
 *     u1 info[attribute_length];
 * }
 * </pre>
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public abstract class AbstractAttributeInfo {

    public final int attributeNameIndex;
    public final int attributeLength;

    public AbstractAttributeInfo(int attributeNameIndex, int attributeLength) {
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
