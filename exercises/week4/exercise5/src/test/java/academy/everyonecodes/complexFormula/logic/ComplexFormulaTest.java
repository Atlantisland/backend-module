package academy.everyonecodes.complexFormula.logic;

import academy.everyonecodes.complexFormula.communication.client.FormulaClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ComplexFormulaTest {

    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;

    @Test
    void apply() {

        int input = 1;
        int expected = 2;

        when(formulaClient.send(input)).thenReturn(expected);
        int result = formulaClient.send(input);
        Assertions.assertEquals(expected, result);
        Mockito.verify(formulaClient).send(input);
    }
}
