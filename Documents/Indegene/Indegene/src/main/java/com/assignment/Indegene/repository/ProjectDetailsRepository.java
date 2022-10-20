package com.assignment.Indegene.repository;

import com.assignment.Indegene.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails,Long> {
    @Query("select pd from ProjectDetails pd join Project p on p.id=pd.project.id where p.id=:id")
    public Optional<ProjectDetails> getProjectDetailsById(@Param("id") Long id);
}
