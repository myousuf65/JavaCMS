package uowProgramming;

public class Contact {

	//initiatializing variables
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String category;

    //for retrieving first name
    public String getFirstName() {
        return firstName;
    }

    //for setting first name in case of editting , updating
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //for retrieving last name
    public String getLastName() {
        return lastName;
    }

  //for setting last name in case of editting , updating
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
  //for retrieving phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
  //for setting Phone number in case of editting , updating
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
  //for retrieving email
    public String getEmail() {
        return email;
    }
  //for setting email in case of editting , updating
    public void setEmail(String email) {
        this.email = email;
    }
  //for retrieving info using various categories
    public String getCategory() {
        return category;
    }
  //for setting category in case of editting , updating
    public void setCategory(String category) {
        this.category = category;
    }

    //class constructor for contact.java class
    //source : w3schools (https://www.w3schools.com/java/ref_keyword_this.asp)
    public Contact(String firstName, String lastName, String phoneNumber, String email, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.category = category;
    }
    
    //twisting method
    //when retrieving info, the info will be displayed in this format
    public String toString(){
        return "\t"+firstName+"\t\t"+lastName+"\t\t"+phoneNumber+"\t\t"+email+"\t\t"+category;
                
    }
}
