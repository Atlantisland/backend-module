package academy.everyonecodes.tailoredRecommendations.logic;

import academy.everyonecodes.tailoredRecommendations.domain.Movie;
import academy.everyonecodes.tailoredRecommendations.domain.TailoredRecommendation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsStoreTest {

    @Autowired
    TailoredRecommendationsStore tailoredRecommendationsStore;

    @ParameterizedTest
    @MethodSource("parameters")
    void getMovie(Set<TailoredRecommendation> expected, String uuid){
        Set<Movie> result = tailoredRecommendationsStore.getMovie(uuid);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(Set.of(new Movie("title1", "synopsis1")), "123abc"),
                Arguments.of(Set.of(new Movie("title2", "synopsis2")), "321cba"),
                Arguments.of(Set.of(), "")
        );
    }

    @DirtiesContext
    @Test

    void post() {
        TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("123abc", new Movie("title3", "synopsis3"));
        tailoredRecommendationsStore.post(tailoredRecommendation);

        Set<TailoredRecommendation> result = tailoredRecommendationsStore.getTailoredRecommendations();
        Set<TailoredRecommendation> expected = Set.of(
                new TailoredRecommendation("123abc", new Movie("title1", "synopsis1")),
                new TailoredRecommendation("321cba", new Movie("title2", "synopsis2")),
                new TailoredRecommendation("123abc", new Movie("title3", "synopsis3"))
        );
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getTailoredRecommendations() {
        Set<TailoredRecommendation> result = tailoredRecommendationsStore.getTailoredRecommendations();
        Set<TailoredRecommendation> expected = Set.of(
                new TailoredRecommendation("123abc", new Movie("title1", "synopsis1")),
                new TailoredRecommendation("321cba", new Movie("title2", "synopsis2"))
        );

        Assertions.assertEquals(expected, result);
    }
}