package example.service.number.controller;

import example.model.NumberRequest;
import example.model.NumberResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

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
    public Flux<NumberResponse> randomNumbers(NumberRequest numberRequest) {
        return Flux.from(s -> {
            for (int i = 0; i < numberRequest.getNumberOfNumbers(); i++) {
                s.onNext(new NumberResponse(RAND.nextInt()));
            }

            s.onComplete();
        });
    }
}
