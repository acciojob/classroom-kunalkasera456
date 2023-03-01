package com.driver;

import com.sun.source.tree.BreakTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        addStudentTeacherPair(student, teacher);
    }
    public Student getStudentByName(String studentName) {
        return StudentRepository.getStudentByName(studentName);
    }
    public Teacher getTeacherByName(String teacherName) {
        return studentRepository.getTeacherByName(teacherName);
    }
    public List<String> getStudentsByTeacherName(String director) {
        return studentRepository.getStudentsByTeacherName(director);
    }
    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }
    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }

}
