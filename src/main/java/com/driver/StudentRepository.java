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
        if(teacherStudentMap.containsKey(teacher)) {
            List<String> teacher_list = new ArrayList<>();
            teacherStudentMap.get(teacher);
            teacher_list.add(student);
            teacherStudentMap.put(teacher, teacher_list);
        } else {
            List<String> teacher_list = new ArrayList<>();
            teacher_list.add(student);
            teacherStudentMap.put(teacher, teacher_list);
        }
    }
    public  Student getStudentByName(String student) {
        return studentMap.get(student);
    }
    public Teacher getTeacherByName(String teacher) {
        return teacherMap.get(teacher);
    }
    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)) {
            studentList = teacherStudentMap.get(teacher);
        }
        return studentList;
    }
    public List<String> getAllStudents() {
        List<String> student_list = new ArrayList<>();
        for(String e : studentMap.keySet()) {
            student_list.add(e);
        }
        return student_list;
    }
    public void deleteTeacherByName(String teacher) {
        List<String> students_list = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)) {
            students_list = teacherStudentMap.get(teacher);
            for(String e : students_list) {
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
        for (List<String> student_list: teacherStudentMap.values()){
            for (String s: student_list){
                studentMap.remove(s);
            }
        }
        teacherMap.clear();
        teacherStudentMap.clear();
    }
}
