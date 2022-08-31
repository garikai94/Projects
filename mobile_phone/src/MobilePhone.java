import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<String> mobilePhone = new ArrayList<>();

    public void printMobileContacts(){
        System.out.println("Contact list: " + mobilePhone.size() + " in your mobile phone.");
        for (int i = 0; i < mobilePhone.size(); i++){
            System.out.println((i + 1) + ". " + mobilePhone.get(i));
        }
    }
    public void addContact(String number){
        mobilePhone.add(number);
    }
    public void storeMobileContacts(String names){
        System.out.println("The names is your contact list " + mobilePhone.add(names));

    }

    public void modifyMobileContacts(int  position, String contact){
        mobilePhone.set(position,contact);
        System.out.println("Your contact: " + (position + 1) + " has been modified.");


    }

    public void removeMobileContacts(String contacts){
        int position = findContact(contacts);
        if (position >= 0){
            modifyMobileContacts(position, contacts);
        }

    }

    public void queryMobileContacts(){

    }
    public int findContact(String searchItem){
        return mobilePhone.indexOf(searchItem);
    }

}
