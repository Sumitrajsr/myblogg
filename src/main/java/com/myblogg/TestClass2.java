package com.myblogg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass2 {
    public static void main(String[] args) {
        List<Employee> employees= Arrays.asList(new Employee("mike",30,"chennai"),
                new Employee("styling",34,"chennai"),
                new Employee("adam",25,"pune"),
                new Employee("sam",34,"bengaluru")

        );
        Map<Integer, List<Employee>> collectByAge = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
//        System.out.println(collect1);
        System.out.println("\nGrouped by Age:");
        collectByAge.forEach((age, employeeList) -> {
            System.out.println("Age: " + age);
            employeeList.forEach(employee -> {
                System.out.println("  Name: " + employee.getName() + ", City: " + employee.getCity());
            });
        });

        Map<String, List<Employee>> collectByCity = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
//        System.out.println(collect1);
        System.out.println("\nGrouped by City:");
        collectByCity.forEach((city, employeeList) -> {
            System.out.println("City: " + city);
            employeeList.forEach(employee -> {
                System.out.println("  Name: " + employee.getName() + ", Age: " + employee.getAge());
            });
        });
            
            
        }
    }

