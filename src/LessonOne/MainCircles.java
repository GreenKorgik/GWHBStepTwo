package LessonOne;
//пока сдаю без смены цвета канвы, так как еще не допер как ее поменять.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[1];
    private int spritesCount = 1;
    private static Color color = new Color(23,123,23);
    public static void main(String[] args) {
        new MainCircles();
    }
    private MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Circles");
        getContentPane().setBackground(Color.BLUE);//отдаленно понимаю почему цвет канвы не меняется
        GameCanvas canvas = new GameCanvas(this);
        initApplication();
        add(canvas);
        setVisible(true);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    addBall(new Ball());
                }else{
                    if(e.getButton() == MouseEvent.BUTTON3){
                        deleteBall();
                    }
                }
            }
        });

    }
    private  void initApplication(){
        for(int i = 0;i < spritesCount; i++){
            sprites[i] = new Ball();
        }
    }
    private void addBall(Sprite sprite){//
        if(spritesCount == sprites.length){
            Sprite[] newSpritesArray = new Sprite[spritesCount*2];
            for(int i = 0;i < sprites.length;i++){
                newSpritesArray[i] = sprites[i];
            }
            sprites = newSpritesArray;
        }
        sprites[spritesCount] = sprite;
        spritesCount++;
    }
    private void deleteBall(){
        if(spritesCount>0)
        spritesCount--;// удаляет последний вылетевший шарик
    }
    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
       // g.fillOval(40,50,45,34);
        canvas.controller.getContentPane().setBackground(Color.GREEN);
    }
    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(GameCanvas canvas, Graphics g) {

        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(canvas, g);
        }

    }
}
