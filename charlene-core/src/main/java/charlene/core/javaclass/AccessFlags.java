package charlene.core.javaclass;

import java.io.DataInput;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author chutian
 * @Email victorchu0610@outlook.com
 * @Date 2019-03-30-13:10
 * @Project charlene
 * @Package charlene.javaclass
 * @Version 1.0
 * @Description  use bit map for option combine
 *
 * # class
 * Flag Name	  Value	Interpretation
 * ACC_PUBLIC	  0x0001	Declared public; may be accessed from outside its package.
 * ACC_FINAL	  0x0010	Declared final; no subclasses allowed.
 * ACC_SUPER	  0x0020	Treat superclass methods specially when invoked by the invokespecial instruction.
 * ACC_INTERFACE  0x0200	Is an interface, not a class.
 * ACC_ABSTRACT	0x0400	Declared abstract; must not be instantiated.
 * ACC_SYNTHETIC	0x1000	Declared synthetic; not present in the source code.
 * ACC_ANNOTATION	0x2000	Declared as an annotation type.
 * ACC_ENUM	0x4000	Declared as an enum type.
 *
 * # field
 * Flag Name	   Value	Interpretation
 * ACC_PUBLIC	   0x0001	Declared public; may be accessed from outside its package.
 * ACC_PRIVATE	   0x0002	Declared private; usable only within the defining class.
 * ACC_PROTECTED   0x0004	Declared protected; may be accessed within subclasses.
 * ACC_STATIC	   0x0008	Declared static.
 * ACC_FINAL	   0x0010	Declared final; never directly assigned to after object construction (JLS §17.5).
 * ACC_VOLATILE	   0x0040	Declared volatile; cannot be cached.
 * ACC_TRANSIENT   0x0080	Declared transient; not written or read by a persistent object manager.
 * ACC_SYNTHETIC   0x1000	Declared synthetic; not present in the source code.
 * ACC_ENUM	       0x4000	Declared as an element of an enum.
 *
 * # method
 * Flag Name	    Value	Interpretation
 * ACC_PUBLIC	    0x0001	Declared public; may be accessed from outside its package.
 * ACC_PRIVATE	    0x0002	Declared private; accessible only within the defining class.
 * ACC_PROTECTED	0x0004	Declared protected; may be accessed within subclasses.
 * ACC_STATIC	    0x0008	Declared static.
 * ACC_FINAL	    0x0010	Declared final; must not be overridden (§5.4.5).
 * ACC_SYNCHRONIZED	0x0020	Declared synchronized; invocation is wrapped by a monitor use.
 * ACC_BRIDGE	    0x0040	A bridge method, generated by the compiler.
 * ACC_VARARGS	    0x0080	Declared with variable number of arguments.
 * ACC_NATIVE	    0x0100	Declared native; implemented in a language other than Java.
 * ACC_ABSTRACT	    0x0400	Declared abstract; no implementation is provided.
 * ACC_STRICT	    0x0800	Declared strictfp; floating-point mode is FP-strict.
 * ACC_SYNTHETIC	0x1000	Declared synthetic; not present in the source code.
 *
 * note:
 *
 * ACC_SYNTHETIC 由编译器自动生成
 * ACC_MANDATED  表示在源代码中隐式声明形式参数
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


    private static String flagToModifier(int var0, AccessFlags.Kind var1) {
        switch(var0) {
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
                return var1 == AccessFlags.Kind.Field ? "transient" : null;
            case 256:
                return "native";
            case 1024:
                return "abstract";
            case 2048:
                return "strictfp";
            case 32768:
                return "mandated";
            default:
                return null;
        }
    }


    private static String flagToName(int var0, AccessFlags.Kind var1) {
        switch(var0) {
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
                return var1 == AccessFlags.Kind.Class ? "ACC_SUPER" : "ACC_SYNCHRONIZED";
            case 64:
                return var1 == AccessFlags.Kind.Field ? "ACC_VOLATILE" : "ACC_BRIDGE";
            case 128:
                return var1 == AccessFlags.Kind.Field ? "ACC_TRANSIENT" : "ACC_VARARGS";
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
