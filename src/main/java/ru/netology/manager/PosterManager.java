package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

public class PosterManager {

    private PosterRepository repository;
    private int standardPosterLength = 10;
    private int newPosterLength;

    public PosterManager(int i) {
    }

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public PosterManager(PosterRepository repository, int i) {

    }

    public void addPoster(Poster item) {
        repository.save(item);
    }

    public Poster[] getAll() {
        Poster[] items = repository.findAll();
        int length = items.length;
        if(newPosterLength <=0) {
            if(standardPosterLength < length) {
                length = standardPosterLength;
            }
        } else {
            if(newPosterLength < length) {
                length = newPosterLength;
            }
        }
        Poster[] result = new Poster[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
