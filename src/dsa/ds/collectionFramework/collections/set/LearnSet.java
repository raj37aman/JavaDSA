package dsa.ds.collectionFramework.collections.set;

import java.util.*;

public class LearnSet {

    public static void main(String[] args) {

        System.out.println("!!! Learn Set !!!");

        /*
        * Set: Does not allow duplicates.
        * HashSet: stores elements in random order [All operation is O(1) as it uses hashing].
        * LinkedHashSet: stores elements in order in which you insert the elements [All operation is O(n)].
        * TreeSet: stores elements sorted in natural ascending order [All operation is O(log n)].
        */

        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(1);// will not sore as we already have 1
        set.add(6);
        set.add(4);
        set.add(2);
        set.add(7);
        set.add(5);
        set.add(3);

        System.out.println("set: " + set);
        System.out.println("set.size(): " + set.size());

        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(6);
        anotherSet.add(7);
        anotherSet.add(8);
        System.out.println("anotherSet: " + anotherSet);
        System.out.println("set.addAll(anotherSet): " + set.addAll(anotherSet));// return boolean as per if even 1 element is added (duplicates do not add) // return false if anotherSet is empty
        System.out.println("set: " + set);

        System.out.println("set.contains(3): " + set.contains(3));// return boolean if element is available in set or not (false if set is empty)
        System.out.println("set.isEmpty(): " + set.isEmpty());// return boolean if set is empty or not

        System.out.println("set: " + set.remove(22));// return boolean if item is present & removed (false if not present / set is empty)
        System.out.println("set: " + set);

        System.out.println("set.removeAll(anotherSet): " + set.removeAll(anotherSet));// return boolean as per if even 1 element is removed // false if any of the set is empty (removal will not happen)
        System.out.println("set: " + set);

        System.out.println("set.retainAll(anotherSet): " + set.retainAll(anotherSet));// return boolean as per if even 1 element is removed while retention (true - if anotherSet is empty - will remove all element from set & retain nothing)
        System.out.println("set: " + set);


        /*---------------------*/
        /* Set of Custom Class */
        /*---------------------*/

        System.out.println("!!! Learn Set of Custom Class !!!");

        Set<Student> sSet = new HashSet<>();

        sSet.add(new Student(1 ,"Aman"));
        sSet.add(new Student(1 ,"Aman"));// here duplicate will be allowed as the objects are different

        System.out.println("sSet: " + sSet);

        /*
        * But we do not want that - then we define on which basis the uniqueness should be decided in Student class
        * After implementing equals & hashCode methods to decide uniqueness in the class now we will see unique student(on rollNo) is only added in Set
        */

        Set<Student> studentSet = new HashSet<>();
        Student s1 = new Student(1 ,"Aman");
        Student s2 = new Student(1 ,"Raj");
        System.out.println(s1.equals(s2));// true - here student uniqueness is decided on rollNo (which is same here)

        studentSet.add(s1);
        studentSet.add(s2);// here duplicate will NOT be allowed as the objects are same basis of uniqueness defined (rollNo) - even if name / other fields are different
        System.out.println("studentSet: " + studentSet);


        /*---------*/
        /* EnumSet */
        /*---------*/

        EnumSet<Colours> coloursSet = EnumSet.allOf(Colours.class);
        System.out.println("coloursSet.toArray(): " + Arrays.toString(coloursSet.toArray()));
    }

    // make enum to prepare its Set
    enum Colours {
        // convention: all caps
        RED, BLACK, WHITE
    }
}

class Student {

    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // implement equals & hashCode methods to decide uniqueness in the class (Here deciding on the basis of rollNo only)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rollNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}
