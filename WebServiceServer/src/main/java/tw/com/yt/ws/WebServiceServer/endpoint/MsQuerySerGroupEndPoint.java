/**
 * @Description : MsQuerySerGroup 業務邏輯的進入點
 * @ClassName : MsQuerySerGroupEndPoint.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceServer.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tw.com.yt.ws.WebServiceServer.init.initDataMsQuerySerGroupService;
import tw.com.yt.ws.WebServiceServer.msquerysergroup.MsQuerySerGroup;
import tw.com.yt.ws.WebServiceServer.msquerysergroup.MsQuerySerGroupResponse;

@Endpoint
public class MsQuerySerGroupEndPoint {

    private static final String NAMESPACE_URI = "http://www.richbank.com.tw/";
	
    private static final Logger LOGGER = LoggerFactory.getLogger(MsQuerySerGroupEndPoint.class);
    
    /***
     * 
     * 
     * @param request
     * @return
     * @throws InterruptedException
     */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "MsQuerySerGroup")
    public @ResponsePayload MsQuerySerGroupResponse getGroupResponse(@RequestPayload MsQuerySerGroup request)
            throws InterruptedException {
		
		LOGGER.info("start endPoint...");
    	
		initDataMsQuerySerGroupService service = new initDataMsQuerySerGroupService();
		MsQuerySerGroupResponse response = service.findOne(request.getBranch());
        
		LOGGER.info("end endPoint...");
		
        return response;
    }
	
}
