package com.shanchuan.java1;

/**
 * @Description:
 * 1.注解？
 *      从 JDK 5.0 开始, Java 增加了对元数据(MetaData) 的支持, 也就是Annotation(注解)
 *      Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取,
 *      并执行相应的处理。通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下,
 *      在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息
 *      进行验证或者进行部署。
 *      Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明,
 *      这些信息被保存在 Annotation的 “name=value” 对中。
 * 2.使用实例
 *      示例一：生成文档相关的注解
 *      示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *          @Override: 限定重写父类方法, 该注解只能用于方法
 *          @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
 *          所修饰的结构危险或存在更好的选择
 *          @SuppressWarnings: 抑制编译器警告
 *      示例三：跟踪代码依赖性，实现替代配置文件功能
 * 3.自定义注解
 * 4.元注解
 *      JDK 的元 Annotation 用于修饰其他 Annotation 定义
 *      JDK5.0提供了4个标准的meta-annotation类型，分别是：
 *          Retention：
 *              @Retention: 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 的生命周期,
 *              @Rentention 包含一个 RetentionPolicy 类型的成员变量, 使用@Rentention 时必须为该 value 成员变量指定值:
 *                  RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），
 *                  编译器直接丢弃这种策略的注释
 *                  RetentionPolicy.CLASS:在class文件中有效（即class保留） ，
 *                  当运行 Java 程序时, JVM不会保留注解。 这是默认值
 *                  RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），
 *                  当运行 Java 程序时, JVM 会保留注释。程序可以通过反射获取该注释。
 *          Target
 *              用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
 *              @Target 也包含一个名为 value 的成员变量。
 *          Documented
 *              用于指定被该元 Annotation 修饰的 Annotation 类将被
 *              javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 *          Inherited
 *               被它修饰的 Annotation 将具有继承性。如果某个类使用了被
 *              @Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 *
 * 5.通过反射获取新注解
 *
 * 6.JDK8中注解的新特性
 *      可重复的注解
 *      可用于类型的注解
 *           ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *           ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 * @Author: ShanChuan
 * @Data: 16:512020/7/21
 */
public class AnnotationTest {
}

/*
 定义新的 Annotation 类型使用 @interface 关键字
 自定义注解自动继承了java.lang.annotation.Annotation接口
 Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其
方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能
是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、
以上所有类型的数组。
 可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始
值可使用 default 关键字
 如果只有一个参数成员，建议使用参数名为value
 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认
值。格式是“参数名 = 参数值”
，如果只有一个参数成员，且名称为value，
可以省略“value=”
 没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数
据 Annotation
注意：自定义注解必须配上注解的信息处理流程才有意义。
 */
@interface MyAnnotation{
    String value();
}