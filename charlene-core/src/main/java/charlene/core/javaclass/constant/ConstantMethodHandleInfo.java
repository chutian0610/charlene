package charlene.core.javaclass.constant;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-28-10:00
 * @Project charlene
 * @Package charlene.javaclass.constant
 * @Version 1.0
 * @Description 方法句柄
 * CONSTANT_MethodHandle_info {
 *     u1 tag;
 *     u1 reference_kind;   1-9,决定了方法句柄的类型
 *     u2 reference_index;  对常量池的有效索引
 * }
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
