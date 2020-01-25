package charlene.core.javaclass;

import java.io.DataInput;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * use bit map for option combine.
 *
 * <table border="1">
 *     <caption>class</caption>
 *     <tr>
 *         <th>Flag Name</th><th>Value</th><th>Interpretation</th>
 *     </tr>
 *     <tr>
 *         <td>ACC_PUBLIC</td><td>0x0001</td><td>Declared public; may be accessed from outside its package.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_FINAL</td><td>0x0010</td><td>Declared final; no subclasses allowed.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_SUPER</td><td>0x0020</td><td>Treat superclass methods specially when invoked by the invokespecial instruction.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_INTERFACE</td><td>0x0200</td><td>Is an interface, not a class.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_ABSTRACT</td><td>0x0400</td><td>Declared abstract; must not be instantiated.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_SYNTHETIC</td><td>0x1000</td><td>Declared synthetic; not present in the source code.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_ANNOTATION</td><td>0x2000</td><td>Declared as an annotation type.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_ENUM</td><td>0x4000</td><td>Declared as an enum type.</td>
 *     </tr>
 * </table>
 *
 * <table border="1">
 *     <caption>field</caption>
 *     <tr>
 *         <th>Flag Name</th><th>Value</th><th>Interpretation</th>
 *     </tr>
 *     <tr>
 *         <td>ACC_PUBLIC</td><td>0x0001</td><td>Declared public; may be accessed from outside its package.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_PRIVATE</td><td>0x0002</td><td>Declared private; usable only within the defining class.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_PROTECTED</td><td>0x0004</td><td>Declared protected; may be accessed within subclasses.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_STATIC</td><td>0x0008</td><td>Declared static.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_FINAL</td><td>0x0010</td><td>Declared final; never directly assigned to after object construction (JLS §17.5).</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_VOLATILE</td><td>0x0040</td><td>Declared volatile; cannot be cached.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_TRANSIENT</td><td>0x0080</td><td>Declared transient; not written or read by a persistent object manager.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_SYNTHETIC</td><td>0x1000</td><td>Declared synthetic; not present in the source code.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_ENUM</td><td>0x4000</td><td>Declared as an element of an enum.</td>
 *     </tr>
 * </table>
 *
 * <table border="1">
 *     <caption>method</caption>
 *     <tr>
 *         <th>Flag Name</th><th>Value</th><th>Interpretation</th>
 *     </tr>
 *     <tr>
 *         <td>ACC_PUBLIC</td><td>0x0001</td><td>Declared public; may be accessed from outside its package.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_PRIVATE</td><td>0x0002</td><td>Declared private; accessible only within the defining class.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_PROTECTED</td><td>0x0004</td><td>Declared protected; may be accessed within subclasses.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_STATIC</td><td>0x0008</td><td>Declared static.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_FINAL</td><td>0x0010</td><td>Declared final; must not be overridden (§5.4.5).</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_SYNCHRONIZED</td><td>0x0020</td><td>Declared synchronized; invocation is wrapped by a monitor use.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_BRIDGE</td><td>0x0040</td><td>A bridge method, generated by the compiler.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_VARARGS</td><td>0x0080</td><td>Declared with variable number of arguments.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_NATIVE</td><td>0x0100</td><td>Declared native; implemented in a language other than Java.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_ABSTRACT</td><td>0x0400</td><td>Declared abstract; no implementation is provided.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_STRICT</td><td>0x0800</td><td>Declared strictfp; floating-point mode is FP-strict.</td>
 *     </tr>
 *     <tr>
 *         <td>ACC_SYNTHETIC</td><td>0x1000</td><td>Declared synthetic; not present in the source code.</td>
 *     </tr>
 * </table>
 *
 * <pre>
 * note:
 * ACC_SYNTHETIC 由编译器自动生成
 * ACC_MANDATED  表示在源代码中隐式声明形式参数
 * </pre>
 *
 * @author chutian
 * @victor.email victorchu0610@outlook.com
 * @version 1.0
 * @victor.date 2020-01-25
 */

public class AccessFlags {
    public static final int ACC_PUBLIC = 1;
    public static final int ACC_PRIVATE = 2;
    public static final int ACC_PROTECTED = 4;
    public static final int ACC_STATIC = 8;
    public static final int ACC_FINAL = 16;
    public static final int ACC_SUPER = 32;
    public static final int ACC_SYNCHRONIZED = 32;
    public static final int ACC_VOLATILE = 64;
    public static final int ACC_BRIDGE = 64;
    public static final int ACC_TRANSIENT = 128;
    public static final int ACC_VARARGS = 128;
    public static final int ACC_NATIVE = 256;
    public static final int ACC_INTERFACE = 512;
    public static final int ACC_ABSTRACT = 1024;
    public static final int ACC_STRICT = 2048;
    public static final int ACC_SYNTHETIC = 4096;
    public static final int ACC_ANNOTATION = 8192;
    public static final int ACC_ENUM = 16384;
    public static final int ACC_MANDATED = 32768;

