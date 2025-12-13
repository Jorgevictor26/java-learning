/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class Student {

    private int UserCode;

    public Student(int UserCode) {
        this.UserCode = UserCode;
    }

    public int getUserCode() {
        return UserCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.UserCode;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.UserCode == other.UserCode;
    }

}
