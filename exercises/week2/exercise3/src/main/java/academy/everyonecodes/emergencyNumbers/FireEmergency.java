package academy.everyonecodes.emergencyNumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FireEmergency implements EmergencyNumber {

    private String name;
    private int number;

    public FireEmergency(@Value("${emergency.fire.name}") String name,
                         @Value("${emergency.fire.number}") int number) {
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
