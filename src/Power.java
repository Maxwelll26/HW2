/**
 The Power class represents a power function, where a given function is raised to a specified power.
 It extends the Function class and provides methods for calculating the value, obtaining a string representation,
 and computing the derivative of the power function.
 */
public class Power extends Function {
    private Function function;
    private int power;

    /**
     * Constructor for the power class. power in this case is between 2 objects.
     * @param function from the Type of function.
     * @param power To what power do we raise the function
     */
    public Power(Function function, int power) {
        this.function = function;
        this.power = power;
    }

    /**
     * According to the definition of a power, we calculate the value of the function at a
     * point, and we raise the result to the given power.
     * @param x the value we want to calculate at this point.
     * @return double number
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(function.valueAt(x),power);
    }

    /**
     * We represent power between  function and a number simply by F(x)^a
     * @return String in the format (f(x)^power)
     */
    @Override
    public String toString() {
        return  "(" + function.toString() + "^" + power + ")";
    }

    /** this is the template of how to calculate the derivative of power.
     * f'(x) = n * g(x)^(n-1) * g'(x)
     * @return product function
     */
    @Override
    public Function derivative() {
        if (power == 1)
            return function.derivative();
        else
            return new MultiProduct(new Constant(power), new Power(function, power - 1), function.derivative());
    }
}
