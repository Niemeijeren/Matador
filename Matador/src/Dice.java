
package matador;
import java.util.ArrayList;
import matador.*;

public class Dice {
    
    private int die1;
    private int die2;
    private int die;
    private boolean doubles = false;
    
    public Dice(){
        this.die = die1 + die2;
        
    }
    //Method for throwing dices, containing a method for telling if doubles
    public int throwDice(){
        this.die1 = (int)(Math.random()* 6 + 1);
        this.die2 = (int)(Math.random()* 6 + 1);
        System.out.println("You rolled " + die1 + " and " + die2);
        this.die = this.die1 + this.die2;
        if ( die1 == die2 ){
            doubles = true;
            System.out.println("Doubles!");
        } else if (die1 != die2) {
            doubles = false;
    }
        return die1 + die2;
    }
    public int getDie(){
        return this.die;
    }

    public boolean checkDoubles(){
        return doubles;
    }
}
