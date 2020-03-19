package academy.everyonecodes.singaporeReconstruction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BuildingReconstructionCandidateAnaliserTest {

    @Autowired
    BuildingReconstructionCandidateAnaliser analiser;

    @Test
    void findCandidates() {
        Building building1 = new Building("building1", LocalDate.of(1800,1, 1), false);
        Building building2 = new Building("building3", LocalDate.of(1800, 1, 1), true);
        List<Building> buildings = List.of(building1, building2);
        List<Building> expected = List.of(building1);
        analiser.setBuildings(buildings);
        List<Building> result = analiser.findCandidates();
        assertEquals(expected, result);
    }
}