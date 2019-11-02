package example.service.letter.controller;

import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * Controller responsible for generating random letters.
 */
@Controller
public class RandomLetterController {
    private static final Logger LOG = LoggerFactory.getLogger(RandomLetterController.class);

    private static final Random RAND = new Random(System.currentTimeMillis());

    /**
     * Get a random letter.
     *
     * @return a {@link Mono} of a random letter
     */
    @MessageMapping("randomLetter")
    public Mono<String> randomLetter() {
        return Mono.fromSupplier(() -> {
            char c = (char) (RAND.nextInt(26) + 'a');
            return Character.toString(c);
        });
    }

    /**
     * Get a stream of random letters.
     *
     * @return a {@link Flux} of random letters
     */
    @MessageMapping("randomLetters")
    public Flux<String> randomLetters() {
        return Flux.from(s -> s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                for (int i = 0; i < n; i++) {
                    char c = (char) (RAND.nextInt(26) + 'a');
                    s.onNext(Character.toString(c));
                }

                s.onComplete();
            }

            @Override
            public void cancel() {
                LOG.info("Stream Cancelled - randomLetters");
            }
        }));
    }

    @MessageExceptionHandler
    public Mono<Exception> exceptionHandler(Exception e) {
        return Mono.just(e);
    }
}
