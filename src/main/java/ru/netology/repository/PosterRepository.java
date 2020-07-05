package ru.netology.repository;

import ru.netology.domain.Poster;

public class PosterRepository {

    private Poster[] items = new Poster[0];

    public Poster[] findAll() {
        return items;
    }

    public void save(Poster item) {
        int length = items.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(items,0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void findById(int id) {
        Poster[] tmp = new Poster[1];
        int index = 0;
        for(Poster item : items) {
            if(item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length- 1;
        Poster[] tmp = new Poster[length];
        int index = 0;
        for(Poster item : items) {
            if(item.getId() !=id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new Poster[0];
    }
}
