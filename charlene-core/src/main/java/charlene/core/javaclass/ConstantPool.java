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
 * constant pool table of class file，contains subtype as followed.
 *
 * <table border="1">
 *     <caption>constant pool</caption>
 *     <tr>
 *         <th>Constant Type</th><th>Value</th>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Class</td><td>7</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Fieldref</td><td>9</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Methodref</td><td>10</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_InterfaceMethodref</td><td>11</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_String</td><td>8</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Integer</td><td>3</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Float</td><td>4</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Long</td><td>5</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Double</td><td>6</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_NameAndType</td><td>12</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_Utf8</td><td>1</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_MethodHandle</td><td>15</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_MethodType</td><td>16</td>
 *     </tr>
 *     <tr>
 *         <td>CONSTANT_InvokeDynamic</td><td>18</td>
 *     </tr>
 * </table>
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
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
