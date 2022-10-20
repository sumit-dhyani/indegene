package com.assignment.Indegene.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="`PROJECT`")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PROJECT_ID`", nullable = false)
    private Long id;
    @Column(name = "`PROJECT_NAME`",length = 100)
    private String projectName;
    @Column(name = "`CREATION_DATE`")
    @CreationTimestamp
    private LocalDate creationDate;
    @Column(name = "`PROJECT_COMPLETION_DATE`")
    private LocalDate projectCompletionDate;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getProjectCompletionDate() {
        return projectCompletionDate;
    }

    public void setProjectCompletionDate(LocalDate projectCompletionDate) {
        this.projectCompletionDate = projectCompletionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project(String projectName, LocalDate creationDate, LocalDate projectCompletionDate) {
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.projectCompletionDate = projectCompletionDate;
    }
    public Project(){

    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", creationDate=" + creationDate +
                ", projectCompletionDate=" + projectCompletionDate +
                '}';
    }
}
