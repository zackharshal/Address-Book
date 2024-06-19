import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    public static int numOfContacts = 0;
    AddressBook(String firstName,String lastName, String address,String city, String state,String zipCode, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        numOfContacts++;
    }
    public void printInfo(){
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Address: "+address);
        System.out.println("City,State: "+city+", "+state);
        System.out.println("Zipcode: "+zipCode);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.println("Email: "+email);
    }
    static void deleteContact(ArrayList<AddressBook> contacts){
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<contacts.size();i++){
            System.out.printf("%s\n",contacts.get(i).firstName);
        }
        System.out.println("Enter the name of the contact you want to delete");
        String name= scanner.nextLine();
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).firstName.equals(name)){
                contacts.remove(i);
            }
        }
        System.out.println("Contact has been deleted");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Address Book program.");
        ArrayList<AddressBook> contacts = new ArrayList<AddressBook>();
        boolean run = true;
        while(run){
            System.out.println("1. Add contact\t 2. Edit contact\t 3. Delete contact\t 4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
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
                    contacts.add(new AddressBook(firstName,lastName,address,city,state,zipCode,phoneNumber,email));
                    break;

                case 2:
                    for(AddressBook cont: contacts){
                        System.out.println(cont.firstName);
                    }
                    System.out.println("Enter the first name of that contact you want to edit: ");
                    String name = scanner.next();
                    for (AddressBook cont: contacts) {
                        if(Objects.equals(cont.firstName, name)){
                            System.out.println("What do you want to edit?");
                            System.out.println("1. Address");
                            System.out.println("2. City");
                            System.out.println("3. State");
                            System.out.println("4. Zip code");
                            System.out.println("5. Phone number");
                            System.out.println("6. Email");
                            int scase = scanner.nextInt();
                            switch (scase){
                                case 1:
                                    scanner.nextLine();
                                    System.out.println("Enter the new address: ");
                                    cont.address = scanner.nextLine();
                                    System.out.println("The address has been changed.");
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Enter the new City: ");
                                    cont.city = scanner.nextLine();
                                    System.out.println("The City has been changed.");
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.println("Enter the new State: ");
                                    cont.state = scanner.nextLine();
                                    System.out.println("The state has been changed.");
                                    break;
                                case 4:
                                    scanner.nextLine();
                                    System.out.println("Enter the new Zip code: ");
                                    cont.zipCode = scanner.nextLine();
                                    System.out.println("The zip code has been changed.");
                                    break;
                                case 5:
                                    scanner.nextLine();
                                    System.out.println("Enter the new phone number: ");
                                    cont.phoneNumber = scanner.nextLine();
                                    System.out.println("The phone number has been changed.");
                                    break;
                                case 6:
                                    scanner.nextLine();
                                    System.out.println("Enter the new email: ");
                                    cont.email = scanner.nextLine();
                                    System.out.println("The email has been changed.");
                                    break;
                                default:
                                    System.out.println("Wrong number/key entered.");
                            }
                            System.out.println("The new contact info is: ");
                            cont.printInfo();
                        }
                    }
                    break;
                case 3:
                    deleteContact(contacts);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Wrong number/key pressed.");
            }
        }
    }
}