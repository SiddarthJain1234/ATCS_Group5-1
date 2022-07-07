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
import com.atcs.SpringJobPortal.Repo.JobRepo;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobRepo jr;

	@GetMapping("/")
	public List<Job> get() {
		return jr.findAll();
	}

	@PostMapping("/")
	public List<Job> post(@RequestBody Job j) {
		jr.save(j);
		return jr.findAll();
	}

	@PutMapping("/")
	public List<Job> put(@RequestBody Job je) {
		jr.save(je);
		return jr.findAll();
	}

	@DeleteMapping("/{id}")
	public List<Job> delete(@PathVariable int id) {
		jr.deleteById(id);
		return jr.findAll();
	}
}
