package collectionframework.compare;

import java.util.*;

class CustomComparator implements Comparator<Animal> {
    /*
    * Functional Interface which let you use it's method compare() to implement comparison logic
    * As it is Functional Interface(which means it has ONLY one method) - so you can implement it through lambda expression instead of making a class to implement it's ONLY method compare()
    */

    @Override
    public int compare(Animal o1, Animal o2) {
        /*
         * return +ve means current obj(this) > specified obj(parameter)
         * return -ve means current obj < specified obj
         * return 0 means current obj = specified obj
         */
        return o1.weight - o2.weight;
    }
}

public class LearnComparableAndComparator {

    public static void main(String[] args) {

        Animal a3 = new Animal(3, "Box", 4);
        Animal a2 = new Animal(1, "Den", 6);
        Animal a1 = new Animal(4, "Leo", 7);
        Animal a4 = new Animal(2, "Don", 4);

        List<Animal> dogs = new ArrayList<>();
        dogs.add(a1);
        dogs.add(a2);
        dogs.add(a3);
        dogs.add(a4);

        System.out.println("dogs: " + dogs);

        // using Comparable in class to sort
        Collections.sort(dogs);

        System.out.println("dogs: " + dogs);

        // using Custom Comparator Class and the Animal class remains unchanged
        Collections.sort(dogs, new CustomComparator());

        System.out.println("dogs: " + dogs);

        // using Comparator but with anonymous class
        Collections.sort(dogs, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1.weight == o2.weight) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.weight - o2.weight;
            }
        });

        System.out.println("dogs: " + dogs);

        // using Comparator but with lambda expression
        Collections.sort(dogs, (o1, o2) -> o1.age - o2.age);
        // OR
        Collections.sort(dogs, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.name.compareTo(o2.name);
            }
            return o1.age - o2.age;
        });

        System.out.println("dogs: " + dogs);


        // Sorting 2D array on the basis of 1st element
        int arr[][] = {{4, 5, 2}, {3, 1, 2}, {1, 4, 2}};

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] - arr2[0]);

        for (int ar[] : arr) {
            for (int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
