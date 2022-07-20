package brussels.digitalcity.tu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParametrerizedTests {

    enum WeekDay {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    @ParameterizedTest
    @ValueSource(strings = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday"})
    void isPresentInEnum(String day) {
        assertNotNull(WeekDay.valueOf(day.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(WeekDay.class)
    void isOnePresent(WeekDay day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(names = {"MONDAY", "THURSDAY"})
    void isMondayAndThursdayPresent(WeekDay day){
        assertTrue(EnumSet.of(WeekDay.MONDAY, WeekDay.THURSDAY).contains(day));
    }

    @ParameterizedTest
    @MethodSource("Injecter")
    void isInjectedByMethod(String args) {
        assertTrue(args.endsWith("e"));
    }
    static Stream<String> Injecter() {
        return Stream.of("apple", "pear", "raspberry", "cherry");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/days.csv", delimiterString = " | ", numLinesToSkip = 1)
    void testWithFileInjection(String day, int index) {
        assertNotNull(day);
        assertNotEquals(-1, index);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/days.csv", delimiterString = " | ", numLinesToSkip = 1)
    void testWithFileInjectionWithObject(ArgumentsAccessor args) {
        Day day = new Day();
        day.setName(args.getString(0));
        day.setIndex(args.getInteger(1));
        assertNotNull(day.getName());
        assertNotEquals(-1, day.getIndex());
    }

    static class Day {
        private String name;
        private int index;

        public String getName() {
            return name;
        }

        public void setName(String value) {
            name = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int value) {
            index = value;
        }
    }
}
