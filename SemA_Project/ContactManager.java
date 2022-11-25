package uowProgramming;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ContactManager {
	//defining an arraylist for storing contacts
		//the use of arraylist provides more flexibility
	    private ArrayList<Contact> contacts;
	    
	    private Scanner sc; //initializing a scanner outside methods so that it can accessible by all
	   
	  //----------------------------------------------------- 
	    public ContactManager(){

	        contacts = new ArrayList<Contact>();
	        
	        sc = new Scanner(System.in);
	        
	        Scanner fileScanner;
	        File contactsFile;
	        
        
	        try{
	          contactsFile = new File("contacts.txt");
	          fileScanner = new Scanner(contactsFile);
	          
	          while(fileScanner.hasNext()){
	              String line = fileScanner.nextLine();
	              String[] array = line.split(",");
	              Contact contact = new Contact(array[0], array[1], array[2], array[3], array[4]);
	              contacts.add(contact);
	          }
	        }
	        catch(Exception e){
	            System.out.println("File not found exception");
	        }
	    }   
	    
	    
	//===========================================================
	    
	    public void printAllContacts(){
	        System.out.println("\t\t------------- All Contacts -------------");
	        System.out.println("S.No | First Name\t | Last Name \t| Phone Number \t| Email \t| Category");
	        
	        //using for loop to print out all contacts
	        for(int i=0; i<contacts.size(); i++){
	            System.out.println((i+1)+": " + contacts.get(i));
	        }
	        
	        System.out.println("\n\n");
	    }
	//-----------------------------------------------------
	//method for adding a new contact
	    
	    public void addNewContact(){
	        
	    	//initializing varibles 
	        String firstName, lastName, phone, email, category = "";
	         System.out.println("------------- Add New Contact -------------");
	        System.out.print("Enter first name for contact: ");
	        firstName = sc.nextLine();
	        
	      
	        if(firstName.equals("")){
	             firstName = sc.nextLine();
	        }
	        
	        System.out.print("Enter last name for contact: ");
	        lastName = sc.nextLine();
	        
	      //getting input from user
	        if(lastName.equals("")){
	             lastName = sc.nextLine();
	        }
	        
	        System.out.print("Enter phone number for contact: ");
	        phone = sc.nextLine();
	        
	      //getting input from user
	        if(phone.equals("")){
	             phone = sc.nextLine();
	        }
	        
	        System.out.print("Enter email for contact: ");
	        email = sc.nextLine();
	        
	        //getting input from user
	        if(email.equals("")){
	             email = sc.nextLine();
	        }
	        
	       
	        String choice;
	        //if loop is true, continue loop, if false, stop the loop
	        boolean loop = true;
	        
	        do{
	             System.out.println("Choose category for contact: "
	                + "\n"
	                + "1. General"
	                + "\n"
	                + "2. Family"
	                + "\n"
	                + "3. Friends"
	                + "\n"
	                + "4. Classmate"
	                + "\n");
	        
	        System.out.print("\nEnter your option: ");
	            choice = sc.nextLine();
	            
	            if(choice.equals("")){
	                choice = sc.nextLine();
	            }
	            
	            switch(choice){
	                case "1":
	                    category = "General";
	                    loop = false;
	                    break;
	                case "2":
	                     category = "Family";
	                     loop = false;
	                    break;
	                case "3":
	                     category = "Friends";
	                     loop = false;
	                    break;
	                case "4":
	                     category = "Classmate";
	                     loop = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice, enter again!");
	            }
	        } while(loop); 
	        //while "loop" is true, continue the loop
	        
	        
	        //adding this data to "contacts"
	        contacts.add(new Contact(firstName, lastName, phone, email, category));
	        //message to show that new contact has been added
	        System.out.println("Contact Added Successfully");
	        
	    }
	    
	//----------------------------------------------------------------------------------------
	//Updating the txt file with the information retrieved from user
	//Storing that info from variables to the txt file
	    public void updateFile(){
	        try {
	            FileWriter fw = new FileWriter("contacts.txt");
	            PrintWriter pw = new PrintWriter(fw);
	            
	            for(int i=0; i<contacts.size(); i++){
	                Contact contact = contacts.get(i);
	                
	                pw.print(contact.getFirstName()+","+contact.getLastName()+","+contact.getPhoneNumber()+","+contact.getEmail()+","+contact.getCategory());
	                pw.println();
	                
	            }
	            pw.close();
	        } catch (IOException ex) {
	        	System.out.println("File not found exception");
	        }
	    }
	    
	 //----------------------------------------------------------------------------------------  
	 // for searching a contact
	    public void searchContact(){
	        
	        System.out.println("1. Search by first name");
	        System.out.println("2. Search by email");
	        System.out.println("3. Search by phone");
	        //no option to search by name because names can be redundant
	        //e.g : 2 people can have the same first name, Chan
	        
	        String choice = "";
	        choice = sc.nextLine();
	            
	        if(choice.equals("")){
	            choice = sc.nextLine();
	        }
	        
	        switch(choice){
	            case "1":
	                String name;
	                
	                System.out.print("Enter first name to search: ");
	                
	                name = sc.nextLine();
	                
	                if(name.equals("")){
	                	//get input from user
	                    name = sc.nextLine();
	                }
	                
	                boolean found = false;
	                for(int i = 0; i<contacts.size(); i++){
	                	//see if the input equals to any of of the inputs in "first name"
	                    if(name.toLowerCase().equals(contacts.get(i).getFirstName().toLowerCase())){
	                    	//display all related info.
	                        System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                        System.out.println(""+contacts.get(i).toString());
	                        found = true;
	                        break;
	                    }
	                }
	                //loop completed, found still equals false, than display this message
	                if(found==false){
	                    System.out.println("Contact Not Found!");
	                }
	                
	                break;
	            case "2":
	              
	                String email;
	                
	                System.out.print("Enter email to search: ");
	                //get email input from user
	                email = sc.nextLine();
	                
	                if(email.equals("")){
	                    email = sc.nextLine();
	                }
	                
	                 found = false;
	                for(int i = 0; i<contacts.size(); i++){
	                    if(email.toLowerCase().equals(contacts.get(i).getEmail().toLowerCase())){
	                    	//display all related info
	                        System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                        System.out.println(""+contacts.get(i).toString());
	                        found = true;
	                        break;
	                    }
	                }
	                
	                if(found==false){
	                    System.out.println("Contact Not Found!");
	                }
	                break;
	                
	                case "3":
	              
	                String phone;
	                
	                System.out.print("Enter phone to search: ");
	                
	                phone = sc.nextLine();
	                
	                if(phone.equals("")){
	                	//get phone number input from user
	                    phone = sc.nextLine();
	                }
	                
	                 found = false;
	                for(int i = 0; i<contacts.size(); i++){
	                    if(phone.toLowerCase().equals(contacts.get(i).getPhoneNumber().toLowerCase())){
	                    	//display all related info.
	                        System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                        System.out.println(""+contacts.get(i).toString());
	                        found = true;
	                        break;
	                    }
	                }
	                
	                if(found==false){
	                    System.out.println("Contact Not Found!");
	                }
	                break;
	            default:
	                System.out.println("Invalid Choice!");
	              
	        }
	            
	        
	        
	    }
	 //-----------------------------------------------------------------------------------------------------  
	 // for deleting contact 
	    
	    public void removeContact(){
	    	
	    	System.out.println("[1]Search by email");
	    	System.out.println("[2]Search by phone number");
	    	System.out.print("\t\tEnter your choice: ");
	    	String Choice = sc.nextLine();
	    	
	    	switch(Choice) {
	    	case "1":
	    		System.out.print("Enter email to search: ");
	    		String email= sc.nextLine();
	            boolean found = false;
	            
	            if(email.equals("")){
	                email = sc.nextLine();
	            }
	            
	             found = false;
	            for(int i = 0; i<contacts.size(); i++){
	                if(email.toLowerCase().equals(contacts.get(i).getEmail().toLowerCase())){
	                    System.out.println("First Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                    System.out.println(""+contacts.toString());
	                    found = true;
	                    
	                    contacts.remove(contacts.get(i));
	                    System.out.println("Contact Found & Contact Removed");
	                    break;
	                }
	            }
	            
	            if(found==false){
	                System.out.println("Contact Not Found!");
	            }
	            break;
	    	case "2":
	    		System.out.print("Enter phone number to search: ");
	    		String phone= "";
	            boolean fd = false;
	            
	            if(phone.equals("")){
	                phone = sc.nextLine();
	            }
	            
	             fd = false;
	            for(int i = 0; i<contacts.size(); i++){
	                if(phone.toLowerCase().equals(contacts.get(i).getPhoneNumber().toLowerCase())){
	                    System.out.println("First Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                    System.out.println(""+contacts.toString());
	                    fd = true;
	                    
	                    contacts.remove(contacts.get(i));
	                    System.out.println("Contact Found & Contact Removed");
	                    break;
	                }
	            }
	            
	            if(fd==false){
	                System.out.println("Contact Not Found!");
	            }   
	            default:
	            System.out.println("Invalid Choice");
	    	}  
	            
	    }
	 
	 //----------------------------------------------------------------------------------------------------- 
	 // for displaying contacts inside a specific category
	    public void showByCategory(){
	        String category = "";
	        
	        System.out.println("Choose Category to show contacts: \n"
	                + "1. Family \n"
	                + "2. Friends \n"
	                + "3. Classmate \n"
	                + "4. General\n"
	                + "\tYour choice: ");
	        
	        category = sc.nextLine();
	        
	        if(category.equals("")){
	            category = sc.nextLine();
	        }
	        
	       switch(category){
	           case "1":
	                System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	               for(int i=0; i<contacts.size(); i++){
	                   if(contacts.get(i).getCategory().toLowerCase().equals("family")){ 
	                        System.out.println(""+contacts.get(i).toString());   
	                    }
	               }
	               
	               break;
	           case "2":
	               System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	               for(int i=0; i<contacts.size(); i++){
	                   if(contacts.get(i).getCategory().toLowerCase().equals("friends")){ 
	                       System.out.println(""+contacts.get(i).toString());   
	                    }
	               }
	               break;
	           case "3":
	               System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	               for(int i=0; i<contacts.size(); i++){
	                   if(contacts.get(i).getCategory().toLowerCase().equals("classmate")){ 
	                        System.out.println(""+contacts.get(i).toString());      
	                    }
	               }
	               break;
	           case "4":
	               System.out.println("\tFirst Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	               for(int i=0; i<contacts.size(); i++){
	                   if(contacts.get(i).getCategory().toLowerCase().equals("general")){ 
	                        System.out.println(""+contacts.get(i).toString());    
	                    }
	               }
	               break;
	           default:
	       }
	    }
	    
	    
	  //-----------------------------------------------------
	  //for editing contacts
	     public void editContact(){
	          String email; 
	          String firstName, lastName, phone, email2, category="";
	                
	                System.out.print("Enter email to search: ");
	                
	                email = sc.nextLine();
	                
	                int index = -1;
	                
	                boolean found = false;
	                
	                if(email.equals("")){
	                    email = sc.nextLine();
	                }
	                
	                 found = false;
	                for(int i = 0; i<contacts.size(); i++){
	                    if(email.toLowerCase().equals(contacts.get(i).getEmail().toLowerCase())){
	                        System.out.println("First Name | Last Name \t\t| Phone Number \t\t| Email \t\t    | Category");
	                        System.out.println(""+contacts.get(i).toString());
	                        found = true;
	                        index = i;
	                        
	                        break;
	                    }
	                }
	                
	                if(found==false){
	                    System.out.println("Contact Not Found!");
	                }
	                else{
	                    
	                    
	                    System.out.print("Enter first name for contact: ");
	        firstName = sc.nextLine();
	        
	        if(firstName.equals("")){
	             firstName = sc.nextLine();
	        }
	        
	        System.out.print("Enter last name for contact: ");
	        lastName = sc.nextLine();
	        
	        if(lastName.equals("")){
	             lastName = sc.nextLine();
	        }
	        
	        System.out.print("Enter phone number for contact: ");
	        phone = sc.nextLine();
	        
	        if(phone.equals("")){
	             phone = sc.nextLine();
	        }
	        
	        System.out.print("Enter email for contact: ");
	        email2 = sc.nextLine();
	        
	        if(email2.equals("")){
	             email2 = sc.nextLine();
	        }
	        
	       
	        
	        String choice;
	        
	        boolean loop = true;
	        
	        do{
	             System.out.println("Choose category for contact: "
	                + "\n"
	                + "1. General"
	                + "\n"
	                + "2. Family"
	                + "\n"
	                + "3. Friends"
	                + "\n"
	                + "4. Classmate"
	                + "\n");
	        
	        System.out.print("\nEnter your option: ");
	            choice = sc.nextLine();
	            
	            if(choice.equals("")){
	                choice = sc.nextLine();
	            }
	            
	            switch(choice){
	                case "1":
	                    category = "General";
	                    loop = false;
	                    break;
	                case "2":
	                     category = "Family";
	                     loop = false;
	                    break;
	                case "3":
	                     category = "Friends";
	                     loop = false;
	                    break;
	                case "4":
	                     category = "Classmate";
	                     loop = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice, enter again!");
	            }
	        } while(loop);
	        
	        //saving the info back to the txt file
	        contacts.get(index).setFirstName(firstName);
	        contacts.get(index).setLastName(lastName);
	        contacts.get(index).setPhoneNumber(phone);
	        contacts.get(index).setEmail(email2);
	        contacts.get(index).setCategory(category);
	            
	                    System.out.println("Contact Edited Successfully");
	                }
	               
	    }
}
