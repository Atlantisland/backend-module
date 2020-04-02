package academy.everyonecodes.complexFormula.logic;

import academy.everyonecodes.complexFormula.communication.client.FormulaClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ComplexFormula {

    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }

    public int apply(int number){
        return Integer.parseInt(
                Arrays.stream(String.valueOf(number).split(""))
                .map(digit -> formulaClient.post(Integer.parseInt(digit)))
                .map(Object::toString)
                .collect(Collectors.joining())
        );
    }
}
