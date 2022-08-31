package com.company;


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Choose an option:(6 to select a list of actions) ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...Goodbye");
                    quit = true;
                    break;
                case 1:
                   mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeExistingContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
      }
    private static void startPhone(){
        System.out.println("Hello, Welcome :) Phone starting...");
    }
    private static void addNewContact(){
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String contact = scanner.next();
        Contact newContact = Contact.createContact(name, contact);
        if (mobilePhone.addNewContacts(newContact)) {
            System.out.println("New contact added: name = " + name + " phone = " + contact);
        }
        else {
            System.out.println("Cannot add, " + name + " already on file");
        }

    }
    private static void updateExistingContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        //mobilePhone.queryContact(name);
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found");
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.next();
        System.out.println("Enter new phone number: ");
        String newNumber = scanner.next();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateExistingContacts(existingContact, newContact)){
            System.out.println("Contact successfully updated");
        }
        else {
            System.out.println("Error updating record");
        }

    }
    private static void removeExistingContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.next();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Contact successfully deleted");
        }
        else {
            System.out.println("Error deleting contact");
        }

    }
    private static void queryContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.next();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("contact not found");
        }
        else {
            System.out.println("name: " + existingContact.getName() + "contact: " +
                    existingContact.getPhoneNumber());
        }
    }
    private static void printActions(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - to add a new contact\n" +
                           "3 - to update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query contact" +
                           "6 -  print actions" );
        System.out.println("Choose your action: ");
    }
   }
