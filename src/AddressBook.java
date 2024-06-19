import java.util.ArrayList;
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
    AddressBook(String firstName,String lastName, String address,String city, String state,String zipCode, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public void printInfo(){
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Address: "+address);
        System.out.println("City,State: "+city+", "+state);
        System.out.println("Zipcode: "+zipCode);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.println("Email: "+email);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program.");
        System.out.print("How many contacts do you want to enter?: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        ArrayList<AddressBook> contacts = new ArrayList<AddressBook>();
        for(int i = 0; i < num; i++){
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
        }
        for(AddressBook cont: contacts){
            cont.printInfo();
        }
    }
}