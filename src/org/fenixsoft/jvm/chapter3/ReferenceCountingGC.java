package org.fenixsoft.jvm.chapter3;

/**
 * testGC()方法执行后，objA和objB会不会被GC呢？
 *
 * @author zzm
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA和objB是否能被回收？
        /**
         * 答：如果垃圾回收判断方法是引用计数法的话，不会
         * 因为他们互相引用着对方，导致他们的引用计数器都不为0。
         * 于是，引用计数算法无法同之GC收集器回收他们
         * */
        System.gc();
    }
}
