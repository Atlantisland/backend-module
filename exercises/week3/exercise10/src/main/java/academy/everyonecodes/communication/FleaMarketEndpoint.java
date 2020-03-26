package academy.everyonecodes.communication;

import academy.everyonecodes.domain.Item;
import academy.everyonecodes.logic.FleaMarketStation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class FleaMarketEndpoint {

    private final FleaMarketStation station;

    public FleaMarketEndpoint(FleaMarketStation station) {
        this.station = station;
    }

    @GetMapping("/items")
    List<Item> getItems() {
        return station.finaALL();
    }

    @PostMapping("/items")
    Item post(@RequestBody Item item) {
        getItems().add(item);
        return item;
    }

    @GetMapping("/items/{name}")
    List<Item> getSameItem(@PathVariable String name) {
        return station.findBy(name);
    }
}