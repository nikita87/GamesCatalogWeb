package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import java.util.List;

public interface GenreService {

    List<Genre> getGenres();

    Genre addGenre(Genre genre);

}
