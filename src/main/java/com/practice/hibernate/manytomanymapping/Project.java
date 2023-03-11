package com.practice.hibernate.manytomanymapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int projectId;
    @Column(name="project_name")
    private String projectName;
    @ManyToMany
    private List<Employee> employees;

    public Project() {
    }
    public Project(int projectId, String projectName, List<Employee> employees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
