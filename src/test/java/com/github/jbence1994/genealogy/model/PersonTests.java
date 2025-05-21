package com.github.jbence1994.genealogy.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTests {

    static Stream<Arguments> peopleParams() {
        return Stream.of(
                Arguments.of(
                        "Juhász Mihály",
                        new Person(UUID.randomUUID(), "Mihály", null, "Juhász", "Makó", LocalDate.of(1917, 9, 29), "Budapest", LocalDate.of(2004, 10, 4), null, null, null, null, null),
                        87
                ),
                Arguments.of(
                        "Marosi Irén",
                        new Person(UUID.randomUUID(), "Irén", null, "Marosi", "Makó", LocalDate.of(1936, 1, 1), "Makó", LocalDate.of(1998, 1, 1), null, null, null, null, null),
                        62
                ),
                Arguments.of(
                        "Juhász Bence Zsolt",
                        new Person(UUID.randomUUID(), "Bence", "Zsolt", "Juhász", "Makó", LocalDate.of(1994, 3, 27), null, null, null, null, null, null, null),
                        31
                )
        );
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("peopleParams")
    public void calculateAgeTest(
            String testCase,
            Person person,
            int expectedAge
    ) {
        var result = person.calculateAge();

        assertEquals(expectedAge, result);
    }
}
