package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.util.db.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PcGameRepositoryImpl implements PcGameRepository {

    private final String getPcGamesQuery = "Select * from games_catalogue";
    private final String addPcGamesQuery = "INSERT INTO games (title, release_year, description) VALUES (?, ?, ?)";
    private final String addPriceCurrencyGameQuery = "INSERT INTO currency (currency_name) VALUES (?)";
    private final String addPriceValueGameQuery = "INSERT INTO game_currency_price (price) VALUES (?)";

    @Override
    public List<PcGame> getPcGame() {
        List<PcGame> pcGamesList = new ArrayList<>();
        try {
            Connection conn = DBUtils.connection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getPcGamesQuery);
            pcGamesList.addAll(createPcGamesList(rs));
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pcGamesList;
    }

    @Override
    public PcGame addPcGame(PcGame pcGame) {
        try {
            Connection conn = DBUtils.connection();
            PreparedStatement prst = conn.prepareStatement(addPcGamesQuery);
            PreparedStatement prst1 = conn.prepareStatement(addPriceCurrencyGameQuery);
            PreparedStatement prst2 = conn.prepareStatement(addPriceValueGameQuery);
            prst.setString(1, pcGame.getTitle());
            prst.setString(2, pcGame.getYear());
            prst.setString(3, pcGame.getDescription());
            prst1.setString(1,pcGame.getPrice().getCurrency());
            prst2.setString(1, String.valueOf(pcGame.getPrice().getValue()));
            prst.executeUpdate();
            prst1.executeUpdate();
            prst2.executeUpdate();
            ResultSet rs = prst.getGeneratedKeys();
            if(rs.next())
            {
                pcGame.setId(rs.getLong(1));
            }
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pcGame;
    }

    private List<PcGame> createPcGamesList (ResultSet rs) throws SQLException {
        List<PcGame> pcGamesList = new ArrayList<>();
        while (rs.next()) {
            pcGamesList.add(createPcGame(rs));
        }
        return pcGamesList;
    }

    private PcGame createPcGame(ResultSet rs) throws SQLException {
        PcGame pcGame = new PcGame();

        pcGame.setId(rs.getLong(1));
        pcGame.setTitle(rs.getString(2));
        pcGame.setGenre((Genre) rs.getObject(3));
        pcGame.setYear(rs.getString(4));
        pcGame.setPublisher((Publisher) rs.getObject(5));
        pcGame.setDescription(rs.getString(6));
        pcGame.setPrice(rs.getObject(7));

        return pcGame;
    }
}

