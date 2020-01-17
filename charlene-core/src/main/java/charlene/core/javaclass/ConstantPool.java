package charlene.core.javaclass;

import charlene.core.javaclass.constant.ConstantInvokeDynamicInfo;
import charlene.core.javaclass.exception.ConstantPoolException;
import charlene.core.javaclass.constant.ConstantClassInfo;
import charlene.core.javaclass.constant.ConstantDoubleInfo;
import charlene.core.javaclass.constant.ConstantFieldRefInfo;
import charlene.core.javaclass.constant.ConstantFloatInfo;
import charlene.core.javaclass.constant.ConstantIntegerInfo;
import charlene.core.javaclass.constant.ConstantInterfaceMethodRefInfo;
import charlene.core.javaclass.constant.ConstantLongInfo;
import charlene.core.javaclass.constant.ConstantMethodHandleInfo;
import charlene.core.javaclass.constant.ConstantMethodRefInfo;
import charlene.core.javaclass.constant.ConstantMethodTypeInfo;
import charlene.core.javaclass.constant.ConstantNameAndTypeInfo;
import charlene.core.javaclass.constant.ConstantPoolInfo;
import charlene.core.javaclass.constant.ConstantStringInfo;
import charlene.core.javaclass.constant.ConstantUtf8Info;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-10:12
 * @Project charlene
 * @Package charlene.javaclass
 * @Version 1.0
 * @Description
 * constant pool table of class file，contains subtype as followed：
 *
 * Constant Type	            Value
 * CONSTANT_Class	            7
 * CONSTANT_Fieldref         	9
 * CONSTANT_Methodref	        10
 * CONSTANT_InterfaceMethodref	11
 * CONSTANT_String	            8
 * CONSTANT_Integer	            3
 * CONSTANT_Float	            4
 * CONSTANT_Long	            5
 * CONSTANT_Double	            6
 * CONSTANT_NameAndType	        12
 * CONSTANT_Utf8	            1
 * CONSTANT_MethodHandle	    15
 * CONSTANT_MethodType	        16
 * CONSTANT_InvokeDynamic	    18
 */

public class ConstantPool {
    public static final int CONSTANT_Utf8 = 1;
    public static final int CONSTANT_Integer = 3;
    public static final int CONSTANT_Float = 4;
    public static final int CONSTANT_Long = 5;
    public static final int CONSTANT_Double = 6;
    public static final int CONSTANT_Class = 7;
    public static final int CONSTANT_String = 8;
    public static final int CONSTANT_Fieldref = 9;
    public static final int CONSTANT_Methodref = 10;
    public static final int CONSTANT_InterfaceMethodref = 11;
    public static final int CONSTANT_NameAndType = 12;
    public static final int CONSTANT_MethodHandle = 15;
    public static final int CONSTANT_MethodType = 16;
    public static final int CONSTANT_InvokeDynamic = 18;
    private ArrayList<ConstantPoolInfo> constantPoolInfoList = new ArrayList<>();

    ConstantPool(DataInput dataInput) throws IOException {
        // constant pool array count
        int count = dataInput.readUnsignedShort();
        if (count >0) {
            for (int i = 1; i < count; ++i) {
                byte tag = dataInput.readByte(); // subtype index
                switch (tag) {
                    case ConstantPool.CONSTANT_Utf8:
                        constantPoolInfoList.add(new ConstantUtf8Info(tag, dataInput.readUTF()));
                        break;
                    case ConstantPool.CONSTANT_Integer:
                        constantPoolInfoList.add(new ConstantIntegerInfo(tag, dataInput.readInt()));
                        break;
                    case ConstantPool.CONSTANT_Float:
                        constantPoolInfoList.add(new ConstantFloatInfo(tag, dataInput.readFloat()));
                        break;
                    case ConstantPool.CONSTANT_Long:
                        constantPoolInfoList.add(new ConstantLongInfo(tag,dataInput.readLong()));
                        break;
                    case ConstantPool.CONSTANT_Double:
                        constantPoolInfoList.add(new ConstantDoubleInfo(tag,dataInput.readDouble()));
                        break;
                    case ConstantPool.CONSTANT_Class:
                        constantPoolInfoList.add(new ConstantClassInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_String:
                        constantPoolInfoList.add(new ConstantStringInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_Fieldref:
                        constantPoolInfoList.add(new ConstantFieldRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_Methodref:
                        constantPoolInfoList.add(new ConstantMethodRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_InterfaceMethodref:
                        constantPoolInfoList.add(new ConstantInterfaceMethodRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_NameAndType:
                        constantPoolInfoList.add(new ConstantNameAndTypeInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_MethodHandle:
                        constantPoolInfoList.add(new ConstantMethodHandleInfo(tag,dataInput.readByte()
                                ,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_MethodType:
                        constantPoolInfoList.add(new ConstantMethodTypeInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_InvokeDynamic:
                        constantPoolInfoList.add(new ConstantInvokeDynamicInfo(tag,dataInput.readUnsignedShort()
                                ,dataInput.readUnsignedShort()));
                        break;
                    default:
                        throw new ConstantPoolException(
                                "Invalid constant pool tag, this kind tag{"+ tag +"} is not supported currently!");


                }
            }
        }
    }

    public ConstantPoolInfo get(int i) {
        return constantPoolInfoList.get(i);
    }

    public ConstantUtf8Info getUTF8Info(int i){
        ConstantPoolInfo constantPoolInfo = constantPoolInfoList.get(i);
        if(constantPoolInfo.getTag() == CONSTANT_Utf8){
            return (ConstantUtf8Info) constantPoolInfo;
        }else {
            throw new ConstantPoolException("unexpected constant at #" + i + " -- expected tag 1, found "+constantPoolInfo.getTag());
        }
    }

    public int size() {
        return constantPoolInfoList.size();
    }
}
