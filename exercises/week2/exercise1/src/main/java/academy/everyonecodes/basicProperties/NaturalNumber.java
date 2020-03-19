package academy.everyonecodes.basicProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber(@Value("${basic.naturalNumber}") int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }

    public int getNaturalNumber() {
        return naturalNumber;
    }

}
