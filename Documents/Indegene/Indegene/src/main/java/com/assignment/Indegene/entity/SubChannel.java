package com.assignment.Indegene.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "`SUBCHANNEL`")
public class SubChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SUBCHANNEL_ID`", nullable = false)
    private Long id;
    @Column(name = "`SUBCHANNEL_NAME`")
    private String subChannelName;

    @ManyToOne
    @JsonBackReference
    private ProjectDetails projectDetails;

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    public SubChannel() {
    }

    @Override
    public String toString() {
        return "SubChannel{" +
                "id=" + id +
                ", subChannelName='" + subChannelName + '\'' +
                '}';
    }

    public SubChannel(String subChannelName) {
        this.subChannelName = subChannelName;
    }

    public String getSubChannelName() {
        return subChannelName;
    }

    public void setSubChannelName(String subChannelName) {
        this.subChannelName = subChannelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
