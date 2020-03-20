package academy.everyonecodes.secretAgentHandshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("secretagent")
public class PriceToHandshakesTranslator {
    private int minPrice;
    private int maxPrice;
    private final HandshakeNumberToMoveTranslator translator;

    public PriceToHandshakesTranslator(int minPrice, int maxPrice, HandshakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    //public List<String> translate(int number){}
}


// I started the handout at around 11:40 due to a scheduled school video call. Apologies but i need to stop here now for a break and then back to retrospective meeting.