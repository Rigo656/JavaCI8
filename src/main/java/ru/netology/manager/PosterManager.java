package ru.netology.manager;

import lombok.Getter;
import lombok.Setter;
import ru.netology.domain.Poster;

@Getter
@Setter
public class PosterManager {
    private Poster[] movies = new Poster[0];
    private int limitMovies = 10;

    public PosterManager() {
    }

    public PosterManager(int limitMovies) {
        this.limitMovies = limitMovies;
    }

    public void addMovie(Poster film) {
        int length = movies.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        movies = tmp;
    }

    public Poster[] findAll() {
        return movies;
    }

    public Poster[] getLatestMovies() {
        int resultLength = Math.min(movies.length, limitMovies);
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
