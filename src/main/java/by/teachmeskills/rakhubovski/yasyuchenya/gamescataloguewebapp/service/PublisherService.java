package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getPublishers();

    Publisher addPublisher(Publisher publisher);

}
