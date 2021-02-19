package page.monad.gamification.game.badgeprocessors;

import java.util.List;
import java.util.Optional;

import page.monad.gamification.challenge.ChallengeSolvedEvent;
import page.monad.gamification.game.domain.BadgeType;
import page.monad.gamification.game.domain.ScoreCard;

public interface BadgeProcessor {

    /**
     * Processes some or all of the passed parameters and decides if the user
     * is entitled to a badge.
     *
     * @return a BadgeType if the user is entitled to this badge, otherwise empty
     */
    Optional<BadgeType> processForOptionalBadge(int currentScore,
                                                List<ScoreCard> scoreCardList,
                                                ChallengeSolvedEvent solved);

    /**
     * @return the BadgeType object that this processor is handling. You can use
     * it to filter processors according to your needs.
     */
    BadgeType badgeType();

}
