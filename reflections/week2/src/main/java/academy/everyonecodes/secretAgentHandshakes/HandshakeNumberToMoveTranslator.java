package academy.everyonecodes.secretAgentHandshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Service
@ConfigurationProperties("secretagent")

public class HandshakeNumberToMoveTranslator {

    private Set<Handshake> handshakes;

    public HandshakeNumberToMoveTranslator(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public Optional<String> translate(int number) {
        return handshakes.stream()
                .filter(handshake -> handshakes.contains(number))
                .map(handshake -> handshake.getMove())
                .findFirst();
    }
}
