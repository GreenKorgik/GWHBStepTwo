package LessonThree;

import java.util.ArrayList;
import java.util.HashMap;

/*
Написать простой класс PhoneBook(внутри использовать HashMap):
    - В качестве ключа использовать фамилию
    - В каждой записи всего два поля: phone, e-mail
    - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
    и отдельный метод для поиска e-mail по фамилии. Следует учесть, что под одной фамилией может быть несколько записей.
    Итого должно получиться 3 класса Main, PhoneBook, Person.
 */
public class PhoneBook {
    private HashMap<String,Person> Array;
    public PhoneBook(){
        this.Array = new HashMap<>();
    }
    public void addPerson(Person person){
        Array.put(person.getLastName(),person);
    }
    public void addPerson(Person[] person){
        for(int i = 0;i<person.length;i++){
            Array.put(person[i].getLastName(),person[i]);
        }
    }
    public ArrayList<String> getPhone(String lastName){
        return Array.get(lastName).getNumbersTelephone();
    }
    public ArrayList<String> getEmail(String lastName){
        return Array.get(lastName).getEmails();
    }
}
