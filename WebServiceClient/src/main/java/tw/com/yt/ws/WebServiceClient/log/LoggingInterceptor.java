package tw.com.yt.ws.WebServiceClient.log;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import java.io.ByteArrayOutputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingInterceptor implements ClientInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			messageContext.getRequest().writeTo(out);
			String outStr = new String(out.toString("UTF-8"));
			LOGGER.info("== req == messageContext:{}", outStr);
		} catch (Exception e) {
			LOGGER.error("error...", e);
		}

		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			messageContext.getResponse().writeTo(out);
			String outStr = new String(out.toString("UTF-8"));
			LOGGER.info("== res == messageContext:{}", outStr);
		} catch (Exception e) {
			LOGGER.error("error...", e);
		}
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			messageContext.getResponse().writeTo(out);
			String outStr = new String(out.toString("UTF-8"));
			LOGGER.info("== fault == messageContext:{}", outStr);
		} catch (Exception e) {
			LOGGER.error("error...", e);
		}
		return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
		if (ex != null) {
			if (ex instanceof ConnectException) {
				LOGGER.info("== aftercomplete == do with Connect error...");
			} else if (ex instanceof ConnectTimeoutException) {
				LOGGER.info("== aftercomplete == do with Connect timeout error...");
			} else if (ex instanceof SocketTimeoutException) {
				LOGGER.info("== aftercomplete == do with Read timeout ...");
			} else {
				LOGGER.error("== aftercomplete == do with other error ...", ex);
			}
		} else {
			LOGGER.info("== aftercomplete == do something ...");
		}
	}

}
