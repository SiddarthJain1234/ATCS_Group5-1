package com.atcs.SpringJobPortal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atcs.SpringJobPortal.Entity.Job;
public interface JobRepo extends JpaRepository<Job,Integer> {

	Job findBylocation(String location);

	Job findByexp(int exp);

	List<Job> findBycompanyid(int cid);

	List<Job> findBydegreeReq(String degree);


}
