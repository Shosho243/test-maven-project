package Homework13;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "897452719");
        phoneBook.add("Ivanov", "896452419");
        phoneBook.add("Semenov", "893452519");
        System.out.println("Телефоны фамилии Ivanov ");
        ArrayList<String> ivanovNumber = phoneBook.get("Ivanov");
        for (String number : ivanovNumber) {
            System.out.println(number);
        }
        System.out.println("Телефоны фамилии Semenov ");
        ArrayList<String> semenovNumber = phoneBook.get("Semenov");
        for (String number : semenovNumber) {
            System.out.println(number);
        }
    }
}


