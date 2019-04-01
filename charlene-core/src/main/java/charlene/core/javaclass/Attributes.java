package charlene.core.javaclass;

import charlene.core.javaclass.exception.ClassFileFormatExecption;
import charlene.core.javaclass.attribute.AttributeInfo;
import charlene.core.javaclass.attribute.ConstantValueAttribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-30-18:33
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description
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
 */

public class Attributes {
    public static final String AnnotationDefault = "AnnotationDefault";
    public static final String BootstrapMethods = "BootstrapMethods";
    public static final String CharacterRangeTable = "CharacterRangeTable";
    public static final String Code = "Code";
    public static final String ConstantValue = "ConstantValue";
    public static final String CompilationID = "CompilationID";
    public static final String Deprecated = "Deprecated";
    public static final String EnclosingMethod = "EnclosingMethod";
    public static final String Exceptions = "Exceptions";
    public static final String InnerClasses = "InnerClasses";
    public static final String LineNumberTable = "LineNumberTable";
    public static final String LocalVariableTable = "LocalVariableTable";
    public static final String LocalVariableTypeTable = "LocalVariableTypeTable";
    public static final String MethodParameters = "MethodParameters";
    public static final String RuntimeVisibleAnnotations = "RuntimeVisibleAnnotations";
    public static final String RuntimeInvisibleAnnotations = "RuntimeInvisibleAnnotations";
    public static final String RuntimeVisibleParameterAnnotations = "RuntimeVisibleParameterAnnotations";
    public static final String RuntimeInvisibleParameterAnnotations = "RuntimeInvisibleParameterAnnotations";
    public static final String RuntimeVisibleTypeAnnotations = "RuntimeVisibleTypeAnnotations";
    public static final String RuntimeInvisibleTypeAnnotations = "RuntimeInvisibleTypeAnnotations";
    public static final String Signature = "Signature";
    public static final String SourceDebugExtension = "SourceDebugExtension";
    public static final String SourceFile = "SourceFile";
    public static final String SourceID = "SourceID";
    public static final String StackMap = "StackMap";
    public static final String StackMapTable = "StackMapTable";
    public static final String Synthetic = "Synthetic";

    private List<AttributeInfo> attributeInfos = new ArrayList<>();
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
                int attribute_name_index = dataInput.readUnsignedShort();
                int attribute_length = dataInput.readInt();
                String attribute_name = constantPool.getUTF8Info(attribute_name_index).getUtf8();
                switch (attribute_name){
                    case Attributes.AnnotationDefault:
                        break;
                    case Attributes.BootstrapMethods:
                        break;
                    case Attributes.Code:
                        break;
                    case Attributes.ConstantValue:
                        if (attribute_length !=2){
                            throw new ClassFileFormatExecption("Invalid attribute length for constant value");
                        }
                        attributeInfos.add(new ConstantValueAttribute(attribute_name_index,attribute_length,dataInput.readUnsignedShort()));
                        break;
                    case Attributes.Deprecated:
                        break;
                    case Attributes.EnclosingMethod:
                        break;
                    case Attributes.Exceptions:
                        break;
                    case Attributes.InnerClasses:
                        break;
                    case Attributes.LineNumberTable:
                        break;
                    case Attributes.LocalVariableTable:
                        break;
                    case Attributes.LocalVariableTypeTable:
                        break;
                    case Attributes.MethodParameters:
                        break;
                    case Attributes.RuntimeInvisibleAnnotations:
                        break;
                    case Attributes.RuntimeInvisibleParameterAnnotations:
                        break;
                    case Attributes.RuntimeInvisibleTypeAnnotations:
                        break;
                    case Attributes.RuntimeVisibleAnnotations:
                        break;
                    case Attributes.RuntimeVisibleParameterAnnotations:
                        break;
                    case Attributes.RuntimeVisibleTypeAnnotations:
                        break;
                    case Attributes.Signature:
                        break;
                    case Attributes.SourceDebugExtension:
                        break;
                    case Attributes.SourceFile:
                        break;
                    case Attributes.StackMapTable:
                        break;
                    case Attributes.Synthetic:
                        break;
                }
            }
        }
    }
}