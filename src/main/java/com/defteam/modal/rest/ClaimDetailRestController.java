package com.defteam.modal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defteam.modal.ClaimDetail;
import com.defteam.modal.service.ClaimDetailService;

@RestController
@RequestMapping("/api")
public class ClaimDetailRestController {
	
	@Autowired
	ClaimDetailService claimDetailService;
	
	@RequestMapping("/claims")  //saveLoc uri in action="/saveLoc" jsp
	public List<ClaimDetail> getLocation(){
		
		return claimDetailService.getAllLocation();
	}

}
