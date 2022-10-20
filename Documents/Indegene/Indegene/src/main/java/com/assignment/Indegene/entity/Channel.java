package com.assignment.Indegene.entity;

import javax.persistence.*;

@Entity
@Table(name = "`CHANNEL`")
public class Channel {
    @Id
    @Column(name = "`CHANNEL_ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`CHANNEL_NAME`",length = 100)
    private String channelName;

    public Channel() {
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                '}';
    }

    public Channel(String channelName) {
        this.channelName = channelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
