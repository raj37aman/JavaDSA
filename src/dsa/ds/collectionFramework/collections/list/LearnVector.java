package dsa.ds.collectionFramework.collections.list;

import java.util.List;
import java.util.Vector;

public class LearnVector {

    public static void main(String[] args) {

        System.out.println("!!! Learn Vector !!!");

        /*
        * Implements List Interface.
        * Vector is a synchronised List: means if we perform any operation on Vector, Vector class automatically applies lock on it.
        * ConcurrentModificationException is generated if another thread try to access the Vector.
        * Continuous of lock operation on Vector make it less efficient.
        * ArrayList is usually preferred unless you specifically need Vector's synchronised behavior.
        */

        // Reference type: List
        // Actual object: Vector
        // You can only directly use methods guaranteed by the List interface.
        // This is generally preferred when you don't specifically need Vector-specific behavior.
        List<Integer> vectorList = new Vector<>();

        // Reference type: Vector
        // Actual object: Vector
        // You can use both List methods and Vector-specific methods.
        Vector<Integer> vector = new Vector<>();

    }
}
