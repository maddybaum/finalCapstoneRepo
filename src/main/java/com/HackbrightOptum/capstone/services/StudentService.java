package com.HackbrightOptum.capstone.services;

import com.HackbrightOptum.capstone.dtos.StudentAccommodationDto;
import com.HackbrightOptum.capstone.dtos.StudentDto;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentService {
    @Transactional
    void deleteStudentById(Long studentId);

    List<StudentAccommodationDto> getStudentAccomsById(Long studentId);

    void createStudent(StudentDto studentDto);

    @Transactional
    void increaseStudentAccommodationReceived(Long studentAccommodationId);

    List<StudentDto> getAllStudents();


}