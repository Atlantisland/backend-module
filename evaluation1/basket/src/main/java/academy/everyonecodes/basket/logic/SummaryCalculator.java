package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.communication.client.UsersClient;
import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryCalculator {

    private final UsersClient usersClient;
    private final double deliveryCosts;

    public SummaryCalculator(UsersClient usersClient,
                             @Value("${basket.deliverycosts}") double deliveryCosts) {
        this.usersClient = usersClient;
        this.deliveryCosts = deliveryCosts;
    }

    public Summary calculate(ItemSelection itemSelection) {
        Optional<User> oUser = usersClient.getUser(itemSelection.getUserEmail());
        Summary summary = createStandardSummary(itemSelection);
        if (hasPremiumAccount(oUser)) {
            removeDeliveryCosts(summary);
        }
        return summary;
    }

    private Summary createStandardSummary(ItemSelection itemSelection) {
        double totalPrice = itemSelection.getItemPrice() + deliveryCosts;
        return new Summary(
                itemSelection.getUserEmail(),
                itemSelection.getItemName(),
                itemSelection.getItemPrice(),
                deliveryCosts,
                totalPrice
        );
    }

    private boolean hasPremiumAccount(Optional<User> oUser) {
        String account = oUser.map(User::getAccountType).orElse("no account");
        return account.equals("premium");
    }

    private void removeDeliveryCosts(Summary summary) {
        double itemPrice = summary.getItemPrice();
        summary.setDeliveryCost(0.0);
        summary.setTotalPrice(itemPrice);
    }
}

