package academy.everyonecodes.languageBarriers.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteractionsServiceTest {

    InteractionsService interactionsService;

    @BeforeEach
    void setup() {
        interactionsService = new InteractionsService();
    }

    @Test
    void getNumberOfInteractions() {
        int result = interactionsService.getNumberOfInteractions();

        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void increaseNumberOfInteractionsBy() {
        int initial = interactionsService.getNumberOfInteractions();
        assertEquals(0, initial);

        interactionsService.increaseNumberOfInteractionsBy(1);

        int result = interactionsService.getNumberOfInteractions();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    void increaseNumberOfInteractionsByOne() {
        int initial = interactionsService.getNumberOfInteractions();
        assertEquals(0, initial);

        interactionsService.increaseNumberOfInteractionsByOne();

        int result = interactionsService.getNumberOfInteractions();
        int expected = 1;
        assertEquals(expected, result);
    }
}
