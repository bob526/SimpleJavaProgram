// Student ID: 403410011    Java Assignment1

public class Rational 
{
    private int denominator;
    private int numerator;
//Develop Test Code
/*
    public static void main(String[] args)
    {
        System.out.printf("gcd: %d\n",gcd(20,5));
        System.out.printf("lcm: %d\n",lcm(20,5));
        Rational test = new Rational();
        Rational test2 = new Rational(32);
        Rational test3 = new Rational(2,3);
        Rational test4 = new Rational(6,3);
        Rational test5 = new Rational(test3);
        System.out.println(test);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test3.toString(5));
        System.out.println(test4);
        System.out.println(test5.toString(5));
        Rational addTest = add(test3, test4);
        System.out.println(addTest);
        Rational subTest = subtract(test3, test4);
        System.out.println(subTest);
        Rational mulTest = multiply(test3, test4);
        System.out.println(mulTest);
        Rational divTest = divide(test3, test4);
        System.out.println(divTest);
    }
*/
    public static int gcd(int a, int b)
    {
        while(b>0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b)
    {
        return a*(b/gcd(a,b));
    }
    
    //Default Constructor
    public Rational()
    {
        numerator = 0;
        denominator = 1;
    }
    //Interger Constructor
    public Rational(int initInt)
    {
        numerator = initInt;
        denominator = 1;
    }
    //Fraction Constructor
    public Rational(int inputNumer, int inputDenom)
    {
        /*
        int inputGcd = gcd(inputNumer, inputDenom);
        numerator = inputNumer/inputGcd;
        denominator = inputDenom/inputGcd;
        */
        numerator = inputNumer;
        denominator = inputDenom;
        reduction();
    }
    //Construct with the same Rational class object
    public Rational(Rational initFrac)
    {
        numerator = initFrac.numerator;
        denominator = initFrac.denominator;
        reduction();
    }
    public Rational(Rational initFrac, String specify)
    {
        //Dangerous! This won't automatically reduce fraction
        if (specify.equals("noReduce")) {
            numerator = initFrac.numerator;
            denominator = initFrac.denominator;
        }
        else 
            throw new IllegalArgumentException();
        
    }
    
    public String toString()
    {
        if (denominator==1)
            return String.format("%d",numerator);
        else
            return String.format("%d/%d",numerator,denominator);
    }
    public String toString(int presion)
    {
        return String.format("%." + presion + "f", ((double)numerator/denominator));
    }
    //Simplify the fraction
    private void reduction()
    {
        int fractionGcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator/=fractionGcd;
        denominator/=fractionGcd;
    }
    //Reduction of common denominator
    //Find caller and parameter's common denominator 
    private Rational commonDenom(Rational anotherFrac)
    {
        //Usage: (a as caller) Rational b = commonDenom(b); 
        //Both a and b will be change
        //So, you need to backup by yourself.

        //caller's denominator  &   parameter's denominator
        int fractionLcm = lcm(denominator, anotherFrac.denominator);
        int callerMul = fractionLcm/denominator;
        int paraMul = fractionLcm/anotherFrac.denominator;

        //Multiple the fraction
        //Caller
        denominator*=callerMul;
        numerator*=callerMul;
        //Parameter
        anotherFrac.denominator *= paraMul;
        anotherFrac.numerator *= paraMul;
        return new Rational(anotherFrac, "noReduce");
    }

    public static Rational add(Rational a, Rational b)
    {
        Rational backupA, backupB;
        backupA = new Rational(a);
        backupB = new Rational(b);
        //Use backupA and backupB to operate
        backupB = backupA.commonDenom(backupB);   //Both will change to common denominator.
        int theNewNumer = backupA.numerator + backupB.numerator;
        int theNewDenom = backupA.denominator;
        return new Rational(theNewNumer, theNewDenom);
        //This constructor will simplify it.
    }
    public static Rational subtract(Rational a, Rational b)
    {
        Rational backupA, backupB;
        backupA = new Rational(a);
        backupB = new Rational(b);
        backupB = backupA.commonDenom(backupB); 
        int theNewNumer = backupA.numerator - backupB.numerator;
        int theNewDenom = backupA.denominator;
        return new Rational(theNewNumer, theNewDenom);
    }
    public static Rational multiply(Rational a, Rational b)
    {
        int theNewNumer = a.numerator * b.numerator;
        int theNewDenom = a.denominator * b.denominator;
        return new Rational(theNewNumer, theNewDenom);
    }
    public static Rational divide(Rational a, Rational b)
    {
        Rational reverseFrac = new Rational(b.denominator, b.numerator);
        return multiply(a, reverseFrac);
    }
}