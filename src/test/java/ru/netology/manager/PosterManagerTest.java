package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PosterManagerTest {
    @Mock
    PosterRepository repository;
    @InjectMocks
    PosterManager manager = new PosterManager(repository);

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
    }

    @Test
    void addPoster() {
        Poster twelwth = new Poster(12, "Rashomon", "drama");
        manager.addPoster(twelwth);
        repository.save(twelwth);
        PosterManager manager = new PosterManager(repository, 5);
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth, twelwth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{twelwth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnLastTenPoster() {
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnAllPosters() {
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnFiveLastInManager() {
        PosterManager manager = new PosterManager(repository, 5);
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnLastFiveWhenZero() {
        PosterManager manager = new PosterManager(repository, 0);
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnLastFiveWhenLessThanZero() {
        PosterManager manager = new PosterManager(repository, -1);
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnLastFiveWhenMore() {
        PosterManager manager = new PosterManager(repository, 1000);
        Poster[] returned = new Poster[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
        verify(repository, times(1)).findAll();

    }

    @Test
    void shouldReturnMoreThenTen() {
        Poster[] returned = new Poster[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }
}