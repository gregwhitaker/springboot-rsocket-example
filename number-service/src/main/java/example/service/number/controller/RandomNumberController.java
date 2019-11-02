package example.service.number.controller;

import example.model.NumberResponse;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Controller responsible for generating random numbers.
 */
@Controller
public class RandomNumberController {
    private static final Logger LOG = LoggerFactory.getLogger(RandomNumberController.class);

    private static final Random RAND = new Random(System.currentTimeMillis());

    /**
     * Get a random number.
     *
     * @return a {@link Mono} of a random number
     */
    @MessageMapping("randomNumber")
    public Mono<NumberResponse> randomNumber() {
        return Mono.fromSupplier(() -> new NumberResponse(RAND.nextInt()));
    }

    /**
     * Get random numbers.
     *
     * @return a {@link Flux} of random numbers.
     */
    @MessageMapping("randomNumbers")
    public Flux<NumberResponse> randomNumbers() {
        return Flux.from(s -> s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                for (int i = 0; i < n; i++) {
                    s.onNext(new NumberResponse(RAND.nextInt()));
                }

                s.onComplete();
            }

            @Override
            public void cancel() {
                LOG.info("Stream Cancelled - randomNumbers");
            }
        }));
    }

    @MessageExceptionHandler
    public Mono<Exception> exceptionHandler(Exception e) {
        return Mono.just(e);
    }
}
