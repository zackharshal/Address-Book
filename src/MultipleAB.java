import java.util.*;
import java.util.stream.Collectors;

public class MultipleAB {
    static HashMap<String, AddressBook> multipleAB = new HashMap<>();
    static HashMap<String, Set<AddressBook>> cityPersonMap = new HashMap<>();
    static HashMap<String, Set<AddressBook>> statePersonMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("1. Add new address book");
            System.out.println("2. Search person by city or state");
            System.out.println("3. View persons by city");
            System.out.println("4. View persons by state");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the name of the address book: ");
                    String name = scanner.nextLine();
                    AddressBook addressBook = new AddressBook();
                    multipleAB.put(name, addressBook);
                    addressBook.manageContacts();
                }
                case 2 -> {
                    System.out.println("Enter city or state to search: ");
                    String location = scanner.nextLine();
                    searchPersonByCityOrState(location);
                }
                case 3 -> {
                    System.out.println("Enter city to view persons: ");
                    String city = scanner.nextLine();
                    viewPersonsByCity(city);
                }
                case 4 -> {
                    System.out.println("Enter state to view persons: ");
                    String state = scanner.nextLine();
                    viewPersonsByState(state);
                }
                case 5 -> check = false;
                default -> System.out.println("Wrong number/key pressed.");
            }
        }

        for (String key : multipleAB.keySet()) {
            System.out.println("Details of " + key);
            multipleAB.get(key).printInfo();
            System.out.println();
        }
    }

    public static void updateDictionaries(String city, String state, AddressBook contact) {
        cityPersonMap.computeIfAbsent(city, k -> new HashSet<>()).add(contact);
        statePersonMap.computeIfAbsent(state, k -> new HashSet<>()).add(contact);
    }

    public static void searchPersonByCityOrState(String location) {
        List<AddressBook> result = new ArrayList<>(cityPersonMap.getOrDefault(location, new HashSet<>()));
        result.addAll(statePersonMap.getOrDefault(location, new HashSet<>()));

        if (result.isEmpty()) {
            System.out.println("No contacts found in " + location);
        } else {
            result.forEach(System.out::println);
        }
    }

    public static void viewPersonsByCity(String city) {
        Set<AddressBook> persons = cityPersonMap.getOrDefault(city, new HashSet<>());
        if (persons.isEmpty()) {
            System.out.println("No contacts found in " + city);
        } else {
            persons.forEach(System.out::println);
        }
    }

    public static void viewPersonsByState(String state) {
        Set<AddressBook> persons = statePersonMap.getOrDefault(state, new HashSet<>());
        if (persons.isEmpty()) {
            System.out.println("No contacts found in " + state);
        } else {
            persons.forEach(System.out::println);
        }
    }
}
