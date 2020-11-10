/**
 *
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Date: October 06-2020
 * @author Botshelo-3
 * @version 1.0
 */
public class PoisedProject {
    /**
     * Main method which is entry point of our program
     * @param args Array of Strings arguments
     *
     */
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false",
                        "garietaffy", "alluwisia");

                Statement statement = conn.createStatement()
                )
        // Creating local variables
        Scanner input = new Scanner(System.in);
        String name = "", surname = "";
        String telephone = "";
        String email = "";
        String address = "";
        String projectName = "", projectNumber = "", type = "";
        String projectFee = "", amountPaid = "", erfNum = "";
        String dueDate = "";
        int choice = 0;
        while (choice != 9) {
            System.out.println("Please choose an option below:");
            System.out.println("1.Add the customers details.");
            System.out.println("2.Add constructor details.");
            System.out.println("3.Add architect details.");
            System.out.println("4.Add project details.");
            System.out.println("5.Print all details.");
            System.out.println("6.Change due date of the project.");
            System.out.println("7.Update contractors details.");
            System.out.println("8.Change the amount of fees paid to date.");
            System.out.println("9.Enter any other number to exit the program.");
            System.out.println("\nEnter any number from 1 to 8 and select.");
            choice = input.nextInt();

            if (choice == 1) {
                // Collecting information
                // If choice is 1 the program will execute customer's details
                Customer customer = new Customer(name, surname, telephone, email, address);
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter your name: ");
                customer.name = keyboard.next();
                System.out.println("Enter the your surname: ");
                customer.surname = keyboard.next();
                System.out.println("Enter your cell number: ");
                customer.telephone = keyboard.next();
                System.out.println("Enter the customer's email address: ");
                customer.email = keyboard.next();
                System.out.println("Enter the customer's physical address: ");
                customer.address = keyboard.next();
                System.out.print("Customer's full name: " + customer.name);
                System.out.println("\t"+customer.surname);
                System.out.println("Customer's cell number: " + customer.telephone);
                System.out.println("Customer's email address: " + customer.email);
                System.out.println("Customer's physical address: " + customer.address);
                break;
            }
            else if (choice == 2) {                       // if choice is 2 the program will execute contractor's details
                Contractor contractor = new Contractor(name, surname, telephone, email, address);
                Scanner keyboard2 = new Scanner(System.in);
                System.out.println("Enter your name: ");
                contractor.name = keyboard2.next();
                System.out.println("Enter the your surname: ");
                contractor.surname = keyboard2.next();
                System.out.println("Enter your cell number: ");
                contractor.telephone = keyboard2.next();
                System.out.println("Enter the customer's email address: ");
                contractor.email = keyboard2.next();
                System.out.println("Enter the customer's physical address: ");
                contractor.address = keyboard2.next();
                System.out.print("Contractor's full name: " + contractor.name);
                System.out.println("\t"+contractor.surname);
                System.out.println("Contractor's cell number: " + contractor.telephone);
                System.out.println("Contractor's email address: " + contractor.email);
                System.out.println("Contractor's physical address: " + contractor.address);
                break;
            }
            else if (choice == 3) {                       // if choice is 3 the program will execute Architect'a details
                Architect architect = new Architect(name, surname,email, telephone, address);
                Scanner keyboard3 = new Scanner(System.in);
                System.out.println("Enter your name: ");
                architect.name = keyboard3.nextLine();
                System.out.println("Enter the your surname: ");
                architect.surname = keyboard3.nextLine();
                System.out.println("Enter your cell number: ");
                architect.telephone = keyboard3.next();
                System.out.println("Enter the customer's email address: ");
                architect.email = keyboard3.nextLine();
                System.out.println("Enter the customer's physical address: ");
                architect.address = keyboard3.nextLine();
                System.out.println("Architect's full name: " + architect.name);
                System.out.println("\t"+architect.surname);
                System.out.println("Architect's cell number: " + architect.telephone);
                System.out.println("Architect's email address: " + architect.email);
                System.out.println("Architect's physical address: " + architect.address);
                break;
            }
            else if (choice == 4) {                          // if choice is 4 the program will execute Project's details
                Project project = new Project(projectName,projectNumber,erfNum,type,dueDate,projectFee,amountPaid);
                Scanner keyboard4 = new Scanner(System.in);
                System.out.println("Enter the project name: ");
                project.projectName = keyboard4.nextLine();
                System.out.println("Enter the project number: ");
                project.projectNumber = keyboard4.nextInt();
                System.out.println("Enter the project due date: ");
                project.builtDate = keyboard4.nextLine();
                System.out.println("Enter the type of building: ");
                project.type = keyboard4.nextLine();
                System.out.println("Enter the ERF number of the project: ");
                project.erfNum = keyboard4.nextInt();
                System.out.println("Enter the project fee: ");
                project.projectFee = keyboard4.nextInt();
                System.out.println("Enter the total amount paid to date: ");
                project.amountPaid = keyboard4.nextInt();
                System.out.println("Enter the new deadline date: ");
                project.dueDate = keyboard4.nextLine();
                System.out.println("Project name: " + project.projectName);
                System.out.println("Project number:" + project.projectNumber);
                System.out.println("Project building type: " + project.type);
                System.out.println("Project ERF number: " + project.erfNum);
                System.out.println("Project fee: " + project.projectFee);
                System.out.println("Amount paid: " + project.amountPaid);
                System.out.println("Project's deadline date: " + project.dueDate);
                break;

            }else {
                System.out.println("Exit program");
            }
        }
    }
}
// Attributes
class Contractor {
    String name;
    String surname;
    String telephone;
    String email;
    String address;

