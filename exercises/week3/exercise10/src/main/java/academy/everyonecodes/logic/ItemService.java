package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Item;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ItemService {

    private final List<Item> items;

    public ItemService(List<Item> items) {
        this.items = items;
    }

    public List<Item> findAll(){
        return items;
    }

    public void add(Item item){
        items.add(item);
    }

    public List<Item> findByName(String name){
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(toList());
    }
}
