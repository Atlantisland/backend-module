package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SummaryCalculator {

    private User user;
    private final double standardDeliverCost;
    private final double noaccountDeliverCost;
    private final double premiumDeliverCost;

    public SummaryCalculator(//User user,
                             @Value("${deliverCost.standard}") double standardDeliverCost,
                             @Value("${deliverCost.noaccount}") double noaccountDeliverCost,
                             @Value("${deliverCost.premium}") double premiumDeliverCost) {
        //this.user = user;
        this.standardDeliverCost = standardDeliverCost;
        this.noaccountDeliverCost = noaccountDeliverCost;
        this.premiumDeliverCost = premiumDeliverCost;
    }

    public Summary calculateSummary(ItemSelection selection) {

        if (selection.getUserEmail().equalsIgnoreCase(user.getEmail()) && user.getAccountType().equalsIgnoreCase("premium")) {
            return new Summary(selection.getUserEmail(), selection.getItemName(), selection.getItemPrice(), premiumDeliverCost, selection.getItemPrice() + premiumDeliverCost);
        }
        if (selection.getUserEmail().equalsIgnoreCase(user.getEmail()) && user.getAccountType().equalsIgnoreCase("standard")) {
            return new Summary(selection.getUserEmail(), selection.getItemName(), selection.getItemPrice(), standardDeliverCost, selection.getItemPrice() + standardDeliverCost);
        }
        return new Summary(selection.getUserEmail(), selection.getItemName(), selection.getItemPrice(), noaccountDeliverCost, selection.getItemPrice() + noaccountDeliverCost);
    }
}
