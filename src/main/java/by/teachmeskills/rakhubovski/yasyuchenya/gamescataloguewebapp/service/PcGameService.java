package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;

import java.util.List;

public interface PcGameService {

    List<PcGame> getPcGames();

    PcGame addPcGame(PcGame pcGame);
}
