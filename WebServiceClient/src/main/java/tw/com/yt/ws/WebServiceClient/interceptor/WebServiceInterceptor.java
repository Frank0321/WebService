/**
 * @Description : web Service Interceptor
 * @ClassName : WebServiceInterceptor.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.interceptor;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

public class WebServiceInterceptor implements ClientInterceptor {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceInterceptor.class);

	@Override
	public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
		
		printLog("berfore soap : ", messageContext);
		
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
		
		printLog("after soap : ", messageContext);
		
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
		
		printLog("soap fault : ", messageContext);
		
		return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 列印 log
	 * 
	 * @param string
	 * @param messageContext
	 */
	private void printLog(String preString, MessageContext messageContext) {
		
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			
			// request 和 response (fault) 需要使用的物件不同，需要先判斷
			if (preString.contains("berfore")) {
				 messageContext.getRequest().writeTo(out);
			} else {
				messageContext.getResponse().writeTo(out);
			}
			
            String outStr = new String(out.toString("UTF-8"));
            LOGGER.info(preString + "\n" + outStr);
            
        } catch (Exception e) {
        	
            LOGGER.error("error...", e);
        }
		
	}

}
