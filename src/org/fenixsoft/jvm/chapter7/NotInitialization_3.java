package org.fenixsoft.jvm.chapter7;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization_3 {

    public static void main(String[] args) {
        /**
         * 没有初始化的原因：
         * 虽然引用了ConstClass类中的常量，但实际上通过在编译期的常量传播优化，
         * 已经将此常量的值“hello world”存储到了NotInitialization类的常量池中，以后NotInitialization
         * 对常量ConstClass.HELLOWORLD的引用实际都转化为NotInitialization类对自己的常量池的引用。
         * 也就是说，实际上NotInitialization的Class文件之中，并没有ConstClass类的符号引用入口，
         * 这两个类在编译成Class之后，就不存在任何联系了。
         * */
        System.out.println(ConstClass.HELLOWORLD);
    }
}
