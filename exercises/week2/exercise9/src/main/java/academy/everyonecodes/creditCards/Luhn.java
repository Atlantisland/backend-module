package academy.everyonecodes.creditCards;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Luhn {

    public boolean isValid(String number) {
        AtomicInteger multiplier = getMultiplierInitialValue(number);
        return number.chars()
                .map(ascii -> ascii - '0')
                .map(num -> num * multiplier.updateAndGet(actual -> actual == 1 ? 2 : 1))
                .map(num -> num > 9 ? num - 9 : num)
                .sum() % 10 == 0;
    }

    private AtomicInteger getMultiplierInitialValue(String number) {
        boolean hasAnEvenNumberOfDigits = number.length() % 2 == 0;
        return new AtomicInteger(hasAnEvenNumberOfDigits ? 1 : 2);
    }
}
