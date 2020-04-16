package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Basket {

    private final SummaryCalculator summaryCalculator;
    private final List<Summary> summaries;

    public Basket(SummaryCalculator summaryCalculator, List<Summary> summaries) {
        this.summaryCalculator = summaryCalculator;
        this.summaries = summaries;
    }

    public void process(ItemSelection itemSelection) {
        Summary summary = summaryCalculator.calculate(itemSelection);
        summaries.add(summary);
    }

    public List<Summary> getSummaries() {
        return summaries;
    }
}

