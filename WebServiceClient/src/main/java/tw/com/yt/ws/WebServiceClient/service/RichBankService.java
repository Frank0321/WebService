/**
 * @Description : TODO
 * @ClassName : RichBankService.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.yt.ws.WebServiceClient.api.MsQuerySerGroupRes;
import tw.com.yt.ws.WebServiceClient.api.MsQuerySerGroupResData;
import tw.com.yt.ws.WebServiceClient.api.MsQuerySerGroupRq;
import tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup.Data;
import tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup.MsQuerySerGroup;
import tw.com.yt.ws.WebServiceClient.richbank.msquerysergroup.MsQuerySerGroupResponse;
import tw.com.yt.ws.WebServiceClient.service.helper.RichBankServiceHelper;

@Service
public class RichBankService {

	@Autowired
	private RichBankServiceHelper helper;
	
	/**
	 * @param rq
	 * @return
	 */
	public MsQuerySerGroupRes msQuerySerGroup(MsQuerySerGroupRq rq) {
		
		// pre msRq
		MsQuerySerGroup msRq = new MsQuerySerGroup();
		msRq.setBranch(rq.getBranch());
		
		// send soap
		MsQuerySerGroupResponse res = helper.send(msRq);
		
		// pre Res
		MsQuerySerGroupRes serGroupRes = new MsQuerySerGroupRes();

		List<MsQuerySerGroupResData> resDatas = new ArrayList<>();
		
		for(Data data : res.getGroup().getData()) {
			
			MsQuerySerGroupResData resData = new MsQuerySerGroupResData();
			resData.setBranch(data.getBranch());
			resData.setGroupId(data.getGroupID());
			resData.setCallNumber(data.getCallNumber());
			resData.setName(data.getName());
			
			resDatas.add(resData);
			
		}
		
		serGroupRes.setData(resDatas);
		
		return serGroupRes;
	}

}
