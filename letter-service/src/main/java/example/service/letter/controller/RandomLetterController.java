package example.service.letter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RandomLetterController {
    private static final Logger LOG = LoggerFactory.getLogger(RandomLetterController.class);

    @MessageMapping("randomLetter")
    public Mono<String> randomLetter() {
        return null;
    }

    @MessageMapping("randomLetters")
    public Flux<String> randomLetters(int num) {
        return null;
    }

    @MessageExceptionHandler
    public Mono<Exception> exceptionHandler(Exception e) {
        return Mono.just(e);
    }
}
