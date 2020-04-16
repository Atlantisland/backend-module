package academy.everyonecodes.communication;

import academy.everyonecodes.domain.Item;
import academy.everyonecodes.logic.FleaMarketStation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class FleaMarketEndpoint {

    private final FleaMarketStation station;

    public FleaMarketEndpoint(FleaMarketStation station) {
        this.station = station;
    }

    @GetMapping
    List<Item> getItems() {
        return station.findAll();
    }

    @PostMapping
    Item add(@RequestBody Item item) {
        return station.add(item);
    }

    @GetMapping("/{name}")
    List<Item> getSameItem(@PathVariable String name) {
        return station.findBy(name);
    }
}