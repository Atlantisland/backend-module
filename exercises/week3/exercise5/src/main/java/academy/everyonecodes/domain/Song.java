package academy.everyonecodes.domain;

import java.util.Objects;

public class Song {

    private String name;
    private String genre;

    Song() {
    }

    public Song(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) &&
                Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }
}
