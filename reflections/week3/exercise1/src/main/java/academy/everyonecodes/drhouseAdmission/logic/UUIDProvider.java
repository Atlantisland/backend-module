package academy.everyonecodes.drhouseAdmission.logic;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@ConfigurationProperties("patients")
public class UUIDProvider {

    private Set<Patient> cache = new HashSet<>();

   /* void setCache(Set<Patient> cache) {
        this.cache = cache;
    }

    */

    public Set<Patient> provideUUID(Patient patient) {
        String uuid = UUID.randomUUID().toString();
        return cache.stream()
                .filter(e -> !cache.contains(patient.getUuid()))
                .map(e -> patient.setUuid(uuid))
                .collect(Collectors.toList());

        // I have stacked here...
        // how else it could be possible to add missing values in the Patient data class
        //depending on the logic? hmmm...
    }

    public Set<Patient> getCacheSnapshot() {
        return new HashSet<>();
    }

    public Optional<String> findUUID(String name) {
        return getCacheSnapshot().stream()
                .filter(e -> getCacheSnapshot().contains(name))
                .map(Patient::getUuid)
                .findFirst();
    }

}
