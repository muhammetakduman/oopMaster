import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super(4,"Snake",getRandomDamage(),12,0);
    }

    public static int getRandomDamage(){
        return new Random().nextInt(4)+3;
    }
}
