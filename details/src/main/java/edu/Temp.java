package edu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Temp {

    public static void main(String... args) {
        Iterable<Person> firsts = getFirstCollection();
        Iterable<Person> second = getSecondCollection();
        System.out.println(vergleich(firsts,second));
    }

    static boolean vergleich(Iterable<Person> first, Iterable<Person> second) {

//
        return true;
    }

    public static Iterable<Person> getFirstCollection() {

        Set<Person> ships = new HashSet<>();
        Person p1 = new Person("Ship1");
        Person p2 = new Person("Ship2");
        Person p3 = new Person("Ship3");
        Person p4 = new Person("Ship4");
        Person p5 = new Person("Ship5");
        ships.add(p1);
        ships.add(p2);
        ships.add(p3);
        ships.add(p4);
        ships.add(p5);

        return ships;
    }

    public static Iterable<Person> getSecondCollection() {
        Set<Person> ships = new HashSet<>();
        Person p1 = new Person("Ship1");
        Person p2 = new Person("Ship2");
        Person p3 = new Person("Ship3");
        Person p4 = new Person("Ship4");
        Person p5 = new Person("Ship5");
        ships.add(p1);
        ships.add(p2);
        ships.add(p3);
        ships.add(p4);
        ships.add(p5);

        return ships;
    }

    private static void printIterable(Iterable l) {
        System.out.println("CurrentIterable:  " + l.getClass());
        Iterator<Integer> i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
