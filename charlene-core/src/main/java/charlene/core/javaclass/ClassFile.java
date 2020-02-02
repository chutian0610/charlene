package charlene.core.javaclass;

import charlene.core.javaclass.exception.ClassFileFormatException;

import java.io.DataInput;
import java.io.IOException;

/**
 * jvm class 文件结构模型.
 * 基于<a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html">jvm class file format</a> 实现的class文件model.<br/>
 * class 文件结构如下:<br/>
 * <pre>
 * ClassFile {
 *      u4             magic; 魔数
 *      u2             minor_version; 次版本号
 *      u2             major_version; 主版本号
 *      u2             constant_pool_count; 常量池容量(计数从1开始)
 *      cp_info        constant_pool[constant_pool_count-1]; 常量池
 *      u2             access_flags; 访问标志
 *      u2             this_class; 类索引
 *      u2             super_class; 父类索引
 *      u2             interfaces_count; 接口计数器
 *      u2             interfaces[interfaces_count]; 接口表
 *      u2             fields_count; 字段表计数
 *      field_info     fields[fields_count]; 字段表
 *      u2             methods_count; 方法表计数
 *      method_info    methods[methods_count]; 方法表
 *      u2             attributes_count; 属性表计数
 *      attribute_info attributes[attributes_count]; 属性表
 * }
 * </pre>
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ClassFile {
    /**
     * class 文件头 默认魔数值.
     */

    public static final int CLASS_MAGIC_NUMBER = 0xCAFEBABE;
    public final int magic;
    public final int minorVersion;
    public final int majorVersion;
    public final ConstantPool constantPool;
    public final AccessFlags accessFlags;
    public final int thisClass;
    public final int superClass;
    public final int[] interfaces;
    public final Field[] fields;
//    public final Method[] methods;
//    public final Attributes attributes;

    ClassFile(DataInput dataInput) throws IOException {
        magic = dataInput.readInt();
        checkMagicNumber(magic);
        minorVersion = dataInput.readUnsignedShort();
        majorVersion = dataInput.readUnsignedShort();
        constantPool = new ConstantPool(dataInput);
        accessFlags = new AccessFlags(dataInput);
        thisClass = dataInput.readUnsignedShort();
        superClass = dataInput.readUnsignedShort();
        interfaces = deserializeInterfaces(dataInput);
        fields = deserializeFields(dataInput,constantPool);
    }

    /**
     * fetch field of class from data input
     * @param dataInput
     * @return
     * @throws IOException
     */
    private static Field[] deserializeFields(DataInput dataInput,ConstantPool constantPool) throws IOException {
        int count = dataInput.readUnsignedShort();
        if (count == 0) {
            return null;
        } else {
            Field[] fields = new Field[count];
            for(int i = 0; i < count; ++i) {
                fields[i] = new Field(dataInput,constantPool);
            }
            return fields;
        }
    }

    /**
     * check magic number of DataInput. if valivictor.dated , must equals ClassFile.classMagicNumber
     * @param magic
     * @throws IOException
     */
    private static void checkMagicNumber(int magic) throws IOException {
        if (magic != ClassFile.CLASS_MAGIC_NUMBER) {
            throw new ClassFileFormatException("Invalid class file format，wrong magic number！");
        }
    }

    /**
     * fetch interface tables
     * @param dataInput
     * @return
     * @throws IOException
     */
    private static int[] deserializeInterfaces(DataInput dataInput) throws IOException {
        int count = dataInput.readUnsignedShort();
        if (count == 0) {
            // not implement any interface
            return null;
        } else {
            int[] interfaces = new int[count];
            for(int i = 0; i < count; ++i) {
                interfaces[i] = dataInput.readUnsignedShort();
            }
            return interfaces;
        }
    }

}