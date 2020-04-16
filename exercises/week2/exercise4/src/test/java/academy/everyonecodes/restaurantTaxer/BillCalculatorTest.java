package academy.everyonecodes.restaurantTaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BillCalculatorTest {

    @Autowired
    BillCalculator calculator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0.0, List.of()),
                Arguments.of(1.0, List.of(new RestaurantDish("test", 1.0))),
                Arguments.of(2.1, List.of(new RestaurantDish("tiramisu", 1.0))),
                Arguments.of(2.2, List.of(new RestaurantDish("milkshake", 1.0))),
                Arguments.of(4.300000000000001, List.of(
                        new RestaurantDish("tiramisu", 1.0),
                        new RestaurantDish("milkshake", 1.0))),
                Arguments.of(5.300000000000001, List.of(
                        new RestaurantDish("tiramisu", 1.0),
                        new RestaurantDish("milkshake", 1.0),
                        new RestaurantDish("test", 1.0)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, List<RestaurantDish> dishes) {
        double result = calculator.calculate(dishes);

        assertEquals(expected, result);
    }
}
