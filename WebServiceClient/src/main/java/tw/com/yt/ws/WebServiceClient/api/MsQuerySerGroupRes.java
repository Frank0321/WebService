/**
 * @Description : TODO
 * @ClassName : MsQuerySerGroupRes.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.api;

import java.util.List;

public class MsQuerySerGroupRes {

	List<MsQuerySerGroupResData> data;

	/**
	 * @return the data
	 */
	public List<MsQuerySerGroupResData> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<MsQuerySerGroupResData> data) {
		this.data = data;
	}
	
	
	
}
