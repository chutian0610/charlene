package charlene.core.javaclass;

import java.io.DataInput;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-29-22:06
 * @Project charlene
 * @Package charlene.javaclass
 * @Version 1.0
 * @Description java class field
 * field_info {
 *     u2             access_flags; 字段修饰符
 *     u2             name_index;  对常量池的引用,代表字段的简单名称
 *     u2             descriptor_index; 对常量池的引用,代表字段的描述符，字段类型
 *     u2             attributes_count; 属性表长度
 *     attribute_info attributes[attributes_count]; 属性表
 * }
 */

public class Field {

    public Field(DataInput dataInput, ConstantPool constantPool) {

    }
}
