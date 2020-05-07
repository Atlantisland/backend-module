package academy.everyonecodes.steamPurchases.communication;


import academy.everyonecodes.steamPurchases.logic.PurchaseService;
import academy.everyonecodes.steamPurchases.persistence.domain.Purchase;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@Secured("ROLE_APP")
public class PurchaseEndpoint {

    private final PurchaseService purchaseService;

    public PurchaseEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    Purchase post(@RequestBody Purchase purchase){
        return purchaseService.purchase(purchase);
    }
}
