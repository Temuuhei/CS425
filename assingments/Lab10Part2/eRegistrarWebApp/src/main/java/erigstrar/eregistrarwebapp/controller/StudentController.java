package erigstrar.eregistrarwebapp.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import erigstrar.eregistrarwebapp.model.Student;
import erigstrar.eregistrarwebapp.repository.StudentRepository;
import erigstrar.eregistrarwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( value = {"/eregistrar/student"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping( value = {"/list"})
    public ModelAndView listStudents() {
        var students = studentService.getAllStudents();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/student/new";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping( value = {"/edit/{studentId}"})
    public String displayEditStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }

        return "redirect:/eregistrar/student/list";

    }

    @PostMapping(value = {"/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult, Model model) {
        // if (bindingResult.hasErrors()) {
        //     model.addAttribute("student", student);
        //     model.addAttribute("errors", bindingResult.getAllErrors());
        //     return "secured/student/edit";
        // }
        // student.setEnrollmentDate(LocalDate.of(2021,12,12));
        studentService.updateStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/delete/{studentId}"}) //TODO Change to use QueryString param
    public String deleteStudent(@PathVariable Integer studentId) {

        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

    // Search by first_name
    @GetMapping( value = {"/search"})
    public ModelAndView searchedStudents(String firstName) {
        List<Student> students = studentService.getAllStudentsByName(firstName);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }


}
