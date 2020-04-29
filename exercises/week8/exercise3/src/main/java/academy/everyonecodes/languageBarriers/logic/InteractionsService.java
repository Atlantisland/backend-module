package academy.everyonecodes.languageBarriers.logic;

import org.springframework.stereotype.Service;

@Service
public class InteractionsService {

    private int numberOfInteractions;

    public int getNumberOfInteractions() {
        return numberOfInteractions;
    }

    public void increaseNumberOfInteractionsByOne() {
        numberOfInteractions++;
    }

    public void increaseNumberOfInteractionsBy(int amount) {
        numberOfInteractions += amount;
    }
}

