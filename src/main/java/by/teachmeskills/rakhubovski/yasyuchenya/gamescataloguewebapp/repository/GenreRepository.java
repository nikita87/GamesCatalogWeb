package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import java.util.List;

public interface GenreRepository {

    List<Genre> getGenre();

    Genre addGenre(Genre genre);

    void removeGenre(Genre genre);
}
