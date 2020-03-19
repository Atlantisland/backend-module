package academy.everyonecodes.creditCards;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditCards {
    private Set<Issuer> issuers;
    private Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String creditcardNumber) {
        boolean isValid = luhn.isValid(creditcardNumber);
        if (!isValid) {
            return "Invalid";
        }
        return issuers.stream()
                .filter(issuer -> issuer.issues(creditcardNumber))
                .map(Issuer::getName)
                .findFirst()
                .orElse("Not Supported");
    }
}
