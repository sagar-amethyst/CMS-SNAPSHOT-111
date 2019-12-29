package com.callippus.water.erp.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callippus.water.erp.domain.EmpLeaveBalance;
import com.callippus.water.erp.domain.EmpMaster;
import com.callippus.water.erp.domain.FamilyMaster;
import com.callippus.water.erp.domain.LeaveDetailsEntry;
import com.callippus.water.erp.domain.LeaveTypes;
import com.callippus.water.erp.domain.enumeration.EmpLeaveBalanceStatus;
import com.callippus.water.erp.domain.enumeration.genderField;
import com.callippus.water.erp.repository.EmpLeaveBalanceRepository;
import com.callippus.water.erp.repository.EmpMasterRepository;
import com.callippus.water.erp.repository.LeaveDetailsEntryRepository;
import com.callippus.water.erp.repository.LeaveRegisterRepository;
import com.callippus.water.erp.repository.LeaveTypesRepository;
import com.callippus.water.erp.repository.LeaveYearMasterRepository;
import com.callippus.water.erp.repository.StatusMasterRepository;
import com.callippus.water.erp.repository.UserRepository;
import com.callippus.water.erp.web.rest.util.HeaderUtil;
import com.callippus.water.erp.web.rest.util.PaginationUtil;
import com.codahale.metrics.annotation.Timed;

/**
 * REST controller for managing EmpLeaveBalance.
 */
@RestController
@RequestMapping("/api")
public class EmpLeaveBalanceResource {

    private final Logger log = LoggerFactory.getLogger(EmpLeaveBalanceResource.class);
        
    @Inject
    private EmpLeaveBalanceRepository empLeaveBalanceRepository;
    
    @Inject
    private EmpMasterRepository empMasterRepository;
    
    @Inject
    private LeaveTypesRepository leaveTypesRepository;
    
    @Inject
    private LeaveRegisterRepository leaveRegisterRepository;
    
    @Inject
    private StatusMasterRepository statusMasterRepository;
    
    @Inject 
    private LeaveDetailsEntryRepository leaveDetailsEntryRepository;
    
    @Inject
    private LeaveYearMasterRepository leaveYearMasterRepository;
    
