package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.service.InMemoryStudentService;

@Controller
public class StudentController {
  private final StudentService studentService;

  public StudentController(){
    studentService = new InMemoryStudentService();
  }

  @RequestMapping("/student/add")
  public String add(@RequestParam(value = "npm", required = true) String npm,
      @RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "gpa", required = true) double gpa) {
    StudentModel student = new StudentModel(npm, name, gpa);
    studentService.addStudent(student);
    return "add";
  }

  @RequestMapping("/student/view")
  public String view(Model model, @RequestParam(value = "npm", required = true) String npm) {
    StudentModel student = studentService.selectStudent(npm);
    model.addAttribute("student", student);
    return "view";
  }
}
