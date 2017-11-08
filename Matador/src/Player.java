
package matador;
import matador.*;
import java.util.*;


public class Player {
    
    private int roundCounter = 0;
    private String name;
    private int number;
    FieldInterface currentfield;
    private int wallet;
    private ArrayList <F_OwnableField> myFields = new ArrayList<>(); 
    
    public Player(String name){
        this.name = name;
    }
    
    public void move(Dice die){
        int newFieldIndex;
        newFieldIndex = currentfield.getNumber() + die.getDie();
        if (newFieldIndex >= Game.board.size()){
            newFieldIndex = newFieldIndex % Game.board.size();
            this.wallet = wallet + MonopolyConstants.PASSING_START;
            roundCounter++;
        }
        setCurrentField(Game.board.get(newFieldIndex));
        System.out.println(this.name + ", you moved to field: " + currentfield.getName());
        printField();
        
    }
    
    public void buyField(F_OwnableField thisField){
        if (this.wallet - thisField.getPrice() > 0) {
            this.myFields.add(thisField);
            this.wallet = wallet - thisField.getPrice();
            thisField.setOwner(this);
            System.out.println("You bought " + thisField.getName() + "!");
        } else {
            System.out.println("You can't afford " + thisField.getName());
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCurrentField(FieldInterface currentfield){
        this.currentfield = currentfield;
    }
    public String getCurrentField(){
        return "player " + name + ", is on field " + currentfield;
    }
    public String printField(){
        return "You landed on " + this.currentfield;
    }
    public void setRoundCounter(int round){
        this.roundCounter = this.roundCounter + round;
    }
    public int getRoundCounter(){
        return this.roundCounter;
    }
    public String getName(){
        return this.name;
    }
    public int getWallet(){
        return this.wallet;
    }
    public void setWallet(int money){
        this.wallet = wallet + money;
    }
    public void setMyFields(){
        this.myFields = myFields;
    }
    public void setNumber(int number){
        this.number = number;
    }
}
