		package com.defteam.modal.controller;
		
		
		import java.math.BigInteger;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.List;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.beans.propertyeditors.CustomDateEditor;
		import org.springframework.format.annotation.DateTimeFormat;
		import org.springframework.stereotype.Controller;
		import org.springframework.ui.Model;
		import org.springframework.ui.ModelMap;
		import org.springframework.web.bind.WebDataBinder;
		import org.springframework.web.bind.annotation.InitBinder;
		import org.springframework.web.bind.annotation.ModelAttribute;
		import org.springframework.web.bind.annotation.PathVariable;
		import org.springframework.web.bind.annotation.PutMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RequestMethod;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.http.MediaType;
		
		import com.defteam.modal.ClaimDetail;
		import com.defteam.modal.repo.ClaimDetailRepository;
		import com.defteam.modal.service.ClaimDetailService;
		
		@Controller
		public class ClaimDetailController {
		
		 @Autowired
		 private ClaimDetailService claimDetailService;
		
		 @Autowired
		 private ClaimDetailRepository claimDetailRepository;
		
		
		 @InitBinder
		 public void initBinder(WebDataBinder binder) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  sdf.setLenient(true);
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		 }
		
		
		 @RequestMapping("/claim_details")
		 public String showPage(ModelMap modelMap) {
		  return "claimDetail";
		 }
		
		
		 @RequestMapping(value = "/saveClaim", method = RequestMethod.POST,
		  produces = MediaType.APPLICATION_JSON_VALUE)
		 public String saveClaim(@ModelAttribute("claimdetail") ClaimDetail claimdetail, Model modelMap) {
		
		
		  System.out.println(claimdetail);
		  claimDetailService.saveClaimDetail(claimdetail);
		  return "redirect:displayClaimDetails";
		
		 }
		
		
		 @RequestMapping(value = "/allClaims", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		 public String getListOfClaimDetails(ModelMap modelMap) {
		
		  List < ClaimDetail > claims = claimDetailService.getAllLocation();
		  List < ClaimDetail > employees = claimDetailRepository.findDistinctEmployee();
		
		  System.out.println(employees);
		  modelMap.addAttribute("employees", employees);
		
		  //System.out.println(claims);
		  modelMap.addAttribute("claims", claims);
		
		  return "displayClaimDetails";
		
		 }
		
		
		
		 @RequestMapping(value = "/search", method = RequestMethod.GET,
		  produces = MediaType.APPLICATION_JSON_VALUE)
		 public String searchDetails(@RequestParam("empId") String empId,
		  @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
		  @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
		  ModelMap modelMap) {
		
		  //List<ClaimDetail> claims=claimDetailRepository.findClaimDetails(empId,startDate,endDate);
		
		  List < ClaimDetail > claims = claimDetailRepository.findClaimDetails(empId);
		  System.out.println(claims);
		  List < ClaimDetail > employees = claimDetailRepository.findDistinctEmployee();
		  employees.add(0, null);
		  System.out.println(employees);
		
		  modelMap.addAttribute("employees", employees);
		
		  modelMap.addAttribute("claims", claims);
		  return "displayClaimDetails";
		
		 }
		
		
		 /*	@RequestMapping(value="/updateClaim",method=RequestMethod.GET,
		 	        produces = MediaType.APPLICATION_JSON_VALUE)
		 	public String showUpdate(@RequestParam("id") BigInteger id,Model modelMap){
		 		
		 		ClaimDetail claim=claimDetailRepository.getClaimDetailById(id);
		 		modelMap.addAttribute("claim",claim);
		 		return "updateClaim";
		 		
		 	}
		 	*/
		 @RequestMapping(value = "/showUpdate/{id}")
		 public String showUpdate(@PathVariable("id") Long id, ModelMap modelMap) {
		
			//BigInteger bid = BigInteger.valueOf(id);	 
		  ClaimDetail claims = claimDetailRepository.getClaimDetailById(id);
		  System.out.println(claims);
		  modelMap.addAttribute("claim", claims);
		  return "/updateClaim";
		
		 }
		 @RequestMapping(value = "/showUpdate1/{id}", method = RequestMethod.GET,
				  produces = MediaType.APPLICATION_JSON_VALUE)
		 public String showUpdate1(@PathVariable("id") Long id, ModelMap modelMap) {
		
			//BigInteger bid = BigInteger.valueOf(id);
			 //ClaimDetail claims1=new ClaimDetail(); 
		  ClaimDetail claim = claimDetailRepository.getClaimDetailById(id);
		  if(claim.getIsUserCommit().equalsIgnoreCase("yes")){
			  claim.setStatus("APPROVED");
			  claimDetailService.saveClaimDetail(claim);
			  /*List < ClaimDetail > claims = claimDetailService.getAllLocation();
			 modelMap.addAttribute("claims", claims);*/
		
			 
			  return "redirect:/allClaims";
		  }else if(claim.getIsUserCommit().equalsIgnoreCase("")||claim.getIsUserCommit().equals(null)||claim.getIsUserCommit()==""||claim.getIsUserCommit()==null){
			/*
			  List < ClaimDetail > claims = claimDetailService.getAllLocation();
				 modelMap.addAttribute("claims", claims);
				 modelMap.addAttribute("msg", "CHECK IS USER COMMIT 'YES'");*/ 
				 return "redirect:/message";
			 }
		 
		  
		  System.out.println(claim);
		  modelMap.addAttribute("claim", claim);
		  return "updateClaim";
		
		 }
		 
		
		
		 @PutMapping(value = "/updateClaim",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
				    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
		 
		 
		 public String updateClaim(@ModelAttribute("claimdetail") ClaimDetail claimdetail, Model modelMap) {
		
		
		  //System.out.println(claimdetail);
		  claimDetailService.saveClaimDetail(claimdetail);
		  return "claimDetail";
		
		 }
		
		 
		 
		 @RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		 public String getMessage(ModelMap modelMap) {
		
		  List < ClaimDetail > claims = claimDetailService.getAllLocation();
		  List < ClaimDetail > employees = claimDetailRepository.findDistinctEmployee();
		
		  System.out.println(employees);
		  modelMap.addAttribute("employees", employees);
		
		  //System.out.println(claims);
		  modelMap.addAttribute("claims", claims);
		  modelMap.addAttribute("msg", "User not agreed..");

		
		  return "displayClaimDetails";
		
		 }
		 
		 
		 
		
		
		}