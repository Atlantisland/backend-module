package academy.everyonecodes.restaurantTaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodstuffTaxer extends Taxer {

    public FoodstuffTaxer(@Value("${restaurant.foodstuff.names}") List<String> names, @Value("${restaurant.foodstuff.tax}") double tax) {
        super(names, tax);
    }
}