    @Inject
	private UserRepository userRepository;


    
    /**
     * POST  /empLeaveBalances -> Create a new empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> createEmpLeaveBalance(@Valid @RequestBody EmpLeaveBalance empLeaveBalance) throws URISyntaxException {
        log.debug("REST request to save EmpLeaveBalance : {}", empLeaveBalance);
        if (empLeaveBalance.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("empLeaveBalance", "idexists", "A new empLeaveBalance cannot already have an ID")).body(null);
        }
        EmpLeaveBalance result = empLeaveBalanceRepository.save(empLeaveBalance);
        return ResponseEntity.created(new URI("/api/empLeaveBalances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("empLeaveBalance", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /empLeaveBalances -> Updates an existing empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> updateEmpLeaveBalance(@Valid @RequestBody EmpLeaveBalance empLeaveBalance) throws URISyntaxException {
        log.debug("REST request to update EmpLeaveBalance : {}", empLeaveBalance);
        if (empLeaveBalance.getId() == null) {
            return createEmpLeaveBalance(empLeaveBalance);
        }
        EmpLeaveBalance result = empLeaveBalanceRepository.save(empLeaveBalance);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("empLeaveBalance", empLeaveBalance.getId().toString()))
            .body(result);
    }

    /**
     * GET  /empLeaveBalances -> get all the empLeaveBalances.
     */
    @RequestMapping(value = "/empLeaveBalances",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<EmpLeaveBalance>> getAllEmpLeaveBalances(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of EmpLeaveBalances");
        
        //Page<EmpLeaveBalance> page = empLeaveBalanceRepository.findAll(pageable);
        EmpMaster empMaster = empMasterRepository.findLoginEmp();
        List<EmpLeaveBalance> empLeaveBalances=empLeaveBalanceRepository.findByEmpMaster(empMaster);
        Page<EmpLeaveBalance> page = empLeaveBalanceRepository.findByEmpMaster(pageable, empMaster); 
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/empLeaveBalances");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /empLeaveBalances/:id -> get the "id" empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> getEmpLeaveBalance(@PathVariable Long id) {
        log.debug("REST request to get EmpLeaveBalance : {}", id);
        EmpLeaveBalance empLeaveBalance = empLeaveBalanceRepository.findOne(id);
        return Optional.ofNullable(empLeaveBalance)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /empLeaveBalances/:id -> delete the "id" empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteEmpLeaveBalance(@PathVariable Long id) {
        log.debug("REST request to delete EmpLeaveBalance : {}", id);
        EmpLeaveBalance empLeaveBalance = empLeaveBalanceRepository.findOne(id);
        empLeaveBalance.setEmpLeaveBalanceStatus(EmpLeaveBalanceStatus.DEACTIVE);
        empLeaveBalanceRepository.save(empLeaveBalance);
        //empLeaveBalanceRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("empLeaveBalance", id.toString())).build();
    }
    
    /**
     * GET  /empLeaveBalances/:id -> get the "id" empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/getLeaveBalance",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> getEmployeeLeaveBalance(@Param("empMasterId") Long empMasterId,@Param("leaveTypesId") Long leaveTypesId) {
        log.debug("REST request to get EmpLeaveBalance : {}");
        EmpLeaveBalance empLeaveBalance =null;
        
        if(leaveTypesId ==3){
        	empLeaveBalance=empLeaveBalanceRepository.findByEmpMasterAndLeaveTypes(empMasterRepository.findOne(empMasterId),leaveTypesRepository.findOne(1l));
        }
        else{
        empLeaveBalance = empLeaveBalanceRepository.findByEmpMasterAndLeaveTypes(empMasterRepository.findOne(empMasterId),leaveTypesRepository.findOne(leaveTypesId));
        }
        return Optional.ofNullable(empLeaveBalance)
                .map(result -> new ResponseEntity<>(
                    result,
                    HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }
    


    /**
     * GET  /empLeaveBalances/:id -> get the "id" empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/getFieldsForLeave",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<EmpLeaveBalance>> getFieldsForLeave(@Param("userId") Long userId) {
        log.debug("REST request to get getFieldsForLeave : {}");
        
        List<EmpLeaveBalance> empLeaveBalances = new ArrayList<EmpLeaveBalance>();
        
        List<LeaveTypes> leaveTypess = new ArrayList<LeaveTypes>();
        
       // EmpMaster empMaster = empMasterRepository.findOne(empMasterId);
        
        EmpMaster empMaster = empMasterRepository.findByUser(userRepository.findOne(userId));
       
        empLeaveBalances = empLeaveBalanceRepository.findByEmpMaster(empMaster);
       
        
        if(empLeaveBalances.size() == 0){
        	 if(genderField.MALE.equals(empMaster.getGender())){
             	leaveTypess = leaveTypesRepository.getEligibleLeaveTypes();
             	
             }else if(genderField.FEMALE.equals(empMaster.getGender())){
             	leaveTypess = leaveTypesRepository.getFemaleEligibleLeaveTypes();
             }
        	
             for(LeaveTypes lt : leaveTypess){
            	EmpLeaveBalance empLeaveBalance = new EmpLeaveBalance();
            	/*LeaveDetailsEntry leaveDetailsEntry = leaveDetailsEntryRepository.findByLeaveTypes(lt);
            	
            	if("PERMANENT".equals(empMaster.getEmploymentTypeMaster().getName())){
            		empLeaveBalance.setUsedBalance(leaveDetailsEntry.getEmpParmenentLeaves());
            	}else if("CONTRACT".equals(empMaster.getEmploymentTypeMaster().getName())){
            		  empLeaveBalance.setUsedBalance(leaveDetailsEntry.getEmpContractLeaves());
            	}*/
            	
             	empLeaveBalance.setEmpMaster(empMaster);
             	empLeaveBalance.setLeaveTypes(lt);
             	empLeaveBalance.setNoOfDays(0);
             	/*empLeaveBalance.setUsedBalance(leaveDetailsEntry.getEmpParmenentLeaves());
             	empLeaveBalance.setAvliableBalance(0);*/
             	empLeaveBalance.setEmpLeaveBalanceStatus(EmpLeaveBalanceStatus.ACTIVE);
             	empLeaveBalances.add(empLeaveBalance);
             	
             }
        }
        
