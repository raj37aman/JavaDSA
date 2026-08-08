package collectionFramework.compare;

public class Animal implements Comparable<Animal> {// Interface which let you use it's method compareTo() to implement comparison logic

    int age;
    String name;
    int weight;

    public Animal(int age, String name, int weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}' + "\n";
    }

    @Override
    public int compareTo(Animal o) {

//        return 0;

         /*
         * return +ve means current obj(this) > specified obj(parameter)
         * return -ve means current obj < specified obj
         * return 0 means current obj = specified obj
         */

//        return this.age - o.age;// logic for sorting by age

        // if age is same & you want to go on next logic for sorting (by name)
        if (this.age == o.age) {
            return this.name.compareTo(o.name);
        }
        return this.age - o.age;
    }
}
