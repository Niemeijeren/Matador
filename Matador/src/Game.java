
package matador;
import matador.*;
import java.util.*;

public class Game {
    Scanner input = new Scanner(System.in);
    protected static ArrayList <FieldInterface> board = new ArrayList <>();
    public ArrayList <Player> playerList = new ArrayList<>();
    Dice dice = new Dice();
    int playerTurnCounter = 0;
    
    //Game method
    public Game(){
    
        setGame();
    }
    
    //Startup (Create board and players
    private void setGame(){
        setFields();
        setPlayers();
        setStartMoney();
    }
    
    //Loop for creating fields, and setting them into arraylist
    private void setFields(){

        //Set names of fields
        board.add(new F_OtherField("Start", 0));
        board.add(new F_StreetField("Rødovrevej", 1, 100));
        board.add(new F_OtherField("Prøv lykken", 2));
        board.add(new F_StreetField("Hvidovrevej", 3, 100));
        board.add(new F_OtherField("Betal Indkomstskat", 4));
        board.add(new F_ShipField("Scandlines - Helsingør/Helsingborg", 5, 100));
        board.add(new F_StreetField("Roskildevej", 6, 100));
        board.add(new F_OtherField("Prøv lykken", 7));
        board.add(new F_StreetField("Valbylanggade", 8, 100));
        board.add(new F_StreetField("Allégade", 9, 100));
        board.add(new F_OtherField("Fængsel", 10));
        board.add(new F_StreetField("Frederiksberg Allé", 11, 100));
        board.add(new F_BreweryField("Bryggeri - Tuborg", 12, 100));
        board.add(new F_StreetField("Büllowsvej", 13, 100));
        board.add(new F_StreetField("Gl. Kongevej", 14, 100));
        board.add(new F_ShipField("Scandlines - Mols-linjen", 15, 100));
        board.add(new F_StreetField("Berstorfvej", 16, 100));
        board.add(new F_OtherField("Prøv lykken", 17));
        board.add(new F_StreetField("Hellerupvej", 18, 100));
        board.add(new F_StreetField("Strandvejen", 19, 100));
        board.add(new F_OtherField("Parkering", 20));
        board.add(new F_OtherField("Trianglen", 21));
        board.add(new F_OtherField("Prøv lykken", 22));
        board.add(new F_StreetField("Østerbrogade", 23, 100));
        board.add(new F_StreetField("Grønningen", 24, 100));
        board.add(new F_ShipField("Scandlines - Gedser/Rostock", 25, 100));
        board.add(new F_StreetField("Bredgade", 26, 100));
        board.add(new F_StreetField("Kng. Nytorv", 27, 100));
        board.add(new F_BreweryField("Bryggeri - Coca-Cola", 28, 100));
        board.add(new F_StreetField("Østergade", 29, 100));
        board.add(new F_GoToJailField("Politi! (Fængselstid)", 30));
        board.add(new F_StreetField("Amager torv", 31, 100));
        board.add(new F_StreetField("Vimmelskaftet", 32, 100));
        board.add(new F_OtherField("Prøv lykken", 33));
        board.add(new F_StreetField("Nygade", 34, 100));
        board.add(new F_ShipField("Scandlines - Rødby/Puttgarden", 35, 100));
        board.add(new F_OtherField("Prøv lykken", 36));
        board.add(new F_StreetField("Frederiksberggade", 37, 100));
        board.add(new F_OtherField("Ekstra statsskat",38));
        board.add(new F_StreetField("Rådhuspladsen", 39, 100));
        
        //Set consequences for selected fields
        
    }
    
    //Method for choosing amount of, and creating players
    private void setPlayers(){
        System.out.println("How many players? (min 2, max 6) : ");
        int players = input.nextInt();

        if (players > 2 || players < 4){
            for (int i = 0; i < players; i++){
                playerList.add(new Player("player" + i));
                playerList.get(i).setNumber(i);
            } 
            } else { 
                System.out.println("incorrect amount of players");
                setPlayers();
                }
        for (int i = 0; i < playerList.size(); i++){
            System.out.println("Player " + i + ", choose your name!");
            playerList.get(i).setName(input.next());
        }
        for (int i = 0; i < playerList.size(); i++){
            playerList.get(i).currentfield = board.get(0);
        }
    }
    
    //Run-condition
    public boolean run(){
        
        while (!hasEnded()){
            turn(playerList.get(playerTurn()));
            
        }
        System.out.print(playerTurnCounter);
        return false;
    }
    
    // What to do every turn
    public void turn(Player player){
        System.out.println(player.getName() + ", you're up!");
        dice.throwDice();
        player.move(dice);
        player.currentfield.consequence(player);
        if (dice.checkDoubles() == true){
            turn(player);
        }
        System.out.println("For next players turn, write 'y'");
        String endturn = input.next();
        switch (endturn.toLowerCase()){
            case "y":
                break;
            default:
                break;
        }
        
        
    }
    
    //Method for choosing what players turn it is
    public int playerTurn(){
        int index = playerTurnCounter % playerList.size();
        playerTurnCounter++;
        return index;
    }
    
    //Mothod for checking if game has ended
    public boolean hasEnded(){
        for (Player player: playerList){
            if (player.getRoundCounter() >= 5){
                return true;
            }
        }
        return false;

    }
    
    //Method for giving players startmoney
    public void setStartMoney(){
        for (int i = 0; i < playerList.size(); i++){
            playerList.get(i).setWallet(MonopolyConstants.START_MONEY);
        }
    }
    
}
