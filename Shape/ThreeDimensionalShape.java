public abstract class ThreeDimensionalShape extends Shape
{
    protected double area;
    protected double volume;

    @Override
    public String toString()
    {
        return "This Shape is ThreeDimensionalShape.";
    }

    @Override
    public int whatDimension()
    {
        return 3;
    }

    @Override
    public double getArea()
    {
        return area;
    }

    public double getVolume()
    {
        return volume;
    }
}