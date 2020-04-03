package academy.everyonecodes.drhouseAdmission.communication;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import academy.everyonecodes.drhouseAdmission.logic.UUIDProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/uuids")
public class UuidProviderEndpoint {

    private final UUIDProvider provider;

    public UuidProviderEndpoint(UUIDProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    Set<Patient> getCachedPatients(){
        return provider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    String getCachedPatientUUID(@PathVariable String patientName){
        return ;

    }
// I need to stop here and to commit


}
