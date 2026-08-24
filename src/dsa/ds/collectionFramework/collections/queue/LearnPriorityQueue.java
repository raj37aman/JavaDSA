package dsa.ds.collectionFramework.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {

    public static void main(String[] args) {

        System.out.println("!!! Learn Priority Queue !!!");

        /*
        * Operates on the basis of priority.
        * Default Integers priority is: lower > higher
        * Same String priority is: A > Z > a > z
        * Also can prioritize custom class by implementing comparable
        */

        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(20);// does not add in any order
        pq.add(40);
        pq.add(10);
        pq.add(30);

        System.out.println("pq: " + pq);
        System.out.println("pq.peek(): " + pq.peek());
        System.out.println("pq.poll(): " + pq.poll());
        System.out.println("pq: " + pq);
        System.out.println("pq.peek(): " + pq.peek());
        System.out.println("pq.poll(): " + pq.poll());

    }
}
