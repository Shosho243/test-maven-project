package org.example;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void Info() {
        System.out.println("ФИО:" + fullName + "; Должность: " + position + "; Почта: "
                + email + "; Номер телефона: " + phoneNumber
                + "; Зарплата: " + salary + "; Возраст: " + age);
    }
}

