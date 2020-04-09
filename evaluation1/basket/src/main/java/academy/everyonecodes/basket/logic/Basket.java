package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;

import java.util.List;

import static java.util.stream.Collectors.toList;
//@Service
public class Basket {

    private SummaryCalculator calculator;

    private final List<ItemSelection> selections;

    public Basket(List<ItemSelection> selections) {
        this.selections = selections;
    }

    public void add(ItemSelection selection) {
        selections.add(selection);
    }

    public List<Summary> get(List<ItemSelection> selections) {
        return selections.stream()
                .map(calculator::calculateSummary)
                .collect(toList());
    }
}
