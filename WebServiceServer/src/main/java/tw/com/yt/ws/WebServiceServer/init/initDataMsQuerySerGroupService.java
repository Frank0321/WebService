/**
 * @Description : init Data
 * @ClassName : initDataMsQuerySerGroupService.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/03, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceServer.init;

import java.util.ArrayList;
import java.util.List;

import tw.com.yt.ws.WebServiceServer.msquerysergroup.Data;
import tw.com.yt.ws.WebServiceServer.msquerysergroup.Group;
import tw.com.yt.ws.WebServiceServer.msquerysergroup.MsQuerySerGroupResponse;
import tw.com.yt.ws.WebServiceServer.msquerysergroup.Response;

public class initDataMsQuerySerGroupService {
	
	private static Group GROUP = new Group();
	
	/***
	 * create data
	 */
	private void initData() {
		
		List<Data> datas = new ArrayList<>();
		
		Data data1 = new Data();
		data1.setBranch("123");
		data1.setCallNumber("1");
		data1.setGroupID("A");
		data1.setName("data1");
		datas.add(data1);
		
		Data data2 = new Data();
		data2.setBranch("234");
		data2.setCallNumber("2");
		data2.setGroupID("A");
		data2.setName("data2");
		datas.add(data2);
		
		Data data3 = new Data();
		data3.setBranch("345");
		data3.setCallNumber("1");
		data3.setGroupID("B");
		data3.setName("data3");
		datas.add(data3);
		
		Data data4 = new Data();
		data4.setBranch("456");
		data4.setCallNumber("2");
		data4.setGroupID("B");
		data4.setName("data4");
		datas.add(data4);
		
		GROUP.setData(datas);
		
	}
	
	/***
	 * 找尋資料
	 * 
	 * @param groupID
	 * @return
	 */
	public MsQuerySerGroupResponse findOne(String groupID) {
		
		initData();
		
		List<Data> datas = GROUP.getData().stream()
												.filter(d -> d.getGroupID().equals(groupID))
												.toList();
		
		MsQuerySerGroupResponse groupResponse = new MsQuerySerGroupResponse();
		
		Response response = new Response();
		
		if (datas.size() != 0) {
			
			response.setCode("200");
			response.setDesc("成功");
			response.setTxSeq("666");
			response.setDateTime("2025/06/04");
			
			Group group = new Group();
			group.setData(datas);
			groupResponse.setGroup(group);
			
		} else {
			
			response.setCode("500");
			response.setDesc("失敗");
			response.setTxSeq("777");
			response.setDateTime("2025/06/04");
			
		}
		
		groupResponse.setResponse(response);
		
		return groupResponse;
	}

}
