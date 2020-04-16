package academy.everyonecodes.punchCards.domain;

public class PunchCard {

    private String id;
    private String dayOfTheWeek;
    private String timeOfDay;

    public PunchCard(String dayOfTheWeek, String timeOfDay) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "PunchCard{" +
                "id='" + id + '\'' +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                '}';
    }
}
