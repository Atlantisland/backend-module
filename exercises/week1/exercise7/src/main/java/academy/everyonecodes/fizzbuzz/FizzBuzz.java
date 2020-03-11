package academy.everyonecodes.fizzbuzz;

public class FizzBuzz {

    private final MultipleFinder multipleOfThree;
    private final MultipleFinder multipleOfFive;


    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply(int number) {
        if (multipleOfThree.isMultiple(number) && multipleOfFive.isMultiple(number)) {
            return "FizzBuzz";
        }
        if (multipleOfThree.isMultiple(number)) {
            return "Fizz";
        }
        if (multipleOfFive.isMultiple(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
