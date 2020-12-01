package LessonTwo;

import java.lang.reflect.Array;

/*
Есть строка вида: ; (другими словами матрица 4x4)
10 3 1 2
2 3 2 2
5 6 7 1
300 3 1 0
Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
3. Ваши методы должны бросить исключения в случаях:
Если размер матрицы, полученной из строки, не равен 4x4;
Если в одной из ячеек полученной матрицы не число; (например символ или слово)
4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
5. * Написать собственные классы исключений для каждого из случаев
 */
public class Solution {
    public static void main(String[] args) {
        String line = "10 3 1 2\n2 3 2 t\n5 6 7 1\n300 3 1 0";
        String[][] Array = transformToArray(line);
        if(Array.length!=4||Array[0].length!=4)
            throw new SizeArrayException("Размер массива не 4х4",4);
        try {
            System.out.println(SumElementArrayDividedTwo(Array));
        }catch (JustMyExceptionAgain e){
        }

    }
    //сделал не совсем, что требовалось, метод не кидает исключение, ему вообще наплевать, что за текст придет. Вернет двумерный массив слов,
    //правда могут быть null ячейки, если соответственно в строчках разное количество елементов. Логика подсказывает, что этого можно избежать сделав
    //размер строк в массиве разным. Не используя списки и не спускаясь к ++, как это сделать, без понятия.

    public static String[][] transformToArray(String line){
        String[] row = line.split("\n");
        System.out.println(row[0]);
        int rowCount = row.length;
        int rowColumn = 0;
        for(int i = 0; i < rowCount; i++){
            int variable = 0;
            if(rowColumn<(variable = row[i].split(" ").length)){
                rowColumn = variable;
            }
        }
        String[][] Array = new String[rowCount][rowColumn];
        for(int i = 0; i < rowCount; i++){
            System.arraycopy(row[i].split(" "),0,Array[i],0,row[i].split(" ").length);//при больших данных этот вариант возможно заставит машину умереть, так как я слышал что split затратен
        }
        return Array;
    }
    public static int SumElementArrayDividedTwo(String[][] Array) throws JustMyExceptionAgain{
        int sum = 0;
        for(int i = 0; i < Array.length; i++){
            for(int j = 0; j < Array[i].length;j++){
                try {
                    sum += Integer.parseInt(Array[i][j]);
                }catch (NumberFormatException e){
                    throw new JustMyExceptionAgain(e.getMessage());
                }
            }
        }
        return sum/2;
    }
}
