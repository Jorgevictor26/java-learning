/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;

/**
 *
 * @author jorge-victor
 */
public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private ArrayList<HourContract> contractList = new ArrayList();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<HourContract> getContractList() {
        return contractList;
    }

    public void addContract(HourContract contract) {
        contractList.add(contract);
    }

    public void removeContract(HourContract contract) {
        contractList.remove(contract);

    }

    public Double income(int year, int month) {

        double sum = baseSalary;

        for (HourContract c : contractList) {

            int c_year = c.getDate().getYear();
            int c_month = c.getDate().getMonthValue();

            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Worker{" + "name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", department=" + department + ", contractList=" + contractList + '}';
    }
}
