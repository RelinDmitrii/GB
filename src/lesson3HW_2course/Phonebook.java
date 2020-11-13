package lesson3HW_2course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String putContact = reader.readLine();
        Map<String, String> phonebook = new HashMap<>();
        addContact(phonebook, "89260606444", "Иванов");
        addContact(phonebook, "89260606443", "Петров");
        addContact(phonebook, "89260606234", "Иванов");
        scanPhoneBook(phonebook,putContact);

    }


    public static void addContact(Map<String, String> listPhoneBook, String phone, String name) {
        listPhoneBook.put(phone, name);
    }

    public static void scanPhoneBook(Map<String, String> listPhoneBook, String findID) {
        for (Map.Entry<String, String> i : listPhoneBook.entrySet()) {
            if (i.getValue().equals(findID)) {
                System.out.println(i);
            }
        }
    }

}

