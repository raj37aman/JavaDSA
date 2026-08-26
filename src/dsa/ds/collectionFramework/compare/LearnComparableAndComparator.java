package dsa.ds.collectionFramework.compare;

import java.util.*;

public class LearnComparableAndComparator {

    public static void main(String[] args) {

        System.out.println("!!! Learn Comparable & Comparator !!!");

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


        /*------------*/
        /* Comparable */
        /*------------*/

        // using Comparable in a class to sort it.
        // Animal implements Comparable<Animal> to use Collections.sort();
//        Collections.sort(dogs);

        System.out.println("dogs1: " + dogs);


        /*------------*/
        /* Comparator */
        /*------------*/

        /* using Custom Comparator Class */
        /*-------------------------------*/

        // & the class you want to compare remains unchanged - means [Animal implements Comparable<Animal>] is not needed to use Collections.sort();
        Collections.sort(dogs, new CustomComparator());

        // OR can also be written as:
        dogs.sort(new CustomComparator());

        System.out.println("dogs2: " + dogs);


        /* using Comparator but with anonymous class */
        /*-------------------------------------------*/

        dogs.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1.weight == o2.weight) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.weight - o2.weight;
            }
        });

        System.out.println("dogs3: " + dogs);


        /* using Comparator but with lambda expression */
        /*---------------------------------------------*/

        dogs.sort((o1, o2) -> o1.age - o2.age);// compare age

        // OR can also be written as:
        dogs.sort(Comparator.comparing(Animal::getAge));// compare age (this needed getters)

        // OR (if multiple logic)
        dogs.sort((o1, o2) -> {// compare first age & if age is same then by name
            if (o1.age == o2.age) {
                return o1.name.compareTo(o2.name);
            }
            return o1.age - o2.age;
        });

        // OR can also be written as:
        dogs.sort(Comparator.comparing(Animal::getAge).thenComparing(Animal::getName).thenComparing(Animal::getWeight));// compare age , then name & then weight (this needed getters)

        System.out.println("dogs4: " + dogs);



        /* Sorting 2D array on the basis of 1st element */
        /*----------------------------------------------*/

        int[][] arr = {{4, 5, 2}, {3, 1, 2}, {1, 4, 2}};

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] - arr2[0]);

        for (int[] ar : arr) {
            for (int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}

class CustomComparator implements Comparator<Animal> {
    /*
     * Functional Interface which let you use it's method compare() to implement comparison logic
     * As it is Functional Interface(which means it has ONLY one method)
        so you can implement it through lambda expression instead of making a class to implement its ONLY method compare()
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