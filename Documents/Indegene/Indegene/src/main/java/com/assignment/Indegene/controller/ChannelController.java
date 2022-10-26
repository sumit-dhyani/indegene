package com.assignment.Indegene.controller;
import com.assignment.Indegene.entity.Channel;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.exceptions.RecordNotFound;
import com.assignment.Indegene.repository.ChannelRepository;
import com.assignment.Indegene.repository.ProjectDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("channel")
public class ChannelController {
    private final ChannelRepository channelRepository;
    private final ProjectDetailsRepository projectDetailsRepository ;
    public ChannelController(ChannelRepository channelRepository,ProjectDetailsRepository projectDetailsRepository){
        this.channelRepository=channelRepository;
        this.projectDetailsRepository=projectDetailsRepository;
    }
    @PostMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel createNewChannel(@PathVariable long id, @RequestBody Channel channel){
        Optional<ProjectDetails> projectDetails=projectDetailsRepository.findById(id);
        if(projectDetails.isPresent()){
        channel.setProjectDetails(projectDetails.get());
        }
        else{
            throw new RecordNotFound("Project with id:"+id+" not found");
        }
        return channelRepository.save(channel);
    }
}
