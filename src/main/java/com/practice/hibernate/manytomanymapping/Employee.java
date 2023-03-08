package com.practice.hibernate.manytomanymapping;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Employee {
    @Id
    private int employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @ManyToMany
    @JoinTable(name = "employee_project_join_table")
    private List<Project> projects;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, List<Project> projects) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.projects = projects;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
