import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    public int numOfContacts = 0;
    ArrayList<AddressBook> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    AddressBook() {
        // No call to addContact() in the constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    AddressBook(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Address: " + address + "\n" +
                "City: " + city + ", State: " + state + "\n" +
                "Zipcode: " + zipCode + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n";
    }

    public void printInfo() {
        contacts.stream()
                .sorted((c1, c2) -> (c1.getFirstName() + " " + c1.getLastName()).compareTo(c2.getFirstName() + " " + c2.getLastName()))
                .forEach(System.out::println);
    }

    public void manageContacts() {
        boolean condi = true;
        while (condi) {
            System.out.println("1. Add contact\t 2. Edit contact\t 3. Delete contact\t 4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addContact();
                case 2 -> editContact();
                case 3 -> deleteContact();
                case 4 -> condi = false;
                default -> System.out.println("Wrong number/key pressed.");
            }
        }
    }

    public void addContact() {
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the address: ");
        String address = scanner.nextLine();
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();
        System.out.print("Enter the state: ");
        String state = scanner.nextLine();
        System.out.print("Enter the zip code: ");
        String zipCode = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        AddressBook newContact = new AddressBook(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        if (contacts.stream().anyMatch(contact -> contact.equals(newContact))) {
            System.out.println("This contact already exists.");
        } else {
            contacts.add(newContact);
            numOfContacts++;
            MultipleAB.updateDictionaries(city, state, zipCode, newContact);
        }
    }

    public void editContact() {
        for (AddressBook cont : contacts) {
            System.out.println(cont.firstName);
        }
        System.out.println("Enter the first name of the contact you want to edit: ");
        String name = scanner.next();
        scanner.nextLine();
        for (AddressBook cont : contacts) {
            if (Objects.equals(cont.firstName, name)) {
                System.out.println("What do you want to edit?");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip code");
                System.out.println("5. Phone number");
                System.out.println("6. Email");
                int scase = scanner.nextInt();
                scanner.nextLine();
                switch (scase) {
                    case 1 -> {
                        System.out.println("Enter the new address: ");
                        cont.address = scanner.nextLine();
                        System.out.println("The address has been changed.");
                    }
                    case 2 -> {
                        System.out.println("Enter the new City: ");
                        cont.city = scanner.nextLine();
                        System.out.println("The City has been changed.");
                    }
                    case 3 -> {
                        System.out.println("Enter the new State: ");
                        cont.state = scanner.nextLine();
                        System.out.println("The state has been changed.");
                    }
                    case 4 -> {
                        System.out.println("Enter the new Zip code: ");
                        cont.zipCode = scanner.nextLine();
                        System.out.println("The zip code has been changed.");
                    }
                    case 5 -> {
                        System.out.println("Enter the new phone number: ");
                        cont.phoneNumber = scanner.nextLine();
                        System.out.println("The phone number has been changed.");
                    }
                    case 6 -> {
                        System.out.println("Enter the new email: ");
                        cont.email = scanner.nextLine();
                        System.out.println("The email has been changed.");
                    }
                    default -> System.out.println("Wrong number/key entered.");
                }
                System.out.println("The new contact info is: ");
                MultipleAB.updateDictionaries(cont.city, cont.state,cont.zipCode, cont);
            }
        }
    }

    public void deleteContact() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%s\n", contacts.get(i).firstName);
        }
        System.out.println("Enter the name of the contact you want to delete");
        String name = scanner.nextLine();
        contacts.removeIf(contact -> contact.firstName.equals(name));
        System.out.println("Contact has been deleted");
    }
}
