package com.assignment.Indegene.entity;

import javax.persistence.*;

@Entity
@Table(name = "`PROJECT_DETAILS`")
public class ProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PROJECT_DETAILS_ID`", nullable = false)
    private Long id;
    @Column(name = "`BRAND_NAME`")
    private String brandName;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`PROJECT_ID`",referencedColumnName = "`PROJECT_ID`")
    private Project project;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`CHANNEL_ID`",referencedColumnName = "`CHANNEL_ID`")
    private Channel channel;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="`SUB_CHANNEL_ID`",referencedColumnName = "`SUBCHANNEL_ID`")
    private SubChannel subChannel;
    public Long getId() {
        return id;
    }

    public ProjectDetails() {
    }

    public ProjectDetails(String brandName, Project project, Channel channel, SubChannel subChannel) {
        this.brandName = brandName;
        this.project = project;
        this.channel = channel;
        this.subChannel = subChannel;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public SubChannel getSubChannel() {
        return subChannel;
    }

    public void setSubChannel(SubChannel subChannel) {
        this.subChannel = subChannel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", project=" + project +
                ", channel=" + channel +
                ", subChannel=" + subChannel +
                '}';
    }
}
