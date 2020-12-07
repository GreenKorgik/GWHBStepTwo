package LessonThree;

import java.util.ArrayList;

public class Person {
    private String lastName;
    private ArrayList<String> numbersTelephone;
    private ArrayList<String> emails;
    public  Person(String lastName){
        this.lastName = lastName;
        numbersTelephone = new ArrayList<>();
        emails = new ArrayList<>();
    }
    public Person(String lastName,String numberTelephone,String email){
        this.lastName = lastName;
        numbersTelephone = new ArrayList<>();
        numbersTelephone.add(numberTelephone);
        emails = new ArrayList<>();
        emails.add(email);
    }
    public void addTelephoneNumber(String numberTelephone){
        numbersTelephone.add(numberTelephone);
    }
    public void addTelephoneNumber(String[] numbersTelephone){
        for(int i = 0; i < numbersTelephone.length; i++){
            this.numbersTelephone.add(numbersTelephone[i]);
        }
    }
    public void addEmail(String email){
        emails.add(email);
    }
    public void addEmail(String[] emails){
        for(int i = 0; i < emails.length; i++){
            this.emails.add(emails[i]);
        }
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getNumbersTelephone() {
        return numbersTelephone;
    }
}
