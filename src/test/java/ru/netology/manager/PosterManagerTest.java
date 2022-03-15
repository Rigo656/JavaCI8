package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    Poster first = new Poster(1, "Бладшот", "боевик");
    Poster second = new Poster(2, "Вперёд", "мультфильм");
    Poster third = new Poster(3, "Отель 'Белград'", "комедия");
    Poster fourth = new Poster(4, "Джентльмены", "боевик");
    Poster fifth = new Poster(5, "Человек-невидимка", "ужасы");
    Poster sixth = new Poster(6, "Тролли. Мировой тур", "мультфильм");
    Poster seventh = new Poster(7, "Номер один", "комедия");
    Poster eighth = new Poster(8, "Девять", "мультфильм");
    Poster ninth = new Poster(9, "Проксима", "драма");
    Poster tenth = new Poster(10, "Дюна", "фантастика");
    Poster eleventh = new Poster(11, "Моана", "мультфильм");

    @Test
    public void shouldGiveMoviesLimit() {
        PosterManager manager = new PosterManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);


        Poster[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Poster[] actual = manager.getLatestMovies();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveMoviesOverLimit() {
        PosterManager manager = new PosterManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);


        Poster[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Poster[] actual = manager.getLatestMovies();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveMoviesWithSelectableLimitCheckOverLimit() {
        PosterManager manager = new PosterManager(7);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);


        Poster[] expected = {seventh, sixth, fifth, fourth, third, second, first};
        Poster[] actual = manager.getLatestMovies();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveMoviesWithSelectableLimitCheckBelowLimit() {
        PosterManager manager = new PosterManager(7);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);


        Poster[] expected = {fourth, third, second, first};
        Poster[] actual = manager.getLatestMovies();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveMoviesWithSelectableLimitBorderCheck() {
        PosterManager manager = new PosterManager(0);
        manager.addMovie(third);


        Poster[] expected = {};
        Poster[] actual = manager.getLatestMovies();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveMoviesInOrderOfAddition() {
        PosterManager manager = new PosterManager(0);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);


        Poster[] expected = {first, second, third, fourth, fifth, sixth, seventh};
        Poster[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

    }


}