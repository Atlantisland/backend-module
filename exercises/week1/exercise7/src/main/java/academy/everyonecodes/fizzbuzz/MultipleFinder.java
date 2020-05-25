package academy.everyonecodes.fizzbuzz;

public class MultipleFinder {

    private final int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int number) {
        return number % multiple == 0;
    }
}
