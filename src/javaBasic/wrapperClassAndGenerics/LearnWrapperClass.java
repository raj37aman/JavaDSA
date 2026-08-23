package javaBasic.wrapperClassAndGenerics;

public class LearnWrapperClass {

    public static void main(String[] args) {

        System.out.println("!!! Learn Wrapper Class !!!");

        /*
        * Wrapper Class in java is class whose object wraps or contains primitive data types
        * When we create object of Wrapper Class - it contains a field we can store primitive data type
        * Need of Wrapper Class:
           1. Classes in java.util package handles only objects.
           2. Data structure in Collection Framework (ex: ArrayList/Vector) only store objects and not primitive types.
           3. To support synchronization, object is needed, primitive types does not support.
        * Autoboxing: primitive type - Wrapper Class & Unboxing: Wrapper Class - primitive type
        */

        Integer obj1 = Integer.valueOf(123);
        Integer obj2 = Integer.valueOf("123");

        Integer obj3 = 123;// autoboxing
        int age = obj2;// unboxing

        System.out.println(obj1 == obj2);// true
        System.out.println(obj1.equals(obj2));// true
        System.out.println(obj2 == obj3);// true
        System.out.println(obj2.equals(obj3));// true

        Boolean myBool1 = Boolean.valueOf(true);
        Boolean myBool2 = Boolean.TRUE;// same as above
        Boolean myBool3 = Boolean.valueOf("true");

    }
}
