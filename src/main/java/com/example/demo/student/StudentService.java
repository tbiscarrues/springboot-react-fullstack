/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ItemNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amurillo
 */
@Slf4j
@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;
 
    public List<Student> getAll() {
        return repository.findAll();
    }

    /**
     *
     * @param student
     */
    public void add(Student student) {       
        //Check if email is taken
        Boolean emailTaken = repository.selectExistsEmail(student.getEmail());
        if(emailTaken){
            throw new BadRequestException("Email is taken");
        } 
        repository.save(student);
    }
    
    @Transactional
    public void update(Student student) {
        log.debug("student update", student);
         Student dbItem = repository.findById(student.getId()).orElseThrow(()-> new ItemNotFoundException());
         /*
        if(!opt.isPresent()){
            throw new ItemNotFoundException();
        }*/
             
       dbItem.setName(student.getName());
       dbItem.setEmail(student.getEmail());
       dbItem.setGender(student.getGender());      
    }

    /**
     *
     * @param studentId
     */
    public void delete(Long studentId)  {
        Optional<Student> opt = repository.findById(studentId);        
        if(!opt.isPresent()){
            throw new ItemNotFoundException();
        }
       repository.delete(opt.get());
    }

   
}
