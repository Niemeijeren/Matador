
package matador;

public class F_ShipField extends F_OwnableField{
    private boolean canBuy = true;
    

    public F_ShipField(String name, int number, int price) {
        super(name, number, price);
    }

    @Override
    public void consequence(Player poorplayer) {
        super.consequence(poorplayer);
    }
}
