package charlene.core.javaclass;

import charlene.core.javaclass.exception.ClassFileFormatException;
import charlene.core.javaclass.attribute.AbstractAttributeInfo;
import charlene.core.javaclass.attribute.ConstantValueAttribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Jvm class 文件 attribute的处理器.
 *
 * <pre>
 * Attribute:
 *         ConstantValue
 *         Code
 *         StackMapTable
 *         Exceptions
 *         InnerClasses
 *         EnclosingMethod
 *         Synthetic
 *         Signature
 *         SourceFile
 *         SourceDebugExtension
 *         LineNumberTable
 *         LocalVariableTable
 *         LocalVariableTypeTable
 *         Deprecated
 *         RuntimeVisibleAnnotations
 *         RuntimeInvisibleAnnotations
 *         RuntimeVisibleParameterAnnotations
 *         RuntimeInvisibleParameterAnnotations
 *         RuntimeVisibleTypeAnnotations
 *         RuntimeInvisibleTypeAnnotations
 *         AnnotationDefault
 *         BootstrapMethods
 *         MethodParameters
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class Attributes {
    public static final String ANNOTATION_DEFAULT = "AnnotationDefault";
    public static final String BOOTSTRAP_METHODS = "BootstrapMethods";
    public static final String CHARACTER_RANGE_TABLE = "CharacterRangeTable";
    public static final String CODE = "Code";
    public static final String CONSTANT_VALUE = "ConstantValue";
    public static final String COMPILATIONID = "CompilationID";
    public static final String DEPRECATED = "Deprecated";
    public static final String ENCLOSING_METHOD = "EnclosingMethod";
    public static final String EXCEPTIONS = "Exceptions";
    public static final String INNER_CLASSES = "InnerClasses";
    public static final String LINE_NUMBER_TABLE = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    public static final String METHOD_PARAMETERS = "MethodParameters";
    public static final String RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";
    public static final String RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";
    public static final String SIGNATURE = "Signature";
    public static final String SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";
    public static final String SOURCE_FILE = "SourceFile";
    public static final String SOURCEID = "SourceID";
    public static final String STACK_MAP = "StackMap";
    public static final String STACK_MAP_TABLE = "StackMapTable";
    public static final String SYNTHETIC = "Synthetic";

    /**
     * fetch attributes of class, field and method from data input
     * @param dataInput
     * @return
     * @throws IOException
     */
    Attributes(DataInput dataInput, ConstantPool constantPool) throws IOException {
        int count = dataInput.readUnsignedShort();
        if (count > 0) {
            for(int i = 0; i < count; ++i) {
                int attributeNameIndex = dataInput.readUnsignedShort();
                int attributeLength = dataInput.readInt();
                String attributeName = constantPool.getutf8Info(attributeNameIndex).getUtf8();
                List<AbstractAttributeInfo> abstractAttributeInfos = new ArrayList<>();
                switch (attributeName){
                    case Attributes.ANNOTATION_DEFAULT:
                        break;
                    case Attributes.BOOTSTRAP_METHODS:
                        break;
                    case Attributes.CODE:
                        break;
                    case Attributes.CONSTANT_VALUE:
                        if (attributeLength !=2){
                            throw new ClassFileFormatException("Invalid attribute length for constant value");
                        }
                        abstractAttributeInfos.add(new ConstantValueAttribute(attributeNameIndex,attributeLength,dataInput.readUnsignedShort()));
                        break;
                    case Attributes.DEPRECATED:
                        break;
                    case Attributes.ENCLOSING_METHOD:
                        break;
                    case Attributes.EXCEPTIONS:
                        break;
                    case Attributes.INNER_CLASSES:
                        break;
                    case Attributes.LINE_NUMBER_TABLE:
                        break;
                    case Attributes.LOCAL_VARIABLE_TABLE:
                        break;
                    case Attributes.LOCAL_VARIABLE_TYPE_TABLE:
                        break;
                    case Attributes.METHOD_PARAMETERS:
                        break;
                    case Attributes.RUNTIME_INVISIBLE_ANNOTATIONS:
                        break;
                    case Attributes.RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
                        break;
                    case Attributes.RUNTIME_INVISIBLE_TYPE_ANNOTATIONS:
                        break;
                    case Attributes.RUNTIME_VISIBLE_ANNOTATIONS:
                        break;
                    case Attributes.RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
                        break;
                    case Attributes.RUNTIME_VISIBLE_TYPE_ANNOTATIONS:
                        break;
                    case Attributes.SIGNATURE:
                        break;
                    case Attributes.SOURCE_DEBUG_EXTENSION:
                        break;
                    case Attributes.SOURCE_FILE:
                        break;
                    case Attributes.STACK_MAP_TABLE:
                        break;
                    case Attributes.SYNTHETIC:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + attributeName);
                }
            }
        }
    }
}