/**
 * Created by mitchellvaline on 5/7/15.
 */
import java.util.Random;

public class Dice {
    private int value;

    public Dice() {
        this.setValue(1);
    }

    public Dice(int value){
        this.setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void rollDice() {
        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(6 - 1 + 1) + 1;
        this.setValue(value);
    }
}
