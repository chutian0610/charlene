# jvm class format - V8

ClassFile的结构如下: 

|Type|Name|Desc|
|:---|:---|:---|
|u4|magic|魔数|
|u2|minor_version|次版本号|
|u2|major_version|主版本号|
|u2|constant_pool_count|常量池容量(计数从1开始)|
|cp_info|constant_pool[constant_pool_count-1]|常量池|
|u2|access_flags|访问标志|
|u2|this_class|类索引|
|u2|super_class|父类索引|
|u2|interfaces_count|接口计数器|
|u2|interfaces[interfaces_count]|接口表|
|u2|fields_count|字段表计数|
|field_info|fields[fields_count]|字段表|
|u2|methods_count|方法表计数|
|method_info|methods[methods_count]|方法表|
|u2|attributes_count|属性表计数|
|attribute_info|attributes[attributes_count]|属性表|

* 类型u1,u2,u4,u8分别用来表示1个字节，2个字节，4个字节和8个字节的无符号数。
* 以`_info`结尾的类型，是class中用于描述复合结构数据的表

## class meta info 

### magic

每个class文件的前4个字节被称为魔数,类似协议头，用于验证该文件是否是能被虚拟机接受的class文件。java的magic是`0xCAFEBABE`。

### version

魔数后的4个字节存储了class 文件的版本号，前两个字节是次版本号，后两个字节是主版本号。

## constant pool

在版本号之后是常量池,常量池中存储着class文件中使用的常量。常量池的大小是不固定的,所以在常量池的前面放置一个u2类型的参数，代表常亮池的长度。但是要注意的是，常量池的索引是从1开始的。

常量池存储了两大类常量：字面量和符号引用。具体来说，常量池中存储了如下类型的数据,value是该类型的枚举值：

|Constant Type|tag|Desc|
|:---|:---|:---|
|CONSTANT_Class|7|类或接口符号引用|
|CONSTANT_Fieldref|9|字段符号引用|
|CONSTANT_Methodref|10|方法符号引用|
|CONSTANT_InterfaceMethodref|11|接口方法符号引用|
|CONSTANT_String|8|字符串类型引用|
|CONSTANT_Integer|3|整型字面量|
|CONSTANT_Float|4|浮点型字面量|
|CONSTANT_Long|5|长整型字面量|
|CONSTANT_Double|6|双精度类型字面量|
|CONSTANT_NameAndType|12|字段或方法的部分符号引用|
|CONSTANT_Utf8|1|字符串|
|CONSTANT_MethodHandle|15|方法句柄|
|CONSTANT_MethodType|16|方法类型|
|CONSTANT_InvokeDynamic|18|动态调用点|

这14种常量各有各自的数据结构,但是每种常量都以一个1字节的标签开头,用于区分。

```text
 constant pool info{
    u1 tag;  // 标志位，用于区分常量类型
    ... ...
 }
```

### CONSTANT Class

此类型的常量表示一个类或是接口的符号引用。

```text
 CONSTANT_Class_info {
    u1 tag;         // 是标志位，用于区分常量类型
    u2 name_index;  // 是一个索引值,指向了常量池中一个constant utf8 类型的常量。此常量代表类或接口的全名。
 }
```

### CONSTATNT Utf-8

```text
 CONSTANT_Utf8_info {
    u1 tag;            // 是标志位，用于区分常量类型
    u2 length;         // utf8编码的字符串占用的字节数
    u1 bytes[length];  // 长度为length的 utf8 编码的字符串
 }
```

### CONSTANT Integer

```text
 CONSTANT_Integer_info {
    u1 tag;    // 是标志位，用于区分常量类型
    u4 bytes;  // 高位在前的 int 值
 }
```

### CONSTANT Float

```text
 CONSTANT_Float_info {
    u1 tag;    // 是标志位，用于区分常量类型
    u4 bytes;  // 高位在前的 float
 }
```

### CONSTANT Long

```text
 CONSTANT_Long_info {
    u1 tag;   // 是标志位，用于区分常量类型
    u8 bytes; // 高位在前的 long
 }
```

### CONSTANT Double

```text
 CONSTANT_Double_info {
    u1 tag;   // 是标志位，用于区分常量类型
    u8 bytes; // 高位在前的 double
 }
```

### CONSTANT String

```text
 CONSTANT_String_info {
    u1 tag;           // 是标志位，用于区分常量类型
    u2 string_index;  // 字符串字面量的索引
 }
```

### CONSTANT Fieldref

```text
 CONSTANT_Fieldref_info {
    u1 tag;                 // 是标志位，用于区分常量类型
    u2 class_index;         // 指向声明字段的类或接口 CONSTANT_Class_info
    u2 name_and_type_index; // 指向字段描述符 CONSTANT_NameAndType_info的索引项
 }
```

### CONSTANT Methodref

```text
 CONSTANT_Methodref_info {
    u1 tag;                 // 是标志位，用于区分常量类型
    u2 class_index;         // 指向声明方法的类 CONSTANT_Class_info
    u2 name_and_type_index; // 指向字段描述符 CONSTANT_NameAndType_info的索引项
 }
```

### CONSTANT InterfaceMethodref

```text
 CONSTANT_InterfaceMethodref_info {
    u1 tag;                 // 是标志位，用于区分常量类型
    u2 class_index;         // 指向声明方法的接口 CONSTANT_Class_info
    u2 name_and_type_index; // 指向字段描述符 CONSTANT_NameAndType_info的索引项
 }
```

### CONSTANT NameAndType

```text
 CONSTANT_NameAndType_info {
    u1 tag;              // 是标志位，用于区分常量类型
    u2 name_index;       // 指向该字段或方法名称常量项
    u2 descriptor_index; // 指向该字段或方法描述符常量项
 }
```

### CONSTANT MethodHandle

```text
 CONSTANT_MethodHandle_info {
    u1 tag;              // 是标志位，用于区分常量类型
    u1 reference_kind;   // 1-9,决定了方法句柄的类型,决定了方法句柄的字节码行为
    u2 reference_index;  // 必须是对常量池的有效索引
 }
```

### CONSTANT MethodType

```text
 CONSTANT_MethodType_info {
    u1 tag;              // 是标志位，用于区分常量类型
    u2 descriptor_index; // 对常量池的有效索引，常量池在该索引处的项必须是 CONSTANT_Utf8_info,表示方法的描述符
 }
```

### CONSTANT InvokeDynamic

```text
 CONSTANT_InvokeDynamic_info {
    u1 tag;                         // 是标志位，用于区分常量类型
    u2 bootstrap_method_attr_index; // 值必须是对当前 class中引导方法表 bootstrap_method[] 数组的有效索引
    u2 name_and_type_index;         // 对常量池的有效索引，CONSTANT_NameAndType_info 类型,表示方法名和方法描述符
 }
```

## 访问标志



---

参考资料:

* [Java Virtual Machine Specification -
   Java SE 8 Edition](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)