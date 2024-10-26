package org.example;

import comporators.PersonAgeComporator;
import comporators.PersonNameComporator;
import entities.Person;
import interfaces.IList;
import lib.CustomArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IList persons = new CustomArrayList<Person>(10);
        persons.add(new Person("Ivan",64));
        persons.add(new Person("Olga",38));
        persons.add(new Person("Olga",21));
        persons.add(new Person("Elena",39));
        persons.add(new Person("Anna",35));
        persons.add(new Person("Victor",78));
        persons.add(new Person("Ivan",18));
        persons.add(new Person("Victor",20));
        persons.add(new Person("Olga",21));


//        var temp = persons.remove(1);
//        for(var t: persons) System.out.println(t);

//        var temp = persons.remove(new Person("Olga",21));
//        for(var t: persons) System.out.println(t);

//        persons.add(3, new Person("Elena",21));
//        System.out.println(persons.get(3));
//        for(var t: persons) System.out.println(t);

//        List list = new ArrayList<Person>(3);
//        list.add(new Person("Elena",39));
//        list.add(new Person("Anna",35));
//        list.add(new Person("Victor",78));
//        persons.addAll(list);
//        for(var t: persons) System.out.println(t);

//        Comparator<Person> comporator = new PersonNameComporator().thenComparing(new PersonAgeComporator());
//        persons.sort(comporator);
//        for(var t: persons) System.out.println(t);

//        persons.clear();
//        System.out.println(persons.isEmpty());



    }
}