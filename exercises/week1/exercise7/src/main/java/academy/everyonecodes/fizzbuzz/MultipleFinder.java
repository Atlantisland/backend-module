package academy.everyonecodes.fizzbuzz;

public class MultipleFinder {
    private int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int number) {
        if (number == 0) {
            return false;
        }
        double result = number % multiple;
        return result == 0;
    }
}
