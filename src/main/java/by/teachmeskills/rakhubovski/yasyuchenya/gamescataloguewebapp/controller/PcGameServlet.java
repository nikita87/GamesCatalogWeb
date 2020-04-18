package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.controller;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.PcGameRepositoryImpl;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.PcGameService;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service.PcGameServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pcGame")
public class PcGameServlet extends HttpServlet {

    private final PcGameService pcGameService;

    public PcGameServlet() {
        this.pcGameService = new PcGameServiceImpl(new PcGameRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<PcGame> pcGames = pcGameService.getPcGames();
       req.setAttribute("pcGames", pcGames);
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
        String title = req.getParameter("title");
        String release_year = req.getParameter("year");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String currency = req.getParameter("currency");
        PcGame pcGame = new PcGame();
        pcGame.setTitle(title);
        pcGame.setYear(release_year);
        pcGame.setDescription(description);
        pcGame.getPrice().setValue(Double.valueOf(price));
        pcGame.getPrice().setCurrency(currency);

        pcGameService.addPcGame(pcGame);

        getServletContext().getRequestDispatcher("/pcGame.jsp").forward(req,resp);
    }

   /* private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            List<PcGame> pcGamesList = pcGameService.getPcGames();
            pcGamesList.forEach(it -> writer.write(it.toString()));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}

