package academy.everyonecodes.restaurantTaxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.ToDoubleFunction;

@Service
public class BillCalculator {

    private final Set<Taxer> taxers;

    public BillCalculator(Set<Taxer> taxers) {
        this.taxers = taxers;
    }

    public double calculate(List<RestaurantDish> dishes) {
        return dishes.stream()
                .mapToDouble(applyMatchingTax())
                .sum();
    }

    private ToDoubleFunction<RestaurantDish> applyMatchingTax() {
        return dish -> taxers.stream()
                .filter(taxer -> taxer.matches(dish))
                .map(taxer -> taxer.tax(dish))
                .findFirst()
                .orElse(dish.getPrice());
    }
}

