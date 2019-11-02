package example.client;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

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
        letterRSocketRequester.route("randomLetters")
                .retrieveFlux(String.class)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        LOG.info("Requesting 10 letters...");
                        s.request(10);
                    }

                    @Override
                    public void onNext(String s) {
                        LOG.info(s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        LOG.error("An error occured during processing", t);
                    }

                    @Override
                    public void onComplete() {
                        LOG.info("Done");
                    }
                });
    }
}
