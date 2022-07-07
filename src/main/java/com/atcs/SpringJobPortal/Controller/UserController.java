package com.atcs.SpringJobPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.SpringJobPortal.Entity.Job;
import com.atcs.SpringJobPortal.Entity.Message;
import com.atcs.SpringJobPortal.Entity.User;
import com.atcs.SpringJobPortal.Repo.CompanyRepo;
import com.atcs.SpringJobPortal.Repo.JobRepo;
import com.atcs.SpringJobPortal.Repo.MessageRepo;
import com.atcs.SpringJobPortal.Repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo ur;

	@Autowired
	JobRepo jr;

	@Autowired
	MessageRepo mr;

	@Autowired
	CompanyRepo c;
	
	@GetMapping("/")
	public List<User> get() {
		return ur.findAll();
	}

	@GetMapping("/viewjobs")
	public List<Job> getjobs(){
	return jr.findAll();	
	}
	
	@PostMapping("/register")
	public String post(@RequestBody User e) {
		ur.save(e);
		return "user registered";
	}

	@PutMapping("/applyJob")
	public String applyjob(@RequestBody User u) {
		//appliedUsers from job side 
		//appliedJobs from user side
		ur.save(u);
	List<Job> jobs=u.getAppliedJobs();
	
	try {
	for(Job j :jobs) {
		j.getAppliedUsers().add(u);
	}
	}
	catch (NullPointerException e) {
		
	}
		return "job applied";
	}
	
	@GetMapping("/appliedJobs/{userId}")
	public List<Job> appliedJobs(@PathVariable int userId){
		User u=ur.findById(userId).get();
		return u.getAppliedJobs();
	}
	
	@GetMapping("/viewbylocation/{loc}")
	public Job getjobbylocation(@PathVariable String loc){
		return jr.findBylocation(loc);
	}
	
	@GetMapping("/viewbyexp/{exp}")
	public Job getjobbyexp(@PathVariable int exp){
		return jr.findByexp(exp);	
	}

	
	//send message to company
	@PostMapping("/sendmessage")
	public String sendMessage(@RequestBody Message m) {
		mr.save(m);
		return "message successfullly sent to "+c.findById(m.getTo_companyid()).get().getName();
	}
	
	
	
	
	//find job by degree
	@GetMapping("/viewjobsbydegree/{degree}")
	public List<Job> getJobByDegree(@PathVariable String degree){
	return jr.findBydegreeReq(degree);
	}
	
	
	@DeleteMapping("/{id}")
	public List<User> delete(@PathVariable int id) {
		ur.deleteById(id);
		return ur.findAll();
	}
}
