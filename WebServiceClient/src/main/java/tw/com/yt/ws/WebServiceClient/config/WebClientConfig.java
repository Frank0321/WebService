package tw.com.yt.ws.WebServiceClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import tw.com.yt.ws.WebServiceClient.log.LoggingInterceptor;
import tw.com.yt.ws.WebServiceClient.service.BookClient;

@Configuration
public class WebClientConfig {
	
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("tw.com.yt.ws.WebServiceClient.book");
        return marshaller;
    }

    @Bean
    public WebServiceMessageSender webServiceMessageSender() {
        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        sender.setConnectionTimeout(5 * 1000);
        sender.setReadTimeout(5 * 1000);
        return sender;
    }

    @Bean
    public BookClient wsClient(Jaxb2Marshaller marshaller, WebServiceMessageSender sender) {
        BookClient client = new BookClient();
        client.setDefaultUri("http://localhost:8090/bookService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMessageSender(sender);
        ClientInterceptor[] ci = {new LoggingInterceptor()};
        client.setInterceptors(ci);
        return client;
    }
}
