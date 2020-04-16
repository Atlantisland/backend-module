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
                Arguments.of(List.of(), null),
                Arguments.of(List.of(), ""),
                Arguments.of(List.of(new Song("Song1", "Genre1")), "Genre1"),
                Arguments.of(List.of(new Song("Song1", "Genre1")), "genre1"),
                Arguments.of(
                        List.of(new Song("Song2", "Genre2"),
                                new Song("Song3", "Genre2")),
                        "Genre2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(List<Song> expected, String keyword) {
        List<Song> result = musicStation.findBy(keyword);

        assertEquals(expected, result);
    }
}
