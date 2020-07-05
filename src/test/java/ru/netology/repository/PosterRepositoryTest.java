package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PosterRepositoryTest {

    private Poster first = new Poster(1, "Dirty Harry", "cop movie");
    private Poster second = new Poster(2, "Unforgiven", "western");
    private Poster third = new Poster(3, "Point Blank", "crime movie");
    private Poster fourth = new Poster(4, "The Killers", "thriller");
    private Poster fifth = new Poster(5, "Wild Bunch", "western");
    private Poster sixth = new Poster(6, "Seven Samurai", "drama");
    private Poster seventh = new Poster(7, "Searchers", "western");
    private Poster eighth = new Poster(8, "Bullitt", "action");
    private Poster ninth = new Poster(9, "The Getaway", "action");
    private Poster tenth = new Poster(10, "The Hustler", "drama");
    private Poster eleventh = new Poster(11, "From Here to Eternity", "drama");

    private PosterRepository repository = new PosterRepository();

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
    }
    @Test
    void shouldSave() {
        repository.save(tenth);
        Poster[] actual = repository.findAll();
        Poster[] expected = new Poster[] {tenth};
        assertArrayEquals(actual,expected);
    }

    @Test
    void shouldFindById() {
        int neededId = 3;
        repository.findById(neededId);
        Poster[] actual = repository.findAll();
        Poster[] expected = new Poster[] {third};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveById() {
        int removingId = 5;
        repository.removeById(removingId);
        Poster[] actual = repository.findAll();
        Poster[] expected = new Poster[] {first};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveAllInRepo() {
        Poster[] actual = repository.findAll();
        Poster[] expected = new Poster[] {};
        assertArrayEquals(expected,actual);
    }

}
