package org.fenixsoft.jvm.chapter7;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization_1 {

    /**
     * sout:
     * SuperClass init!
     * 123
     *
     * 原因：
     * 对于静态字段，只有直接定义该字段的类才会被初始化，
     * 因此通过其子类来引用父类中定义的静态字段，
     * 只会触发父类的初始化，而不会触发子类的初始化
     * */
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}
