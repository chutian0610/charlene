package charlene.core.javaclass.constant;

/**
 * abstract constant pool item.
 * <pre>
 * cp_info {
 *     u1 tag;
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
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
