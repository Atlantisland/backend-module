package academy.everyonecodes.emergencyNumbers;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmergencyNumberProvider {

    private final Set<EmergencyNumber> numbers;
    private final GeneralEmergency generalEmergency;

    public EmergencyNumberProvider(PoliceEmergency policeEmergency, FireEmergency fireEmergency, GeneralEmergency generalEmergency) {
        numbers = Set.of(policeEmergency, fireEmergency);
        this.generalEmergency = generalEmergency;
    }

    public int provide(String name) {
        return numbers.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equalsIgnoreCase(name))
                .map(EmergencyNumber::getNumber)
                .findFirst()
                .orElse(generalEmergency.getNumber());
    }
}
