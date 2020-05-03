package academy.everyonecodes.securedPolo.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Polo {

    private final String question;
    private final String correct;
    private final String wrong;

    public Polo(@Value("${polo.question}") String question,
                       @Value("${polo.correct}") String correct,
                       @Value("${polo.wrong}") String wrong) {
        this.question = question;
        this.correct = correct;
        this.wrong = wrong;
    }

    public String respond(String message) {
        if (question.equals(message)) {
            return correct;
        }
        return wrong;
    }
}