        return Optional.ofNullable(empLeaveBalances)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
    /**
     * POST  /empLeaveBalances -> Create a new empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/saveMultipleLeaves",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> saveMultipleLeaves(@Valid @RequestBody List<EmpLeaveBalance> empLeaveBalances,
    		@Param(value="id") Long id) throws URISyntaxException,Exception {
        log.debug("REST request to save saveMultipleLeaves : {}", empLeaveBalances);
       
       for(EmpLeaveBalance empLeaveBalance : empLeaveBalances){
        	String emp = empLeaveBalance.getEmpMaster().getEmploymentTypeMaster().getName();
        	
        	LeaveDetailsEntry leaveDetailsEntry = leaveDetailsEntryRepository.findByLeaveTypesAndStatus(empLeaveBalance.getLeaveTypes(),"1");
        	//LeaveDetailsEntry leaveDetailsEntry = leaveDetailsEntryRepository.findByLeaveTypes(empLeaveBalance.getLeaveTypes());
        	if(emp.equals("PERMANENT")){
        		empLeaveBalance.setUsedBalance(leaveDetailsEntry.getEmpParmenentLeaves());
        		empLeaveBalance.setAvliableBalance(empLeaveBalance.getUsedBalance()-empLeaveBalance.getNoOfDays());
            	
        	}else if(emp.equals("CONTRACT")){
        		empLeaveBalance.setUsedBalance(leaveDetailsEntry.getEmpContractLeaves());
        		empLeaveBalance.setAvliableBalance(empLeaveBalance.getUsedBalance()-empLeaveBalance.getNoOfDays());
        		
        	}
        	
        	empLeaveBalanceRepository.save(empLeaveBalance);
        }
        
        return null;
       
    }
    
    
    
    
    /**
     * GET  /empLeaveBalances/:id -> get the "id" empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/getLeave",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<EmpLeaveBalance>> getLeave(@Param("id") Long id) 
    {
        log.debug("REST request to get EmpLeaveBalance : {}", id);
        List<EmpLeaveBalance > empLeaveBalance = empLeaveBalanceRepository.findByLeave(id);
        return Optional.ofNullable(empLeaveBalance)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    
    /**
     * GET  /empLeaveBalances -> get all the getEmpLeaveBalances.
     */
    @RequestMapping(value = "/empLeaveBalances/getEmpAdminLeaveBalance",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<EmpLeaveBalance>> getEmpAdminLeaveBalance(@Param("empMasterId") Long empMasterId) throws URISyntaxException {
        log.debug("REST request to get getEmpLeaveBalance");
        
        EmpMaster empMaster= empMasterRepository.findOne(empMasterId);

        List<EmpLeaveBalance>  empLeaveBalance = empLeaveBalanceRepository.findByEmpMaster(empMaster);
        
        return new ResponseEntity<>(empLeaveBalance, HttpStatus.OK);
    }
    
    
    /**
     * PUT  /empLeaveBalances -> Create a new empLeaveBalance.
     */
    @RequestMapping(value = "/empLeaveBalances/updateMultipleLeaves",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<EmpLeaveBalance> updateMultipleLeaves(@Valid @RequestBody List<EmpLeaveBalance> empLeaveBalances) throws URISyntaxException,Exception {
        log.debug("REST request to save saveMultipleLeaves : {}", empLeaveBalances);
       
       for(EmpLeaveBalance empLeaveBalance : empLeaveBalances){
    	   EmpMaster empMaster=empLeaveBalance.getEmpMaster();
    	   LeaveTypes leaveTypes=empLeaveBalance.getLeaveTypes();
    	   EmpLeaveBalance balance=empLeaveBalanceRepository.findByEmpMasterAndLeaveTypes(empMaster,leaveTypes);
    	   
    	   if (empLeaveBalance.getNoOfDays() == 0) {
   			throw new Exception("First Save the Records");
   		   }

    	   balance.setNoOfDays(empLeaveBalance.getNoOfDays());
    	   balance.setUsedBalance(balance.getUsedBalance());
    	   balance.setAvliableBalance(balance.getUsedBalance()-balance.getNoOfDays());
    	   balance.setEmpLeaveBalanceStatus(empLeaveBalance.getEmpLeaveBalanceStatus());
    	   balance.setEmpMaster(empMaster);
    	   balance.setLeaveTypes(empLeaveBalance.getLeaveTypes());
           
    	   empLeaveBalanceRepository.save(balance);
        }
        
        return null;
       
        
    }

	
    
    
    
    
    
}
