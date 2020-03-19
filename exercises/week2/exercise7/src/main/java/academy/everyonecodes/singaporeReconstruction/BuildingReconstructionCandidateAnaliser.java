package academy.everyonecodes.singaporeReconstruction;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnaliser {
    private List<Building> buildings;
    private final long yearThreshold = 20;

    void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates() {
        return buildings.stream()
                .filter(building -> building.getBuilt().isBefore(LocalDate.now().minusYears(yearThreshold)) && !building.isHistoric())
                .collect(Collectors.toList());
    }
}

