package page.monad.gamification.game.badgeprocessors;

import page.monad.gamification.challenge.ChallengeSolvedDTO;
import page.monad.gamification.game.domain.BadgeType;
import page.monad.gamification.game.domain.ScoreCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class GoldBadgeProcessor implements BadgeProcessor {

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore,
                                                       List<ScoreCard> scoreCardList,
                                                       ChallengeSolvedDTO solved) {
        return currentScore > 400 ?
                Optional.of(BadgeType.GOLD) :
                Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.GOLD;
    }
}
