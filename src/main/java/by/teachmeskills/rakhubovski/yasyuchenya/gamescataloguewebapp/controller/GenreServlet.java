package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.controller;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.Genre;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.GenreRepositoryImpl;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.GenreService;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.GenreServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/genres")
public class GenreServlet extends HttpServlet {

    private final GenreService genreService;

    public GenreServlet() {
        this.genreService = new GenreServiceImpl(new GenreRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Genre> genres = genreService.getGenres();
        req.setAttribute("genres", genres);
        try {
            getServletContext().getRequestDispatcher("/pcGame.jsp").forward(req, resp);
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

        Genre genre = new Genre();
        genre.setName(name);

        genreService.addGenre(genre);

        getServletContext().getRequestDispatcher("/genre.jsp").forward(req,resp);

        }

    /*private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            List<Genre> genresList = genreService.getGenres();
            genresList.forEach(it -> writer.write(it.toString()));
            writer.flush();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }*/
}


