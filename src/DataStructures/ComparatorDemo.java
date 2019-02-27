package DataStructures;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorDemo {


    public void demo(Person person){

        PriorityQueue<Person> pq  = new PriorityQueue<>(Comparator.comparing(Person :: getAge).
                thenComparing( Comparator.comparing( p -> p.name)));
    }

     class Person{
        String name;
        int age;
        int rank;
        Person(String name, int age, int rank){
            this.age = age;
            this.rank = rank;
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getRank() {
            return rank;
        }

    }
}
