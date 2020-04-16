package academy.everyonecodes.interactions.communication;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {

    private Set<String> colors= new HashSet<>();

    @GetMapping
    Set<String> getColors(){
        return colors;
    }

    @GetMapping("/{name}")
    String getColorName(@PathVariable String name){
        return colors.stream()
                .filter(color -> color.equalsIgnoreCase(name))
                .findFirst()
                .orElse("The color is not available in the app");
    }


    @PostMapping
    String post(@RequestBody String name){
        colors.add(name);
        return name;
    }

    @PutMapping("/{target}")
    String put(@PathVariable String target,
               @RequestBody String received) {
        colors.remove(target);
        colors.add(received);
        return received;
    }

    @DeleteMapping
    void delete() {
        colors.clear();
    }

    @DeleteMapping("/{name}")
    void delete(@PathVariable String name) {
        colors.remove(name);
    }

}

