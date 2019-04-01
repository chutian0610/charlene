package charlene.core.javaclass.attribute;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-30-19:20
 * @Project charlene
 * @Package charlene.javaclass.attribute
 * @Version 1.0
 * @Description
 * AnnotationDefault_attribute {
 *     u2            attribute_name_index;
 *     u4            attribute_length;
 *     element_value default_value;
 * }
 */

public class AnnotationDefaultAttribute extends AttributeInfo {
    public AnnotationDefaultAttribute(int attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
    }
}
