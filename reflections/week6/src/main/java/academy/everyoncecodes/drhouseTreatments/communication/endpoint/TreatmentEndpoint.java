package academy.everyoncecodes.drhouseTreatments.communication.endpoint;

import academy.everyoncecodes.drhouseTreatments.domain.Treatment;
import academy.everyoncecodes.drhouseTreatments.logic.TreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {

    private final TreatmentService service;

    public TreatmentEndpoint(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    List<Treatment> get(){
        return service.findAll();
    }

    @GetMapping("/{uuid}")
    List<Treatment> getByUuid(@PathVariable String uuid){
        return service.findByUuid(uuid);
    }
}
