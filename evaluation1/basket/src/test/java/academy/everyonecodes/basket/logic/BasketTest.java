package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.domain.Summary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BasketTest {

    @Autowired
    Basket basket;

    @MockBean
    SummaryCalculator summaryCalculator;

    @Test
    @DirtiesContext
    void process() {
        ItemSelection itemSelection = new ItemSelection("test", "test", 1.0);
        Summary summary = new Summary("test@test.com", "test", 1.0, 1.0, 2.0);
        Mockito.when(summaryCalculator.calculate(itemSelection))
                .thenReturn(summary);
        assertTrue(basket.getSummaries().isEmpty());

        basket.process(itemSelection);

        assertEquals(1, basket.getSummaries().size());
        assertEquals(summary, basket.getSummaries().get(0));
        Mockito.verify(summaryCalculator).calculate(itemSelection);
    }

    @Test
    void getSummaries() {
        assertTrue(basket.getSummaries().isEmpty());
    }
}
