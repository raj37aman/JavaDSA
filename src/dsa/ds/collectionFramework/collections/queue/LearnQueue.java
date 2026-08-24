package dsa.ds.collectionFramework.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LearnQueue {

    public static void main(String[] args) {

        System.out.println("!!! Learn Queue !!!");

        /*
        * FIFO
            offer() - last
            peek() / poll() - first
            peek() / poll() - [][][][][][][] - offer()
        */

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);// add element from last // return boolean
        queue.offer(2);
        queue.offer(3);
        queue.add(4);// add element from last // return boolean

        System.out.println("queue: " + queue);

        System.out.println("queue.peek(): " + queue.peek());// return element from first // return null if queue is empty
        System.out.println("queue.element(): " + queue.element());// return element from first // throw NoSuchElementException if queue is empty
        System.out.println("queue: " + queue);

        System.out.println("queue.poll(): " + queue.poll());// remove & return element from first // return null if queue is empty
        System.out.println("queue: " + queue);
        System.out.println("queue.remove(): " + queue.remove());// remove & return element from first // throw NoSuchElementException if queue is empty
        System.out.println("queue: " + queue);


    }
}
