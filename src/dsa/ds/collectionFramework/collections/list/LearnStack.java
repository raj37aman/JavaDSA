package dsa.ds.collectionFramework.collections.list;

import java.util.List;
import java.util.Stack;

public class LearnStack {

    public static void main(String[] args) {

        System.out.println("!!! Learn Stack !!!");

        /*
        * Stack operates as LIFO
        */

        // Reference type: List
        // Actual object: Stack
        // You can not use Stack-specific methods.
        List<Integer> stackList = new Stack<>();
//        stackList.push();// cannot use Stack Methods directly

        Stack<Integer> stack = new Stack<>();
        stack.push(1);// adds element at the last

        stack.add(2);// (List method) add element at last
        stack.add(1, 3);// (List method) add element at index specified
        stack.addElement(6);// (Vector method) add element at last
        stack.addFirst(4);// (SequencedCollection method) add element
        stack.addLast(5);// (SequencedCollection method) add element

//        stack.addLast(7);
//        stack.addLast(7);

        System.out.println("stack: " + stack);

        stack.pop();// remove & return element from last // throw EmptyStackException is stack is empty
        System.out.println("stack: " + stack);


        System.out.println(stack.peek());// return element from last

        stack.empty();// return boolean whether stack is empty or not
        stack.isEmpty();// (List method) return boolean whether stack is empty or not

    }
}
