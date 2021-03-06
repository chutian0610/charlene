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
 * @since 2020-01-25
 */

public abstract class AbstractConstantPoolInfo {

    private final byte tag;

    public AbstractConstantPoolInfo(byte tag) {
        this.tag = tag;
    }

    public byte getTag() {
        return tag;
    }
}
