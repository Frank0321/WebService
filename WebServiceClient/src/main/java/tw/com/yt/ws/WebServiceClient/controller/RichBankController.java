/**
 * @Description : RichBank API 入口點
 * @ClassName : RichBankController.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/06/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceClient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tw.com.yt.ws.WebServiceClient.api.MsQuerySerGroupRes;
import tw.com.yt.ws.WebServiceClient.api.MsQuerySerGroupRq;
import tw.com.yt.ws.WebServiceClient.service.RichBankService;

@RestController
public class RichBankController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(RichBankController.class);

	@Autowired
	private RichBankService service;
	
	@GetMapping("/msQuerySerGroup/{branch}")
	public ResponseEntity<MsQuerySerGroupRes> msQuerySerGroup (@PathVariable("branch") String branch){
		
		LOGGER.info("start controller...");
		
		// 轉換成 req
		MsQuerySerGroupRq rq = new MsQuerySerGroupRq();
		rq.setBranch(branch);
		
		MsQuerySerGroupRes res = service.msQuerySerGroup(rq);
		
		LOGGER.info("end controller...");
		
		return ResponseEntity.ok(res);
	}
	
}
