package academy.everyonecodes.restaurantTaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeverageTaxerTest {

    @Autowired
    BeverageTaxer taxer;

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "false, wrong-dish",
            "true, milkshake",
    })
    void matches(boolean expected, String name) {
        RestaurantDish dish = new RestaurantDish(name, 1.0);

        boolean result = taxer.matches(dish);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1.2, 0.0",
            "2.2, 1.0",
            "3.2, 2.0",
    })
    void tax(double expected, double price) {
        RestaurantDish dish = new RestaurantDish("name", price);

        double result = taxer.tax(dish);

        assertEquals(expected, result);
    }
}
