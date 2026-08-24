package dsa.ds.collectionFramework.collections.list;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList {

    public static void main(String[] args) {

        System.out.println("!!! Learn List !!!");

        /*
        * Internal Working of ArrayList:
            - It creates resizable array.
            - Unlike Array(fixed size while declaration), ArrayList automatically changes its capacity as we add/remove element.
            - resizing logic:
        */

        List<Integer> list = new ArrayList<>();// List is the interface but to define an object we need a class which here is ArrayList

        // method of Collection interface to add element
        list.add(1);// adds element at the last
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addFirst(6);// SequencedCollection method to add element at first
        list.addLast(6);// SequencedCollection method to add element at last
        System.out.println("list: " + list);
        System.out.println("list.size(): " + list.size());// return size of list

        // method of List Interface
        list.add(5, 7);// add at particular index // throw IndexOutOfBoundsException if index given is out of bound
        System.out.println("list: " + list);

        // method of List Interface
        list.set(4, 8);// replace element at given index // throw IndexOutOfBoundsException if index given is out of bound
        System.out.println("list: " + list);


        // method of List Interface
        System.out.println(list.get(1));// return element at given index // throw ArrayIndexOutOfBoundsException when index not present in list
        System.out.println(list.getFirst());// return element from first // throw NoSuchElementException if list is empty
        System.out.println(list.getLast());// return element from last // throw NoSuchElementException if list is empty

        System.out.println(list.indexOf(17));// return index of first occurrence of the given element // return -1 if element not present or list is empty
        System.out.println(list.lastIndexOf(17));// return index of last occurrence of the given element // return -1 if element not present or list is empty


        // method of List Interface
        list.remove(1);// remove & return element from index=1 // throw ArrayIndexOutOfBoundsException when index not present in list
        System.out.println("list: " + list);

        // method of Collection Interface
        list.remove(Integer.valueOf(1));// remove value 1 // return boolean as per element is present or not
        System.out.println("list: " + list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println("list2: " + list2);
        list.removeAll(list2);// remove overlapping elements from list // return true if any element removed else return false
        System.out.println("list: " + list);

        System.out.println(list.contains(7));// return boolean if the element is present or not
        System.out.println(list.containsAll(list2));// return boolean if ALL the element is present or not

        list2.add(7);
        list2.add(8);
        System.out.println("list2: " + list2);

        list2.removeFirst();// remove first element // return boolean // throw NoSuchElementException if list is empty
        list2.removeLast();// remove last element // return boolean // throw NoSuchElementException if list is empty
        System.out.println("list2: " + list2);

        list.retainAll(list2);// remove all element except which are present in list2 // return true if any element removed else return false
        System.out.println("list: " + list);

        list2.clear();// remove all elements of array
        System.out.println("list2: " + list2);


        list2.add(11);
        list2.add(22);
        list2.add(33);
        list2.add(44);
        list2.add(55);
        list2.add(66);
        list2.add(77);

        // iteration
        for (Integer num: list2) {
            System.out.println(num);
        }

        System.out.println(list2.subList(2,4));// first index is inclusive, second is exclusive // throw ArrayIndexOutOfBoundsException when index not present in list
    }
}
