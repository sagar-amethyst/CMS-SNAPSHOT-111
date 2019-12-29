package com.callippus.water.erp.repository;

import com.callippus.water.erp.domain.EmpLeaveBalance;
import com.callippus.water.erp.domain.EmpMaster;
import com.callippus.water.erp.domain.LeaveTypes;
import com.callippus.water.erp.domain.TadaRegister;
import com.callippus.water.erp.domain.enumeration.TadaAdvanceStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the EmpLeaveBalance entity.
 */
public interface EmpLeaveBalanceRepository extends JpaRepository<EmpLeaveBalance,Long> {

	EmpLeaveBalance findByEmpMasterAndLeaveTypes(EmpMaster empMaster, LeaveTypes leaveTypes);

	@Query("select e from EmpLeaveBalance e where e.empMaster.id=:id")
    List<EmpLeaveBalance> findByLeave(@Param("id") Long id);

	List<EmpLeaveBalance> findByEmpMaster(EmpMaster empMaster);

	Page<EmpLeaveBalance> findByEmpMaster(Pageable pageable, EmpMaster empMaster);
	
	
	

	@Query("select c from RequestWorkflowHistory r ,RequestMaster rm,CustomerComplaints c"
			+ " where r.domainObject=c.id and r.requestMaster.id=:reqType and c.complaintTypeMaster.id= :id ")
	public  List<CustomerComplaints> findByRequestType(@Param("reqType") Long reqType, @Param("id") Long id);
	
	@Query("SELECT c FROM  CustomerComplaints c, RequestWorkflowHistory r where r.requestMaster.id = ifnull(:reqType, r.requestMaster.id) "
			+ " and r.statusMaster.id = ifnull(:status, r.statusMaster.id) and c.can =ifnull(:can, c.can) "
			+ " and c.complaintDate=ifnull(:complaintDate,c.complaintDate) "
			+ " and c.id = r.domainObject and r.statusMaster.id != 5 and r.statusMaster.id != 6 "
			+ " and (r.requestMaster.id = 3 or r.requestMaster.id = 5 or r.requestMaster.id = 17)")
	public Page<CustomerComplaints> findComplaints(Pageable pageable, @Param("can") String can,
			@Param("status") Long status, @Param("reqType") Long reqType, @Param("complaintDate") String complaintDate);

	
	/*@Query("Select ccn from CustomerComplaints ccn where ccn.id like %:searchTerm% ")
	public List<CustomerComplaints> findByComplaintIdContaining(@Param("searchTerm")String searchTerm);*/
	
	@Query("Select c from CustomerComplaints c where c.id like %:id% ")
	public List<CustomerComplaints> searchNumber(@Param("id") Long id) ;
	
	public List<CustomerComplaints> findByIdLike(Long id) ;
	
	@Query("Select c from CustomerComplaints c, RequestWorkflowHistory r where  c.can =:can and c.id = r.domainObject and "
			+ "r.statusMaster.id = 3 and r.requestMaster.id in (3,5,17)")
	public List<CustomerComplaints> findPrevRequest(@Param("can")String can);

	

	

	

}
