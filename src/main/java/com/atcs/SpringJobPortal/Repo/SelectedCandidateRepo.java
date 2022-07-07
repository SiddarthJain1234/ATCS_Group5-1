package com.atcs.SpringJobPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atcs.SpringJobPortal.Entity.SelectedCandidates;

public interface SelectedCandidateRepo extends JpaRepository<SelectedCandidates, Integer>{

}
