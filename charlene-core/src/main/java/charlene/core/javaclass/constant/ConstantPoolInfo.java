package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-09:26
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description abstract constant pool item
 *
 * cp_info {
 *     u1 tag;
 * }
 */

public abstract class ConstantPoolInfo {

    private final byte tag;

    public ConstantPoolInfo(byte tag) {
        this.tag = tag;
    }

    public byte getTag() {
        return tag;
    }
}
