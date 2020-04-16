package academy.everyonecodes.rockScissorsPaper;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {
    private final Scanner scanner = new Scanner(System.in);
    private final MoveUtils moveUtils;

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {
        Optional<Move> oMove = Optional.empty();
        while (oMove.isEmpty()) {
            oMove = askForMove();
        }
        return oMove.get();
    }

    private Optional<Move> askForMove() {
        System.out.println("Choose one move. Available options: " + moveUtils.getNames());
        String moveName = scanner.nextLine();
        return moveUtils.getOne(moveName);
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? (y,n)");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y");
    }
}
