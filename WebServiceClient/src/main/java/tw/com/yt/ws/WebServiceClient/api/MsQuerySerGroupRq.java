/**
 * @Description : TODO
 * @ClassName : MsQuerySerGroupRq.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.api;

public class MsQuerySerGroupRq {

	private String txSeq;
	
	private String wsid;
	
	private String branch;

	/**
	 * @return the txSeq
	 */
	public String getTxSeq() {
		return txSeq;
	}

	/**
	 * @param txSeq the txSeq to set
	 */
	public void setTxSeq(String txSeq) {
		this.txSeq = txSeq;
	}

	/**
	 * @return the wsid
	 */
	public String getWsid() {
		return wsid;
	}

	/**
	 * @param wsid the wsid to set
	 */
	public void setWsid(String wsid) {
		this.wsid = wsid;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
}
