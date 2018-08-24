public class Sphere extends ThreeDimensionalShape
{
    private double radius;

    //Constructor
    //Default constructor
    public Sphere()
    {
        //Default's radius is 1;
        radius = 1;
        calArea();
        calVolume();
    }
    //One parameter constructor
    public Sphere(double userRadius)
    {
        radius = userRadius;
        calArea();
        calVolume();
    }

    private double calArea()
    {
        area = 4 * Math.PI * radius * radius;
        return area;
    }

    private double calVolume()
    {
        volume = (4.0/3.0) * Math.PI * radius * radius * radius;
        return volume;
    }


    @Override
    public String toString()
    {
        return String.format("This shape is Sphere.\tRadius = %f",radius);
    }


}