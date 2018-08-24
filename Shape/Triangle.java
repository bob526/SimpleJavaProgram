public class Triangle extends TwoDimensionalShape
{
    private double length1, length2, length3;

    //Constructor
    //Default constructor
    public Triangle()
    {
        //Default is a regular triangle with length 1
        length1 = 1; length2 = 1; length3 = 1;
        checkTri();
        calArea();
    }
    //one parameter constructor
    public Triangle(double oneLength)
    {
        //Regular triangle with length oneLength
        length1 = oneLength; length2 = oneLength; length3 = oneLength;
        checkTri();
        calArea();
    }
    //Three parameter constructor
    public Triangle(double a, double b, double c)
    {
        length1 = a; length2 = b; length3 =c;
        checkTri();
        calArea();
    }


    @Override
    public String toString()
    {
        return String.format("This shape is Triangle.\tEdge a = %f, edge b = %f, edge c = %f",length1,length2,length3);
    }

    private boolean isValid()
    {
        //Check triangle's validation
        if (length1+length2>length3 && length1+length3>length2 && length2+length3>length1)
            return true;
        else
            return false;
    }

    private void checkTri()
    {
        if (!isValid()) {
            //Not valid will enter here
            String mesg;
            mesg = String.format("%f, %f and %f can't form a triangle.",length1, length2, length3);
            throw new IllegalArgumentException(mesg);
        }
    }

    private double calArea()
    {
        double s = (length1 + length2 + length3)/2;
        area = Math.sqrt(s * (s-length1) * (s-length2) * (s-length3));
        return area;
    }
}