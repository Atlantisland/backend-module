package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.Basket;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {

    private final SummaryCalculator calculator;
    private final Basket basket;

    public ItemSelectionEndpoint(SummaryCalculator calculator, Basket basket) {
        this.calculator = calculator;
        this.basket = basket;
    }

    @PostMapping
    ItemSelection post(@RequestBody ItemSelection selection){
        basket.add(selection);
        calculator.calculateSummary(selection);
        return selection;
    }
}
