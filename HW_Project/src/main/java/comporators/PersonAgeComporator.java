package comporators;

import entities.Person;
import java.util.Comparator;


public class PersonAgeComporator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
