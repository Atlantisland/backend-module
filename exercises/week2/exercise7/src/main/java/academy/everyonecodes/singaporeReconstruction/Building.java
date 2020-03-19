package academy.everyonecodes.singaporeReconstruction;
import java.time.LocalDate;
import java.util.Objects;

public class Building {
    private String name;
    private LocalDate built;
    private boolean historic;

    public Building() {
    }

    public Building(String name, LocalDate built, boolean historic) {
        this.name = name;
        this.built = built;
        this.historic = historic;
    }

    void setName(String name) {
        this.name = name;
    }

    void setBuilt(LocalDate built) {
        this.built = built;
    }

    void setHistoric(boolean historic) {
        this.historic = historic;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBuilt() {
        return built;
    }

    public boolean isHistoric() {
        return historic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return historic == building.historic &&
                Objects.equals(name, building.name) &&
                Objects.equals(built, building.built);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, built, historic);
    }
}

