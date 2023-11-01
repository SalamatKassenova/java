import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void printSortedPhoneBook() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        
        // Сортируем записи по убыванию размера множества номеров
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Демонстрация использования
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иван", "12345");
        phoneBook.addContact("Петя", "23456");
        phoneBook.addContact("Коля", "34567");
        phoneBook.addContact("Ваня", "45678");
        phoneBook.addContact("Петя 2", "56789");
        phoneBook.addContact("Маша", "67890");

        phoneBook.printSortedPhoneBook();
    }
}