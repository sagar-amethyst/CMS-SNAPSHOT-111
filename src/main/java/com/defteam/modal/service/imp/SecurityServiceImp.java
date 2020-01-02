package com.defteam.modal.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.defteam.modal.service.SecurityService;
import com.defteam.modal.service.UserDetailService;

@Service
public class SecurityServiceImp implements SecurityService {

	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Override
	public boolean login(String username, String password) {

		UserDetails userDetails=userDetailService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
		 
		authenticationManager.authenticate(token);
		boolean result=token.isAuthenticated();
		if(result){
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return result;
	}

}
