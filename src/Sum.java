public class Sum extends Function {
    protected Function firstFunction;
    protected Function secondFunction;


    /**
     * contractor for the SUM class. difference is always between 2 objects.
     * @param firstFunction from the Type of function
     * @param secondFunction from the type of function
     */
    public Sum (Function firstFunction, Function secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

    /**
     * The result of a SUM function is to take each function and calculate its value and
     * make a sum between the 2 results
     * @param x - double For which X we calculate the value of the function.
     * @return we will get a double number.
     */
    @Override
    public double valueAt(double x) {
        return firstFunction.valueAt(x) + secondFunction.valueAt(x);
    }

    /**
     * We represent sum between 2 functions simply by presenting function A
     * and summing from function B.
     * @return String in the format (Fx + Gx)
     */
    @Override
    public String toString() {
        return "(" + firstFunction.toString() + " + " + secondFunction.toString() + ")";
    }

    /**
     * Derivative of the sum is to make each function separately its derivative and then
     * make the sum between these results.
     * @return new sum that it is a function itself.
     */
    @Override
    public Function derivative() {
        Function derivativeFirst = firstFunction.derivative();
        Function derivativeSecond = secondFunction.derivative();
        return new Sum(derivativeFirst,derivativeSecond);
    }
}
