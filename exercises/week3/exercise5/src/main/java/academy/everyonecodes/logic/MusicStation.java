package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Song;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@ConfigurationProperties("music")
public class MusicStation {

    private List<Song> songs;

    public List<Song> findAll() {
        return songs;
    }

    public List<Song> findBy(String genre) {
        return songs.stream()
                .filter(song -> song.getGenre().equalsIgnoreCase(genre))
                .collect(toList());
    }

    void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
