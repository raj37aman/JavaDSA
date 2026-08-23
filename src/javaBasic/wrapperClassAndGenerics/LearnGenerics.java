package javaBasic.wrapperClassAndGenerics;

public class LearnGenerics {

    public static void main(String[] args) {

        System.out.println("!!! Learn Generics !!!");

        /*
        * Using Generics we can create class that work with different data types
        */


        Dog<String> dog1 = new Dog<>("1");
        Dog<Integer> dog2 = new Dog<>(2);// notice here Wrapper Class is used as Dog need an object & cannot be primitive

        System.out.println(dog1.getId());
        System.out.println(dog2.getId());

        printWhatever(200);
        printWhatever("OK");

        // Class having multiple generic type
        Cat<Integer, String> cat = new Cat<>(1, "Sam");

        /* Bounded Generic Types */
        // Generic type accepts any type of parameter, we can restrict it
        printOnlyNumber(200);
//        printOnlyNumber("OK");// will give error as it is restricted
        printOnlyNumber(200.00);
    }

    static <T> void printWhatever(T data) {// generic method (generic method can be made in any class, no need of generic class only)
        System.out.println(data);
    }

    static <T extends Number> void printOnlyNumber(T data) {// Generic type restricted to Number type
        System.out.println(data);
    }

}

class Dog<T> {// to define any class supporting generic type // T is generic type here (any letter can be used)

    T id;

    public Dog (T id) {
        this.id = id;
    }

    T getId() {
        return id;
    }
}

class Cat<A, B> {// to define any class supporting multiple generic type

    A id;
    B name;

    public Cat (A id, B name) {
        this.id = id;
        this.name = name;
    }
}
