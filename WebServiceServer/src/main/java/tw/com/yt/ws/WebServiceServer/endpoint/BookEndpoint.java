/**
 * @Description : Book 業務邏輯的進入點
 * @ClassName : BookEndpoint.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/05/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceServer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tw.com.yt.ws.WebServiceServer.book.Book;
import tw.com.yt.ws.WebServiceServer.book.GetBookRequest;
import tw.com.yt.ws.WebServiceServer.book.GetBookResponse;
import tw.com.yt.ws.WebServiceServer.init.InitDataBookService;

@Endpoint
public class BookEndpoint {
	
    private static final String NAMESPACE_URI = "http://WebServiceServer.ws.yt.com.tw/book";
    
    @Autowired
    private InitDataBookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    public @ResponsePayload GetBookResponse getBookByIsbn(@RequestPayload GetBookRequest request)
            throws InterruptedException {
    	
        GetBookResponse response = new GetBookResponse();
        Book book = bookService.findBookByIsbn(request.getIsbn());
        response.setBook(book);
        
        return response;
    }

}
