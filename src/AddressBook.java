import java.util.*;

class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private ArrayList<AddressBook> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
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

    public void printInfo() {
        for (AddressBook con : contacts) {
            System.out.println("Name: " + con.firstName + " " + con.lastName);
            System.out.println("Address: " + con.address);
            System.out.println("City, State: " + con.city + ", " + con.state);
            System.out.println("Zipcode: " + con.zipCode);
            System.out.println("Phone Number: " + con.phoneNumber);
            System.out.println("Email: " + con.email);
            System.out.println();
        }
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
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
            MultipleAB.updateDictionaries(city, state, newContact);
        }
    }

    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the contact you want to edit: ");
        String name = scanner.next();
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
                MultipleAB.updateDictionaries(cont.city, cont.state, cont);
                System.out.println("The new contact info is: ");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the contact you want to delete");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).firstName.equals(name)) {
                AddressBook contact = contacts.remove(i);
                MultipleAB.cityPersonMap.get(contact.city).remove(contact);
                MultipleAB.statePersonMap.get(contact.state).remove(contact);
                System.out.println("Contact has been deleted");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void manageContacts() {
        Scanner scanner = new Scanner(System.in);
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
}