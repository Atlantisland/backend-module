package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Item;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FleaMarketStation {

    private List<Item> items = new ArrayList<>();

    public List<Item> findAll() {
        return items;
    }

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> findBy(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
