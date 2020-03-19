package academy.everyonecodes.rockScissorsPaper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.print.Paper;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    Judge judge = new Judge();

    static Stream<Arguments> parameters() {
        Move rock = new Move("rock", "scissors");
        Move scissors = new Move("scissors", "paper");
        Move paper = new Move("paper", "rock");
        return Stream.of(
                Arguments.of("Nobody wins", rock, rock),
                Arguments.of("Nobody wins", scissors, scissors),
                Arguments.of("Nobody wins", paper, paper),
                Arguments.of("Player 1 wins!", rock, scissors),
                Arguments.of("Player 1 wins!", scissors, paper),
                Arguments.of("Player 1 wins!", paper, rock),
                Arguments.of("Player 2 wins!", rock, paper),
                Arguments.of("Player 2 wins!", scissors, rock),
                Arguments.of("Player 2 wins!", paper, scissors)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move move1, Move move2) {
        String result = judge.judge(move1, move2);

        assertEquals(expected, result);
    }
}
