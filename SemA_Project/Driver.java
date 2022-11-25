package uowProgramming;

import java.util.*;

public class Driver {
    public static void showMenu(){
        
        System.out.println("------------- Menu -------------");
        System.out.println("1. Add New Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Edit/Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Show All Contacts");
        System.out.println("6. Show Categories");
         System.out.println("7. Exit");
        
        System.out.print("\tEnter your choice: ");
    }
    
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        String input = "";
        
        ContactManager contactManager = new ContactManager();
        
        
        do{
            showMenu();
            input = sc.nextLine();
            
            if(input.equals("")){
                input = sc.nextLine();
            }
            
            switch(input){
                case "1":
                    contactManager.addNewContact();
                    //the info is stored in variable, save them to the txt file
                    contactManager.updateFile();
                    break;
                case "2":
                    contactManager.searchContact();
                    break;
                case "3":
                    contactManager.editContact();
                    contactManager.updateFile();
                    break;
                case "4":
                    contactManager.removeContact();
                    contactManager.updateFile();
                    break;
                case "5":
                    contactManager.printAllContacts();
                    break;
                case "6":
                    contactManager.showByCategory();
                    break;
                case "7":
                    contactManager.updateFile(); //as a back, in case the data has not been saved to the txt file
                    System.out.println("Bye Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, try again!\n");
            }
        } while(true);
            
        
    }
}
