package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private static ArrayList<Contact> myContacts;

    public MobilePhone(){
        myContacts = new ArrayList<>();
    }
    public void printContacts(){
        for (int i = 0; i < myContacts.size(); i++){
            System.out.println((i + 1) + ", " + "Contact name --> "
                    +  myContacts.get(i).getName() + " phone number " +myContacts.get(i).getPhoneNumber());
        }
    }
    public boolean addNewContacts(Contact name){
        int findPosition = findContact(name);
        if (findPosition >= 0){
            System.out.println("Oops the contact already exists");
            return false;
        }
        else {
            myContacts.add(name);
        }
        return true;
    }
    public boolean updateExistingContacts(Contact oldName, Contact newName){
        int findPosition = findContact(oldName);
        if (findPosition < 0){
            System.out.println("Contact does not exist");
            return false;
        }
        else if (findContact(newName.getName()) != -1){
            System.out.println("Contact already exists.. Update not successful");
            return false;
        }
        else {
            Contact contact = myContacts.set(findPosition, newName);
            System.out.println("old contact was replaced with " + contact.getName());
        }
        return true;
    }
    public boolean removeContact(Contact contact){
        int findPosition = findContact(contact);
        if (findPosition < 0){
            System.out.println("Contact does not exist");
            return false;
        }
        else {
            myContacts.remove(findPosition);
            System.out.println("Contact was successfully deleted");
        }
        return true;
    }
//    public String queryContact(Contact contact){
//        int findPosition = findContact(contact);
//        if (findPosition >= 0){
//            return contact.getName();
//        }
//        return null;
//    }
    public Contact queryContact(String name ){
        int position = findContact(name);
        if (position >= 0){
            return myContacts.get(position);
        }
        return null;
    }
    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    public int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    }


