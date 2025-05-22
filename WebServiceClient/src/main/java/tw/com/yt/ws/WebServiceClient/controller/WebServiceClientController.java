package tw.com.yt.ws.WebServiceClient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.yt.ws.WebServiceClient.book.Book;
import tw.com.yt.ws.WebServiceClient.book.GetBookRequest;
import tw.com.yt.ws.WebServiceClient.book.GetBookResponse;
import tw.com.yt.ws.WebServiceClient.service.BookClient;

@RestController
public class WebServiceClientController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(WebServiceClientController.class);
	
    @Autowired
    private BookClient client;

    // 接收 POST 請求，並通過 ISBN 查詢書籍
    @PostMapping("/getBook")
    public GetBookResponse getBook(@RequestBody String isbn) {
        GetBookResponse response = client.getBook(isbn);
        if (response != null) {
            Book resBookData = response.getBook();
            LOGGER.debug("Book Name:{} author:{} Currency:{} Population:{}", resBookData.getName(),
                    resBookData.getAuthor(), resBookData.getPublishing(), resBookData.getEdition());
        } else {
            LOGGER.debug("無法取得資訊...");
        }
        return response;
    }
}
