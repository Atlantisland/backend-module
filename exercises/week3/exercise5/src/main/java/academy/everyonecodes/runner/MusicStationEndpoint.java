package academy.everyonecodes.communication;

import academy.everyonecodes.logic.MusicStation;
import academy.everyonecodes.domain.Song;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicStationEndpoint {

    private final MusicStation musicStation;


    public MusicStationEndpoint(MusicStation musicStation) {
        this.musicStation = musicStation;
    }

    @GetMapping
    List<Song> getSongs() {
        return musicStation.findAll();
    }

    @GetMapping("/electronic")
    List<Song> getElectronicSongs() {
        return musicStation.findBy("Electronic");
    }

    @GetMapping("/psychedelic")
    List<Song> getPsychedelicSongs() {
        return musicStation.findBy("Psychedelic Rock");
    }

    @GetMapping("/son")
    List<Song> getSonSongs() {
        return musicStation.findBy("Son");
    }
}
