/**
 The Quotient class represents a quotient of two functions. It extends the Function class and provides methods for
 obtaining a string representation, calculating the value, and computing the derivative of the quotient function.
 */
public class Quotient extends Function{
    private Function firstFunction;
    private Function secondFunction;

    /**
     * Constructor for the Quotient class. A portion is defined between 2 functions and no less.
     * @param firstFunction from the Type of function
     * @param secondFunction from the type of function
     */
    public Quotient(Function firstFunction, Function secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

    /**
     * We represent quotient between 2 functions simply by presenting function A
     * and dividing with function B.
     * @return String in the format (Fx / Gx)
     */
    @Override
    public String toString() {
        return  "(" + firstFunction.toString() + " / " + secondFunction.toString() + ")";
    }

    /**
     * The result of the division between 2 functions is to take function A, calculate its value
     * and also the same in B . The final answer will be dividing the 2 results.
     * We were asked not to refer to the part where you divide by 0 - the result will be infinity or
     * minus infinity or NAN.
     * @param x double number
     * @return double number
     */
    @Override
    public double valueAt(double x) {
        return (firstFunction.valueAt(x)) / (secondFunction.valueAt(x));
    }

    /**
     * The derivative of the Quotient of 2 functions is known and is in the following format:
     * F(x)/G(x) dx = (F`(x)*G(x) - G`(x)*F(x)) / [G(x)]^2
     * @return Quotient function
     */
    @Override
    public Function derivative() {
        Function derivativeFirst = firstFunction.derivative();
        Function derivativeSecond = secondFunction.derivative();
        Product firstMulti = new Product(derivativeFirst,secondFunction);
        Product SecondMulti = new Product(derivativeSecond,firstFunction);
        Difference countedInFraction = new Difference(firstMulti,SecondMulti); // תוצאת המונה
        Power denominator = new Power(secondFunction,2); // תוצאת המכנה
        return new Quotient(countedInFraction,denominator);
    }
}
