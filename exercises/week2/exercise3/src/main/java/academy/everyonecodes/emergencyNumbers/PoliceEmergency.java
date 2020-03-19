package academy.everyonecodes.emergencyNumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PoliceEmergency implements EmergencyNumber {

    private String name;
    private int number;

    public PoliceEmergency(@Value("${emergency.police.name}") String name,
                           @Value("${emergency.police.number}") int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
