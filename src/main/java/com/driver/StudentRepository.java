package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    private  HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMap = new HashMap<String, List<String>>();  // teacher and list of students
    }

    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)) {
//            studentMap.put(student, studentMap.get(student));
//            teacherMap.put(teacher, teacherMap.get(teacher));

            List<String> currentStudents = new ArrayList<>();
            if(teacherStudentMap.containsKey(teacher)) {
                currentStudents = teacherStudentMap.get(teacher);
            }
            currentStudents.add(student);
            teacherStudentMap.put(teacher, currentStudents);
        }
    }
    public  Student getStudentByName(String student) {
        return studentMap.get(student);
    }
    public Teacher getTeacherByName(String teacher) {
        return teacherMap.get(teacher);
    }
    public List<String> getStudentsByTeacherName(String director) {
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMap.containsKey(director)) {
            studentList = teacherStudentMap.get(director);
        }
        return studentList;
    }
    public List<String> getAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }
    public void deleteTeacherByName(String teacher) {
        List<String> students = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)) {
            students = teacherStudentMap.get(teacher);
            for(String e : students) {
                if(studentMap.containsKey(e))
                    studentMap.remove(e);

            }
            teacherStudentMap.remove(teacher);
        }


        if(teacherMap.containsKey(teacher)) {
            teacherMap.remove(teacher);
        }
    }
    public void deleteAllTeachers() {
        HashSet<String> studentSet = new HashSet<>();
        for(String teacher : teacherStudentMap.keySet()) {
            for(String students : teacherStudentMap.keySet()) {
                studentSet.add(students);
            }
        }

        for(String e : studentSet) {
            if(studentMap.containsKey(e)) {
                studentMap.remove(e);
            }
        }
    }
}
