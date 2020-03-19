package academy.everyonecodes.rockScissorsPaper;
import java.util.List;
import java.util.Random;

public class Computer implements Player {

    private Random random = new Random();
    private final List<Move> moves;

    public Computer(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Move play() {
        int position = random.nextInt(moves.size());
        return moves.get(position);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
