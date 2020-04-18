package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.util.db.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository{

    private final String getPublishersQuery = "Select * from publishers";
    private final String addPublishersQuery = "INSERT INTO publishers (name, country) VALUES (?, ?)";


    @Override
    public List<Publisher> getPublisher() {
        List<Publisher> publishersList = new ArrayList<>();
        try {
            Connection conn = DBUtils.connection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getPublishersQuery);
            publishersList.addAll(createPublishersList(rs));
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishersList;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        try {
            Connection conn = DBUtils.connection();
            PreparedStatement prst = conn.prepareStatement(addPublishersQuery);
            prst.setString(1, publisher.getName());
            prst.setString(2, publisher.getCountry());

            prst.executeUpdate();
            ResultSet rs = prst.getGeneratedKeys();
            if(rs.next())
            {
                publisher.setId(rs.getLong(1));
            }
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    private List<Publisher> createPublishersList (ResultSet rs) throws SQLException {
        List<Publisher> publishersList = new ArrayList<>();
        while (rs.next()) {
            publishersList.add(createPublisher(rs));
        }
        return publishersList;
    }

    private Publisher createPublisher(ResultSet rs) throws SQLException {
        Publisher publisher = new Publisher();

        publisher.setId(rs.getLong(1));
        publisher.setName(rs.getString(2));
        publisher.setCountry(rs.getString(3));

        return publisher;
    }
}
