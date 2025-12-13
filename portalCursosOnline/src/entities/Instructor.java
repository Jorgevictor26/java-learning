/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jorge-victor
 */
public class Instructor {

    private String name;
    private Set<Course> courses = new HashSet<>();

    public Instructor(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course courses) {
        this.courses.add(courses);
    }

    public int getTotalStudents() {

        Set<Student> users = new HashSet<>();
        
        for (Course c : courses) {
            users.addAll(c.getStudents());
        }

        return users.size();
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

}
