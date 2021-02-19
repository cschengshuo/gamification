package page.monad.gamification.game;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import page.monad.gamification.challenge.ChallengeSolvedEvent;

@RequiredArgsConstructor
@Slf4j
@Service
public class GameEventHandler {

    private final GameService gameService;

    @RabbitListener(queues = "${amqp.queue.gamification}")
    void handleMultiplicationSolved(final ChallengeSolvedEvent event) {
        log.info("收到挑战解决事件：{}", event.getAttemptId());
        try {
            gameService.newAttemptForUser(event);
        } catch (Exception e) {
            log.error("处理ChallengeSolvedEvent时出现错误", e);
            // 避免事件重新处理
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
