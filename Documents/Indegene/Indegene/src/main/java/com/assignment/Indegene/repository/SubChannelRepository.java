package com.assignment.Indegene.repository;

import com.assignment.Indegene.entity.SubChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubChannelRepository extends JpaRepository<SubChannel,Long> {
}
