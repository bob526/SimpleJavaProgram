public class Cube extends ThreeDimensionalShape
{
    private double len;

    //Constructor
    //Default constructor
    public Cube()
    {
        //Assume len = 1
        len = 1;
        calArea();
        calVolume();
    }
    //One parameter constructor
    public Cube(double userLen)
    {
        len = userLen;
        calArea();
        calVolume();
    }

    private double calArea()
    {
        area = 6 * len * len;
        return area;
    }

    private double calVolume()
    {
        volume = len * len * len;
        return volume;
    }

    @Override
    public String toString()
    {
        return String.format("This shape is Cube.\tEdge length = %f",len);
    }
}