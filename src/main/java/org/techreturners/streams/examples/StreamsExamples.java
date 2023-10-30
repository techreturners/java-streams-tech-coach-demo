package org.techreturners;

import org.techreturners.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExamples {

    public static void main(String[] args) throws IOException {


        List<Integer> integerList = Arrays.asList(2, 5, 6, 8, 15);

        integerList.stream().map(number -> number * 2).forEach(System.out::println);


        List<String> stringList = Arrays.asList("Simon", "Ellie", "Chris", "Alex", "Hannah");

        stringList.stream().map(String::toUpperCase).forEach(System.out::println);


        List<Integer> wordLength = stringList.stream().map(word -> word.length()).toList();

        System.out.println(wordLength);

        double sum = integerList.stream().mapToDouble(Integer::doubleValue).sum();

        System.out.println(sum);

        List<Car> cars = MockData.getCars();

        List<ClassicCarDTO> classicCars = cars.stream().filter(a -> a.year() < 1980).map(e -> new ClassicCarDTO(e.make(), e.year(), e.model())).toList();

        System.out.println(classicCars);

    }
}
