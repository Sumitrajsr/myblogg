package com.myblogg;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
//        List<Employee> employees= Arrays.asList(new Employee("mike",30,"chennai"),
//                new Employee("styling",31,"chennai"),
//                new Employee("adam",25,"pune"),
//                new Employee("sam",34,"bengaluru")
//
//        );
//        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
////        List<Employee> emps = employees.stream().filter(emp -> emp.getName().startsWith("s")).collect(Collectors.toList());
//        for (Employee e:emps){
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//            System.out.println(e.getCity());
//        }
//        new TestClass1().test().example();
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("Testing"));




    }
//    public TestClass1 test(){
////        System.out.println(100);
//        return  new TestClass1();
//    }
//    public void example(){
//        System.out.println("hello");
//    }


}
