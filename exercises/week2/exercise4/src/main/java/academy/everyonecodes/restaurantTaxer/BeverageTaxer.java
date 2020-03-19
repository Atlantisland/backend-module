package academy.everyonecodes.restaurantTaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageTaxer extends Taxer {
    private List<String> names;
    private double tax;

    public BeverageTaxer(@Value("${restaurant.beverage.names}") List<String> names, @Value("${restaurant.beverage.tax}") double tax) {
        super(names, tax);
    }
}
