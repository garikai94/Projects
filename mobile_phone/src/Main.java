import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (! quit){
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printListOfContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContacts();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();

                case 6:
                    quit = true;
                    break;
            }

        }

    }
    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("Print Instructions");
        System.out.println("\t 0 - To print instructions.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add new contacts.");
        System.out.println("\t 3 - To update contact list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search a contact from the list.");
        System.out.println("\t 6 - To quit");
    }
    public static void printListOfContacts(){
        mobilePhone.printMobileContacts();
        System.out.println("Print all contacts:" );
    }
    public static void addNewContact(){
        System.out.println("Enter the contact you want add:");
        mobilePhone.addContact(scanner.nextLine());
    }
    public static void updateContacts(){
        System.out.println("Enter the contacts you want to update:");
        mobilePhone.addContact(scanner.nextLine());
    }
    public static void removeContact(){
        System.out.println("Enter the contact name you want to remove:");
        mobilePhone.removeMobileContacts(scanner.nextLine());
    }
    public static void findContact(){
        System.out.println("Enter the contact you are searching:");
        mobilePhone.findContact(scanner.nextLine());
    }






}
