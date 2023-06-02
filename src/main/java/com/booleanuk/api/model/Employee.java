package com.booleanuk.api.model;

public class Employee {
private int id;
private String name;
private String jobName;
private String salaryGrade;
private String department;

public Employee(int id, String name, String jobName, String salaryGrade, String department){
    this.id = id;
    this.name = name;
    this.jobName = jobName;
    this.salaryGrade = salaryGrade;
    this.department = department;
}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobName() {
        return jobName;
    }

    public String getSalaryGrade() {
        return salaryGrade;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        String result = "";
        result += this.id + " - ";
        result += this.name + " - ";
        result += this.jobName + " - ";
        return result;
    }

}
