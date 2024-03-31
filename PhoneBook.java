import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонов
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        // Пример входных данных
        String[][] contacts = {
            {"Иван", "123-456-7890"},
            {"Мария", "456-789-0123"},
            {"Иван", "789-012-3456"},
            {"Петр", "234-567-8901"},
            {"Иван", "567-890-1234"},
            {"Мария", "901-234-5678"}
        };

        // Заполняем телефонную книгу
        for (String[] contact : contacts) {
            String name = contact[0];
            String phoneNumber = contact[1];

            // Если имя уже есть в книге, добавляем телефон к существующему списку
            if (phoneBook.containsKey(name)) {
                HashSet<String> phoneNumbers = phoneBook.get(name);
                phoneNumbers.add(phoneNumber);
            } else {
                // Если имя отсутствует в книге, создаем новую запись
                HashSet<String> phoneNumbers = new HashSet<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }

        // Создаем список записей для сортировки по количеству телефонов
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию количества телефонов
        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> entry1, Map.Entry<String, HashSet<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Выводим результат
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

