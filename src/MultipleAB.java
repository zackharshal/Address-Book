import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MultipleAB {
    static HashMap<String, AddressBook> multipleAB = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("1. Add new address book");
            System.out.println("2. Search person by city or state");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the name of the address book: ");
                    String name = scanner.nextLine();
                    multipleAB.put(name, new AddressBook());
                }
                case 2 -> {
                    System.out.println("Enter city or state to search: ");
                    String location = scanner.nextLine();
                    searchPersonByCityOrState(location);
                }
                case 3 -> check = false;
                default -> System.out.println("Wrong number/key pressed.");
            }
        }

        for (String key : multipleAB.keySet()) {
            System.out.println("Details of " + key);
            multipleAB.get(key).printInfo();
            System.out.println();
        }
    }

    public static void searchPersonByCityOrState(String location) {
        List<AddressBook> results = multipleAB.values().stream()
                .flatMap(ab -> ab.contacts.stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(location) || contact.getState().equalsIgnoreCase(location))
                .toList();

        if (results.isEmpty()) {
            System.out.println("No contacts found in " + location);
        } else {
            results.forEach(contact -> {
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Address: " + contact.getAddress());
                System.out.println("City, State: " + contact.getCity() + ", " + contact.getState());
                System.out.println("Zipcode: " + contact.getZipCode());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println();
            });
        }
    }
}
