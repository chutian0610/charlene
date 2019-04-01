package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:29
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description utf-8 编码的字符串
 * CONSTANT_Utf8_info {
 *     u1 tag;
 *     u2 length;  utf8编码的字符串占用的字节数
 *     u1 bytes[length];  长度为length的 utf8 编码的字符串
 * }
 */

public class ConstantUtf8Info extends ConstantPoolInfo {
    private final String value;

    public ConstantUtf8Info(byte tag, String value) {
        super(tag);
        this.value = value;
    }

    public String getUtf8() {
        return value;
    }

    @Override
    public String toString() {
        return "ConstantUtf8Info{" +
                "value='" + value + '\'' +
                "} " + super.toString();
    }
}
