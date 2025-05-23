package tw.com.yt.ws.WebServiceClient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.yt.ws.WebServiceClient.book.Book;
import tw.com.yt.ws.WebServiceClient.book.GetBookResponse;
import tw.com.yt.ws.WebServiceClient.client.BookClient;

@SpringBootTest
public class WebServiceClientApplicationTests {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(WebServiceClientApplicationTests.class);

    @Test
    void contextLoads() {}
    
    @Autowired
    BookClient client;
}
