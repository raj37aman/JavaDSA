package dsa.ds.collectionFramework.collections.queue;

import java.util.ArrayDeque;

public class LearnDeque {

    public static void main(String[] args) {

        System.out.println("!!! Learn Deque !!!");

        /*
        * Doubly Ended Queue
        * Recommended to implement Stack by Deque (as Stack class implements Vector which makes it slow due to synchronization)
            Stack methods can also be used in Deque like:
            push() / pop() / peek() - FIRST
            [All these operates from first, unlike Stack (All three perform at last)]
        * Also Queue methods can be implemented:
            offer() - LAST
            poll() / peek() - FIRST
        * But but but... As peek() is there in both Stack & Queue. So Deque implements peek() method of Queue.
        * Summary:
            push() - [][][][][][][] - offer() / add()
            peek() / poll() / pop() - [][][][][][][] -
        */

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.offer(1);// add element at last (like normal queue)
        deque.offer(2);
        deque.offer(3);
        deque.offerFirst(4);// add element at first
        deque.offerLast(5);// add element at last

        deque.push(9);// add element at first [unlike push() of Stack]

        deque.add(6);// add element at last
        deque.addFirst(7);
        deque.addLast(8);

        System.out.println("deque: " + deque);


        System.out.println("deque.peek(): " + deque.peek());// return element from first [like peek() of Queue, unlike of Stack] // return null if deque is empty
        System.out.println("deque.peekFirst(): " + deque.peekFirst());// return element from first // return null if deque is empty
        System.out.println("deque.peekLast(): " + deque.peekLast());// return element from last // return null if deque is empty

        System.out.println("deque.getFirst(): " + deque.getFirst());// return element from first (SequencedCollection method) // throw NoSuchElementException if deque is empty
        System.out.println("deque.getLast(): " + deque.getLast());// return element from last (SequencedCollection method) // throw NoSuchElementException if deque is empty


        System.out.println("deque.poll(): " + deque.poll());// remove & return element from first // return null if deque is empty
        System.out.println("deque.pollFirst(): " + deque.pollFirst());// remove & return element from first // return null if deque is empty
        System.out.println("deque.pollLast(): " + deque.pollLast());// remove & return element from last // return null if deque is empty

        System.out.println("deque.pop(): " + deque.pop());// remove & return element from first [unlike pop() of Stack] // throw NoSuchElementException if deque is empty
    }
}
