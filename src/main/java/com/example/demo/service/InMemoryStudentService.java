package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.StudentModel;

public class InMemoryStudentService implements StudentService {
  private static List<StudentModel> studentList = new ArrayList<StudentModel>();

  @Override
  public StudentModel selectStudent(String npm) {
	StudentModel temp;
    // Implement
	for(StudentModel m : studentList) {
	  if(m.getNpm().equals(npm)) {
	    return m;
	  }
	}
    return null;
  }

  @Override
  public List<StudentModel> selectAllStudents() {
    return studentList;
  }

  @Override
  public void addStudent(StudentModel student) {
    studentList.add(student);
  }

  @Override
  public StudentModel delete(String npm){
    StudentModel temp = selectStudent(npm);
    if(temp != null && studentList.remove(temp)){
      return temp;
    }

    return null;
  }
}
