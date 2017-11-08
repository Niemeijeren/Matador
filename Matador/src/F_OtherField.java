
package matador;


public class F_OtherField implements FieldInterface{
    
    private String name;
    private int number;

    public F_OtherField(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getNumber(){
        return number;
    }
    public boolean getCanBuy(){
        return false;
    }


    @Override
    public void consequence(Player poorplayer) {
        
        switch(poorplayer.getCurrentField()){
            case "Prøv lykken":
                lykken(poorplayer);
            case "Betal Indkomstskat":
                PayTax(poorplayer);
            case "Ekstra statsskat":
                GetTaxBack(poorplayer);
        }
    }
        private void PayTax(Player poorplayer){
        int random2 = (int) (Math.random()*3 );
            switch (random2) {
            case 0:
                System.out.println("Your forgot your taxes! Pay 200!");
                poorplayer.setWallet(-200);
            case 1:
                System.out.println("Your forgot your taxes! Pay 400!");
                poorplayer.setWallet(-400);
            case 2: 
                System.out.println("Your forgot your taxes! Pay 600!");
                poorplayer.setWallet(-600);
                break;
                }
    }
        
    private void lykken(Player poorplayer){
        int random = (int) (Math.random() * 10);
        switch (random){
            case 0:
            System.out.println("Nothing exciting this time!");
            break;
        case 1:
            System.out.println("You got 400 from the bank!");
            poorplayer.setWallet(400);
            break;
        case 2:
            System.out.println("You got 600 from the bank!");
            poorplayer.setWallet(600);
            break;
        case 3:
            System.out.println("You got 1000 from the bank!");
            poorplayer.setWallet(1000);
            break;
        case 4:
            System.out.println("Put 200 in the bank!");
            poorplayer.setWallet(-200);
            break;
        case 5:
            System.out.println("Put 400 in the bank!");
            poorplayer.setWallet(-400);
            break;
        case 6:
            System.out.println("Put 600 in the bank!");
            poorplayer.setWallet(-600);
            break;
        case 7:
            System.out.println("Move 2 fields back!");
            int newfield1 = poorplayer.currentfield.getNumber() - 2;
            if (newfield1 < 0){
                poorplayer.setCurrentField(Game.board.get(0));
                System.out.println("New field: " + poorplayer.getCurrentField());
            } else {
            poorplayer.setCurrentField(Game.board.get(newfield1));
            System.out.println("New field: " + poorplayer.getCurrentField());

            }
            break;
        case 8:
            System.out.println("Move 6 fields back!");
            int newfield2 = poorplayer.currentfield.getNumber() - 6;
            if (newfield2 < 0){
                poorplayer.setCurrentField(Game.board.get(0));
                System.out.println("New field: " + poorplayer.getCurrentField());
            } else {
            poorplayer.setCurrentField(Game.board.get(newfield2));
            System.out.println("New field: " + poorplayer.getCurrentField());

            }

            break;
        case 9:
            System.out.println("You get another turn!");


            break;
        }
    }
    
    private void GetTaxBack(Player poorplayer){
        int random2 = (int) (Math.random()*3 );
            switch (random2) {
            case 0:
                System.out.println("You get taxes back! 200$!");
                poorplayer.setWallet(200);
            case 1:
                System.out.println("You taxes back! 400$!");
                poorplayer.setWallet(400);
            case 2: 
                System.out.println("You get taxes back! 600$!");
                poorplayer.setWallet(600);
                break;
                }
    }
}