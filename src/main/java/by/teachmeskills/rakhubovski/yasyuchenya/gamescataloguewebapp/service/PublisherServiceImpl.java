package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.PublisherRepository;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Override
    public List<Publisher> getPublishers() {
        List<Publisher> publishersList = publisherRepository.getPublisher();
        System.out.println("Internal application service logic");
        return publishersList;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisher;
    }
}
