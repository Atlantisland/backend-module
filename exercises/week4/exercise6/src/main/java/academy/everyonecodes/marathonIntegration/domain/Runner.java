package academy.everyonecodes.marathonIntegration.domain;

import java.time.Duration;
import java.util.Objects;

public class Runner {

    private String name;
    private Duration duration;

    Runner() {
    }

    public Runner(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return Objects.equals(name, runner.name) &&
                Objects.equals(duration, runner.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }
}
