package LessonThree;

import java.util.HashMap;
import java.util.Iterator;

/*
  1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
    - Найти список слов, из которых состоит текст (дубликаты не считать);
    - Посчитать сколько раз встречается каждое слово (использовать HashMap);
   2. Написать простой класс PhoneBook(внутри использовать HashMap):
    - В качестве ключа использовать фамилию
    - В каждой записи всего два поля: phone, e-mail
    - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
    и отдельный метод для поиска e-mail по фамилии. Следует учесть, что под одной фамилией может быть несколько записей.
    Итого должно получиться 3 класса Main, PhoneBook, Person.
 */
public class Solution {
    public static void main(String[] args){
        //taskOne();
        taskTwo();

    }
    public static void taskOne(){
        String text = "Эти мошенники собрали в три вечера четыреста шестьдесят пять долларов. Я еще никогда не видел, чтобы деньги загребали такими кучами.\n" +
                "Немного погодя, когда оба они уснули и захрапели, Джим и говорит:\n" +
                "– Гек, а ты не удивляешься, что короли так себя ведут?\n" +
                "– Нет, – говорю, – не удивляюсь.\n" +
                "– А почему ты не удивляешься, Гек?\n" +
                "– Да потому, что такая уж это порода. Я думаю, они все одинаковы.\n" +
                "– Гек, ведь эти наши короли – сущие мошенники! Вот они что такое – сущие мошенники!\n" +
                "– Ну, а я что тебе говорю: почти что все короли – мошенники, дело известное.\n" +
                "– Да что ты!\n" +
                "– А ты почитай про них, вот тогда и узнаешь. Возьми хоть Генриха Восьмого: наш против него прямо учитель воскресной школы. А возьми Карла Второго, Людовика Четырнадцатого, Людовика Пятнадцатого, Иакова Второго, Эдуарда Второго, Ричарда Третьего и еще сорок других...";
        String[] arrayWords = text.replaceAll("\\pP|\\t|\\n"," ").split("\\s+");
        HashMap<String,Integer> words = new HashMap<>();
        for(int i = 0; i <arrayWords.length;i++){
            if(words.containsKey(arrayWords[i])){
                words.put(arrayWords[i],words.get(arrayWords[i])+1);
            }else{
                words.put(arrayWords[i],1);
            }
        }
        System.out.println("finish");
    }
    public static void taskTwo(){
        Person personOne = new Person("Бэггинс","8-345-645-34-23","ItakeTheRing@gmail.com");
        personOne.addEmail(new String[]{"GiftMeRing.com","Ring@gmail.com"});
        personOne.addTelephoneNumber("681-34-28");
        Person personTwo = new Person("Potter","8-003-463-23-23","WillKillSomeoneWhoCannotBeCalled@gmail.com");
        personTwo.addEmail("izards@mail.su");
        personTwo.addTelephoneNumber("008-83-78");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(new Person[]{personOne,personTwo});
    }
}
