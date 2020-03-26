package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Song;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MusicStationTest {

    @Autowired
    MusicStation musicStation;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(new Song("song1", "genre1"), new Song("song2", "genre1")), "genre1"),
                Arguments.of(List.of(new Song("song3", "genre2")), "genre2"),
                Arguments.of(List.of(), " "));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Song> expected, String genre) {
        List<Song> result = musicStation.findBy(genre);

        assertEquals(expected, result);
    }
}