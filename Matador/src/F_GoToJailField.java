
package matador;


public class F_GoToJailField implements FieldInterface
{

    private String name;
    private int number;

    public F_GoToJailField(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getNumber()
    {
        return number;
    }
    @Override
    public String toString()
    {
        return "GoToJailField{" + "name = " + name + ", number = " + number + '}';
    }

    @Override
    public void consequence(Player poorplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
