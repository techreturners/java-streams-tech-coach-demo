package org.techreturners.streams.examples;

import org.techreturners.streams.data_models.Person;
import org.techreturners.streams.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ImperativeVsDeclarativeApproach {

    public static void main(String[] args) throws Exception {

        imperativeApproach();

        declarativeApproachUsingStreams();
    }

    // We would like our algorithm to:
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    public static void imperativeApproach() throws IOException {

        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = new ArrayList<>();
        int limit = 10;
        int count = 0;
        for (Person person : people) {
            if (person.age() <= 18) {
                youngPeople.add(person);
                count++;
                if (count == limit) {
                    break;
                }
            }
        }
        youngPeople.forEach(System.out::println);
    }

    public static void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();

        List<Person> filteredList = people.stream()
                .filter(s -> s.age() <= 18)
                .limit(10)
                .toList();
        filteredList.forEach(System.out::println);
    }

    private static Predicate<Person> getPerson18OrUnder = s -> s.age() <= 18;

}
