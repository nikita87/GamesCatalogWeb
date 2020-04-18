package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.controller;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Publisher;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.PublisherRepositoryImpl;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.PublisherService;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.PublisherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/publishers")
public class PublisherServlet extends HttpServlet {

    private final PublisherService publisherService;

    public PublisherServlet() {
        this.publisherService = new PublisherServiceImpl(new PublisherRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Publisher> publishers = publisherService.getPublishers();
        req.setAttribute("publishers", publishers);
        try {
            getServletContext().getRequestDispatcher("/publisher.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processRequest(req, resp);
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setCountry(country);

        publisherService.addPublisher(publisher);

        getServletContext().getRequestDispatcher("/publisher.jsp").forward(req,resp);
    }

    /*private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            List<Publisher> publishersList = publisherService.getPublishers();
            publishersList.forEach(it -> writer.write(it.toString()));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

