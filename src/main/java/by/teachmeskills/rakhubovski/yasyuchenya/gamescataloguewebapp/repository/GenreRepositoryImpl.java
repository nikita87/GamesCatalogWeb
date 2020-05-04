package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.util.db.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {

    private final String getGenresQuery = "Select * from genres";
    private final String addGenreQuery = "INSERT INTO genres (name) VALUES (?)";
    private final String removeGenreQuery = "DELETE FROM genres WHERE genre_id (?)";


    @Override
    public List<Genre> getGenre() {
        List<Genre> genresList = new ArrayList<>();
        try {
            Connection conn = DBUtils.connection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getGenresQuery);
            genresList.addAll(createGenreList(rs));
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genresList;
    }

    @Override
    public Genre addGenre(Genre genre) {
        try {
            Connection conn = DBUtils.connection();
            PreparedStatement prst = conn.prepareStatement(addGenreQuery);
            prst.setString(1, genre.getName());

            prst.executeUpdate();
            ResultSet rs = prst.getGeneratedKeys();
            if(rs.next())
            {
                genre.setId(rs.getLong(1));
            }
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    @Override
    public void removeGenre(Genre genre) {
        try {
            Connection conn = DBUtils.connection();
            PreparedStatement prst = conn.prepareStatement(removeGenreQuery);
            prst.setString(1, String.valueOf(genre.getId()));
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private List<Genre> createGenreList (ResultSet rs) throws SQLException {
        List<Genre> genresList = new ArrayList<>();
        while (rs.next()) {
            genresList.add(createGenre(rs));
        }
        return genresList;
    }

    private Genre createGenre(ResultSet rs) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getLong(1));
        genre.setName(rs.getString(2));

        return genre;
    }


}
