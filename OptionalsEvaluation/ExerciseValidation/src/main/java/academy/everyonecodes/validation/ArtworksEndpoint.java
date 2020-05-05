package academy.everyonecodes.validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/artworks")
public class ArtworksEndpoint {

    @PostMapping
    Artwork post(@Valid @RequestBody Artwork artwork){
        return artwork;
    }
}
