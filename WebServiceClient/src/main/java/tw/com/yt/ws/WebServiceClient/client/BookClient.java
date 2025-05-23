package tw.com.yt.ws.WebServiceClient.client;


import java.net.ConnectException;

import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import tw.com.yt.ws.WebServiceClient.book.GetBookRequest;
import tw.com.yt.ws.WebServiceClient.book.GetBookResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BookClient extends WebServiceGatewaySupport {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BookClient.class);

    public GetBookResponse getBook(String isbn) {

        GetBookRequest request = new GetBookRequest();
        request.setIsbn(isbn);

        GetBookResponse response = null;
        try {
            response = (GetBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (Exception ex) {
            if (ex.getCause() instanceof ConnectException) {
                LOGGER.error("Connect error ...", ex);
            } else if (ex.getCause() instanceof ConnectTimeoutException) {
                LOGGER.error("Connect time out error ...", ex);
            } else if (ex.getCause() instanceof SocketTimeoutException) {
                LOGGER.error("Read time out error ...", ex);
            } else {
                LOGGER.error("Other error ...", ex);
            }
        }

        return response;
    }

}
