/**
 * @Description : 呼叫 soap 業務邏輯
 * @ClassName : RichBankServiceHelper.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.service.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import tw.com.yt.ws.WebServiceClient.interceptor.WebServiceInterceptor;
import tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup.MsQuerySerGroup;
import tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup.MsQuerySerGroupResponse;

@Service
public class RichBankServiceHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(RichBankServiceHelper.class);
	
	/**
	 * @param msRq
	 * @return
	 */
	public MsQuerySerGroupResponse send(MsQuerySerGroup msRq) {
		
		MsQuerySerGroupResponse msRes = new MsQuerySerGroupResponse();
		
		try {
			
			LOGGER.info("create Jaxb2Marshaller");
			
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
			marshaller.setContextPath("tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup");
			marshaller.afterPropertiesSet();
	        
	        LOGGER.info("create WebServiceTemplate");
			
	        WebServiceTemplate template = new WebServiceTemplate();
	        template.setMarshaller(marshaller);
	        template.setUnmarshaller(marshaller);
	        template.setInterceptors(new WebServiceInterceptor[] { new WebServiceInterceptor()});
	        
	        msRes = (MsQuerySerGroupResponse) template.marshalSendAndReceive("http://localhost:8090/msQuerySerGroup", msRq);
	        
		} catch (Exception e) {
			LOGGER.error("error", e);
		}

		return msRes;
	}

}