    public Contractor(String name, String surname, String email, String telephone, String address) {
        this.name = name;                        // name of the contractor
        this.surname = surname;                 // surname of the contractor
        this.telephone = telephone;              // Contractor telephone
        this.email = email;                      // Email
        this.address = address;                  // Contractor physical address
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        String output = "Name: " + name;
        output += "\nTelephone:" + telephone;
        output += "\nEmail:" + email;
        output += "\nAddress:" + address;
        return output;
    }
}

class Architect {           // Creating Architect class
    String name;
    String surname;
    String telephone;
    String email;
    String address;

    public Architect(String name, String surname, String telephone, String email, String address) {    // Creating Architect contractor
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.address = address;

    }
    public String getTelephone(){
        return telephone;
    }
}

class Customer {        // creating a customer class
    String name;
    String surname;
    String telephone;
    String email;
    String address;


    public Customer(String name, String surname, String telephone, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.address = address;


    }
    public String getTelephone(){
        return telephone;
    }
}

class Project {    // Creating a project class
    String projectName;
    int projectNumber;
    String builtDate;
    String type;
    int erfNum;
    int projectFee;
    int amountPaid;
    String dueDate;

    public Project(String projectName, int projectNumber, int erfNum, String type, String dueDate, int projectFee, int amountPaid) {        // Class constructor
        this.projectName = projectName;
        this.projectNumber = projectNumber;
        this.type = type;
        this.erfNum = erfNum;
        this.projectFee = projectFee;
        this.amountPaid = amountPaid;
        this.dueDate = dueDate;
    }

    public Project(String projectName, String projectNumber, String erfNum, String type, String dueDate, String projectFee, String amountPaid) {
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public String getType() {
        return type;
    }
    public int getErfNum(){
        return erfNum;
    }
    public int getProjectFee(){
        return projectFee;
    }
    public int getAmountPaid(){
        return amountPaid;
    }

    public String toString() {
        String output = "Name: " + projectName;
        output = "Project number: " + projectNumber;
        output = "Project type: " + type;
        output = "Project ERF number: " + erfNum;
        output = "Project fee: " + projectFee;
        output = "Amount paid to date: " + amountPaid;
        output = "Project due date: " + dueDate;
        return output;
    }
}


