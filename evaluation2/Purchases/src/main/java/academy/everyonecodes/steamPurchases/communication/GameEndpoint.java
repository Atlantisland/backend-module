package academy.everyonecodes.steamPurchases.communication;

import academy.everyonecodes.steamPurchases.logic.PurchaseService;
import academy.everyonecodes.steamPurchases.persistence.domain.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameEndpoint {

    private final PurchaseService purchaseService;

    public GameEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    List<Game> get(){
        return purchaseService.findAll();
    }
}
