package ru.netology.manager;

import ru.netology.domain.Poster;

public class PosterManager {
    private Poster[] items = new Poster[0];
    private int standardPosterLength = 10;
    private int newPosterLength;

    public PosterManager(int i) {
    }

    public PosterManager() {

    }

    public void addPoster(Poster item) {
        int length = items.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Poster[] getAll() {
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
