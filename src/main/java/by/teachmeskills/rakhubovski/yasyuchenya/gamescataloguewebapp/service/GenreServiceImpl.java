package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.GenreRepository;
import java.util.List;

public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genresList = genreRepository.getGenre();
        System.out.println("Internal application service logic");
        return genresList;
    }

    @Override
    public Genre addGenre(Genre genre) {
        return genre;
    }
}
