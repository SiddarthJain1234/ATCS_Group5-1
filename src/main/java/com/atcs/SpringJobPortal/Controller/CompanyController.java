package com.atcs.SpringJobPortal.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.SpringJobPortal.Entity.Company;
import com.atcs.SpringJobPortal.Entity.Job;
import com.atcs.SpringJobPortal.Entity.Message;
import com.atcs.SpringJobPortal.Entity.SelectedCandidates;
import com.atcs.SpringJobPortal.Entity.User;
import com.atcs.SpringJobPortal.Repo.CompanyRepo;
import com.atcs.SpringJobPortal.Repo.JobRepo;
import com.atcs.SpringJobPortal.Repo.MessageRepo;
import com.atcs.SpringJobPortal.Repo.SelectedCandidateRepo;
import com.atcs.SpringJobPortal.Repo.UserRepo;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyRepo cr;

	@Autowired
	JobRepo jr;
	
	@Autowired
	UserRepo ur;
	
	@Autowired
	SelectedCandidateRepo sr;
	
	
	@Autowired
	MessageRepo mr;
	
	
	@GetMapping("/")
	public List<Company> get() {
		return cr.findAll();
	}
	
	
	//change the view order of jobs only string working
	@GetMapping("/sortjobs/{order}")
	public List<Job> getbyorder(@PathVariable String order) {
		return jr.findAll(Sort.by(order));
	}
	

	@PostMapping("/register")
	public List<Company> post(@RequestBody Company c) {
		cr.save(c);
		return cr.findAll();
	}

	@PostMapping("/postjob")
	public String jobpost(@RequestBody Job j){
		jr.save(j);
		return "JOb posted";
	}
	
	@PutMapping("/")
	public List<Company> put(@RequestBody Company r) {
		cr.save(r);
		return cr.findAll();
	}
	
	
	@PutMapping("/editjob")
	public String editJob(@RequestBody Job j) {
		jr.save(j);
		return "Job id "+j.getJob_id()+" Edited By Company "+j.getCompanyid();
	}
	
	
	@GetMapping("/appliedUser/{companyid}")
	public List<User> getAppliedUsers(@PathVariable int companyid){
	
	List<Job> ls =jr.findBycompanyid(companyid);
	List<User> applieduser=new ArrayList<User>();
	for(Job j :ls) {
		applieduser.addAll(j.getAppliedUsers());
	}
	return applieduser;	
	}
	
	
	//search user profile by exp,loc,degree
	@GetMapping("/viewuserbyexp/{exp}")
	public List<User> getUserbyExp(@PathVariable int exp){
		return ur.findByexp(exp);
	}
	
//	@GetMapping("/viewuserbyloc/{loc}")
//	public List<User> getUserbyLoc(@PathVariable String loc){
//		return ur.findByAddress(loc);
//	}

	
	@GetMapping("/viewuserbydegree/{degree}")
	public List<User> getUserbydegree(@PathVariable String degree){
		return ur.findByqualifications(degree);
	}
	
	
	@PostMapping("/selectcandidate/{user_id}")
	public String selectCandidate(@PathVariable int user_id) {
		User u=ur.findById(user_id).get();
		SelectedCandidates s=new SelectedCandidates(u.getUser_id(), u.getName(), u.getEmail(), u.getContactno(), u.getDob(), u.getGender(), u.getSkillSet(), u.getAddress(), u.getExp(), u.getQualifications());
		
		sr.save(s);
		return "candidate Selected";
	}
	
	
	@GetMapping("/getShortlisted")
	public List<SelectedCandidates> getShortlisted(){
	 return sr.findAll();
	}
	
	
	//fetch all messages
	@GetMapping("/showmessages")
	public List<Message> getmessage(){
	return	mr.findAll();
	}
	
	
	@GetMapping("/showmessage/{companyid}")
	public List<Message> getmsg(@PathVariable int companyid){
		List<Message> messages=mr.findAll();
		
		List<Message> listmsg=new ArrayList<Message>();
		
		for(Message m:messages) {
			if(m.getTo_companyid()==companyid)
				listmsg.add(m);
		}
		return listmsg;
	}
	
	

	@DeleteMapping("/{id}")
	public List<Company> delete(@PathVariable int id) {
		cr.deleteById(id);
		return cr.findAll();
	}
}
