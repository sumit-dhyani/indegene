package com.assignment.Indegene.repository;

import com.assignment.Indegene.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
