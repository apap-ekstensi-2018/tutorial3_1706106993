package com.example.demo.model;

public class StudentModel{
  private String name;
  private String npm;
  private double gpa;

  public StudentModel(String npm, String name, double gpa){
    this.npm = npm;
    this.gpa = gpa;
    this.name = name;
  }

  public String getNpm() {
    return npm;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }
}
