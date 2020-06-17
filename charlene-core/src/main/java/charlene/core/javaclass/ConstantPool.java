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
import charlene.core.javaclass.constant.AbstractConstantPoolInfo;
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
 * @since 2020-01-25
 */

public class ConstantPool {
    public static final int CONSTANT_UTF8 = 1;
    public static final int CONSTANT_INTEGER = 3;
    public static final int CONSTANT_FLOAT = 4;
    public static final int CONSTANT_LONG = 5;
    public static final int CONSTANT_DOUBLE = 6;
    public static final int CONSTANT_CLASS = 7;
    public static final int CONSTANT_STRING = 8;
    public static final int CONSTANT_FIELD_REF = 9;
    public static final int CONSTANT_METHOD_REF = 10;
    public static final int CONSTANT_INTERFACE_METHOD_REF = 11;
    public static final int CONSTANT_NAME_AND_TYPE = 12;
    public static final int CONSTANT_METHOD_HANDLE = 15;
    public static final int CONSTANT_METHOD_TYPE = 16;
    public static final int CONSTANT_INVOKE_DYNAMIC = 18;
    private ArrayList<AbstractConstantPoolInfo> abstractConstantPoolInfoList = new ArrayList<>();

    ConstantPool(DataInput dataInput) throws IOException {
        // constant pool array count
        int count = dataInput.readUnsignedShort();
        if (count >0) {
            for (int i = 1; i < count; ++i) {
                // subtype index
                byte tag = dataInput.readByte();
                switch (tag) {
                    case ConstantPool.CONSTANT_UTF8:
                        abstractConstantPoolInfoList.add(new ConstantUtf8Info(tag, dataInput.readUTF()));
                        break;
                    case ConstantPool.CONSTANT_INTEGER:
                        abstractConstantPoolInfoList.add(new ConstantIntegerInfo(tag, dataInput.readInt()));
                        break;
                    case ConstantPool.CONSTANT_FLOAT:
                        abstractConstantPoolInfoList.add(new ConstantFloatInfo(tag, dataInput.readFloat()));
                        break;
                    case ConstantPool.CONSTANT_LONG:
                        abstractConstantPoolInfoList.add(new ConstantLongInfo(tag,dataInput.readLong()));
                        break;
                    case ConstantPool.CONSTANT_DOUBLE:
                        abstractConstantPoolInfoList.add(new ConstantDoubleInfo(tag,dataInput.readDouble()));
                        break;
                    case ConstantPool.CONSTANT_CLASS:
                        abstractConstantPoolInfoList.add(new ConstantClassInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_STRING:
                        abstractConstantPoolInfoList.add(new ConstantStringInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_FIELD_REF:
                        abstractConstantPoolInfoList.add(new ConstantFieldRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_METHOD_REF:
                        abstractConstantPoolInfoList.add(new ConstantMethodRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_INTERFACE_METHOD_REF:
                        abstractConstantPoolInfoList.add(new ConstantInterfaceMethodRefInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_NAME_AND_TYPE:
                        abstractConstantPoolInfoList.add(new ConstantNameAndTypeInfo(tag,dataInput.readUnsignedShort(),
                                dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_METHOD_HANDLE:
                        abstractConstantPoolInfoList.add(new ConstantMethodHandleInfo(tag,dataInput.readByte()
                                ,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_METHOD_TYPE:
                        abstractConstantPoolInfoList.add(new ConstantMethodTypeInfo(tag,dataInput.readUnsignedShort()));
                        break;
                    case ConstantPool.CONSTANT_INVOKE_DYNAMIC:
                        abstractConstantPoolInfoList.add(new ConstantInvokeDynamicInfo(tag,dataInput.readUnsignedShort()
                                ,dataInput.readUnsignedShort()));
                        break;
                    default:
                        throw new ConstantPoolException(
                                "Invalid constant pool tag, this kind tag{"+ tag +"} is not supported currently!");


                }
            }
        }
    }

    public AbstractConstantPoolInfo get(int i) {
        return abstractConstantPoolInfoList.get(i);
    }

    public ConstantUtf8Info getutf8Info(int i){
        AbstractConstantPoolInfo abstractConstantPoolInfo = abstractConstantPoolInfoList.get(i);
        if(abstractConstantPoolInfo.getTag() == CONSTANT_UTF8){
            return (ConstantUtf8Info) abstractConstantPoolInfo;
        }else {
            throw new ConstantPoolException("unexpected constant at #" + i + " -- expected tag 1, found "+ abstractConstantPoolInfo.getTag());
        }
    }

    public int size() {
        return abstractConstantPoolInfoList.size();
    }
}
