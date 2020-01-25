package charlene.core.javaclass;

import java.io.DataInput;

/**
 * Jvm class 文件的field 处理器.
 * <pre>
 * field_info {
 *     u2             access_flags; 字段修饰符
 *     u2             name_index;  对常量池的引用,代表字段的简单名称
 *     u2             descriptor_index; 对常量池的引用,代表字段的描述符，字段类型
 *     u2             attributes_count; 属性表长度
 *     attribute_info attributes[attributes_count]; 属性表
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class Field {

    public Field(DataInput dataInput, ConstantPool constantPool) {

    }
}
