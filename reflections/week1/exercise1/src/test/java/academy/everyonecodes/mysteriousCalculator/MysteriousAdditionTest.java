package academy.everyonecodes.mysteriousCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MysteriousAdditionTest {

    MysteriousAddition mysteriousAddition = new MysteriousAddition(10);

    @Test
    void apply() {
        int result = mysteriousAddition.apply(5);

        int expected = 15;
        Assertions.assertEquals(expected, result);

    }

}