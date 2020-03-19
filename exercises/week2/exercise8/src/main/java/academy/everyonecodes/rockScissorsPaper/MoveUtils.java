package academy.everyonecodes.rockScissorsPaper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoveUtils {
    private final List<Move> moves;

    public MoveUtils(List<Move> moves) {
        this.moves = moves;
    }

    public String getNames() {
        return moves.stream()
                .map(Move::getName)
                .collect(Collectors.joining(","));
    }

    public Optional<Move> getOne(String name) {
        return moves.stream()
                .filter(move -> name.equalsIgnoreCase(move.getName()))
                .findFirst();
    }
}
