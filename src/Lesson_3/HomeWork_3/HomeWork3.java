package Lesson_3.HomeWork_3;

import java.util.Set;

public class HomeWork3 {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Kosarev", "+7-985-556-25-25");
        phoneBook.add("Kosarev", "+7-985-556-25-25");
        phoneBook.add("Kosarev", "+7-902-123-00-00");
        phoneBook.add("Titov", "+7-985-556-25-01");
        phoneBook.add("Krilov", "+7-985-556-25-02");
        phoneBook.add("Pechkin", "+7-985-556-25-03");
        phoneBook.add("Komolov", "+7-985-556-25-04");

        Set<String>  allLastnames = phoneBook.getAllLastnames();

        for (String lastname : allLastnames) {
            System.out.printf("User  %s  have number phone %s %n", lastname, phoneBook.get(lastname));


        }

    }
}
