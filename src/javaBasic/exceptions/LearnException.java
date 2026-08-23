package javaBasic.exceptions;

public class LearnException {

    public static void main(String[] args) {

        System.out.println("Learn Exception !!!");

        int[] a = new int[5];

        System.out.println("Hello");

        try {
            System.out.println(1/0);
            System.out.println(a[6]);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {// if you want to handle multiple exceptions in same way
            System.out.println("Exception handled!");
        } catch (NullPointerException e) {// handle another exception in another way if you want
            System.out.println("Exception handled in different way!");
        } catch (Exception e) {// handle any exceptions
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            System.out.println(e);
        } finally {// will execute no matter exception comes or not // multiple finally is not allowed
            System.out.println("Finally I will run.");
            // finally is good practice to do cleanups like closing a connection
            /*
            Some cases where finally block does not execute:
                1. Use System.exit() method (to terminate program).
                2. Exception in finally block.
                3. Death of any thread.
            */
        }


        /* throws */
//        int element = getArrayElement(a, 8);// this method can throw ArrayIndexOutOfBoundsException so we can surround with try/catch

        // so we catch the exception of method
        try {
            int element = getArrayElement(a, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int getArrayElement(int[] arr, int index) throws ArrayIndexOutOfBoundsException {// to throw exception of this method
        return arr[index];
    }

}
