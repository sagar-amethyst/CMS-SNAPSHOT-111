package com.defteam.modal.service.imp;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defteam.modal.ClaimDetail;
import com.defteam.modal.repo.ClaimDetailRepository;
import com.defteam.modal.service.ClaimDetailService;


@Service
public class ClaimDetailServiceImpl implements ClaimDetailService {
	
	@Autowired
	private ClaimDetailRepository claimDetailRepository;

	public ClaimDetail saveClaim(ClaimDetail claimdetail) {
		// TODO Auto-generated method stub
		return claimDetailRepository.save(claimdetail);
	}

/*	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}
*/
	@Override
	public void deleteLocation(ClaimDetail location) {
		claimDetailRepository.delete(location);
	}

	@Override
	public List<ClaimDetail> getAllLocation() {
		// TODO Auto-generated method stub
		return claimDetailRepository.findAll();
	}

	@Override
	public List<ClaimDetail> findAll() {
		// TODO Auto-generated method stub
		return claimDetailRepository.findAll();
	}

	@Override
	public ClaimDetail saveClaimDetail(ClaimDetail claimdetail) {
		// TODO Auto-generated method stub
		return claimDetailRepository.save(claimdetail);
	}


	@Override
	public Optional<ClaimDetail> getClaimDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClaimDetail> getClaimDetailById(BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}

}
