package academy.everyonecodes.restaurantTaxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class FoodstuffTaxerTest {
    @Autowired
    FoodstuffTaxer foodstuffTaxer;


    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("potato soup", 3.8)),
                Arguments.of(true, new RestaurantDish("caesar salad", 5.2)),
                Arguments.of(true, new RestaurantDish("tiramisu", 6.5)),
                Arguments.of(false, new RestaurantDish("fish", 10.5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = foodstuffTaxer.matches(input);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> parametersTax() {
        return Stream.of(
                Arguments.of(4.9, new RestaurantDish("potato soup", 3.8)),
                Arguments.of(6.5, new RestaurantDish("caesar salad", 5.4)),
                Arguments.of(7.6, new RestaurantDish("tiramisu", 6.5))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersTax")
    void tax(double expected, RestaurantDish input) {
        double result = foodstuffTaxer.tax(input);

        Assertions.assertEquals(expected, result);
    }
}

