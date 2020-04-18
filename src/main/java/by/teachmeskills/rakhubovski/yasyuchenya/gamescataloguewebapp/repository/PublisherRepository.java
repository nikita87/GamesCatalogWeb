package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;

import java.util.List;

public interface PublisherRepository {

    List<Publisher> getPublisher();

    Publisher addPublisher(Publisher publisher);
}
