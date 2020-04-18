package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import java.util.List;

public interface PcGameRepository {

    List<PcGame> getPcGame();

    PcGame addPcGame(PcGame pcGame);

}
