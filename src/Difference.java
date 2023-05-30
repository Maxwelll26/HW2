public class Difference extends Function {
    private Function firstFunction;
    private Function secondFunction;


    /**
     * contractor for the difference class. difference is always between 2 objects.
     * @param firstFunction from the Type of function
     * @param secondFunction from the type of function
     */
    public Difference(Function firstFunction, Function secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }


    /**
     * The result of a difference function is to take each function and calculate its value and
     * make a difference between the 2 results
     * @param x - double For which X we calculate the value of the function.
     * @return we will get a double number.
     */
    @Override
    public double valueAt(double x) {
        return firstFunction.valueAt(x) - secondFunction.valueAt(x);
    }

    /**
     * We represent subtraction between 2 functions simply by presenting function A
     * and subtracting from function B.
     * @return String in the format (Fx - Gx)
     */
    @Override
    public String toString() {
        return "(" + firstFunction.toString() + " - " + secondFunction.toString() + ")";

    }

    /**
     * Derivative of the difference is to make each function separately its derivative and then
     * make a difference between these results.
     * @return new difference that it is a function itself.
     */
    @Override
    public Function derivative() {
        Function derivativeFirst = firstFunction.derivative();
        Function derivativeSecond = secondFunction.derivative();
        return new Difference(derivativeFirst,derivativeSecond);
    }
}
