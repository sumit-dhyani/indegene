package com.assignment.Indegene.repository;

import com.assignment.Indegene.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails,Long> {
   public Optional<ProjectDetails> findProjectDetailsByProject_Id(Long id);

   public List<ProjectDetails> findProjectDetailsByChannel_ChannelNameContainsIgnoreCase(String name);
}
