package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.service;

import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity.PcGame;
import by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.repository.PcGameRepository;

import java.util.List;

    public class PcGameServiceImpl implements PcGameService {

        private final PcGameRepository pcGameRepository;

        public PcGameServiceImpl(PcGameRepository pcGameRepository) {
            this.pcGameRepository = pcGameRepository;
        }

        @Override
        public List<PcGame> getPcGames() {
            List<PcGame> pcGamesList = pcGameRepository.getPcGame();
            System.out.println("Internal application service logic");
            return pcGamesList;
        }

        @Override
        public PcGame addPcGame (PcGame pcGame) {
            return pcGame;
        }
}


