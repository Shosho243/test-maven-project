package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employeeOne = new Employee("Сергей Серго Сергеевич ", "Стажер ",
                "Sergo@gmail.com", "+79063248209", 45000, 32);
        System.out.println("Задание 1");
        employeeOne.Info();
        System.out.println("Задание 2");
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Employee("Петров Петр Петрович", "Менеджер",
                "petrov@mail.com", "+79999876543", 60000, 40);
        persArray[2] = new Employee("Сидоров Сидор Сидорович", "Аналитик",
                "sidorov@mail.com", "+79997654321", 70000, 45);
        persArray[3] = new Employee("Смирнова Елена Петровна", "Бухгалтер",
                "smirnova@mail.com", "+79995432109", 55000, 38);
        persArray[4] = new Employee("Козлова Анна Владимировна", "HR-специалист",
                "kozlova@mail.com", "+79993210987", 45000, 32);
        for (Employee employee : persArray) {
            employee.Info();
        }
        System.out.println("Задание 3");
        Park park = new Park("Москва", "Центральный парк");
        Park.Attraction attraction = park.new Attraction("Американские горки", "10:00", "20:00", 350);
        attraction.parkInfo();


    }
}
