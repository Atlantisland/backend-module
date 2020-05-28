package academy.everyonecodes.communication;

import academy.everyonecodes.domain.Item;
import academy.everyonecodes.logic.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemEndpoint {

    private final ItemService itemService;

    public ItemEndpoint(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    List<Item> getAll(){
        return itemService.findAll();
    }

    @GetMapping("/{name}")
    List<Item> getByName(@PathVariable String name){
        return itemService.findByName(name);
    }

    @PostMapping
    Item post(@RequestBody Item item){
        itemService.add(item);
        return item;
    }
}
