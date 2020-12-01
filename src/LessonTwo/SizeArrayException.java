package LessonTwo;

public class SizeArrayException extends RuntimeException{
    private int size;

    public int getSize() {
        return size;
    }

    public SizeArrayException(String message, int size){
        super(message);
        this.size =size;
    }
}
