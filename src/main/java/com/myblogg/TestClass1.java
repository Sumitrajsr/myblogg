package com.myblogg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
        List<Employee> employees= Arrays.asList(new Employee("mike",30,"chennai"),
                new Employee("styling",31,"chennai"),
                new Employee("adam",25,"pune"),
                new Employee("sam",34,"bengaluru")

        );
        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
//        List<Employee> emps = employees.stream().filter(emp -> emp.getName().startsWith("s")).collect(Collectors.toList());
        for (Employee e:emps){
            System.out.println(e.getName());
            System.out.println(e.getAge());
            System.out.println(e.getCity());
        }
    }
    

}
