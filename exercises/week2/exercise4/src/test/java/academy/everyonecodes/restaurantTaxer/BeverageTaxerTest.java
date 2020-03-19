package academy.everyonecodes.restaurantTaxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class BeverageTaxerTest {
    @Autowired
    BeverageTaxer beverageTaxer;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("soda", 3.8)),
                Arguments.of(true, new RestaurantDish("orange juice", 5.2)),
                Arguments.of(true, new RestaurantDish("milkshake", 6.5)),
                Arguments.of(false, new RestaurantDish("wine", 10.5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = beverageTaxer.matches(input);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> parametersTax() {
        return Stream.of(
                Arguments.of(5.0, new RestaurantDish("soda", 3.8)),
                Arguments.of(6.5, new RestaurantDish("orange juice", 5.3)),
                Arguments.of(7.7, new RestaurantDish("milkshake", 6.5))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersTax")
    void tax(double expected, RestaurantDish input) {
        double result = beverageTaxer.tax(input);

        Assertions.assertEquals(expected, result);
    }
}