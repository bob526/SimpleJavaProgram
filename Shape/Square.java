public class Square extends TwoDimensionalShape
{
    private double length;

    //Constructor
    //Default constructor
    public Square()
    {
        //Assume that the length is 1
        length = 1;
        calArea();
    }
    //One parameter constructor
    public Square(double userLength)
    {
        length = userLength;
        calArea();
    }

    @Override
    public String toString()
    {
        return String.format("This shape is Square.\tEdge length = %f.",length);
    }


    private double calArea()
    {
        area = length * length;
        return area;
    }
}