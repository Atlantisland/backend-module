package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Item;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("items")
public class FleaMarketStation {

    private List<Item> items;

    public FleaMarketStation(List<Item> items) {
        this.items = items;
    }

    public List<Item> finaALL() {
        return items;
    }

    public List<Item> findBy(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
