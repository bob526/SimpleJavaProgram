public abstract class TwoDimensionalShape extends Shape
{
    protected double area;
    
    @Override
    public String toString()
    {
        return "This shape is TwoDimensionalShape.";
    }

    @Override
    public int whatDimension()
    {
        return 2;
    }

    @Override
    public double getArea()
    {
        return area;
    }

}