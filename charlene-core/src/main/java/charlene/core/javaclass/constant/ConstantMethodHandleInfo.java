package charlene.core.javaclass.constant;

/**
 * 方法句柄.
 * <pre>
 * CONSTANT_MethodHandle_info {
 *     u1 tag;
 *     u1 reference_kind;   1-9,决定了方法句柄的类型
 *     u2 reference_index;  对常量池的有效索引
 * }
 * </pre>
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class ConstantMethodHandleInfo extends ConstantPoolInfo {
    private final byte referenceKind;
    private final int referenceIndex;
    public ConstantMethodHandleInfo(byte tag, byte referenceKind, int referenceIndex) {
        super(tag);
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    @Override
    public String toString() {
        return "ConstantMethodHandleInfo{" +
                "referenceKind=" + referenceKind +
                ", referenceIndex=" + referenceIndex +
                "} " + super.toString();
    }
}
