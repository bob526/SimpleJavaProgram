public class Tetrahedron extends ThreeDimensionalShape
{
    private double aX, aY, aZ, bX, bY, bZ, cX, cY, cZ, dX, dY, dZ;
    private double distanceAB, distanceAC, distanceAD, distanceBC, distanceBD, distanceCD; 
    //Constructor
    //No Default constructor
    //One parameter constructor
    public Tetrahedron(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, double x4, double y4, double z4)
    {
        aX = x1;    aY = y1;    aZ = z1;
        bX = x2;    bY = y2;    bZ = z2;
        cX = x3;    cY = y3;    cZ = z3;
        dX = x4;    dY = y4;    dZ = z4;
        calDistance();
        calArea();
        calVolume();
    }

    private double calArea()
    {
        //Need calculate these combination: abc, abd, acd, bcd
        
        //abc -> 3 edges:ab ac bc
        Triangle needTri = new Triangle(distanceAB,distanceAC,distanceBC);
        area += needTri.getArea();
        //abd -> 3 edges: ab, ad, bd
        needTri = new Triangle(distanceAB,distanceAD,distanceBD);
        area += needTri.getArea();
        //acd -> 3 edges: ac, ad, cd
        needTri = new Triangle(distanceAC,distanceAD,distanceCD);
        area += needTri.getArea();
        //bcd -> 3 edges: bc, bd, cd
        needTri = new Triangle(distanceBC, distanceBD, distanceCD);
        area += needTri.getArea();


        return area;
    }
    private double calVolume()
    {
                //ab(vector)                ac(vector)              ad(vector)
        volume = calDet((bX-aX),(bY-aY),(bZ-aZ),  (cX-aX),(cY-aY),(cZ-aZ),  (dX-aX),(dY-aY),(dZ-aZ));
        volume = Math.abs(volume);
        volume/=6;
        return volume;
    }

    private void calDistance()
    {
        distanceAB = twoPointDis(aX,aY,aZ,bX,bY,bZ);
        distanceAC = twoPointDis(aX,aY,aZ,cX,cY,cZ);
        distanceAD = twoPointDis(aX,aY,aZ,dX,dY,dZ);
        distanceBC = twoPointDis(bX,bY,bZ,cX,cY,cZ);
        distanceBD = twoPointDis(bX,bY,bZ,dX,dY,dZ);
        distanceCD = twoPointDis(cX,cY,cZ,dX,dY,dZ);
    }

    private double twoPointDis(double x1, double y1, double z1, double x2, double y2, double z2)
    {
        return Math.sqrt( Math.pow((x1-x2),2) + Math.pow((y1-y2),2) + Math.pow((z1-z2),2) );
    }

    private double calDet(double ab1, double ab2, double ab3, double ac1, double ac2, double ac3, double ad1, double ad2, double ad3)
    {
        //Input: ab(vector), ac(vector), ad(vector)
        return (ab1*ac2*ad3)+(ab2*ac3*ad1)+(ac1*ad2*ab3)-(ab3*ac2*ad1)-(ab2*ac1*ad3)-(ac3*ad2*ab1);
    }

    @Override
    public String toString()
    {
        return String.format("This shape is Tetrahedron.\tPoint: (%g,%g,%g), (%g,%g,%g), (%g,%g,%g), (%g,%g,%g)",aX, aY, aZ, bX, bY, bZ, cX, cY, cZ, dX, dY, dZ);
    }
}