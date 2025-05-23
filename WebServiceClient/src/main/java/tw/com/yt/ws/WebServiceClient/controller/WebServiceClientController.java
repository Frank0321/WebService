package tw.com.yt.ws.WebServiceClient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tw.com.yt.ws.WebServiceClient.book.Book;
import tw.com.yt.ws.WebServiceClient.book.GetBookRequest;
import tw.com.yt.ws.WebServiceClient.book.GetBookResponse;
import tw.com.yt.ws.WebServiceClient.client.BookClient;
import tw.com.yt.ws.WebServiceClient.request.BookRequest;
import tw.com.yt.ws.WebServiceClient.response.BookResponse;

@Slf4j
@RestController
public class WebServiceClientController {
	
	private static final Logger log = LoggerFactory.getLogger(WebServiceClientController.class);
	
    @Autowired
    private BookClient client;

    // 接收 POST 請求，並通過 ISBN 查詢書籍
    @PostMapping("/getBook")
    public BookResponse getBook(@RequestBody BookRequest request) {
    	
        GetBookResponse getBookResponse = client.getBook(request.getIsbn());
        if (getBookResponse != null) {
            Book resBookData = getBookResponse.getBook();
            BookResponse response = new BookResponse();
            response.setIsbn(resBookData.getIsbn());
            response.setAuthor(resBookData.getAuthor());
            response.setEdition(resBookData.getEdition());
            response.setName(resBookData.getName());
            response.setPublishing(resBookData.getPublishing());
            log.info("Book info - ISBN: {}, Name: {}, Author: {}, Publishing: {}, Edition: {}",
                    resBookData.getIsbn(),
                    resBookData.getName(),
                    resBookData.getAuthor(),
                    resBookData.getPublishing(),
                    resBookData.getEdition());
            return response;
        } else {
            log.info("查無資料");
            return null;
        }
    }
}
