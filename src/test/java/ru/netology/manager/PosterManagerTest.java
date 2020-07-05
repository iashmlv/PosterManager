package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager;
    PosterManager managerNew;

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

    @BeforeEach
    void setUp() {
        manager = new PosterManager();
        manager.addPoster(first);
        manager.addPoster(second);
        manager.addPoster(third);
        manager.addPoster(fourth);
        manager.addPoster(fifth);
        manager.addPoster(sixth);
        manager.addPoster(seventh);
        manager.addPoster(eighth);
        manager.addPoster(ninth);

        managerNew = new PosterManager(5);
        managerNew.addPoster(first);
        managerNew.addPoster(second);
        managerNew.addPoster(third);
        managerNew.addPoster(fourth);
        managerNew.addPoster(fifth);
    }

    @Test
    void shouldReturnLastTenPoster() {
        manager.addPoster(tenth);
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAllPosters() {
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[] {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFiveLastInNewManager() {
        Poster[] actual = managerNew.getAll();
        Poster[] expected = new Poster[] {fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }




}