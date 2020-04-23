package academy.everyoncecodes.couchPotato.communication;

import academy.everyoncecodes.couchPotato.domain.Film;
import academy.everyoncecodes.couchPotato.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmRepository filmRepository;

    public FilmEndpoint(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    List<Film> get(){
        return filmRepository.findAll();
    }

    @PostMapping
    Film post(@Valid @RequestBody Film film){
        return filmRepository.save(film);
    }
}
