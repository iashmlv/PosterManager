package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

public class PosterManager {

    private PosterRepository repository;
    private int standardPosterLength = 10;
    private int newPosterLength;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public PosterManager(PosterRepository repository, int newPosterLength) {
        this.repository = repository;
        this.newPosterLength = newPosterLength;
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
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
