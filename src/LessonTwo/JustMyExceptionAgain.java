package LessonTwo;

public class JustMyExceptionAgain extends NumberFormatException{
    public JustMyExceptionAgain() {
        super();
    }

    public JustMyExceptionAgain(String s) {
        super(s);
        System.out.println("in one of the cells not a number");
    }
}
