package academy.everyonecodes.secretAgentHandshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@ConfigurationProperties("secretagent")
public class HandshakeNumberToMoveTranslator {

    private Set<Handshake> handshakes;

    public Optional<String> translate(int number) {
        return handshakes.stream()
                .filter(handshake -> handshake.getNumber() == number)
                .map(Handshake::getMove)
                .findFirst();
    }

    void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }
}

