import java.util.HashMap;
import java.util.Scanner;

public class MultipleAB {
    static HashMap<String, AddressBook> multipleAB = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Enter the name of the address book: ");
            String name = scanner.next();
            multipleAB.put(name, new AddressBook());
            System.out.println("Do you want to add new address book?");
            String question = scanner.next();
            if (question.equalsIgnoreCase("no")) {
                check = false;
            }
        }
        for (String key : multipleAB.keySet()) {
            System.out.println("Details of " + key);
            multipleAB.get(key).printInfo();
            System.out.println("");
        }
    }
}
