package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FleaMarketStationTest {

    @Autowired
    FleaMarketStation station;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(new Item("item1", 10.2), new Item("item1 small", 5.3)), "item1"),
                Arguments.of(List.of(new Item("item2", 3.0)), "item2"),
                Arguments.of(List.of(), " "));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Item> expected, String name) {
        List<Item> result = station.findBy(name);

        assertEquals(expected, result);
    }

}