/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amurillo
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(""
            + "SELECT CASE WHEN COUNT(s) > 0 THEN "
            + "TRUE ELSE FALSE END "
            + "FROM Student s "
            + "WHERE s.email = ?1"
    )
    Boolean selectExistsEmail(String email);
}
