package example.client.config;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.MetadataExtractor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class ClientConfiguration {

    @Bean
    public RSocket letterRSocket() {
        return RSocketFactory.connect()
                .mimeType(MetadataExtractor.ROUTE_KEY, MimeTypeUtils.TEXT_PLAIN_VALUE)
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .transport(TcpClientTransport.create(7001))
                .start()
                .block();
    }

    @Bean
    public RSocket numberRSocket() {
        return RSocketFactory.connect()
                .mimeType(MetadataExtractor.ROUTE_KEY, MimeTypeUtils.TEXT_PLAIN_VALUE)
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .transport(TcpClientTransport.create(7002))
                .start()
                .block();
    }

    @Bean
    public RSocketRequester letterRSocketRequester(RSocketStrategies rSocketStrategies) {
        return RSocketRequester.wrap(letterRSocket(), MimeTypeUtils.TEXT_PLAIN, MimeTypeUtils.TEXT_PLAIN, rSocketStrategies);
    }

    @Bean
    public RSocketRequester numberRSocketRequester(RSocketStrategies rSocketStrategies) {
        return RSocketRequester.wrap(numberRSocket(), MimeTypeUtils.TEXT_PLAIN, MimeTypeUtils.TEXT_PLAIN, rSocketStrategies);
    }
}
