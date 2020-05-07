package academy.everyonecodes.steamPurchases.communication;

import academy.everyonecodes.steamPurchases.logic.PurchaseService;
import academy.everyonecodes.steamPurchases.persistence.domain.SteamUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Secured("ROLE_ADMIN")
public class SteamUserEndpoint {

    private final PurchaseService purchaseService;

    public SteamUserEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    List<SteamUser> get(){
        return purchaseService.findAllSteamUsers();
    }
}
