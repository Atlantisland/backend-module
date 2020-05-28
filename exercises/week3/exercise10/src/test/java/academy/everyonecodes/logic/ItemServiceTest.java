package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class ItemServiceTest {

    List<Item> items;
    ItemService itemService;

    @BeforeEach
    void setup() {
        items = new ArrayList<>();
        itemService = new ItemService(items);
    }

    @Test
    void add() {
        assertTrue(items.isEmpty());

        Item item = new Item("test", 0.0);
        itemService.add(item);
        assertFalse(items.isEmpty());
        assertEquals(1, items.size());

        Item addedItem = items.get(0);
        assertEquals(addedItem, item);
    }

    @Test
    void findAllWithEmptyList() {
        assertTrue(items.isEmpty());

        List<Item> result = itemService.findAll();

        assertTrue(result.isEmpty());
    }

    @Test
    void findAll() {
        assertTrue(items.isEmpty());

        Item item1 = new Item("test", 0.0);
        itemService.add(item1);

        List<Item> result = itemService.findAll();
        List<Item> expected = List.of(item1);
        assertEquals(expected, result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(), List.of(), "item not present"),
                of(List.of(), List.of(new Item("test", 0.0)), "item not present"),
                of(List.of(new Item("test", 0.0)), List.of(new Item("test", 0.0)), "test"),
                of(List.of(new Item("test", 0.0),
                        new Item("test", 1.0)),
                        List.of(new Item("test", 0.0),
                                new Item("test", 1.0)),
                        "test")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findByName(List<Item> expected, List<Item> presentItems, String itemName) {
        items.addAll(presentItems);

        List<Item> result = itemService.findByName(itemName);

        assertEquals(expected, result);
    }
}
