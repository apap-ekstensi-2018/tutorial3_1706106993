package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
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

  // @RequestMapping("/student/view")
  // public String view(Model model, @RequestParam(value = "npm", required = true) String npm) {
  //   StudentModel student = studentService.selectStudent(npm);
  //   model.addAttribute("student", student);
  //   return "view";
  // }

  @RequestMapping("/student/view/{npm}")
  public String view(Model model, @PathVariable Optional<String> npm){
    if(npm.isPresent()){
      StudentModel student = studentService.selectStudent(npm.get());
      if(student != null){
        model.addAttribute("student", student);
        return "view";
      }
    }
    model.addAttribute("npm", npm.get());
    return "student_not_found";
  }

  @RequestMapping("/student/viewall")
  public String viewAll(Model model){
    List<StudentModel> students = studentService.selectAllStudents();
    model.addAttribute("students", students);
    return "viewall";
  }

  @RequestMapping("/student/delete/{npm}")
  public String delete(Model model, @PathVariable Optional<String> npm){
    if(npm.isPresent()){
      StudentModel student = studentService.delete(npm.get());
      if(student != null){
        model.addAttribute("student", student);
        return "delete";
      }
    }
    model.addAttribute("npm", npm.get());
    return "delete_fail";
  }
}
