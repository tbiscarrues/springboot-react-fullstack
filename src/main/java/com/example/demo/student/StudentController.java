/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import com.example.demo.exceptions.ItemNotFoundException;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amurillo
 */
@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> getAll(){       
        return service.getAll();
    }
    
    @PostMapping
    public void add(@Valid @RequestBody Student student){
         service.add(student);
    }
    
    @PutMapping
    public void update(@Valid @RequestBody Student student){
         service.update(student);
    }
    
    @DeleteMapping(path = "{studentId}")
    public void add(@PathVariable("studentId") Long studentId){
         service.delete(studentId);
    }
}
