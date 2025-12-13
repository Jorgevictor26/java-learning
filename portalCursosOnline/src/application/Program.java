/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Course;
import entities.Instructor;
import entities.Student;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Instructor's name: ");
        String instructorName = sc.nextLine();
        Instructor instructor = new Instructor(instructorName);

        System.out.print("How many courses does this instructor have? ");
        int numCourses = sc.nextInt();

        for (int i = 0; i < numCourses; i++) {
            sc.nextLine(); // clear buffer
            System.out.print("\nCourse name: ");
            String courseName = sc.nextLine();
            Course course = new Course(courseName);

            System.out.print("How many students in this course? ");
            int numStudents = sc.nextInt();

            for (int j = 0; j < numStudents; j++) {
                System.out.print("Student ID: ");
                int id = sc.nextInt();
                course.addStudent(new Student(id));
            }

            instructor.addCourses(course);
        }

        System.out.println( "\nTotal students for instructor " + instructor.getName() + ": " + instructor.getTotalStudents()
        );

        sc.close();
    }
}
