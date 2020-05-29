package academy.everyonecodes.mysteriousCalculator.logic;

public class MysteriousAddition {

    private final int number;

    public MysteriousAddition(int number) {
        this.number = number;
    }

    public int apply(int naturalNumber){
        return naturalNumber+number;
    }
}
