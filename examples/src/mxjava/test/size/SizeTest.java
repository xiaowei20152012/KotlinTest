package mxjava.test.size;

/*
//计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
//        System.out.println("humanSizeOf:" + RamUsageEstimator.humanSizeOf(list));
//计算指定对象本身在堆空间的大小，单位字节
//        System.out.println("shallowSizeOf:" + RamUsageEstimator.shallowSizeOf(list));
//计算指定对象及其引用树上的所有对象的综合大小，单位字节
//        System.out.println("sizeOf:" + RamUsageEstimator.sizeOf(list));
 */


import com.carrotsearch.sizeof.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

public class SizeTest {

    public static void main(String[] args) {
        int c = 1;
        Long a = 10l;

        System.out.println("sizeOf:" + RamUsageEstimator.sizeOf(a));

        byte b = 4;
        Byte bWrapper = Byte.valueOf(b);
        Hello hello = new Hello();

        System.out.println("byte sizeOf:" + RamUsageEstimator.sizeOf(b));
        System.out.println("int sizeOf:" + RamUsageEstimator.sizeOf(c));
        System.out.println("Byte sizeOf:" + RamUsageEstimator.sizeOf(bWrapper));
        System.out.println("Object sizeOf:" + RamUsageEstimator.sizeOf(hello));
        System.out.println("Object sizeOf:" + RamUsageEstimator.shallowSizeOf(hello));


//        System.out.println("Integer size of : " + Integer.BYTES);
//        System.out.println("Long size of : " + Long.BYTES);
//        System.out.println("Byte size of : " + Byte.BYTES);
//        System.out.println("double size of : " + Double.BYTES);
//        System.out.println("float size of : " + Float.BYTES);
//        System.out.println("char size of : " + Character.BYTES);
//        System.out.println("Short size of : " + Short.BYTES);


        ClassLayout classLayout = ClassLayout.parseInstance(hello);
        System.out.println(classLayout.toPrintable());


        classLayout = ClassLayout.parseInstance(bWrapper);
        System.out.println(classLayout.toPrintable());

    }


    public static class  Hello {
        
    }




}
