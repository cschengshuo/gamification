package page.monad.gamification.game;

import java.util.List;

import page.monad.gamification.game.domain.LeaderBoardRow;

public interface LeaderBoardService {

    /**
     * @return the current leader board ranked from high to low score
     */
    List<LeaderBoardRow> getCurrentLeaderBoard();
}