    private static final int[] classModifiers =
            new int[]{ACC_PUBLIC, ACC_FINAL, ACC_ABSTRACT};
    private static final int[] classFlags =
            new int[]{ACC_PUBLIC, ACC_FINAL, ACC_SUPER, ACC_INTERFACE, ACC_ABSTRACT, ACC_SYNTHETIC
                    , ACC_ANNOTATION, ACC_ENUM};
    private static final int[] innerClassModifiers =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_ABSTRACT};
    private static final int[] innerClassFlags =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_SUPER, ACC_INTERFACE
                    , ACC_ABSTRACT, ACC_SYNTHETIC, ACC_ANNOTATION, ACC_ENUM};
    private static final int[] fieldModifiers =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_VOLATILE, ACC_VARARGS};
    private static final int[] fieldFlags =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_VOLATILE, ACC_TRANSIENT,
                    ACC_SYNTHETIC, ACC_ENUM};
    private static final int[] methodModifiers =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_SYNCHRONIZED, ACC_NATIVE
                    , ACC_ABSTRACT, ACC_STRICT};
    private static final int[] methodFlags =
            new int[]{ACC_PUBLIC, ACC_PRIVATE, ACC_PROTECTED, ACC_STATIC, ACC_FINAL, ACC_SYNCHRONIZED, ACC_BRIDGE
                    , ACC_VARARGS, ACC_NATIVE, ACC_ABSTRACT, ACC_STRICT, ACC_SYNTHETIC};

    public final int flags;

    public AccessFlags(DataInput dataInput) throws IOException {
        flags = dataInput.readUnsignedShort();
    }

    private static Set<String> getModifiers(int target, int[] allFlags, AccessFlags.Kind kind) {
        Set<String> set = new LinkedHashSet<String>();

        for(int i = 0; i < allFlags.length; ++i) {
            int flag = allFlags[i];
            if ((target & flag) != 0) {
                set.add(flagToModifier(flag, kind));
            }
        }

        return set;
    }

    private Set<String> getFlags(int[] allFlags, AccessFlags.Kind kind) {
        Set<String> set = new LinkedHashSet<>();
        int tmp = flags;
        for(int i = 0; i < allFlags.length; ++i) {
            int flag = allFlags[i];
            if ((tmp & flag) != 0) {
                set.add(flagToName(flag, kind));
                tmp &= ~flag;
            }
        }

        // these flags are not consumed
        while(tmp != 0) {
            int high = Integer.highestOneBit(tmp);
            set.add("0x" + Integer.toHexString(high));
            tmp &= ~high;
        }

        return set;
    }


    private static String flagToModifier(int flag, AccessFlags.Kind kind) {
        switch(flag) {
            case 1:
                return "public";
            case 2:
                return "private";
            case 4:
                return "protected";
            case 8:
                return "static";
            case 16:
                return "final";
            case 32:
                return "synchronized";
            case 64:
                return "volatile";
            case 128:
                return kind == AccessFlags.Kind.Field ? "transient" : null;
            case 256:
                return "native";
            case 1024:
                return "abstract";
            case 2048:
                return "strictfp";
            case 32768:
                return "manvictor.dated";
            default:
                return null;
        }
    }


    private static String flagToName(int flag, AccessFlags.Kind kind) {
        switch(flag) {
            case 1:
                return "ACC_PUBLIC";
            case 2:
                return "ACC_PRIVATE";
            case 4:
                return "ACC_PROTECTED";
            case 8:
                return "ACC_STATIC";
            case 16:
                return "ACC_FINAL";
            case 32:
                return kind == AccessFlags.Kind.Class ? "ACC_SUPER" : "ACC_SYNCHRONIZED";
            case 64:
                return kind == AccessFlags.Kind.Field ? "ACC_VOLATILE" : "ACC_BRIDGE";
            case 128:
                return kind == AccessFlags.Kind.Field ? "ACC_TRANSIENT" : "ACC_VARARGS";
            case 256:
                return "ACC_NATIVE";
            case 512:
                return "ACC_INTERFACE";
            case 1024:
                return "ACC_ABSTRACT";
            case 2048:
                return "ACC_STRICT";
            case 4096:
                return "ACC_SYNTHETIC";
            case 8192:
                return "ACC_ANNOTATION";
            case 16384:
                return "ACC_ENUM";
            case 32768:
                return "ACC_MANDATED";
            default:
                return null;
        }
    }

    public static enum Kind {
        Class,
        InnerClass,
        Field,
        Method;
    }

}
