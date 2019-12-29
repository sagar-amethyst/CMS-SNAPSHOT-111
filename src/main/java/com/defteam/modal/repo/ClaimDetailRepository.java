package com.defteam.modal.repo;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.defteam.modal.ClaimDetail;

//step 2 for create DATA ACESS LAYER but using spring data so no need to DAO(I) ,daoImp(C)
public interface ClaimDetailRepository extends JpaRepository<ClaimDetail,Long>{

	//
	@Query("SELECT c FROM  ClaimDetail c where c.empId=ifnull(:empId,c.empId)")

	 List<ClaimDetail> findClaimDetails(@Param("empId") String empId);


	@Query("SELECT DISTINCT c.empId FROM ClaimDetail c")
	List<ClaimDetail> findDistinctEmployee();

	@Query("SELECT c FROM ClaimDetail c where c.id=:id")
	ClaimDetail getClaimDetailById(@Param("id")Long id);

	
}
