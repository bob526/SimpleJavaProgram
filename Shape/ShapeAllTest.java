public class ShapeAllTest
{
    public static void main(String[] args)
    {
        Shape[] myPolyArray = new Shape[6];

        myPolyArray[0] = new Circle(3);
        myPolyArray[1] = new Square(5);
        myPolyArray[2] = new Triangle(3,4,5);
        myPolyArray[3] = new Sphere(7);
        myPolyArray[4] = new Cube(2);
        myPolyArray[5] = new Tetrahedron(1,1,1,  2,-1,-2,  3,-5,-1,  4,-1,2);

        for (Shape current : myPolyArray) {
            System.out.println(current);

            if (current instanceof TwoDimensionalShape) {
                System.out.printf("Area = %f\n",((TwoDimensionalShape)current).getArea());
            }
            else if (current instanceof ThreeDimensionalShape) {
                System.out.printf("Area = %f\t",((ThreeDimensionalShape)current).getArea());
                System.out.printf("Volume = %f\n",((ThreeDimensionalShape)current).getVolume());
            }
            System.out.println();
        }

        /*System.out.println("Test Class Circle:");
        Shape circleShape = new Circle(5);
        Shape circleShapeDefault = new Circle();
        System.out.println(circleShape);
        System.out.printf("The dimension is: %d\n",circleShape.whatDimension());
        System.out.printf("Area: %f\n",circleShape.getArea());
        System.out.printf("Area: %f\n",circleShapeDefault.getArea());
        System.out.println("---------------------");
        System.out.println("Test Class Square:");
        Shape squShape = new Square();
        System.out.printf("The dimension is: %d\n",squShape.whatDimension());
        System.out.printf("Area: %f\n",squShape.getArea());
        Shape squTenLen = new Square(10.5);
        System.out.printf("The dimension is: %d\n",squTenLen.whatDimension());
        System.out.printf("Area: %f\n",squTenLen.getArea());
        System.out.printf("squShape: %s \nsquTenLen: %s\n",squShape,squTenLen);
        System.out.println("---------------------");
        System.out.println("Test Class Triangle:");
        Shape triDefault = new Triangle();
        Shape triOnePara = new Triangle(3);
        Shape triThrPara = new Triangle(3,5,4);
        System.out.printf("The dimension is: %d\n",triDefault.whatDimension());
        System.out.printf("Area: %f\n",triDefault.getArea());
        System.out.printf("The dimension is: %d\n",triOnePara.whatDimension());
        System.out.printf("Area: %f\n",triOnePara.getArea());
        System.out.printf("The dimension is: %d\n",triThrPara.whatDimension());
        System.out.printf("Area: %f\n",triThrPara.getArea());
        System.out.printf("%s\n%s\n%s\n",triDefault,triOnePara,triThrPara);
        System.out.println("---------------------");
        System.out.println("Test Class Sphere:");
        Shape defaultSphere = new Sphere();
        Shape userSphere = new Sphere(4);
        System.out.printf("The dimension of defaultSphere is %d\n",defaultSphere.whatDimension());
        System.out.printf("defaultSphere's area = %f, volume = %f\n",defaultSphere.getArea(), ((ThreeDimensionalShape)defaultSphere).getVolume());
        System.out.println("defaultSphere -> "+defaultSphere);
        System.out.printf("The dimension of userSphere is %d\n",userSphere.whatDimension());
        System.out.printf("userSphere's area = %f, volume = %f\n",userSphere.getArea(), ((ThreeDimensionalShape)userSphere).getVolume());
        System.out.println("userSphere -> "+userSphere);
        System.out.println("---------------------");
        System.out.println("Test Class Cube:");
        Shape defaultCube = new Cube();
        Shape userCube = new Cube(4);
        System.out.printf("The dimension of defaultCube is %d\n",defaultCube.whatDimension());
        System.out.printf("defaultCube's area = %f, volume = %f\n",defaultCube.getArea(), ((ThreeDimensionalShape)defaultCube).getVolume());
        System.out.println("defaultCube -> "+defaultCube);
        System.out.printf("The dimension of userCube is %d\n",userCube.whatDimension());
        System.out.printf("userCube's area = %f, volume = %f\n",userCube.getArea(), ((ThreeDimensionalShape)userCube).getVolume());
        System.out.println("userCube -> "+userCube);
        System.out.println("---------------------");
        System.out.println("Test Class Tetrahedron:");
        Shape defaultTetra = new Tetrahedron();
        Shape userTetra = new Tetrahedron(4);
        System.out.printf("The dimension of defaultTetra is %d\n",defaultTetra.whatDimension());
        System.out.printf("defaultTetra's area = %f, volume = %f\n",defaultTetra.getArea(), ((ThreeDimensionalShape)defaultTetra).getVolume());
        System.out.println("defaultTetra -> "+defaultTetra);
        System.out.printf("The dimension of userTetra is %d\n",userTetra.whatDimension());
        System.out.printf("userTetra's area = %f, volume = %f\n",userTetra.getArea(), ((ThreeDimensionalShape)userTetra).getVolume());
        System.out.println("userTetra -> "+userTetra);
        System.out.println("---------------------");*/
    }
}