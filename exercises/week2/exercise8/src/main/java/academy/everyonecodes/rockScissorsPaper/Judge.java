package academy.everyonecodes.rockScissorsPaper;

import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move player1, Move player2) {
        if (player1.getDefeats().equals(player2.getName())) {
            return "Player 1 wins!";
        }
        if (player2.getDefeats().equals(player1.getName())) {
            return "Player 2 wins!";
        }
        return "Nobody wins";
    }
}

