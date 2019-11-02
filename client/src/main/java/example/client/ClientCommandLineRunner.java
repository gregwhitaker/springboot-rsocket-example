package example.client;

import example.model.LetterRequest;
import example.model.LetterResponse;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Runs the client application.
 */
@Component
public class ClientCommandLineRunner implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ClientCommandLineRunner.class);

    @Autowired
    private RSocketRequester letterRSocketRequester;

    @Autowired
    private RSocketRequester numberRSocketRequester;

    @Override
    public void run(String... args) throws Exception {
        Flux<LetterResponse> randomLetters = letterRSocketRequester.route("randomLetters")
                .data(new LetterRequest(10))
                .retrieveFlux(LetterResponse.class);

        randomLetters.subscribe(letterResponse -> {
            System.out.println(letterResponse.getLetter());
        });
    }
}
