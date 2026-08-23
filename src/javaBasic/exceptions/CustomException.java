package javaBasic.exceptions;

import java.util.Scanner;

public class CustomException {

    public static void main(String[] args) {

        System.out.println("Learn throw");
        System.out.println("!!! Learn throw & Custom Exception !!!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        try {// surround with try/catch as I am throwing an Exception which is to be caught here only & does not want to throw it further
            if (age > 100) {
//                throw new MyException("Age can not be more than 100");// MyException with message
                // or you can throw any Exception here
                throw new ArithmeticException("Age should be less than 100");// ArithmeticException with message
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Your age is: " + age);
    }
}

class MyException extends Exception {

    // create parameterised(message) constructor to print message
    public MyException(String message) {
        super(message);// super(parent's) constructor is called to save exception message // else in catch block: e.getMessage() will give null
    }

}
