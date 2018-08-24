public class Circle extends TwoDimensionalShape
{
    private double radius;

    //Default Constructor
    public Circle()
    {
        //Assume radius = 1;
        radius = 1;
        calArea();
    }
    //One parameter constructor
    public Circle(double userRadius)
    {
        radius = userRadius;
        calArea();
    }

    private double calArea()
    {
        area = radius*radius*Math.PI;
        return area;
    }

    @Override
    public String toString()
    {
        return String.format("This shape is Circle.\tRadius = %f",radius);
    }

}