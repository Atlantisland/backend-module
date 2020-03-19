package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeveralValues {
    private List<Integer> severalNaturalNumbers;
    private List<Double> severalDecimalNumbers;
    private List<String> severalWords;
    private List<Boolean> severalChoices;

    public SeveralValues(@Value("${basic.several.naturalNumbers}") List<Integer> severalNaturalNumbers, @Value("${basic.several.decimalNumbers}") List<Double> severalDecimalNumbers, @Value("${basic.several.words}") List<String> severalWords, @Value("${basic.several.choices}") List<Boolean> severalChoices) {
        this.severalNaturalNumbers = severalNaturalNumbers;
        this.severalDecimalNumbers = severalDecimalNumbers;
        this.severalWords = severalWords;
        this.severalChoices = severalChoices;
    }

    public List<Integer> getSeveralNaturalNumbers() {
        return severalNaturalNumbers;
    }

    public List<Double> getSeveralDecimalNumbers() {
        return severalDecimalNumbers;
    }

    public List<String> getSeveralWords() {
        return severalWords;
    }

    public List<Boolean> getSeveralChoices() {
        return severalChoices;
    }
}

