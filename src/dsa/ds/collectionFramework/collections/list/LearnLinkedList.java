package dsa.ds.collectionFramework.collections.list;

import java.util.LinkedList;
import java.util.List;

public class LearnLinkedList {

    public static void main(String[] args) {

        System.out.println("!!! Learn Linked List !!!");

        /*
        * Implements List Interface.
        * In java - we have doubly LinkedList.
        * Element in LinkedList are not stored in sequence - they are stored randomly & connected through links (prev/next).
        */

        // Reference type: List
        // Actual object: LinkedList
        // You can use methods defined by the List interface.
        // But you cannot directly access LinkedList-specific methods.
        List<Integer> list = new LinkedList<>();

        // Reference type: LinkedList
        // Actual object: LinkedList
        // So you can use methods available specifically on LinkedList.
        // (You can also use all methods inherited from List, Deque, Queue, etc.)
        LinkedList<Integer> linkedList = new LinkedList<>();

    }
}
