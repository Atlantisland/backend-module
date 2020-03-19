package academy.everyonecodes.advancedYml.beans;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {

    private double decimalNumber;

    public double getDecimalNumber() {
        return decimalNumber;
    }

    void setDecimalNumber(double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
}
