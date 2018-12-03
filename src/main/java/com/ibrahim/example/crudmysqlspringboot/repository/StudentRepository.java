package com.ibrahim.example.crudmysqlspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibrahim.example.crudmysqlspringboot.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
