
package matador;

import java.util.Scanner;


public abstract class F_OwnableField implements FieldInterface{
    Scanner input = new Scanner(System.in);
    private String name;
    private int number;
    private int price;
    private Player owner = null;
    
    protected F_OwnableField(String name, int number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
        
    }

    //@Override
    public String getName(){
        return name;
    }
    //@Override
    public int getNumber(){
        return number;
    }
    public int getPrice(){
        return price;
    }
    public Player getOwner(){
        return owner;
    }
    public void setOwner(Player owner){
        this.owner = owner;
    }
    @Override
    public String toString(){
        return "OwnableField{" + "name = " + name + ", number = " + number 
                + ", price = " + price + ", owner = " + owner + '}';
    }

    public void consequence(Player poorplayer)
    { 
        if (this.owner == null) 
        {
            if (poorplayer.getWallet() - this.getPrice() > 0) 
            {
                System.out.println("This field is not owned");
                System.out.println("Price: " + this.getPrice());
                System.out.println("Would you like to buy it?");
                System.out.println("Type 'Yes' or 'No'");
                String word = input.next();
                switch (word.toLowerCase()){
                    case "yes":
                        poorplayer.buyField(this);
                        
                        break;
                    case "no":
                        System.out.println("You didnt buy " + this.getName());
                        break;
                }
            } else if (poorplayer.getWallet() - this.getPrice() < 0)
            {
                System.out.println("You cant afford " + this.getName());
            }   
        } else {
            System.out.println("This field is owned by: " + this.getOwner().getName());
            System.out.println("You are fined 20% of the housing price: " + (this.getPrice() * 0.2));
            poorplayer.setWallet((int) (poorplayer.getWallet() - (this.getPrice() * 0.2)));
            this.getOwner().setWallet((int) (this.owner.getWallet() + (this.price * 0.2)));
        }
    }
}
