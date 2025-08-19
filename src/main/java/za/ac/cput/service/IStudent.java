package za.ac.cput.service;

import za.ac.cput.domain.Student;

import java.util.List;

public interface IStudent extends IService <Student, Long> {

     List<Student> findAllStudent();

}
