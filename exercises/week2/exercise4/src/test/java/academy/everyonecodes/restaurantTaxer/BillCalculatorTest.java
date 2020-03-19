package academy.everyonecodes.restaurantTaxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class BillCalculatorTest {

    @Autowired
    BillCalculator billCalculator;

    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(19.6, List.of(new RestaurantDish("potato soup", 3.5), new RestaurantDish("caesar salad", 2.8), new RestaurantDish("tiramisu", 6.0), new RestaurantDish("soda", 2.8))),
                Arguments.of(17.3, List.of(new RestaurantDish("fish", 10.2), new RestaurantDish("caesar salad", 2.8), new RestaurantDish("orange juice", 2.0))),
                Arguments.of(14.3, List.of(new RestaurantDish("fish", 10.5), new RestaurantDish("beer", 3.8)))
        );
    }
    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, List<RestaurantDish> input){
        double result = billCalculator.calculate(input);

        Assertions.assertEquals(expected, result);
    }
}