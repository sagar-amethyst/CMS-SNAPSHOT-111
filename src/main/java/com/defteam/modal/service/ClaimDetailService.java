package com.defteam.modal.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.defteam.modal.ClaimDetail;
import com.defteam.modal.repo.ClaimDetailRepository;

//3. After in application.properties file database connection configure
//4.create Service(I) which extends our localRepository(I)
//5.mark @Service annotation for Service(I)

public interface ClaimDetailService {

	ClaimDetail saveClaimDetail(ClaimDetail claimdetail); // save the object

	/*Location updateLocation(Location location);*/

	void deleteLocation(ClaimDetail location);


	List<ClaimDetail> getAllLocation();

	List<ClaimDetail> findAll();

	ClaimDetail saveClaim(ClaimDetail claimdetail);

	Optional<ClaimDetail> getClaimDetailById(Long id);

	Optional<ClaimDetail> getClaimDetailById(BigInteger id);



}
